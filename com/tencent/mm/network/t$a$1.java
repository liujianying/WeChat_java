package com.tencent.mm.network;

import com.tencent.mm.network.t.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$a$1 extends bd<Object> {
    final /* synthetic */ int dKd;
    final /* synthetic */ int dKe;
    final /* synthetic */ r esR;
    final /* synthetic */ String esS;
    final /* synthetic */ a esT;

    t$a$1(a aVar, r rVar, int i, int i2, String str) {
        this.esT = aVar;
        this.esR = rVar;
        this.dKd = i;
        this.dKe = i2;
        this.esS = str;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        try {
            t.a(a.a(this.esT), this.esR, this.esS);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
        }
        return null;
    }
}
