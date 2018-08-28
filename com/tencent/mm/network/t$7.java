package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class t$7 extends bd<Integer> {
    final /* synthetic */ r esB;
    final /* synthetic */ l esC;
    final /* synthetic */ t esu;

    t$7(t tVar, Integer num, r rVar, l lVar) {
        this.esu = tVar;
        this.esB = rVar;
        this.esC = lVar;
        super(3000, num, (byte) 0);
    }

    private Integer UH() {
        try {
            return Integer.valueOf(t.a(this.esu, this.esB, this.esC));
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
            t.a(this.esu);
            return Integer.valueOf(-1);
        }
    }
}
