package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.j;

final class g {
    public boolean[] amA;
    public f amB;
    public int amC;
    public j amD;
    public boolean amE;
    public long amF;
    public c amo;
    public long amp;
    public long amq;
    public long amr;
    public int ams;
    public long[] amt;
    public int[] amu;
    public int[] amv;
    public int[] amw;
    public long[] amx;
    public boolean[] amy;
    public boolean amz;
    public int sampleCount;

    g() {
    }

    public final void cy(int i) {
        if (this.amD == null || this.amD.limit < i) {
            this.amD = new j(i);
        }
        this.amC = i;
        this.amz = true;
        this.amE = true;
    }

    public final long cz(int i) {
        return this.amx[i] + ((long) this.amw[i]);
    }
}
