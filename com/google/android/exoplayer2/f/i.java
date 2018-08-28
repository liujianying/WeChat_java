package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i extends f implements d {
    private long aek;
    private d awd;

    public abstract void release();

    public final void a(long j, d dVar, long j2) {
        this.aih = j;
        this.awd = dVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.aih;
        }
        this.aek = j2;
    }

    public final int lj() {
        return this.awd.lj();
    }

    public final long cM(int i) {
        return this.awd.cM(i) + this.aek;
    }

    public final int P(long j) {
        return this.awd.P(j - this.aek);
    }

    public final List<a> Q(long j) {
        return this.awd.Q(j - this.aek);
    }

    public final void clear() {
        super.clear();
        this.awd = null;
    }
}
