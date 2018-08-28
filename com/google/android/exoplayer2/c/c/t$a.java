package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.t.b;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

class t$a implements p {
    private final i apc = new i(new byte[4]);
    final /* synthetic */ t apd;

    public t$a(t tVar) {
        this.apd = tVar;
    }

    public final void a(q qVar, f fVar, d dVar) {
    }

    public final void b(j jVar) {
        if (jVar.readUnsignedByte() == 0) {
            jVar.da(7);
            int me = jVar.me() / 4;
            for (int i = 0; i < me; i++) {
                jVar.c(this.apc, 4);
                int cY = this.apc.cY(16);
                this.apc.cX(3);
                if (cY == 0) {
                    this.apc.cX(13);
                } else {
                    cY = this.apc.cY(13);
                    t.a(this.apd).put(cY, new q(new b(this.apd, cY)));
                    t.b(this.apd);
                }
            }
            if (t.c(this.apd) != 2) {
                t.a(this.apd).remove(0);
            }
        }
    }
}
