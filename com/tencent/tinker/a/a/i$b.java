package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$b extends AbstractList<n> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$b(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$b(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.voZ).vpo.size);
        return this.voZ.Hu(i.a(this.voZ).vpo.off + (i * 8)).cGq();
    }

    public final int size() {
        return i.a(this.voZ).vpo.size;
    }
}
