DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"
PR = "r8"
DEPENDS = "glib-2.0 gettext-native libxml2 bison-native flex-native"

inherit autotools pkgconfig

# Also here: http://gitorious.org/robclark-gstreamer/gstreamer
SRC_URI = "git://anongit.freedesktop.org/gstreamer/${PN};protocol=git \
           file://common-20091119.tar.gz \
           file://configurable-buffer-alignment.patch;patch=1 \
           file://0001-Changes-to-make-it-possible-to-LD_PRELOAD-libttif.patch;patch=1 \
           file://0001-buffer_remove_subbuffer_subclass.patch;patch=1 \
           file://0002-gst-launch_add_loop_argument.patch;patch=1 \
          "
SRCREV = "5a1c788d9a58a032442ea09f091306640a0a7069"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-docs-build --disable-dependency-tracking --with-check=no --disable-examples --disable-tests --disable-valgrind --disable-debug --with-buffer-alignment=128"


do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm -f ${S}/common/m4/lib-link.m4 || true
	mv ${WORKDIR}/common-20091119/* ${S}/common/
	(cd ${S}/; NOCONFIGURE=1 ./autogen.sh)
}

#do_compile_prepend () {
#	mv ${WORKDIR}/gstregistrybinary.[ch] ${S}/gst/
#}

PARALLEL_MAKE = ""

do_stage() {
	autotools_stage_all
}

FILES_${PN} += " ${libdir}/gstreamer-0.10/*.so ${libexecdir}/gstreamer-0.10/*"
FILES_${PN}-dev += " ${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += " ${libdir}/gstreamer-0.10/.debug/* ${libexecdir}/gstreamer-0.10/.debug/*"
