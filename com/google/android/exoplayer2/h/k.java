package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.n;

public final class k implements d, t<Object> {
    private final d$a aAT;
    private final n aAU;
    private final b aAV;
    private int aAW;
    private long aAX;
    private long aAY;
    private long aAZ;
    private long aBa;
    private long aBb;
    private final Handler acJ;

    public k() {
        this(null, null);
    }

    public k(Handler handler, d$a d_a) {
        this(handler, d_a, (byte) 0);
    }

    private k(Handler handler, d$a d_a, byte b) {
        this(handler, d_a, b.aBU);
    }

    private k(Handler handler, d$a d_a, b bVar) {
        this.acJ = handler;
        this.aAT = d_a;
        this.aAU = new n();
        this.aAV = bVar;
        this.aBb = -1;
    }

    public final synchronized void lS() {
        if (this.aAW == 0) {
            this.aAX = this.aAV.elapsedRealtime();
        }
        this.aAW++;
    }

    public final synchronized void cW(int i) {
        this.aAY += (long) i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void lT() {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        monitor-enter(r10);
        r0 = r10.aAW;	 Catch:{ all -> 0x009f }
        if (r0 <= 0) goto L_0x00a2;
    L_0x0007:
        r0 = r1;
    L_0x0008:
        com.google.android.exoplayer2.i.a.ap(r0);	 Catch:{ all -> 0x009f }
        r0 = r10.aAV;	 Catch:{ all -> 0x009f }
        r8 = r0.elapsedRealtime();	 Catch:{ all -> 0x009f }
        r4 = r10.aAX;	 Catch:{ all -> 0x009f }
        r4 = r8 - r4;
        r3 = (int) r4;	 Catch:{ all -> 0x009f }
        r4 = r10.aAZ;	 Catch:{ all -> 0x009f }
        r6 = (long) r3;	 Catch:{ all -> 0x009f }
        r4 = r4 + r6;
        r10.aAZ = r4;	 Catch:{ all -> 0x009f }
        r4 = r10.aBa;	 Catch:{ all -> 0x009f }
        r6 = r10.aAY;	 Catch:{ all -> 0x009f }
        r4 = r4 + r6;
        r10.aBa = r4;	 Catch:{ all -> 0x009f }
        if (r3 <= 0) goto L_0x0105;
    L_0x0025:
        r4 = r10.aAY;	 Catch:{ all -> 0x009f }
        r6 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r4 = r4 * r6;
        r6 = (long) r3;	 Catch:{ all -> 0x009f }
        r4 = r4 / r6;
        r4 = (float) r4;	 Catch:{ all -> 0x009f }
        r5 = r10.aAU;	 Catch:{ all -> 0x009f }
        r6 = r10.aAY;	 Catch:{ all -> 0x009f }
        r6 = (double) r6;	 Catch:{ all -> 0x009f }
        r6 = java.lang.Math.sqrt(r6);	 Catch:{ all -> 0x009f }
        r6 = (int) r6;	 Catch:{ all -> 0x009f }
        r0 = r5.aCz;	 Catch:{ all -> 0x009f }
        if (r0 == r1) goto L_0x0045;
    L_0x003b:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r1 = com.google.android.exoplayer2.i.n.aCu;	 Catch:{ all -> 0x009f }
        java.util.Collections.sort(r0, r1);	 Catch:{ all -> 0x009f }
        r0 = 1;
        r5.aCz = r0;	 Catch:{ all -> 0x009f }
    L_0x0045:
        r0 = r5.aCC;	 Catch:{ all -> 0x009f }
        if (r0 <= 0) goto L_0x00a5;
    L_0x0049:
        r0 = r5.aCy;	 Catch:{ all -> 0x009f }
        r1 = r5.aCC;	 Catch:{ all -> 0x009f }
        r1 = r1 + -1;
        r5.aCC = r1;	 Catch:{ all -> 0x009f }
        r0 = r0[r1];	 Catch:{ all -> 0x009f }
    L_0x0053:
        r1 = r5.aCA;	 Catch:{ all -> 0x009f }
        r7 = r1 + 1;
        r5.aCA = r7;	 Catch:{ all -> 0x009f }
        r0.index = r1;	 Catch:{ all -> 0x009f }
        r0.weight = r6;	 Catch:{ all -> 0x009f }
        r0.value = r4;	 Catch:{ all -> 0x009f }
        r1 = r5.aCx;	 Catch:{ all -> 0x009f }
        r1.add(r0);	 Catch:{ all -> 0x009f }
        r0 = r5.aCB;	 Catch:{ all -> 0x009f }
        r0 = r0 + r6;
        r5.aCB = r0;	 Catch:{ all -> 0x009f }
    L_0x0069:
        r0 = r5.aCB;	 Catch:{ all -> 0x009f }
        r1 = r5.aCw;	 Catch:{ all -> 0x009f }
        if (r0 <= r1) goto L_0x00b7;
    L_0x006f:
        r0 = r5.aCB;	 Catch:{ all -> 0x009f }
        r1 = r5.aCw;	 Catch:{ all -> 0x009f }
        r1 = r0 - r1;
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r4 = 0;
        r0 = r0.get(r4);	 Catch:{ all -> 0x009f }
        r0 = (com.google.android.exoplayer2.i.n.a) r0;	 Catch:{ all -> 0x009f }
        r4 = r0.weight;	 Catch:{ all -> 0x009f }
        if (r4 > r1) goto L_0x00ac;
    L_0x0082:
        r1 = r5.aCB;	 Catch:{ all -> 0x009f }
        r4 = r0.weight;	 Catch:{ all -> 0x009f }
        r1 = r1 - r4;
        r5.aCB = r1;	 Catch:{ all -> 0x009f }
        r1 = r5.aCx;	 Catch:{ all -> 0x009f }
        r4 = 0;
        r1.remove(r4);	 Catch:{ all -> 0x009f }
        r1 = r5.aCC;	 Catch:{ all -> 0x009f }
        r4 = 5;
        if (r1 >= r4) goto L_0x0069;
    L_0x0094:
        r1 = r5.aCy;	 Catch:{ all -> 0x009f }
        r4 = r5.aCC;	 Catch:{ all -> 0x009f }
        r6 = r4 + 1;
        r5.aCC = r6;	 Catch:{ all -> 0x009f }
        r1[r4] = r0;	 Catch:{ all -> 0x009f }
        goto L_0x0069;
    L_0x009f:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x00a2:
        r0 = r2;
        goto L_0x0008;
    L_0x00a5:
        r0 = new com.google.android.exoplayer2.i.n$a;	 Catch:{ all -> 0x009f }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x009f }
        goto L_0x0053;
    L_0x00ac:
        r4 = r0.weight;	 Catch:{ all -> 0x009f }
        r4 = r4 - r1;
        r0.weight = r4;	 Catch:{ all -> 0x009f }
        r0 = r5.aCB;	 Catch:{ all -> 0x009f }
        r0 = r0 - r1;
        r5.aCB = r0;	 Catch:{ all -> 0x009f }
        goto L_0x0069;
    L_0x00b7:
        r0 = r10.aAZ;	 Catch:{ all -> 0x009f }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x00c8;
    L_0x00bf:
        r0 = r10.aBa;	 Catch:{ all -> 0x009f }
        r4 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x0105;
    L_0x00c8:
        r5 = r10.aAU;	 Catch:{ all -> 0x009f }
        r0 = r5.aCz;	 Catch:{ all -> 0x009f }
        if (r0 == 0) goto L_0x00d8;
    L_0x00ce:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r1 = com.google.android.exoplayer2.i.n.aCv;	 Catch:{ all -> 0x009f }
        java.util.Collections.sort(r0, r1);	 Catch:{ all -> 0x009f }
        r0 = 0;
        r5.aCz = r0;	 Catch:{ all -> 0x009f }
    L_0x00d8:
        r0 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1 = r5.aCB;	 Catch:{ all -> 0x009f }
        r1 = (float) r1;	 Catch:{ all -> 0x009f }
        r6 = r0 * r1;
        r1 = r2;
        r4 = r2;
    L_0x00e1:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r0 = r0.size();	 Catch:{ all -> 0x009f }
        if (r1 >= r0) goto L_0x0131;
    L_0x00e9:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r0 = r0.get(r1);	 Catch:{ all -> 0x009f }
        r0 = (com.google.android.exoplayer2.i.n.a) r0;	 Catch:{ all -> 0x009f }
        r2 = r0.weight;	 Catch:{ all -> 0x009f }
        r2 = r2 + r4;
        r4 = (float) r2;	 Catch:{ all -> 0x009f }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x012c;
    L_0x00f9:
        r0 = r0.value;	 Catch:{ all -> 0x009f }
    L_0x00fb:
        r1 = java.lang.Float.isNaN(r0);	 Catch:{ all -> 0x009f }
        if (r1 == 0) goto L_0x014f;
    L_0x0101:
        r0 = -1;
    L_0x0103:
        r10.aBb = r0;	 Catch:{ all -> 0x009f }
    L_0x0105:
        r4 = r10.aAY;	 Catch:{ all -> 0x009f }
        r6 = r10.aBb;	 Catch:{ all -> 0x009f }
        r0 = r10.acJ;	 Catch:{ all -> 0x009f }
        if (r0 == 0) goto L_0x011c;
    L_0x010d:
        r0 = r10.aAT;	 Catch:{ all -> 0x009f }
        if (r0 == 0) goto L_0x011c;
    L_0x0111:
        r0 = r10.acJ;	 Catch:{ all -> 0x009f }
        r1 = new com.google.android.exoplayer2.h.k$1;	 Catch:{ all -> 0x009f }
        r2 = r10;
        r1.<init>(r2, r3, r4, r6);	 Catch:{ all -> 0x009f }
        r0.post(r1);	 Catch:{ all -> 0x009f }
    L_0x011c:
        r0 = r10.aAW;	 Catch:{ all -> 0x009f }
        r0 = r0 + -1;
        r10.aAW = r0;	 Catch:{ all -> 0x009f }
        if (r0 <= 0) goto L_0x0126;
    L_0x0124:
        r10.aAX = r8;	 Catch:{ all -> 0x009f }
    L_0x0126:
        r0 = 0;
        r10.aAY = r0;	 Catch:{ all -> 0x009f }
        monitor-exit(r10);
        return;
    L_0x012c:
        r0 = r1 + 1;
        r1 = r0;
        r4 = r2;
        goto L_0x00e1;
    L_0x0131:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x009f }
        if (r0 == 0) goto L_0x013c;
    L_0x0139:
        r0 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        goto L_0x00fb;
    L_0x013c:
        r0 = r5.aCx;	 Catch:{ all -> 0x009f }
        r1 = r5.aCx;	 Catch:{ all -> 0x009f }
        r1 = r1.size();	 Catch:{ all -> 0x009f }
        r1 = r1 + -1;
        r0 = r0.get(r1);	 Catch:{ all -> 0x009f }
        r0 = (com.google.android.exoplayer2.i.n.a) r0;	 Catch:{ all -> 0x009f }
        r0 = r0.value;	 Catch:{ all -> 0x009f }
        goto L_0x00fb;
    L_0x014f:
        r0 = (long) r0;
        goto L_0x0103;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.lT():void");
    }
}
