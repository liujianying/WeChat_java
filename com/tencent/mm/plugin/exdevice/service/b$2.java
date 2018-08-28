package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ int itv;
    final /* synthetic */ b iyw;
    final /* synthetic */ r iyx;
    final /* synthetic */ int[] iyy;

    b$2(b bVar, int i, r rVar, int[] iArr) {
        this.iyw = bVar;
        this.itv = i;
        this.iyx = rVar;
        this.iyy = iArr;
    }

    public final void run() {
        if (!b.a(this.iyw, this.itv, this.iyx, this.iyy)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
        }
    }
}
