package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$6 implements Runnable {
    final /* synthetic */ long iyB;
    final /* synthetic */ b iyw;

    b$6(b bVar, long j) {
        this.iyw = bVar;
        this.iyB = j;
    }

    public final void run() {
        if (!b.a(this.iyw, this.iyB)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
        }
    }
}
