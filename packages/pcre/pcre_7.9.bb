DESCRIPTION = "Perl Compatible Regular Expression Library for gpsdrive-support"
LICENSE = "GPL"
SECTION = "base"
PR = "r0"


COMPATIBLE_MACHINE = "omap-3430(l|s)dp"

SRC_URI = "ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/pcre-${PV}.tar.gz"

inherit autotools pkgconfig


do_stage() {
        autotools_stage_all
	oe_libinstall -C  ${libdir} libpcre.so.0  ${STAGING_LIBDIR}	
}

PACKAGES = "${PN}"
