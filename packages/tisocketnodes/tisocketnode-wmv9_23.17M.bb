DESCRIPTION = "Texas Instruments Windows Media Video 9 Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-wmv9-codec"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/video/node/wmv9/dec/... LINUX_RLS_${PV}0%\
	      element /vobs/wtbu/OMAPSW_DSP/video/node/wmv9/dec_pplibs_configs/... LINUX_RLS_${PV}0%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/node/wmv9/dec"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/node/wmv9/dec

inherit ccasefetch tisocketnode