package com.tencent.mm.network;

import com.tencent.mm.network.t.b;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$b$1 extends bd<Object> {
    final /* synthetic */ int dKd;
    final /* synthetic */ int dKe;
    final /* synthetic */ r esU;
    final /* synthetic */ b esV;

    t$b$1(b bVar, r rVar, int i, int i2) {
        this.esV = bVar;
        this.esU = rVar;
        this.dKd = i;
        this.dKe = i2;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        try {
            t.a(b.a(this.esV), this.esU);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
        }
        return null;
    }
}
