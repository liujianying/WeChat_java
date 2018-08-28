package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.e.2;
import com.tencent.mm.sdk.platformtools.x;

class e$2$1 implements Runnable {
    final /* synthetic */ long hgs;
    final /* synthetic */ boolean hgt;
    final /* synthetic */ long hgu;
    final /* synthetic */ 2 hgv;

    e$2$1(2 2, long j, boolean z, long j2) {
        this.hgv = 2;
        this.hgs = j;
        this.hgt = z;
        this.hgu = j2;
    }

    public final void run() {
        int i;
        f fVar = (f) this.hgv.hgr.hfF.get(Long.valueOf(this.hgs));
        Boolean.valueOf(false);
        if (this.hgt) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        if (fVar == null && i2 == 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[]{b.cY(this.hgs)});
            return;
        }
        if (this.hgv.hgr.hgn != null) {
            this.hgv.hgr.hgn.a(this.hgs, this.hgt, this.hgu);
            if (i2 != 0) {
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[]{b.cY(this.hgs)});
            }
        }
        if (i2 != 0) {
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[]{b.cY(this.hgs)});
            this.hgv.hgr.hfF.remove(Long.valueOf(this.hgs));
            this.hgv.hgr.hgp.remove(Long.valueOf(this.hgs));
        }
    }
}
