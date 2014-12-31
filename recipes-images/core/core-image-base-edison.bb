require recipes-core/images/core-image-base.bb

DESCRIPTION = "Core-image-base for EDISON"

INITRD = ""
INITRD_IMAGE = ""

# Do not use legacy nor EFI BIOS
PCBIOS = "0"
# Do not support bootable USB stick
NOISO = "1"
ROOTFS = ""

# This is useless stuff, but necessary for building because
# inheriting bootimg also brings syslinux in..
AUTO_SYSLINUXCFG = "1"
SYSLINUX_ROOT = ""
SYSLINUX_TIMEOUT ?= "10"
SYSLINUX_LABELS ?= "boot install"
LABELS_append = " ${SYSLINUX_LABELS} "


# Specify rootfs image type
IMAGE_FSTYPES = "ext4"

# This has to be set after including core-image otherwise it's overriden with "1"
# and this cancel creation of the boot hddimg
NOHDD = "0"

inherit bootimg
do_bootimg[depends] += "${PN}:do_rootfs"

IMAGE_ROOTFS_SIZE = "524288"

IMAGE_INSTALL += "u-boot-edison \
                  u-boot-edison-fw-utils"

# The packages below aren't in any public layer yet, so add a 'DISABLED_' prefix to mark them as TODO.

# Wifi firmware
DISABLED_IMAGE_INSTALL += "bcm43340-fw \
                  bcm43340-bt \
                  bcm43340-mod \
                 "

# service daemon that listens to rfkill events and trigger FW patch download
DISABLED_IMAGE_INSTALL += "bluetooth-rfkill-event"

