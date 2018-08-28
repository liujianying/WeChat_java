package com.google.android.gms.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class p<K, V> {
    b aXH;
    c aXI;
    e aXJ;

    final class b implements Set<Entry<K, V>> {
        b() {
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bR = p.this.bR();
            for (Entry entry : collection) {
                p.this.b(entry.getKey(), entry.getValue());
            }
            return bR != p.this.bR();
        }

        public final void clear() {
            p.this.bT();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int h = p.this.h(entry.getKey());
            return h >= 0 ? n.c(p.this.p(h, 1), entry.getValue()) : false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return p.a(this, obj);
        }

        public final int hashCode() {
            int bR = p.this.bR() - 1;
            int i = 0;
            while (bR >= 0) {
                Object p = p.this.p(bR, 0);
                Object p2 = p.this.p(bR, 1);
                bR--;
                i += (p2 == null ? 0 : p2.hashCode()) ^ (p == null ? 0 : p.hashCode());
            }
            return i;
        }

        public final boolean isEmpty() {
            return p.this.bR() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(p.this);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return p.this.bR();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    p() {
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    protected abstract void ac(int i);

    public final Object[] ai(int i) {
        int bR = bR();
        Object[] objArr = new Object[bR];
        for (int i2 = 0; i2 < bR; i2++) {
            objArr[i2] = p(i2, i);
        }
        return objArr;
    }

    protected abstract V b(int i, V v);

    protected abstract void b(K k, V v);

    public final <T> T[] b(T[] tArr, int i) {
        int bR = bR();
        T[] tArr2 = tArr.length < bR ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bR) : tArr;
        for (int i2 = 0; i2 < bR; i2++) {
            tArr2[i2] = p(i2, i);
        }
        if (tArr2.length > bR) {
            tArr2[bR] = null;
        }
        return tArr2;
    }

    protected abstract int bR();

    protected abstract Map<K, V> bS();

    protected abstract void bT();

    protected abstract int h(Object obj);

    protected abstract int i(Object obj);

    protected abstract Object p(int i, int i2);
}
