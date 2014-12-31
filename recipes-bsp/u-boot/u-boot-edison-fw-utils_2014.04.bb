SUMMARY = "U-boot bootloader fw_printenv/setenv utils"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

SECTION = "bootloader"

DEPENDS = "virtual/bootloader"

PV = "2014.04"
SRCREV = "dda0dbfc69f3d560c87f5be85f127ed862ea6721"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master \
           file://upstream_to_edison.patch \
           file://${MACHINE}.env \
           file://target_env/*.env \
           file://fw_env.config \
          "
 
S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

do_compile () {
  oe_runmake ${UBOOT_MACHINE}
  oe_runmake env
}

do_install () {
  install -d ${D}${sbindir}
  install -m 755 ${S}/tools/env/fw_printenv_unstripped ${D}${sbindir}/fw_printenv
  # This is not a typo, this tool checks the args[0] to change its behavior a-la-busybox
  install -m 755 ${S}/tools/env/fw_printenv_unstripped ${D}${sbindir}/fw_setenv
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${sbindir}/*"
FILES_${PN} += "${sysconfdir}/fw_env.config"

