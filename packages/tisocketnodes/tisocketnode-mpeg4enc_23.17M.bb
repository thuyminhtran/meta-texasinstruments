DESCRIPTION = "Texas Instruments MPEG4 Encoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-mpeg4enc-codec"

require tisocketnode-cs_${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/node/mpeg4/enc"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/node/mpeg4/enc

inherit ccasefetch tisocketnode
