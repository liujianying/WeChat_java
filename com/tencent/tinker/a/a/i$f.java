package com.tencent.tinker.a.a;

import java.util.AbstractList;
import java.util.RandomAccess;

final class i$f extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ i voZ;

    private i$f(i iVar) {
        this.voZ = iVar;
    }

    /* synthetic */ i$f(i iVar, byte b) {
        this(iVar);
    }

    /* renamed from: te */
    public final String get(int i) {
        i.fH(i, i.a(this.voZ).vpl.size);
        return this.voZ.Hu(this.voZ.Hu(i.a(this.voZ).vpl.off + (i * 4)).aig.getInt()).cGo().value;
    }

    public final int size() {
        return i.a(this.voZ).vpl.size;
    }
}
