package de.neonew.mesh.android

import de.neonew.mesh.android.Runner.Companion.runAsRoot

class WifiAdhoc {
    companion object {
        fun startMesh(ip: String, name: String) {
            runAsRoot("ifconfig wlan0 down")
            runAsRoot("echo \"/system/etc/wifi/bcmdhd_ibss.bin\" >> /sys/module/dhd/parameters/firmware_path")
            runAsRoot("echo \"/system/etc/wifi/nvram_net.txt\" >> /sys/module/dhd/parameters/nvram_path")
            runAsRoot("ifconfig wlan0 ${ip} netmask 255.255.0.0 up")
            runAsRoot("iw wlan0 set type ibss")
            runAsRoot("iw wlan0 ibss join ${name} 2412 00:11:22:33:44:55")
        }
    }
}
