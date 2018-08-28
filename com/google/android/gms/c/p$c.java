package com.google.android.gms.c;

import com.google.android.gms.c.p.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class p$c implements Set<K> {
    final /* synthetic */ p aXK;

    p$c(p pVar) {
        this.aXK = pVar;
    }

    public final boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.aXK.bT();
    }

    public final boolean contains(Object obj) {
        return this.aXK.h(obj) >= 0;
    }

    public final boolean containsAll(Collection<?> collection) {
        Map bS = this.aXK.bS();
        for (Object containsKey : collection) {
            if (!bS.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return p.a(this, obj);
    }

    public final int hashCode() {
        int i = 0;
        for (int bR = this.aXK.bR() - 1; bR >= 0; bR--) {
            Object p = this.aXK.p(bR, 0);
            i += p == null ? 0 : p.hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.aXK.bR() == 0;
    }

    public final Iterator<K> iterator() {
        return new a(this.aXK, 0);
    }

    public final boolean remove(Object obj) {
        int h = this.aXK.h(obj);
        if (h < 0) {
            return false;
        }
        this.aXK.ac(h);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        Map bS = this.aXK.bS();
        int size = bS.size();
        for (Object remove : collection) {
            bS.remove(remove);
        }
        return size != bS.size();
    }

    public final boolean retainAll(Collection<?> collection) {
        Map bS = this.aXK.bS();
        int size = bS.size();
        Iterator it = bS.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != bS.size();
    }

    public final int size() {
        return this.aXK.bR();
    }

    public final Object[] toArray() {
        return this.aXK.ai(0);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.aXK.b(tArr, 0);
    }
}
