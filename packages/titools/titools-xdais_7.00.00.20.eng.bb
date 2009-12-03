SECTION = "toolchains"
PRIORITY = "optional"
DESCRIPTION = "Texas Instruments OSAL"
LICENSE = "Texas Instruments"
PR = "r2"

inherit sdotools-tar

SDOVERS = 7_00_00_20

SDOFILE = xdais_${SDOVERS}_eng.tar.gz

SDOPATH = "XDAIS/${SDOVERS}/exports/${SDOFILE}"

