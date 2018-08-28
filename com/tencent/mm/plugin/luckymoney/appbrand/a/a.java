package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.by.f;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhp;

public abstract class a<Req extends bhd, Resp extends bhp> {
    private com.tencent.mm.ab.a kKL;
    Req kKM;
    private Resp kKN;

    protected abstract int If();

    protected abstract Resp bax();

    protected abstract String getUri();

    public final <T> f<T> b(com.tencent.mm.vending.c.a<T, com.tencent.mm.ab.a.a<Resp>> aVar) {
        boolean z = true;
        bay();
        this.kKN = bax();
        this.kKL = new com.tencent.mm.ab.a();
        com.tencent.mm.ab.a aVar2 = this.kKL;
        bhd bhd = this.kKM;
        bhp bhp = this.kKN;
        if (bhd == null || bhp == null) {
            StringBuilder append = new StringBuilder("CgiBase called withoud req or resp req?[").append(bhd == null).append("] resp?[");
            if (bhp != null) {
                z = false;
            }
            throw new IllegalStateException(append.append(z).append("]").toString());
        }
        com.tencent.mm.ab.b.a aVar3 = new com.tencent.mm.ab.b.a();
        aVar3.dIF = If();
        aVar3.uri = getUri();
        aVar3.dIG = bhd;
        aVar3.dIH = bhp;
        aVar2.diG = aVar3.KT();
        return this.kKL.KM().g(new 1(this)).b(aVar);
    }

    protected void bay() {
    }

    protected void baz() {
    }
}
