package com.google.android.gms.c;

import com.google.android.gms.c.p.a;
import java.util.Collection;
import java.util.Iterator;

final class p$e implements Collection<V> {
    final /* synthetic */ p aXK;

    p$e(p pVar) {
        this.aXK = pVar;
    }

    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.aXK.bT();
    }

    public final boolean contains(Object obj) {
        return this.aXK.i(obj) >= 0;
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.aXK.bR() == 0;
    }

    public final Iterator<V> iterator() {
        return new a(this.aXK, 1);
    }

    public final boolean remove(Object obj) {
        int i = this.aXK.i(obj);
        if (i < 0) {
            return false;
        }
        this.aXK.ac(i);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        int bR = this.aXK.bR();
        int i = 0;
        boolean z = false;
        while (i < bR) {
            if (collection.contains(this.aXK.p(i, 1))) {
                this.aXK.ac(i);
                i--;
                bR--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        int bR = this.aXK.bR();
        int i = 0;
        boolean z = false;
        while (i < bR) {
            if (!collection.contains(this.aXK.p(i, 1))) {
                this.aXK.ac(i);
                i--;
                bR--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final int size() {
        return this.aXK.bR();
    }

    public final Object[] toArray() {
        return this.aXK.ai(1);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.aXK.b(tArr, 1);
    }
}
