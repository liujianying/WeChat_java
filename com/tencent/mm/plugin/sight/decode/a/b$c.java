package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.x;

class b$c implements Runnable {
    volatile boolean lhj = false;
    final /* synthetic */ b ncT;
    int nda;
    b$b ndb;

    public b$c(b bVar) {
        this.ncT = bVar;
        x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
    }

    public final void run() {
        if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode())});
            return;
        }
        this.ncT.E(b.B(this.ncT));
        if (b.r(this.ncT) == 0) {
            o.d(this.ndb, 0);
            return;
        }
        long currentTimeMillis = ((long) this.ncT.ncn) - (System.currentTimeMillis() - b.r(this.ncT));
        if (currentTimeMillis > 0) {
            o.d(this.ndb, currentTimeMillis);
        } else {
            o.d(this.ndb, 0);
        }
    }
}
