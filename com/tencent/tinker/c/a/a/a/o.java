package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class o extends i<Integer> {
    private a vra = null;
    private e vrb = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.aig.getInt());
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        return Integer.valueOf(aVar.HU(((Integer) comparable).intValue()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.vrb.aig.position();
        this.vrb.writeInt(num.intValue());
        a aVar = this.vra;
        aVar.size++;
        return position;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vra = iVar2.voQ.vpm;
            this.vrb = iVar2.a(this.vra);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpm;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.vrG.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.vrU.HR(i);
        }
    }
}
