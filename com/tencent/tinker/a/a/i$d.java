package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$d extends AbstractList<r> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$d(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$d(i iVar, byte b) {
        this(iVar);
    }

    public final /* synthetic */ Object get(int i) {
        i.fH(i, i.a(this.voZ).vpn.size);
        return this.voZ.Hu(i.a(this.voZ).vpn.off + (i * 12)).cGs();
    }

    public final int size() {
        return i.a(this.voZ).vpn.size;
    }
}
