package com.tencent.mm.bt.a;

import android.util.SparseArray;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d teA;

    public abstract ArrayList<T> ae(ArrayList<Object> arrayList);

    public abstract T coe();

    public g(d dVar, int i) {
        this.teA = dVar;
        this.teA.lo(true);
        this.teA.a(new 1(this));
        if (i != 0) {
            this.teA.Dz(i);
        }
        getCount();
    }

    public final void close() {
        this.teA.close();
        this.teA = null;
    }

    public final int getCount() {
        return this.teA.getCount();
    }

    public final boolean isClosed() {
        return this.teA.isClosed();
    }

    public final boolean cnU() {
        return this.teA.cnU();
    }

    public final void c(Object obj, T t) {
        this.teA.a(obj, t);
    }

    public final SparseArray<K>[] cnS() {
        return this.teA.cnS();
    }

    public final boolean cm(Object obj) {
        return this.teA.cm(obj);
    }
}
