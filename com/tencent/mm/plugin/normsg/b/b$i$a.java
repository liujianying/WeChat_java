package com.tencent.mm.plugin.normsg.b;

import android.util.SparseArray;
import com.tencent.mm.plugin.normsg.b.b.i;

final class b$i$a<T> extends SparseArray<T> {
    final /* synthetic */ i lGR;

    private b$i$a(i iVar) {
        this.lGR = iVar;
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final void put(int i, T t) {
        if (get(i) != null) {
            throw new UnsupportedOperationException();
        }
        super.put(i, t);
    }
}
