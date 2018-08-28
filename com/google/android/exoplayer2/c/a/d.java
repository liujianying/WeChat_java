package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.a.b.a;
import com.google.android.exoplayer2.i.t;

final class d implements a {
    private final long aet;
    private final long aiT;
    private final long ajk;
    private final long[] ajl;
    private final long ajm;
    private final int ajn;

    d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.aiT = j;
        this.aet = j2;
        this.ajk = j3;
        this.ajl = jArr;
        this.ajm = j4;
        this.ajn = i;
    }

    public final boolean jR() {
        return this.ajl != null;
    }

    public final long C(long j) {
        if (!jR() || j < this.aiT) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.aiT))) / ((double) this.ajm);
        int a = t.a(this.ajl, (long) d, false) + 1;
        long cr = cr(a);
        long j2 = a == 0 ? 0 : this.ajl[a - 1];
        long j3 = a == 99 ? 256 : this.ajl[a];
        return cr + (j3 == j2 ? 0 : (long) ((((double) (cr(a + 1) - cr)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    private long cr(int i) {
        return (this.aet * ((long) i)) / 100;
    }
}
