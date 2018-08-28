package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class l extends i<r> {
    private a vqS = null;
    private e vqT = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGs();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        r rVar = (r) comparable;
        return new r(rVar.off, aVar.HU(rVar.vph), aVar.HV(rVar.vpi), aVar.HZ(rVar.vpj));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        r rVar = (r) comparable;
        a aVar = this.vqS;
        aVar.size++;
        return this.vqT.a(rVar);
    }

    public l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqS = iVar2.voQ.vpn;
            this.vqT = iVar2.a(this.vqS);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpn;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.vrH.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.vrV.HR(i);
        }
    }
}
