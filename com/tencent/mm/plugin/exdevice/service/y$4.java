package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class y$4 implements Runnable {
    final /* synthetic */ int itv;
    final /* synthetic */ y izl;
    final /* synthetic */ j izm;

    y$4(y yVar, int i, j jVar) {
        this.izl = yVar;
        this.itv = i;
        this.izm = jVar;
    }

    public final void run() {
        if (!y.b(this.izl, this.itv, this.izm)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
        }
    }
}
