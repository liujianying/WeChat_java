package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;

public final class b implements h {
    private final String aem;
    private Format aep;
    long aih;
    private k alX;
    private final i amL;
    private final j amM;
    private String amN;
    private int amO;
    private boolean amP;
    private long amQ;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        this.amL = new i(new byte[8]);
        this.amM = new j(this.amL.data);
        this.state = 0;
        this.aem = str;
    }

    public final void jX() {
        this.state = 0;
        this.amO = 0;
        this.amP = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.kf();
        this.amN = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
    }

    public final void d(long j, boolean z) {
        this.aih = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j r11) {
        /*
        r10 = this;
    L_0x0000:
        r0 = r11.me();
        if (r0 <= 0) goto L_0x011b;
    L_0x0006:
        r0 = r10.state;
        switch(r0) {
            case 0: goto L_0x000c;
            case 1: goto L_0x0057;
            case 2: goto L_0x00e6;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0000;
    L_0x000c:
        r0 = r11.me();
        if (r0 <= 0) goto L_0x0055;
    L_0x0012:
        r0 = r10.amP;
        if (r0 != 0) goto L_0x0024;
    L_0x0016:
        r0 = r11.readUnsignedByte();
        r1 = 11;
        if (r0 != r1) goto L_0x0022;
    L_0x001e:
        r0 = 1;
    L_0x001f:
        r10.amP = r0;
        goto L_0x000c;
    L_0x0022:
        r0 = 0;
        goto L_0x001f;
    L_0x0024:
        r0 = r11.readUnsignedByte();
        r1 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        if (r0 != r1) goto L_0x004b;
    L_0x002c:
        r0 = 0;
        r10.amP = r0;
        r0 = 1;
    L_0x0030:
        if (r0 == 0) goto L_0x0000;
    L_0x0032:
        r0 = 1;
        r10.state = r0;
        r0 = r10.amM;
        r0 = r0.data;
        r1 = 0;
        r2 = 11;
        r0[r1] = r2;
        r0 = r10.amM;
        r0 = r0.data;
        r1 = 1;
        r2 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r0[r1] = r2;
        r0 = 2;
        r10.amO = r0;
        goto L_0x0000;
    L_0x004b:
        r1 = 11;
        if (r0 != r1) goto L_0x0053;
    L_0x004f:
        r0 = 1;
    L_0x0050:
        r10.amP = r0;
        goto L_0x000c;
    L_0x0053:
        r0 = 0;
        goto L_0x0050;
    L_0x0055:
        r0 = 0;
        goto L_0x0030;
    L_0x0057:
        r0 = r10.amM;
        r0 = r0.data;
        r1 = r11.me();
        r2 = r10.amO;
        r2 = 8 - r2;
        r1 = java.lang.Math.min(r1, r2);
        r2 = r10.amO;
        r11.readBytes(r0, r2, r1);
        r0 = r10.amO;
        r0 = r0 + r1;
        r10.amO = r0;
        r0 = r10.amO;
        r1 = 8;
        if (r0 != r1) goto L_0x00e4;
    L_0x0077:
        r0 = 1;
    L_0x0078:
        if (r0 == 0) goto L_0x0000;
    L_0x007a:
        r0 = r10.amL;
        r1 = 0;
        r0.setPosition(r1);
        r0 = r10.amL;
        r9 = com.google.android.exoplayer2.a.a.a(r0);
        r0 = r10.aep;
        if (r0 == 0) goto L_0x00a2;
    L_0x008a:
        r0 = r9.aeg;
        r1 = r10.aep;
        r1 = r1.aeg;
        if (r0 != r1) goto L_0x00a2;
    L_0x0092:
        r0 = r9.sampleRate;
        r1 = r10.aep;
        r1 = r1.sampleRate;
        if (r0 != r1) goto L_0x00a2;
    L_0x009a:
        r0 = r9.mimeType;
        r1 = r10.aep;
        r1 = r1.adW;
        if (r0 == r1) goto L_0x00bd;
    L_0x00a2:
        r0 = r10.amN;
        r1 = r9.mimeType;
        r2 = -1;
        r3 = -1;
        r4 = r9.aeg;
        r5 = r9.sampleRate;
        r6 = 0;
        r7 = 0;
        r8 = r10.aem;
        r0 = com.google.android.exoplayer2.Format.a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r10.aep = r0;
        r0 = r10.alX;
        r1 = r10.aep;
        r0.f(r1);
    L_0x00bd:
        r0 = r9.aft;
        r10.sampleSize = r0;
        r0 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r9.sampleCount;
        r2 = (long) r2;
        r0 = r0 * r2;
        r2 = r10.aep;
        r2 = r2.sampleRate;
        r2 = (long) r2;
        r0 = r0 / r2;
        r10.amQ = r0;
        r0 = r10.amM;
        r1 = 0;
        r0.setPosition(r1);
        r0 = r10.alX;
        r1 = r10.amM;
        r2 = 8;
        r0.a(r1, r2);
        r0 = 2;
        r10.state = r0;
        goto L_0x0000;
    L_0x00e4:
        r0 = 0;
        goto L_0x0078;
    L_0x00e6:
        r0 = r11.me();
        r1 = r10.sampleSize;
        r2 = r10.amO;
        r1 = r1 - r2;
        r0 = java.lang.Math.min(r0, r1);
        r1 = r10.alX;
        r1.a(r11, r0);
        r1 = r10.amO;
        r0 = r0 + r1;
        r10.amO = r0;
        r0 = r10.amO;
        r1 = r10.sampleSize;
        if (r0 != r1) goto L_0x0000;
    L_0x0103:
        r1 = r10.alX;
        r2 = r10.aih;
        r4 = 1;
        r5 = r10.sampleSize;
        r6 = 0;
        r7 = 0;
        r1.a(r2, r4, r5, r6, r7);
        r0 = r10.aih;
        r2 = r10.amQ;
        r0 = r0 + r2;
        r10.aih = r0;
        r0 = 0;
        r10.state = r0;
        goto L_0x0000;
    L_0x011b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.b.b(com.google.android.exoplayer2.i.j):void");
    }

    public final void jY() {
    }
}
