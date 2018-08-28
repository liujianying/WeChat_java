package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class f implements h {
    private final String aem;
    private Format aep;
    private long aih;
    private k alX;
    private final j amM = new j(new byte[15]);
    private int amO;
    private long amQ;
    private String amX;
    private int ang;
    private int sampleSize;
    private int state;

    public f(String str) {
        this.amM.data[0] = Byte.MAX_VALUE;
        this.amM.data[1] = (byte) -2;
        this.amM.data[2] = Byte.MIN_VALUE;
        this.amM.data[3] = (byte) 1;
        this.state = 0;
        this.aem = str;
    }

    public final void jX() {
        this.state = 0;
        this.amO = 0;
        this.ang = 0;
    }

    public final void a(com.google.android.exoplayer2.c.f fVar, d dVar) {
        dVar.kf();
        this.amX = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
    }

    public final void d(long j, boolean z) {
        this.aih = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j r10) {
        /*
        r9 = this;
        r8 = 15;
        r4 = 1;
        r6 = 0;
    L_0x0004:
        r0 = r10.me();
        if (r0 <= 0) goto L_0x00d1;
    L_0x000a:
        r0 = r9.state;
        switch(r0) {
            case 0: goto L_0x0010;
            case 1: goto L_0x0039;
            case 2: goto L_0x009f;
            default: goto L_0x000f;
        };
    L_0x000f:
        goto L_0x0004;
    L_0x0010:
        r0 = r10.me();
        if (r0 <= 0) goto L_0x0037;
    L_0x0016:
        r0 = r9.ang;
        r0 = r0 << 8;
        r9.ang = r0;
        r0 = r9.ang;
        r1 = r10.readUnsignedByte();
        r0 = r0 | r1;
        r9.ang = r0;
        r0 = r9.ang;
        r1 = 2147385345; // 0x7ffe8001 float:NaN double:1.0609493273E-314;
        if (r0 != r1) goto L_0x0010;
    L_0x002c:
        r9.ang = r6;
        r0 = r4;
    L_0x002f:
        if (r0 == 0) goto L_0x0004;
    L_0x0031:
        r0 = 4;
        r9.amO = r0;
        r9.state = r4;
        goto L_0x0004;
    L_0x0037:
        r0 = r6;
        goto L_0x002f;
    L_0x0039:
        r0 = r9.amM;
        r0 = r0.data;
        r1 = r10.me();
        r2 = r9.amO;
        r2 = 15 - r2;
        r1 = java.lang.Math.min(r1, r2);
        r2 = r9.amO;
        r10.readBytes(r0, r2, r1);
        r0 = r9.amO;
        r0 = r0 + r1;
        r9.amO = r0;
        r0 = r9.amO;
        if (r0 != r8) goto L_0x009d;
    L_0x0057:
        r0 = r4;
    L_0x0058:
        if (r0 == 0) goto L_0x0004;
    L_0x005a:
        r0 = r9.amM;
        r0 = r0.data;
        r1 = r9.aep;
        if (r1 != 0) goto L_0x0073;
    L_0x0062:
        r1 = r9.amX;
        r2 = r9.aem;
        r1 = com.google.android.exoplayer2.a.h.a(r0, r1, r2);
        r9.aep = r1;
        r1 = r9.alX;
        r2 = r9.aep;
        r1.f(r2);
    L_0x0073:
        r1 = com.google.android.exoplayer2.a.h.h(r0);
        r9.sampleSize = r1;
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r0 = com.google.android.exoplayer2.a.h.g(r0);
        r0 = (long) r0;
        r0 = r0 * r2;
        r2 = r9.aep;
        r2 = r2.sampleRate;
        r2 = (long) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r0 = (long) r0;
        r9.amQ = r0;
        r0 = r9.amM;
        r0.setPosition(r6);
        r0 = r9.alX;
        r1 = r9.amM;
        r0.a(r1, r8);
        r0 = 2;
        r9.state = r0;
        goto L_0x0004;
    L_0x009d:
        r0 = r6;
        goto L_0x0058;
    L_0x009f:
        r0 = r10.me();
        r1 = r9.sampleSize;
        r2 = r9.amO;
        r1 = r1 - r2;
        r0 = java.lang.Math.min(r0, r1);
        r1 = r9.alX;
        r1.a(r10, r0);
        r1 = r9.amO;
        r0 = r0 + r1;
        r9.amO = r0;
        r0 = r9.amO;
        r1 = r9.sampleSize;
        if (r0 != r1) goto L_0x0004;
    L_0x00bc:
        r1 = r9.alX;
        r2 = r9.aih;
        r5 = r9.sampleSize;
        r7 = 0;
        r1.a(r2, r4, r5, r6, r7);
        r0 = r9.aih;
        r2 = r9.amQ;
        r0 = r0 + r2;
        r9.aih = r0;
        r9.state = r6;
        goto L_0x0004;
    L_0x00d1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.f.b(com.google.android.exoplayer2.i.j):void");
    }

    public final void jY() {
    }
}
