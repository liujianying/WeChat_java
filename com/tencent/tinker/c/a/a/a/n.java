package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c.c;

public final class n extends i<s> {
    private t$a vqW = null;
    private t$a vqX = null;
    private e vqY = null;
    private e vqZ = null;

    protected final /* synthetic */ int e(Comparable comparable) {
        int a = this.vqY.a((s) comparable);
        this.vqZ.writeInt(a);
        t$a t_a = this.vqW;
        t_a.size++;
        t_a = this.vqX;
        t_a.size++;
        return a;
    }

    public n(a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqW = iVar2.voQ.vpx;
            this.vqX = iVar2.voQ.vpl;
            this.vqY = iVar2.a(this.vqW);
            this.vqZ = iVar2.a(this.vqX);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.voQ.vpx;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.vrF.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.vrT.HR(i);
        }
    }
}
