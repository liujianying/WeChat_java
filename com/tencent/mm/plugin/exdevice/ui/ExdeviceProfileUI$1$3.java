package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1;

class ExdeviceProfileUI$1$3 implements Runnable {
    final /* synthetic */ 1 iEz;

    ExdeviceProfileUI$1$3(1 1) {
        this.iEz = 1;
    }

    public final void run() {
        ExdeviceProfileUI.k(this.iEz.iEx);
        ExdeviceProfileUI.l(this.iEz.iEx).notifyDataSetChanged();
    }
}
