DESCRIPTION = "Broadcom wifi driver for the 43340"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f9986853fb3b3403700e7535a392d014"

inherit module

SRC_URI = "file://driver_bcm43x.tar"

S = "${WORKDIR}/driver_bcm43x/"

do_clean() {
    make clean
}

RDEPENDS_${PN} += "bcm43340-fw"
