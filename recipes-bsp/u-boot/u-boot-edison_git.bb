require recipes-bsp/u-boot/u-boot.inc
require u-boot-target-env.inc
require u-boot-osip.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

PV = "2015.10"
SRCREV = "2e2b030bc6ed039b3b27225ee3486bd5b5d9f5a4"

SRC_URI = "git://github.com/01org/edison-u-boot;branch=edison-v2015.10 \
	   file://${MACHINE}.env \
	   file://target_env/*.env \
	  "

S = "${WORKDIR}/git"


do_configure_prepend() {
    sed -i -e 's:-Werror::g' ${S}/arch/x86/cpu/config.mk
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "edison"

