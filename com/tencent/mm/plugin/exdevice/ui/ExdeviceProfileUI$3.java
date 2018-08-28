package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceProfileUI$3 implements Runnable {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$3(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void run() {
        ExdeviceProfileUI.g(this.iEx);
        ExdeviceProfileUI.l(this.iEx).notifyDataSetChanged();
    }
}
