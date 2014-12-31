require recipes-bsp/u-boot/u-boot.inc
require u-boot-target-env.inc
require u-boot-osip.inc

PV = "2014.04"
SRCREV = "dda0dbfc69f3d560c87f5be85f127ed862ea6721"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master \
           file://upstream_to_edison.patch \
	   file://${MACHINE}.env \
	   file://target_env/*.env \
	  "

S = "${WORKDIR}/git"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PACKAGE_ARCH = "${MACHINE_ARCH}"
