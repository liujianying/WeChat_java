package com.tencent.mm.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class bg extends l implements k {
    private final a dCJ;
    private final String dCK;
    private long dCL;
    private e diJ;

    public interface a {
        void a(com.tencent.mm.network.e eVar);
    }

    public bg(a aVar) {
        this(aVar, null);
    }

    public bg(a aVar, String str) {
        x.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, bi.cjd());
        this.dCJ = aVar;
        this.dCK = str;
    }

    public final int getType() {
        return 0;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        c(eVar);
        this.diJ = eVar2;
        this.dCL = bi.VG();
        g.Em().H(new Runnable() {
            public final void run() {
                bg.this.a(0, 0, 0, null, null, null);
            }

            public final String toString() {
                return super.toString() + "|doScene";
            }
        });
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.dCJ != null) {
            x.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.dCK, Long.valueOf(bi.bI(this.dCL)));
            this.dCJ.a(this.dIX);
        }
        this.diJ.a(0, 0, null, this);
    }
}
