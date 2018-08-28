package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class j implements b {
    private final boolean aAM;
    private final int aAN;
    private final byte[] aAO;
    private final a[] aAP;
    private int aAQ;
    private int aAR;
    private a[] aAS;
    private int acy;

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        a.ao(true);
        a.ao(true);
        this.aAM = true;
        this.aAN = 65536;
        this.aAR = 0;
        this.aAS = new a[100];
        this.aAO = null;
        this.aAP = new a[1];
    }

    public final synchronized void reset() {
        if (this.aAM) {
            cV(0);
        }
    }

    public final synchronized void cV(int i) {
        Object obj = i < this.acy ? 1 : null;
        this.acy = i;
        if (obj != null) {
            lM();
        }
    }

    public final synchronized a lL() {
        a aVar;
        this.aAQ++;
        if (this.aAR > 0) {
            a[] aVarArr = this.aAS;
            int i = this.aAR - 1;
            this.aAR = i;
            aVar = aVarArr[i];
            this.aAS[this.aAR] = null;
        } else {
            aVar = new a(new byte[this.aAN]);
        }
        return aVar;
    }

    public final synchronized void a(a aVar) {
        this.aAP[0] = aVar;
        a(this.aAP);
    }

    public final synchronized void a(a[] aVarArr) {
        if (this.aAR + aVarArr.length >= this.aAS.length) {
            this.aAS = (a[]) Arrays.copyOf(this.aAS, Math.max(this.aAS.length * 2, this.aAR + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            boolean z;
            if (aVar.data == this.aAO || aVar.data.length == this.aAN) {
                z = true;
            } else {
                z = false;
            }
            a.ao(z);
            a[] aVarArr2 = this.aAS;
            int i = this.aAR;
            this.aAR = i + 1;
            aVarArr2[i] = aVar;
        }
        this.aAQ -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void lM() {
        /*
        r7 = this;
        r2 = 0;
        monitor-enter(r7);
        r0 = r7.acy;	 Catch:{ all -> 0x0060 }
        r1 = r7.aAN;	 Catch:{ all -> 0x0060 }
        r0 = com.google.android.exoplayer2.i.t.aw(r0, r1);	 Catch:{ all -> 0x0060 }
        r1 = 0;
        r3 = r7.aAQ;	 Catch:{ all -> 0x0060 }
        r0 = r0 - r3;
        r0 = java.lang.Math.max(r1, r0);	 Catch:{ all -> 0x0060 }
        r1 = r7.aAR;	 Catch:{ all -> 0x0060 }
        if (r0 < r1) goto L_0x0018;
    L_0x0016:
        monitor-exit(r7);
        return;
    L_0x0018:
        r1 = r7.aAO;	 Catch:{ all -> 0x0060 }
        if (r1 == 0) goto L_0x0055;
    L_0x001c:
        r1 = r7.aAR;	 Catch:{ all -> 0x0060 }
        r1 = r1 + -1;
        r3 = r2;
    L_0x0021:
        if (r3 > r1) goto L_0x004d;
    L_0x0023:
        r2 = r7.aAS;	 Catch:{ all -> 0x0060 }
        r5 = r2[r3];	 Catch:{ all -> 0x0060 }
        r2 = r5.data;	 Catch:{ all -> 0x0060 }
        r4 = r7.aAO;	 Catch:{ all -> 0x0060 }
        if (r2 != r4) goto L_0x0031;
    L_0x002d:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0021;
    L_0x0031:
        r2 = r7.aAS;	 Catch:{ all -> 0x0060 }
        r2 = r2[r1];	 Catch:{ all -> 0x0060 }
        r4 = r2.data;	 Catch:{ all -> 0x0060 }
        r6 = r7.aAO;	 Catch:{ all -> 0x0060 }
        if (r4 == r6) goto L_0x003e;
    L_0x003b:
        r1 = r1 + -1;
        goto L_0x0021;
    L_0x003e:
        r6 = r7.aAS;	 Catch:{ all -> 0x0060 }
        r4 = r3 + 1;
        r6[r3] = r2;	 Catch:{ all -> 0x0060 }
        r3 = r7.aAS;	 Catch:{ all -> 0x0060 }
        r2 = r1 + -1;
        r3[r1] = r5;	 Catch:{ all -> 0x0060 }
        r1 = r2;
        r3 = r4;
        goto L_0x0021;
    L_0x004d:
        r0 = java.lang.Math.max(r0, r3);	 Catch:{ all -> 0x0060 }
        r1 = r7.aAR;	 Catch:{ all -> 0x0060 }
        if (r0 >= r1) goto L_0x0016;
    L_0x0055:
        r1 = r7.aAS;	 Catch:{ all -> 0x0060 }
        r2 = r7.aAR;	 Catch:{ all -> 0x0060 }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{ all -> 0x0060 }
        r7.aAR = r0;	 Catch:{ all -> 0x0060 }
        goto L_0x0016;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.j.lM():void");
    }

    public final synchronized int lR() {
        return this.aAQ * this.aAN;
    }

    public final int lN() {
        return this.aAN;
    }
}
