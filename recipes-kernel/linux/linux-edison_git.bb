require linux.inc

DESCRIPTION = "Linux kernel for the Intel Edison board"
KERNEL_IMAGETYPE ?= "bzImage"

COMPATIBLE_MACHINE = "(edison)"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-edison:${THISDIR}/linux-edison/${MACHINE}:"

PV = "3.10.32"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.10.y"
SRCREV_pn-${PN} = "61dde96f97bb5b1ed4c11caf9a857d55ad8f6e17"

S = "${WORKDIR}/git"

SRC_URI += " \
             file://0001-Squashed-all-commits-from-upstream-to-Edison.patch \
             file://0002-block-cgroups-kconfig-build-bits-for-BFQ-v7r7-3.10.8.patch \
             file://0003-block-introduce-the-BFQ-v7r7-I-O-sched-for-3.10.8.patch \
             file://0004-block-bfq-add-Early-Queue-Merge-EQM-to-BFQ-v7r7-for-.patch \
             file://defconfig \
"
