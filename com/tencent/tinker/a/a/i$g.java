package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$g extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$g(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$g(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(this.voZ.Hv(i));
    }

    public final int size() {
        return i.a(this.voZ).vpm.size;
    }
}
