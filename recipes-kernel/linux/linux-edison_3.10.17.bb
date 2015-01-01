require linux.inc

DESCRIPTION = "Linux kernel for the Intel Edison board"
KERNEL_IMAGETYPE ?= "bzImage"

COMPATIBLE_MACHINE = "(edison)"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-edison:${THISDIR}/linux-edison/${MACHINE}:"

PV = "3.10.17"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.10.y"
SRCREV_pn-${PN} = "14e9c7db465387ede7f019c42f28c90f99fc2793"

S = "${WORKDIR}/git"

SRC_URI += " \
             file://0001-Squashed-all-commits-from-upstream-to-Edison.patch \
             file://0002-block-cgroups-kconfig-build-bits-for-BFQ-v7r7-3.10.8.patch \
             file://0003-block-introduce-the-BFQ-v7r7-I-O-sched-for-3.10.8.patch \
             file://0004-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r7-for-.patch \
             file://defconfig \
"
