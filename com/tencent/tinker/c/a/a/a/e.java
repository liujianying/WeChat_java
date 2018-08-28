package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a vqG = null;
    private i$e vqH = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGw();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.off, aVar.b(eVar.vok), aVar.b(eVar.vol), aVar.b(eVar.vom), aVar.b(eVar.von));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.vqG;
        aVar.size++;
        return this.vqH.a(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqG = iVar2.voQ.vpv;
            this.vqH = iVar2.a(this.vqG);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpv;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrQ.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vse.HR(i2);
        }
    }
}
