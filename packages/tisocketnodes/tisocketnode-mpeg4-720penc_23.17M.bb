DESCRIPTION = "Texas Instruments MPEG-4 720p Encoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-mpeg4-720penc-codec"

require tisocketnode-cs_${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/node/mpeg4_ari/enc"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/node/mpeg4_ari/enc

inherit ccasefetch tisocketnode