package com.google.android.gms.c;

import com.google.android.gms.c.p.b;
import com.google.android.gms.c.p.c;
import com.google.android.gms.c.p.e;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V> extends q<K, V> implements Map<K, V> {
    p<K, V> aXz;

    private p<K, V> qd() {
        if (this.aXz == null) {
            this.aXz = new p<K, V>() {
                protected final void ac(int i) {
                    m.this.removeAt(i);
                }

                protected final V b(int i, V v) {
                    m mVar = m.this;
                    int i2 = (i << 1) + 1;
                    V v2 = mVar.tT[i2];
                    mVar.tT[i2] = v;
                    return v2;
                }

                protected final void b(K k, V v) {
                    m.this.put(k, v);
                }

                protected final int bR() {
                    return m.this.fi;
                }

                protected final Map<K, V> bS() {
                    return m.this;
                }

                protected final void bT() {
                    m.this.clear();
                }

                protected final int h(Object obj) {
                    return obj == null ? m.this.bX() : m.this.indexOf(obj, obj.hashCode());
                }

                protected final int i(Object obj) {
                    return m.this.indexOfValue(obj);
                }

                protected final Object p(int i, int i2) {
                    return m.this.tT[(i << 1) + i2];
                }
            };
        }
        return this.aXz;
    }

    public Set<Entry<K, V>> entrySet() {
        p qd = qd();
        if (qd.aXH == null) {
            qd.aXH = new b(qd);
        }
        return qd.aXH;
    }

    public Set<K> keySet() {
        p qd = qd();
        if (qd.aXI == null) {
            qd.aXI = new c(qd);
        }
        return qd.aXI;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.fi + map.size();
        if (this.tS.length < size) {
            Object obj = this.tS;
            Object obj2 = this.tT;
            super.du(size);
            if (this.fi > 0) {
                System.arraycopy(obj, 0, this.tS, 0, this.fi);
                System.arraycopy(obj2, 0, this.tT, 0, this.fi << 1);
            }
            q.b(obj, obj2, this.fi);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        p qd = qd();
        if (qd.aXJ == null) {
            qd.aXJ = new e(qd);
        }
        return qd.aXJ;
    }
}
