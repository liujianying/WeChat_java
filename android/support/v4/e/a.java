package android.support.v4.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends j<K, V> implements Map<K, V> {
    g<K, V> tv;

    public a(int i) {
        super(i);
    }

    private g<K, V> bQ() {
        if (this.tv == null) {
            this.tv = new g<K, V>() {
                protected final int bR() {
                    return a.this.fi;
                }

                protected final Object p(int i, int i2) {
                    return a.this.tT[(i << 1) + i2];
                }

                protected final int h(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                protected final int i(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                protected final Map<K, V> bS() {
                    return a.this;
                }

                protected final void b(K k, V v) {
                    a.this.put(k, v);
                }

                protected final V b(int i, V v) {
                    return a.this.setValueAt(i, v);
                }

                protected final void ac(int i) {
                    a.this.removeAt(i);
                }

                protected final void bT() {
                    a.this.clear();
                }
            };
        }
        return this.tv;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.fi + map.size();
        if (this.tS.length < size) {
            Object obj = this.tS;
            Object obj2 = this.tT;
            super.aj(size);
            if (this.fi > 0) {
                System.arraycopy(obj, 0, this.tS, 0, this.fi);
                System.arraycopy(obj2, 0, this.tT, 0, this.fi << 1);
            }
            j.a(obj, obj2, this.fi);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g bQ = bQ();
        if (bQ.tE == null) {
            bQ.tE = new b();
        }
        return bQ.tE;
    }

    public Set<K> keySet() {
        g bQ = bQ();
        if (bQ.tF == null) {
            bQ.tF = new c();
        }
        return bQ.tF;
    }

    public Collection<V> values() {
        g bQ = bQ();
        if (bQ.tG == null) {
            bQ.tG = new e();
        }
        return bQ.tG;
    }
}
