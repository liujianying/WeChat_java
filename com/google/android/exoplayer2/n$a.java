package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.f.b;

public final class n$a {
    public final long adK;
    public final long adL;
    public final b aer;
    public final long aes;
    public final long aet;
    public final boolean aeu;
    public final boolean aev;

    /* synthetic */ n$a(b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, byte b) {
        this(bVar, j, j2, j3, j4, z, z2);
    }

    n$a(b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.aer = bVar;
        this.adK = j;
        this.aes = j2;
        this.adL = j3;
        this.aet = j4;
        this.aeu = z;
        this.aev = z2;
    }

    public final n$a iR() {
        return new n$a(this.aer.cF(-1), this.adK, this.aes, this.adL, this.aet, this.aeu, this.aev);
    }
}
