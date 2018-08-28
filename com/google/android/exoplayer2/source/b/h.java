package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.d;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.f.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import java.util.List;

public final class h implements e, f {
    private final d atN;
    private final int atO;
    private final a atP;
    private final Uri atW;
    private final s.a<c> atX;
    private f.a atY;
    private com.google.android.exoplayer2.source.b.a.e atb;

    static {
        j.ae("goog.exo.hls");
    }

    public h(Uri uri, com.google.android.exoplayer2.h.f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2) {
        this(uri, aVar, handler, aVar2, (byte) 0);
    }

    private h(Uri uri, com.google.android.exoplayer2.h.f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2, byte b) {
        this(uri, new b(aVar), handler, aVar2);
    }

    private h(Uri uri, d dVar, Handler handler, com.google.android.exoplayer2.source.a aVar) {
        this(uri, dVar, handler, aVar, new d());
    }

    private h(Uri uri, d dVar, Handler handler, com.google.android.exoplayer2.source.a aVar, s.a<c> aVar2) {
        this.atW = uri;
        this.atN = dVar;
        this.atO = 3;
        this.atX = aVar2;
        this.atP = new a(handler, aVar);
    }

    public final void a(f.a aVar) {
        com.google.android.exoplayer2.i.a.ap(this.atb == null);
        this.atb = new com.google.android.exoplayer2.source.b.a.e(this.atW, this.atN, this.atP, this.atO, this, this.atX);
        this.atY = aVar;
        com.google.android.exoplayer2.source.b.a.e eVar = this.atb;
        eVar.avE.a(new s(eVar.atN.kT(), eVar.avy, eVar.atX), eVar, eVar.avz);
    }

    public final void kD() {
        com.google.android.exoplayer2.source.b.a.e eVar = this.atb;
        eVar.avE.kC();
        if (eVar.avF != null) {
            eVar.d(eVar.avF);
        }
    }

    public final com.google.android.exoplayer2.source.e a(b bVar, com.google.android.exoplayer2.h.b bVar2) {
        com.google.android.exoplayer2.i.a.ao(bVar.arU == 0);
        return new g(this.atb, this.atN, this.atO, this.atP, bVar2);
    }

    public final void b(com.google.android.exoplayer2.source.e eVar) {
        g gVar = (g) eVar;
        gVar.atb.avD.remove(gVar);
        gVar.atR.removeCallbacksAndMessages(null);
        for (j jVar : gVar.atT) {
            boolean a = jVar.aud.a(jVar);
            if (jVar.adE && !a) {
                for (com.google.android.exoplayer2.source.h kM : jVar.auh) {
                    kM.kM();
                }
            }
            jVar.handler.removeCallbacksAndMessages(null);
            jVar.released = true;
        }
    }

    public final void kE() {
        if (this.atb != null) {
            com.google.android.exoplayer2.source.b.a.e eVar = this.atb;
            eVar.avE.a(null);
            for (com.google.android.exoplayer2.source.b.a.e.a aVar : eVar.avA.values()) {
                aVar.avJ.a(null);
            }
            eVar.avB.removeCallbacksAndMessages(null);
            eVar.avA.clear();
            this.atb = null;
        }
        this.atY = null;
    }

    public final void a(com.google.android.exoplayer2.source.b.a.b bVar) {
        w kVar;
        long j = bVar.auN ? 0 : -9223372036854775807L;
        long n = bVar.auN ? com.google.android.exoplayer2.b.n(bVar.asN) : -9223372036854775807L;
        long j2 = bVar.auG;
        if (this.atb.avH) {
            boolean z;
            long j3 = bVar.auM ? bVar.aet + bVar.asN : -9223372036854775807L;
            List list = bVar.auP;
            if (j2 == -9223372036854775807L) {
                long j4;
                if (list.isEmpty()) {
                    j4 = 0;
                } else {
                    j4 = ((com.google.android.exoplayer2.source.b.a.b.a) list.get(Math.max(0, list.size() - 3))).auR;
                }
                j2 = j4;
            }
            long j5 = bVar.aet;
            long j6 = bVar.asN;
            if (bVar.auM) {
                z = false;
            } else {
                z = true;
            }
            kVar = new k(j, n, j3, j5, j6, j2, z);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            kVar = new k(j, n, bVar.asN + bVar.aet, bVar.aet, bVar.asN, j2, false);
        }
        this.atY.a(kVar, new e(this.atb.ats, bVar));
    }
}
