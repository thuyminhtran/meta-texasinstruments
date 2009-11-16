DESCRIPTION = "TI MemMgr Library"
PRIORITY = "optional"
LICENSE = "LGPL"
SECTION = "libs"

DEPENDS = "virtual/kernel"
inherit autotools pkgconfig

PR = "r2"
PV = "0.00+git+${SRCREV}"

SRC_URI = "git://sealion.sc.ti.com/git/tiler-userspace.git;branch=memmgr_dev;protocol=git"
SRCREV = "ea7b70c78c6a82d96467f6b29c996f78b79d7b96"
S = "${WORKDIR}/git/memmgr"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
FILES_${PN} += "${libdir}/*.so ${libdir}/*.la"
FILES_${PN}-dev += "${libdir}/*.*a ${libdir}/pkgconfig/"
FILES_${PN}-dbg += "${libdir}/.debug/"

EXTRA_OECONF += "--enable-tilermgr --enable-unit-tests"

do_compile_prepend() {
	ln -s ${S}/../utils/testlib.c ${S}/tests/testlib.c
}

do_stage() {
        autotools_stage_all
}

