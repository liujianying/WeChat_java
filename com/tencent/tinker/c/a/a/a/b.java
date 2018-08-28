package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class b extends i<c> {
    private a vqA = null;
    private e vqB = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGz();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.vof.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.Ib(cVar.vof[i]);
        }
        return new c(cVar.off, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        c cVar = (c) comparable;
        a aVar = this.vqA;
        aVar.size++;
        return this.vqB.a(cVar);
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqA = iVar2.voQ.vpt;
            this.vqB = iVar2.a(this.vqA);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpt;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrN.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vsb.HR(i2);
        }
    }
}
