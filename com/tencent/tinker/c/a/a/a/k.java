package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;

public final class k extends i<p> {
    private t$a vqQ = null;
    private e vqR = null;

    protected final /* synthetic */ Comparable a(a aVar, Comparable comparable) {
        p pVar = (p) comparable;
        return new p(pVar.off, aVar.HV(pVar.vpe), aVar.HW(pVar.vpg), aVar.HU(pVar.vpf));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        p pVar = (p) comparable;
        t$a t_a = this.vqQ;
        t_a.size++;
        return this.vqR.a(pVar);
    }

    public k(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqQ = iVar2.voQ.vpp;
            this.vqR = iVar2.a(this.vqQ);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.voQ.vpp;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.vrJ.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.vrX.HR(i);
        }
    }
}
