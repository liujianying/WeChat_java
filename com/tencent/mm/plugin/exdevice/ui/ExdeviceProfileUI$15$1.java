package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.15;

class ExdeviceProfileUI$15$1 implements Runnable {
    final /* synthetic */ 15 iEB;

    ExdeviceProfileUI$15$1(15 15) {
        this.iEB = 15;
    }

    public final void run() {
        if (ExdeviceProfileUI.d(this.iEB.iEx) != null) {
            ExdeviceProfileUI.d(this.iEB.iEx).dismiss();
        }
    }
}
