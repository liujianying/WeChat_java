package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.1;

class ExdeviceConnectedRouterActivateStateUI$1$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ 1 iCD;

    ExdeviceConnectedRouterActivateStateUI$1$1(1 1, int i, int i2) {
        this.iCD = 1;
        this.bFr = i;
        this.bFq = i2;
    }

    public final void run() {
        if (this.bFr == 0 && (this.bFq == 0 || this.bFq == 4)) {
            this.iCD.iCC.ph(2);
        } else if (this.bFq != 4) {
            this.iCD.iCC.ph(4);
        } else if (this.bFr == 90000) {
            this.iCD.iCC.ph(3);
        } else {
            this.iCD.iCC.ph(5);
        }
    }
}
