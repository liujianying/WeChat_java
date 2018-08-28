package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.sdk.platformtools.x;

class e$3 implements Runnable {
    final /* synthetic */ e hgr;

    e$3(e eVar) {
        this.hgr = eVar;
    }

    public final void run() {
        this.hgr.hfH.a(false, this.hgr.hfK);
        x.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
    }
}
