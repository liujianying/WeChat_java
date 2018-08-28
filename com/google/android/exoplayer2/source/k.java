package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.b;

public final class k extends w {
    private static final Object asC = new Object();
    private final long aff;
    private final long afg;
    private final boolean afh = true;
    private final boolean afi;
    private final long asD;
    private final long asE;
    private final long asF;
    private final long asG;

    public k(long j, long j2, long j3, long j4, long j5, long j6, boolean z) {
        this.aff = j;
        this.afg = j2;
        this.asD = j3;
        this.asE = j4;
        this.asF = j5;
        this.asG = j6;
        this.afi = z;
    }

    public final int iU() {
        return 1;
    }

    public final b a(int i, b bVar, long j) {
        a.av(i, 1);
        long j2 = this.asG;
        if (this.afi) {
            j2 += j;
            if (j2 > this.asE) {
                j2 = -9223372036854775807L;
            }
        }
        long j3 = this.aff;
        long j4 = this.afg;
        boolean z = this.afh;
        boolean z2 = this.afi;
        long j5 = this.asE;
        long j6 = this.asF;
        bVar.aeX = null;
        bVar.aff = j3;
        bVar.afg = j4;
        bVar.afh = z;
        bVar.afi = z2;
        bVar.afl = j2;
        bVar.aet = j5;
        bVar.afj = 0;
        bVar.afk = 0;
        bVar.afm = j6;
        return bVar;
    }

    public final int iV() {
        return 1;
    }

    public final w.a a(int i, w.a aVar, boolean z) {
        Object obj;
        a.av(i, 1);
        if (z) {
            obj = asC;
        } else {
            obj = null;
        }
        long j = this.asD;
        long j2 = -this.asF;
        aVar.aeX = obj;
        aVar.adz = obj;
        aVar.adO = 0;
        aVar.aet = j;
        aVar.aeY = j2;
        aVar.aeZ = null;
        aVar.afa = null;
        aVar.afb = null;
        aVar.afc = null;
        aVar.afd = null;
        aVar.afe = -9223372036854775807L;
        return aVar;
    }

    public final int V(Object obj) {
        return asC.equals(obj) ? 0 : -1;
    }
}
