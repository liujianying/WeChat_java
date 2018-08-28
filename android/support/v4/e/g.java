package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g<K, V> {
    b tE;
    c tF;
    e tG;

    final class a<T> implements Iterator<T> {
        int fi;
        int mIndex;
        final int tH;
        boolean tI = false;

        a(int i) {
            this.tH = i;
            this.fi = g.this.bR();
        }

        public final boolean hasNext() {
            return this.mIndex < this.fi;
        }

        public final T next() {
            T p = g.this.p(this.mIndex, this.tH);
            this.mIndex++;
            this.tI = true;
            return p;
        }

        public final void remove() {
            if (this.tI) {
                this.mIndex--;
                this.fi--;
                this.tI = false;
                g.this.ac(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        b() {
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bR = g.this.bR();
            for (Entry entry : collection) {
                g.this.b(entry.getKey(), entry.getValue());
            }
            return bR != g.this.bR();
        }

        public final void clear() {
            g.this.bT();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int h = g.this.h(entry.getKey());
            if (h >= 0) {
                return b.c(g.this.p(h, 1), entry.getValue());
            }
            return false;
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
            return g.this.bR() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d();
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
            return g.this.bR();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int bR = g.this.bR() - 1;
            int i = 0;
            while (bR >= 0) {
                Object p = g.this.p(bR, 0);
                Object p2 = g.this.p(bR, 1);
                bR--;
                i += (p2 == null ? 0 : p2.hashCode()) ^ (p == null ? 0 : p.hashCode());
            }
            return i;
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            g.this.bT();
        }

        public final boolean contains(Object obj) {
            return g.this.h(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bS = g.this.bS();
            for (Object containsKey : collection) {
                if (!bS.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return g.this.bR() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int h = g.this.h(obj);
            if (h < 0) {
                return false;
            }
            g.this.ac(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bS = g.this.bS();
            int size = bS.size();
            for (Object remove : collection) {
                bS.remove(remove);
            }
            return size != bS.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return g.a(g.this.bS(), (Collection) collection);
        }

        public final int size() {
            return g.this.bR();
        }

        public final Object[] toArray() {
            return g.this.ai(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return g.this.b((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bR = g.this.bR() - 1; bR >= 0; bR--) {
                Object p = g.this.p(bR, 0);
                i += p == null ? 0 : p.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mIndex;
        int tK;
        boolean tL = false;

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.tL = true;
            return this;
        }

        d() {
            this.tK = g.this.bR() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.tK;
        }

        public final void remove() {
            if (this.tL) {
                g.this.ac(this.mIndex);
                this.mIndex--;
                this.tK--;
                this.tL = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.tL) {
                return g.this.p(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.tL) {
                return g.this.p(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.tL) {
                return g.this.b(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.tL) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (b.c(entry.getKey(), g.this.p(this.mIndex, 0)) && b.c(entry.getValue(), g.this.p(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.tL) {
                Object p = g.this.p(this.mIndex, 0);
                Object p2 = g.this.p(this.mIndex, 1);
                int hashCode = p == null ? 0 : p.hashCode();
                if (p2 != null) {
                    i = p2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            g.this.bT();
        }

        public final boolean contains(Object obj) {
            return g.this.i(obj) >= 0;
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
            return g.this.bR() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int i = g.this.i(obj);
            if (i < 0) {
                return false;
            }
            g.this.ac(i);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int bR = g.this.bR();
            int i = 0;
            boolean z = false;
            while (i < bR) {
                if (collection.contains(g.this.p(i, 1))) {
                    g.this.ac(i);
                    i--;
                    bR--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int bR = g.this.bR();
            int i = 0;
            boolean z = false;
            while (i < bR) {
                if (!collection.contains(g.this.p(i, 1))) {
                    g.this.ac(i);
                    i--;
                    bR--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return g.this.bR();
        }

        public final Object[] toArray() {
            return g.this.ai(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return g.this.b((Object[]) tArr, 1);
        }
    }

    protected abstract void ac(int i);

    protected abstract V b(int i, V v);

    protected abstract void b(K k, V v);

    protected abstract int bR();

    protected abstract Map<K, V> bS();

    protected abstract void bT();

    protected abstract int h(Object obj);

    protected abstract int i(Object obj);

    protected abstract Object p(int i, int i2);

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] ai(int i) {
        int bR = bR();
        Object[] objArr = new Object[bR];
        for (int i2 = 0; i2 < bR; i2++) {
            objArr[i2] = p(i2, i);
        }
        return objArr;
    }

    public final <T> T[] b(T[] tArr, int i) {
        T[] tArr2;
        int bR = bR();
        if (tArr.length < bR) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bR);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < bR; i2++) {
            tArr2[i2] = p(i2, i);
        }
        if (tArr2.length > bR) {
            tArr2[bR] = null;
        }
        return tArr2;
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
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
