package com.google.android.gms.c;

import java.util.LinkedHashMap;

public class o<K, V> {
    private final LinkedHashMap<K, V> aXB;
    private int aXC;
    private int aXD;
    private int aXE;
    private int aXF;
    private int aXG;
    private int size;

    private int l(K k, V v) {
        int ae = ae(v);
        if (ae >= 0) {
            return ae;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public int ae(V v) {
        return 1;
    }

    public final V get(K k) {
        synchronized (this) {
            V v = this.aXB.get(k);
            if (v != null) {
                this.aXF++;
                return v;
            }
            this.aXG++;
            return null;
        }
    }

    public final V put(K k, V v) {
        if (v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.aXD++;
            this.size += l(k, v);
            put = this.aXB.put(k, v);
            if (put != null) {
                this.size -= l(k, put);
            }
        }
        trimToSize(this.aXC);
        return put;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.aXF + this.aXG;
            if (i2 != 0) {
                i = (this.aXF * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.aXC), Integer.valueOf(this.aXF), Integer.valueOf(this.aXG), Integer.valueOf(i)});
        }
        return format;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trimToSize(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.size;	 Catch:{ all -> 0x0033 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.aXB;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x000d:
        r0 = r3.size;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0033 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0033 }
        r1.<init>();	 Catch:{ all -> 0x0033 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0033 }
        r2 = r2.getName();	 Catch:{ all -> 0x0033 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0033 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0033 }
        r1 = r1.toString();	 Catch:{ all -> 0x0033 }
        r0.<init>(r1);	 Catch:{ all -> 0x0033 }
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = r3.size;	 Catch:{ all -> 0x0033 }
        if (r0 <= r4) goto L_0x0042;
    L_0x003a:
        r0 = r3.aXB;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0044;
    L_0x0042:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        return;
    L_0x0044:
        r0 = r3.aXB;	 Catch:{ all -> 0x0033 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0033 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0033 }
        r0 = r0.next();	 Catch:{ all -> 0x0033 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0033 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0033 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0033 }
        r2 = r3.aXB;	 Catch:{ all -> 0x0033 }
        r2.remove(r1);	 Catch:{ all -> 0x0033 }
        r2 = r3.size;	 Catch:{ all -> 0x0033 }
        r0 = r3.l(r1, r0);	 Catch:{ all -> 0x0033 }
        r0 = r2 - r0;
        r3.size = r0;	 Catch:{ all -> 0x0033 }
        r0 = r3.aXE;	 Catch:{ all -> 0x0033 }
        r0 = r0 + 1;
        r3.aXE = r0;	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.o.trimToSize(int):void");
    }
}
