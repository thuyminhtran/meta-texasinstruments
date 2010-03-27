#
# Copyright (C) 2008 Texas Instruments
#

DESCRIPTION = "Tasks for TI's Socket Nodes for OMAP4"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

RDEPENDS_task-omap-sn = "\
    baseimage \
    tisocketnode-usn \
    tisocketnode-mp3 \
    tisocketnode-mpeg4aacdec \
    tisocketnode-mpeg4aacenc \
    tisocketnode-nbamrenc \
#    tisocketnode-nbamrdec \
    tisocketnode-wbamrenc \
    tisocketnode-wbamrdec \
    "

