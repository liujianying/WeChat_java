package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.aa;

public class f<K, O> extends aa<K, O> {
    private b<K, O> bwc = null;

    public interface a<K, O> {
    }

    public interface b<K, O> {
        void n(K k, O o);
    }

    public f(int i) {
        super(i);
    }

    public final void m(K k, O o) {
        if (o != null) {
            put(k, o);
        }
    }

    public void clear() {
        super.trimToSize(-1);
    }

    public f(int i, b<K, O> bVar) {
        super(i);
        this.bwc = bVar;
    }

    public final void trimToSize(int i) {
        super.trimToSize(i);
    }

    protected final O create(K k) {
        return super.create(k);
    }

    public void entryRemoved(boolean z, K k, O o, O o2) {
        super.entryRemoved(z, k, o, o2);
        if (this.bwc != null && o2 == null) {
            this.bwc.n(k, o);
        }
    }

    public int sizeOf(K k, O o) {
        return super.sizeOf(k, o);
    }

    public void a(a<K, O> aVar) {
        clear();
    }
}
