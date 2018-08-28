package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceDeviceProfileUI$13 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$13(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void run() {
        ExdeviceDeviceProfileUI.a(this.iCP, (DeviceProfileHeaderPreference) this.iCP.tCL.ZZ("device_profile_header"));
    }
}
