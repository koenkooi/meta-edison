FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION_edison = "3.10.17"

SRCREV_machine_edison = "c03195ed6e3066494e3fb4be69154a57066e845b"
SRCREV_meta_edison = "6ad20f049abd52b515a8e0a4664861cfd331f684"

SRC_URI += "file://upstream_to_edison.patch \
            file://defconfig"

do_patch_edison() {
    cd ${S}
    git am "${WORKDIR}/upstream_to_edison.patch"
}

do_configure_edison() {
    cp "${WORKDIR}/defconfig" "${B}/.config"
    yes '' | make oldconfig
}

do_kernel_configme_edison() {
    cp "${WORKDIR}/defconfig" "${B}/.config"
    yes '' | make oldconfig
}

