package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.k;

final class c$a implements i {
    final i ack;
    private final e ady;
    private final long arM;
    private final long arN;
    boolean arQ;
    boolean arR;

    public c$a(e eVar, i iVar, long j, long j2, boolean z) {
        this.ady = eVar;
        this.ack = iVar;
        this.arM = j;
        this.arN = j2;
        this.arQ = z;
    }

    public final boolean hv() {
        return this.ack.hv();
    }

    public final void kC() {
        this.ack.kC();
    }

    public final int b(k kVar, e eVar, boolean z) {
        if (this.arQ) {
            return -3;
        }
        if (this.arR) {
            eVar.flags = 4;
            return -4;
        }
        int b = this.ack.b(kVar, eVar, z);
        if (this.arN == Long.MIN_VALUE || ((b != -4 || eVar.aih < this.arN) && !(b == -3 && this.ady.kA() == Long.MIN_VALUE))) {
            if (b == -4 && !eVar.jy()) {
                eVar.aih -= this.arM;
            }
            return b;
        }
        eVar.clear();
        eVar.flags = 4;
        this.arR = true;
        return -4;
    }

    public final void H(long j) {
        this.ack.H(this.arM + j);
    }
}
