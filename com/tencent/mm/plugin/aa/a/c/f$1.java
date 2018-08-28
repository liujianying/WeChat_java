package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ab.a$a;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class f$1 implements a<Void, a$a<q>> {
    final /* synthetic */ b eBj;
    final /* synthetic */ f eBz;

    f$1(f fVar, b bVar) {
        this.eBz = fVar;
        this.eBj = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a a_a = (a$a) obj;
        x.i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", new Object[]{Integer.valueOf(a_a.errType), Integer.valueOf(a_a.errCode), Integer.valueOf(((q) a_a.dIv).hUm), ((q) a_a.dIv).hUn});
        this.eBj.resume();
        return uQG;
    }
}
