package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f hgG;

    f$2(f fVar) {
        this.hgG = fVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[]{b.cY(f.g(this.hgG)), f.h(this.hgG).getName()});
        if (f.i(this.hgG) != null) {
            f.i(this.hgG).j(f.g(this.hgG), false);
        }
        f.j(this.hgG);
    }
}
