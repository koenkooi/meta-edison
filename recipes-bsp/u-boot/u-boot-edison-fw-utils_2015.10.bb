SUMMARY = "U-boot bootloader fw_printenv/setenv utils"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

SECTION = "bootloader"

DEPENDS = "virtual/bootloader"

PV = "2015.10"
SRCREV = "2e2b030bc6ed039b3b27225ee3486bd5b5d9f5a4"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/01org/edison-u-boot;branch=edison-v2015.10 \
           file://${MACHINE}.env \
            file://target_env/*.env \
            file://0001-fw_env.c-missing-header.patch \
            "

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

do_compile () {
  oe_runmake ${UBOOT_MACHINE}
  oe_runmake env
}

do_install () {
  install -d ${D}${sbindir}
  install -m 755 ${S}/tools/env/fw_printenv ${D}${sbindir}/fw_printenv
  # This is not a typo, this tool checks the args[0] to change its behavior a-la-busybox
  install -m 755 ${S}/tools/env/fw_printenv ${D}${sbindir}/fw_setenv
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${sbindir}/*"
FILES_${PN} += "${sysconfdir}/fw_env.config"

