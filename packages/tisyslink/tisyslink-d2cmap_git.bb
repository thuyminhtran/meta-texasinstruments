DESCRIPTION = "TI Ducati2Chiron Map Library"
PRIORITY = "optional"
LICENSE = "LGPL"
SECTION = "libs"

DEPENDS = "titiler-memmgr tisyslink-lib"
inherit autotools pkgconfig

PR = "r1"
PV = "0.00+git+${SRCREV}"

SRC_URI = " git://dev.omapzoom.org/pub/scm/tisyslink/userspace-syslink.git;protocol=git "
S = "${WORKDIR}/git/syslink/d2c"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

EXTRA_OECONF += "--enable-tests"

do_compile_prepend() {
    if [ ! -e ${S}/tests/testlib.c ]; then
        ln -s ${S}/../utils/testlib.c ${S}/tests/testlib.c
    fi
}

do_stage() {
        autotools_stage_all
}
