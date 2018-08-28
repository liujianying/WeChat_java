package com.tencent.mm.plugin.appbrand.q;

import android.support.v4.e.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class g<K, V> {
    private final Map<K, Set<V>> gBs = new a();

    public final void o(K k, V v) {
        if (k != null) {
            Set l = l(k, true);
            synchronized (l) {
                l.add(v);
            }
        }
    }

    private Set<V> l(K k, boolean z) {
        Set<V> set;
        synchronized (this.gBs) {
            set = (Set) this.gBs.get(k);
            if (set == null && z) {
                set = new HashSet();
                this.gBs.put(k, set);
            }
        }
        return set;
    }

    public final Set<V> bo(K k) {
        if (k == null) {
            return null;
        }
        Collection l = l(k, false);
        if (l == null) {
            return Collections.emptySet();
        }
        Set<V> hashSet = new HashSet();
        synchronized (l) {
            hashSet.addAll(l);
        }
        return hashSet;
    }

    public final Set<V> bp(K k) {
        if (k == null) {
            return null;
        }
        Set<V> set;
        synchronized (this.gBs) {
            set = (Set) this.gBs.remove(k);
        }
        return set;
    }
}
