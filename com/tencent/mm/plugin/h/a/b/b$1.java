package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b hfM;

    b$1(b bVar) {
        this.hfM = bVar;
    }

    public final void run() {
        this.hfM.hfG = false;
        this.hfM.dI(false);
        x.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
        this.hfM.atM();
        if (this.hfM.hfE != null) {
            this.hfM.hfE.atO();
        }
    }
}
