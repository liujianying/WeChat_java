package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.c.c;

public final class p extends i<u> {
    private a vrc = null;
    private e vrd = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGp();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        u uVar = (u) comparable;
        if (uVar == u.vpK) {
            return uVar;
        }
        short[] sArr = new short[uVar.vpL.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) aVar.HV(uVar.vpL[i]);
        }
        return new u(uVar.off, sArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        u uVar = (u) comparable;
        a aVar = this.vrc;
        aVar.size++;
        return this.vrd.a(uVar);
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vrc = iVar2.voQ.vps;
            this.vrd = iVar2.a(this.vrc);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vps;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrK.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vrY.HR(i2);
        }
    }
}
