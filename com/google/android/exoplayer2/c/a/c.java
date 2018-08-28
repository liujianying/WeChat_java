package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.t;

final class c implements b$a {
    private final long aet;
    private final long[] aiA;
    private final long[] ajj;

    c(long[] jArr, long[] jArr2, long j) {
        this.aiA = jArr;
        this.ajj = jArr2;
        this.aet = j;
    }

    public final boolean jR() {
        return true;
    }

    public final long C(long j) {
        return this.aiA[t.a(this.ajj, j, true)];
    }
}
