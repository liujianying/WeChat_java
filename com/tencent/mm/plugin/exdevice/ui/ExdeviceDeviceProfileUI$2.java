package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceDeviceProfileUI$2 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$2(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void run() {
        if (ExdeviceDeviceProfileUI.g(this.iCP) != null && ExdeviceDeviceProfileUI.g(this.iCP).isShowing()) {
            ExdeviceDeviceProfileUI.g(this.iCP).dismiss();
        }
        if (ExdeviceDeviceProfileUI.h(this.iCP) != null && ExdeviceDeviceProfileUI.h(this.iCP).isShowing()) {
            ExdeviceDeviceProfileUI.h(this.iCP).dismiss();
        }
    }
}
