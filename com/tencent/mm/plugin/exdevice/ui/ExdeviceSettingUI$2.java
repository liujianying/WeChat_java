package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceSettingUI$2 implements Runnable {
    final /* synthetic */ ExdeviceSettingUI iFZ;

    ExdeviceSettingUI$2(ExdeviceSettingUI exdeviceSettingUI) {
        this.iFZ = exdeviceSettingUI;
    }

    public final void run() {
        ExdeviceSettingUI.a(this.iFZ).dismiss();
    }
}
