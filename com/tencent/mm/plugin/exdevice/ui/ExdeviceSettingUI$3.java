package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceSettingUI$3 implements Runnable {
    final /* synthetic */ ExdeviceSettingUI iFZ;

    ExdeviceSettingUI$3(ExdeviceSettingUI exdeviceSettingUI) {
        this.iFZ = exdeviceSettingUI;
    }

    public final void run() {
        ExdeviceSettingUI.a(this.iFZ).dismiss();
    }
}
