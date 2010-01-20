DESCRIPTION = "Ittiam OpenMAX IL AAC+ Audio Decoder."
DEPENDS = "tiopenmax-core tiopenmax-rmproxy tiopenmax-resourcemanager"
PR = "r0"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

CCASE_SPEC = "%\
	      element /vobs/wtbu/CSSD_Linux_Releases/... ITTIAM-720P_REL_${PV}%\
	      element * /main/0%"

CCASE_PATHFETCH = "/vobs/wtbu/CSSD_Linux_Releases/3430/Linux_23.I3.x/ittiam-sw/tiopenmax-aacdecitt-3.26.tar.gz"
CCASE_PATHCOMPONENT = "ittiam-sw"
CCASE_PATHCOMPONENTS = "5"

inherit ccasefetch

do_unpack_ccase_append() {
	cd ${S}
	tar zxf tiopenmax-aacdecitt-3.26.tar.gz
	mv vobs/wtbu/OMAPSW_MPU/linux/* .
	rm -fr vobs
	rm -fr tiopenmax-aacdecitt-3.26.tar.gz
}

do_compile_prepend() {
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
}

do_compile() {
	cd ${S}/audio/src/openmax_il/aac_dec_ittiam
	oe_runmake \
		PREFIX=${D}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}${bindir} OMXROOT=${S} OMXLIBDIR=${STAGING_LIBDIR} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		OMXINCLUDEDIR=${STAGING_INCDIR}/omx \
		all
}

do_install() {
	cd ${S}/audio/src/openmax_il/aac_dec_ittiam
	oe_runmake \
		PREFIX=${D}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}${bindir} OMXROOT=${S} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		SYSTEMINCLUDEDIR=${D}/usr/include/omx \
		install
}

do_stage() {
	cd ${S}/audio/src/openmax_il/aac_dec_ittiam
	oe_runmake \
		PREFIX=${STAGING_DIR_TARGET}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${STAGING_DIR_TARGET}/usr OMXTESTDIR=${STAGING_BINDIR} OMXROOT=${S} \
		OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
		SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		install
}

FILES_${PN} = "\
	/usr/lib \
	/usr/bin \
	"

FILES_${PN}-dbg = "\
	/usr/bin/.debug \
	/usr/lib/.debug \
	"

FILES_${PN}-dev = "\
	/usr/include/omx \
	"