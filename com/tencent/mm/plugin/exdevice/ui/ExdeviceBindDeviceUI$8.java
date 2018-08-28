package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;

class ExdeviceBindDeviceUI$8 implements Runnable {
    final /* synthetic */ ExdeviceBindDeviceUI iBf;
    final /* synthetic */ int iBi;
    final /* synthetic */ int iBj;
    final /* synthetic */ String iBk;
    final /* synthetic */ l iBl;

    ExdeviceBindDeviceUI$8(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, l lVar) {
        this.iBf = exdeviceBindDeviceUI;
        this.iBi = i;
        this.iBj = i2;
        this.iBk = str;
        this.iBl = lVar;
    }

    public final void run() {
        ExdeviceBindDeviceUI.a(this.iBf, this.iBi, this.iBj, this.iBk, this.iBl);
    }
}
