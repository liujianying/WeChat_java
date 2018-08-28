package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class s implements p {
    private q alB;
    private k alX;
    private boolean aoO;

    public final void a(q qVar, f fVar, u$d u_d) {
        this.alB = qVar;
        u_d.kf();
        this.alX = fVar.cp(u_d.kg());
        this.alX.f(Format.h(u_d.kh(), "application/x-scte35"));
    }

    public final void b(j jVar) {
        long j = -9223372036854775807L;
        if (!this.aoO) {
            if (this.alB.mp() != -9223372036854775807L) {
                this.alX.f(Format.b("application/x-scte35", this.alB.mp()));
                this.aoO = true;
            } else {
                return;
            }
        }
        int me = jVar.me();
        this.alX.a(jVar, me);
        k kVar = this.alX;
        q qVar = this.alB;
        if (qVar.aCG != -9223372036854775807L) {
            j = qVar.aCG;
        } else if (qVar.amH != Long.MAX_VALUE) {
            j = qVar.amH;
        }
        kVar.a(j, 1, me, 0, null);
    }
}
