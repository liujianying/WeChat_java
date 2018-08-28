package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.sdk.platformtools.x;

class f$4 implements Runnable {
    final /* synthetic */ f hgG;

    f$4(f fVar) {
        this.hgG = fVar;
    }

    public final void run() {
        if (f.k(this.hgG)) {
            if (f.i(this.hgG) != null) {
                f.i(this.hgG).a(f.g(this.hgG), false, f.l(this.hgG));
            }
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
            f.m(this.hgG);
        }
    }
}
