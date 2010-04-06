PRIORITY = "optional"
DESCRIPTION = "Texas Instruments Ducati Multimedia S/w"
LICENSE = "LGPL"
PR = "r7"

DEPENDS = " \
   tisyslink-ducati \
   titools-bios \
   titools-fc \
   titools-xdc \
   titools-ce \
   titools-xdais \
   titools-osal \  
   titools-cgtarm \
   "

inherit xdc ccasefetch

PV = "0.0+cc+${SRCREV}"

CCASE_SPEC = "%\
   element /vobs/WTSD_DucatiMMSW/...   ${SRCREV}%\
   element * /main/LATEST%"

# Note: WTSD_DucatiMMSW is used in the XDC package name, so it must be put
# in the ${S} folder
CCASE_PATHFETCH = "/vobs/WTSD_DucatiMMSW"
CCASE_PATHCOMPONENT = "vobs"
CCASE_PATHCOMPONENTS = "0"

XDCPATH += "\
${STAGING_BINDIR}/syslink/ducati/ipc;\
${S}/WTSD_DucatiMMSW/framework;\
${S}/WTSD_DucatiMMSW/ext_rel/ivahd_codecs/packages;\
"

XDCBUILDROOT="${S}/WTSD_DucatiMMSW/platform/base_image"

XDCARGS="profile=release core=app_m3 target_build=BUILD_OMAP4 cache_wa=USE_CACHE"

XDCBUILDCFG="${S}/WTSD_DucatiMMSW/build/config.bld"

DSP_JOBS="${PARALLEL_MAKE}"

FILES_${PN}="/syslink/"

do_install() {
    install -d ${D}/syslink
    cd ${S}/WTSD_DucatiMMSW/platform/base_image
    for xem3 in ./out/app_m3/whole_program_debug/base_image_app_m3.xem3 ; do
        cp ${xem3} ${xem3}.old
        ${STAGING_BINDIR_NATIVE}/titools/cgtarm-*/bin/strip470 ${xem3}
        install -m 0644 ${xem3}      ${D}/syslink/
        mv ${xem3}.old ${xem3}
    done
}

