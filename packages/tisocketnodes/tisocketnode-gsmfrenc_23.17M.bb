DESCRIPTION = "Texas Instruments GSM Full-Rate Encoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-gsmfrenc-codec"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/speech/node/fr/enc/... LINUX_RLS_${PV}0%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/speech/node/fr/enc"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/speech/node/fr/enc

inherit ccasefetch tisocketnode