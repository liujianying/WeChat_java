package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a vqI = null;
    private i$e vqJ = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGt();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        return new com.tencent.tinker.a.a.f(fVar.off, aVar.HV(fVar.vos), fVar.vop, aVar.HV(fVar.vot), aVar.HZ(fVar.vou), aVar.HU(fVar.vov), aVar.Id(fVar.vow), aVar.If(fVar.vox), aVar.Ie(fVar.voy));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.vqI;
        aVar.size++;
        return this.vqJ.a(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqI = iVar2.voQ.vpq;
            this.vqJ = iVar2.a(this.vqI);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpq;
    }
}
