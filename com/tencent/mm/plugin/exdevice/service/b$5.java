package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.x;

class b$5 implements Runnable {
    final /* synthetic */ long iyB;
    final /* synthetic */ byte[] iyC;
    final /* synthetic */ b iyw;

    b$5(b bVar, long j, byte[] bArr) {
        this.iyw = bVar;
        this.iyB = j;
        this.iyC = bArr;
    }

    public final void run() {
        if (!b.a(this.iyw, this.iyB, this.iyC)) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
        }
    }
}
