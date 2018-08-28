package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ int itv;
    final /* synthetic */ b iyw;

    b$3(b bVar, int i) {
        this.iyw = bVar;
        this.itv = i;
    }

    public final void run() {
        if (!b.a(this.iyw, this.itv)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
        }
    }
}
