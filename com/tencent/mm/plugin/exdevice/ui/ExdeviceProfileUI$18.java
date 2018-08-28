package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceProfileUI$18 implements Runnable {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$18(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void run() {
        if (ExdeviceProfileUI.d(this.iEx) != null) {
            ExdeviceProfileUI.d(this.iEx).show();
        }
    }
}
