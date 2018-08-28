package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class y$3 implements Runnable {
    final /* synthetic */ int itv;
    final /* synthetic */ y izl;
    final /* synthetic */ j izm;

    y$3(y yVar, int i, j jVar) {
        this.izl = yVar;
        this.itv = i;
        this.izm = jVar;
    }

    public final void run() {
        if (!y.a(this.izl, this.itv, this.izm)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
        }
    }
}
