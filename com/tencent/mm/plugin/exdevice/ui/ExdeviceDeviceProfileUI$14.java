package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceDeviceProfileUI$14 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$14(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void run() {
        ExdeviceDeviceProfileUI.a(this.iCP, null);
        ExdeviceDeviceProfileUI.a(this.iCP, false);
        ExdeviceDeviceProfileUI.f(this.iCP);
        this.iCP.tCL.notifyDataSetChanged();
    }
}
