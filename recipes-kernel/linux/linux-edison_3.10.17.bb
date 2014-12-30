require linux.inc

DESCRIPTION = "Linux kernel for the Intel Edison board"
KERNEL_IMAGETYPE ?= "bzImage"

COMPATIBLE_MACHINE = "(edison)"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-edison:${THISDIR}/linux-edison/${MACHINE}"

PV = "3.10.17"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.10.y"
SRCREV_pn-${PN} = "14e9c7db465387ede7f019c42f28c90f99fc2793"

S = "${WORKDIR}/git"

SRC_URI += " \
             file://upstream_to_edison.patch \
             file://defconfig \
"
