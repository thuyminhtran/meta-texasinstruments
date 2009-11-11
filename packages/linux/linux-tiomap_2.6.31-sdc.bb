require linux-omap.inc

PR = "r1"

COMPATIBLE_MACHINE = "omap-4430sdp"
DEFAULT_PREFERENCE = "1"

FILESDIR = "${FILE_DIRNAME}/${PN}-git/${MACHINE}"

RPROVIDES += "virtual/dspbridge-driver"
PROVIDES += "virtual/dspbridge-driver"

SRCREV = "798fbae1f49fea8b3d02dee3b190a92317d5d0bf"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap4.git;branch=L24x-20091110;protocol=git \
          file://defconfig-omap-4430sdp \
          file://driver-Makefile.patch;patch=1 \
"

S = "${WORKDIR}/git"

do_stage_append() {
	install -d ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach
	install -m 0644 ${S}/arch/arm/plat-omap/include/mach/*.h ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach
}

