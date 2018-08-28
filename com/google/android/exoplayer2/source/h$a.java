package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.h.a;

final class h$a {
    public final long ald;
    public a asA;
    public h$a asB;
    public final long asy;
    public boolean asz;

    public h$a(long j, int i) {
        this.asy = j;
        this.ald = ((long) i) + j;
    }

    public final int M(long j) {
        return ((int) (j - this.asy)) + this.asA.offset;
    }

    public final h$a kN() {
        this.asA = null;
        h$a h_a = this.asB;
        this.asB = null;
        return h_a;
    }
}
