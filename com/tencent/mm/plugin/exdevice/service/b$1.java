package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.h.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b iyv;

    b$1(b bVar) {
        this.iyv = bVar;
    }

    public final void run() {
        b.a(this.iyv, new b(ad.getContext(), this.iyv, v.aHH().egm));
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
        b.a(this.iyv).countDown();
    }
}
