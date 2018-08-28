package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.r.c;

public abstract class a implements c {
    public final f aiC;
    public final i asJ;
    public final Format asK;
    public final int asL;
    public final Object asM;
    public final long asN;
    public final long asO;
    public final int type;

    public abstract long kP();

    public a(f fVar, i iVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.aiC = (f) com.google.android.exoplayer2.i.a.Z(fVar);
        this.asJ = (i) com.google.android.exoplayer2.i.a.Z(iVar);
        this.type = i;
        this.asK = format;
        this.asL = i2;
        this.asM = obj;
        this.asN = j;
        this.asO = j2;
    }
}
