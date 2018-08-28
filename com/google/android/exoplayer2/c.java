package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.t;

public final class c implements m {
    private final j acs;
    private final long act;
    private final long acu;
    private final long acv;
    private final long acw;
    private final m acx;
    private int acy;
    private boolean isBuffering;

    public c() {
        this(new j());
    }

    private c(j jVar) {
        this(jVar, (byte) 0);
    }

    private c(j jVar, byte b) {
        this(jVar, 0);
    }

    private c(j jVar, char c) {
        this.acs = jVar;
        this.act = 15000000;
        this.acu = 30000000;
        this.acv = 2500000;
        this.acw = 5000000;
        this.acx = null;
    }

    public final void iy() {
        reset(false);
    }

    public final void a(r[] rVarArr, f fVar) {
        int i = 0;
        this.acy = 0;
        while (i < rVarArr.length) {
            if (fVar.aAu[i] != null) {
                this.acy += t.df(rVarArr[i].getTrackType());
            }
            i++;
        }
        this.acs.cV(this.acy);
    }

    public final void onStopped() {
        reset(true);
    }

    public final void iz() {
        reset(true);
    }

    public final b iA() {
        return this.acs;
    }

    public final boolean c(long j, boolean z) {
        long j2 = z ? this.acw : this.acv;
        return j2 <= 0 || j >= j2;
    }

    public final boolean p(long j) {
        boolean z = false;
        boolean z2 = j > this.acu ? false : j < this.act ? true : true;
        boolean z3;
        if (this.acs.lR() >= this.acy) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = this.isBuffering;
        if (z2 || (z2 && this.isBuffering && !z3)) {
            z = true;
        }
        this.isBuffering = z;
        if (!(this.acx == null || this.isBuffering == z4)) {
            if (this.isBuffering) {
                m mVar = this.acx;
                synchronized (mVar.lock) {
                    mVar.aCs.add(Integer.valueOf(0));
                    mVar.aCt = Math.max(mVar.aCt, 0);
                }
            } else {
                this.acx.mo();
            }
        }
        return this.isBuffering;
    }

    private void reset(boolean z) {
        this.acy = 0;
        if (this.acx != null && this.isBuffering) {
            this.acx.mo();
        }
        this.isBuffering = false;
        if (z) {
            this.acs.reset();
        }
    }
}
