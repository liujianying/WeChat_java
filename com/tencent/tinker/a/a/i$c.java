package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$c extends AbstractList<p> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$c(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$c(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.voZ).vpp.size);
        return this.voZ.Hu(i.a(this.voZ).vpp.off + (i * 8)).cGr();
    }

    public final int size() {
        return i.a(this.voZ).vpp.size;
    }
}
