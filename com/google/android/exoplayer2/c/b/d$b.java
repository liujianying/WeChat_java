package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.a;

final class d$b {
    public final g alW = new g();
    public final k alX;
    public e alY;
    public c alZ;
    public int ama;
    public int amb;
    public int amc;

    public d$b(k kVar) {
        this.alX = kVar;
    }

    public final void a(e eVar, c cVar) {
        this.alY = (e) a.Z(eVar);
        this.alZ = (c) a.Z(cVar);
        this.alX.f(eVar.aep);
        reset();
    }

    public final void reset() {
        g gVar = this.alW;
        gVar.ams = 0;
        gVar.amF = 0;
        gVar.amz = false;
        gVar.amE = false;
        gVar.amB = null;
        this.ama = 0;
        this.amc = 0;
        this.amb = 0;
    }
}
