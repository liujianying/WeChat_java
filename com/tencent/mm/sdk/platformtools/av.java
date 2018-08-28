package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class av<K, V> {
    private final long aJd;
    public final al bAZ;
    public volatile boolean bBc = false;
    public final aa<K, a<V>> ktS;
    public final LinkedHashMap<K, b<K, V>> sIs = new LinkedHashMap();
    private final c<K, V> sIt;
    public final al sIu;
    private final long sIv;
    private boolean sIw = true;
    protected Object tag;
    private final long threshold;

    static class a<V> {
        final V sIy;

        a(V v) {
            this.sIy = v;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.sIy != null) {
                return this.sIy.equals(aVar.sIy);
            }
            if (aVar.sIy == null) {
                return true;
            }
            return false;
        }
    }

    public static class b<K, V> {
        public K qSV;
        public int sIz;
        public V values;
    }

    public interface c<K, V> {
        boolean Sc();

        void Sd();

        void a(av<K, V> avVar, b<K, V> bVar);
    }

    public av(c<K, V> cVar, Looper looper, int i, int i2, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("arg appender can not be null!");
        } else if (looper == null) {
            throw new IllegalArgumentException("arg looper can not be null!");
        } else if (i <= 0) {
            throw new IllegalArgumentException("arg size can not be <= 0!");
        } else {
            this.sIt = cVar;
            this.ktS = new aa(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (j <= 0) {
                j = 60000;
            }
            this.sIv = j;
            if (j2 <= 0) {
                j2 = 60000;
            }
            this.aJd = j2;
            this.bAZ = new al(looper, new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean vD() {
                    long currentTimeMillis = System.currentTimeMillis();
                    av.this.li(false);
                    x.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return false;
                }
            }, false);
            this.sIu = new al(new ah("RWCache_timeoutChecker").lnJ.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean vD() {
                    av.this.bBc = true;
                    return false;
                }
            }, false);
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.ktS.get(k);
        if (aVar != null) {
            return aVar.sIy;
        }
        this.ktS.put(k, new a(null));
        return null;
    }

    public final boolean s(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.ktS.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            return false;
        }
        int i;
        this.ktS.put(k, aVar2);
        b bVar = new b();
        bVar.qSV = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.sIz = i;
        synchronized (this) {
            this.sIs.put(k, bVar);
            if (this.sIw && ((long) this.sIs.size()) > this.threshold) {
                this.bAZ.J(0, 0);
                this.sIw = false;
            } else if (this.bAZ.ciq()) {
                al alVar = this.bAZ;
                long j = this.sIv;
                alVar.J(j, j);
            }
        }
        return true;
    }

    public final void li(boolean z) {
        x.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.sIs.size());
        synchronized (this) {
            this.sIw = true;
            if (this.sIs.isEmpty()) {
            } else if (this.sIt.Sc()) {
                Iterator it = this.sIs.entrySet().iterator();
                if (z) {
                    while (it.hasNext()) {
                        this.sIt.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                } else {
                    this.bBc = false;
                    al alVar = this.sIu;
                    long j = this.aJd;
                    alVar.J(j, j);
                    while (!this.bBc && it.hasNext()) {
                        this.sIt.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                    if (this.bBc) {
                        x.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.sIs.size()), Boolean.valueOf(it.hasNext()));
                    }
                    this.sIu.SO();
                }
                this.sIt.Sd();
            }
        }
    }
}
