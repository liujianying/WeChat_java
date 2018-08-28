package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$a extends AbstractList<f> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$a(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$a(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.voZ).vpq.size);
        return this.voZ.Hu(i.a(this.voZ).vpq.off + (i * 32)).cGt();
    }

    public final int size() {
        return i.a(this.voZ).vpq.size;
    }
}
