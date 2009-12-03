SECTION = "toolchains"
PRIORITY = "optional"
DESCRIPTION = "Texas Instruments OSAL"
LICENSE = "Texas Instruments"
PR = "r2"

inherit sdotools-tar

SDOVERS = 1_00_00_38

SDOFILE = osal_${SDOVERS}.tar.gz

SDOPATH = "OSAL/${SDOVERS}/exports/${SDOFILE}"




