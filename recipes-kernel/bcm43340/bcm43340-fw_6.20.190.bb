DESCRIPTION = "Firmware files for use with Linux kernel"
SECTION = "kernel"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc"

SRC_URI = "file://firmware.tar"

S = "${WORKDIR}/firmware/"

inherit allarch

do_install() {
        install -v -d  ${D}${sysconfdir}/firmware/
        install -m 0755 bcmdhd_aob.cal_4334x_b0 ${D}/${sysconfdir}/firmware/bcmdhd_aob.cal
        install -m 0755 bcmdhd.cal_4334x_b0 ${D}/${sysconfdir}/firmware/bcmdhd.cal
        install -m 0755 fw_bcmdhd_p2p.bin_4334x_b0 ${D}/${sysconfdir}/firmware/fw_bcmdhd.bin
        install -m 0755 LICENCE.broadcom_bcm43xx ${D}/${sysconfdir}/firmware/
}
