require linux.inc

DESCRIPTION = "Linux kernel for the Intel Edison board"
KERNEL_IMAGETYPE ?= "bzImage"

COMPATIBLE_MACHINE = "(edison)"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-edison:${THISDIR}/linux-edison/${MACHINE}:"

PV = "3.10.58"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.10.y"
SRCREV_pn-${PN} = "0b9c3a46536a5be91175e280882f74890e617eef"

S = "${WORKDIR}/git"

SRC_URI += " \
             file://upstream_to_edison.patch \
             file://defconfig \
"
