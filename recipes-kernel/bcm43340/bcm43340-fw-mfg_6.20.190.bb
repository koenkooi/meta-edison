DESCRIPTION = "MFG Firmware files for use with Linux kernel and FCC/EC specific tests"
SECTION = "kernel"

LICENSE = "CLOSED"

SRC_URI = "file://firmware.tar"

S = "${WORKDIR}/firmware"

inherit allarch

do_install() {
        install -v -d  ${D}/${sysconfdir}/firmware/
        install -m 0755 bcmdhd_mfg.cal_4334x_b0 ${D}/${sysconfdir}/firmware/bcmdhd_mfg.cal
        install -m 0755 fw_bcmdhd_mfg.bin_4334x_b0 ${D}/${sysconfdir}/firmware/fw_bcmdhd_mfg.bin
}
