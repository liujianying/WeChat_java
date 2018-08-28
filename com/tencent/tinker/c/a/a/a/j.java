package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private a vqO = null;
    private e vqP = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGq();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.off, aVar.HV(nVar.vpe), aVar.HV(nVar.vos), aVar.HU(nVar.vpf));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.vqO;
        aVar.size++;
        return this.vqP.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqO = iVar2.voQ.vpo;
            this.vqP = iVar2.a(this.vqO);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpo;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.vrI.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.vrW.HR(i);
        }
    }
}
