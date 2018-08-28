package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$1 extends bd<Object> {
    final /* synthetic */ int dJV;
    final /* synthetic */ t esu;

    t$1(t tVar, int i) {
        this.esu = tVar;
        this.dJV = i;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        try {
            t.iL(this.dJV);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
        }
        return null;
    }
}
