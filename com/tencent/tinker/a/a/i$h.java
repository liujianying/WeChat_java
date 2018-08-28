package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$h extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$h(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$h(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        return i.b(this.voZ).te(this.voZ.Hv(i));
    }

    public final int size() {
        return i.a(this.voZ).vpm.size;
    }
}
