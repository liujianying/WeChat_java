package com.tencent.mm.ak.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V> {
    private f<K, V> dYh;

    public a(int i) {
        this.dYh = new f(i);
    }

    public final void clear() {
        if (this.dYh == null) {
            throw new NullPointerException("mData == null");
        }
        this.dYh.trimToSize(-1);
    }

    public final synchronized boolean bb(K k) {
        if (this.dYh == null) {
            throw new NullPointerException("mData == null");
        }
        return this.dYh.bb(k);
    }

    public final V get(K k) {
        if (this.dYh != null) {
            return this.dYh.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.dYh != null) {
            return this.dYh.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized Map<K, V> snapshot() {
        if (this.dYh == null) {
            throw new NullPointerException("mData == null");
        }
        return this.dYh.snapshot();
    }

    public final synchronized String toString() {
        if (this.dYh == null) {
            throw new NullPointerException("mData == null");
        }
        return this.dYh.toString();
    }
}
