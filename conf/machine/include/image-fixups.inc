
ROOTFS_POSTPROCESS_COMMAND += "edison_fixup_watchdog ; "

edison_fixup_watchdog() {
    ( cd ${IMAGE_ROOTFS}

    # Set WDT to 90s, otherwise it will hang ~68s after bootup
    if [ -e etc/systemd/system.conf ] ; then
        sed -i /RuntimeWatchdogSec/d etc/systemd/system.conf
        echo 'RuntimeWatchdogSec=90' >> etc/systemd/system.conf
    fi )
}

