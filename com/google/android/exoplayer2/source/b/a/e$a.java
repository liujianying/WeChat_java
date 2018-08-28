package com.google.android.exoplayer2.source.b.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.b.a.e.d;
import java.io.IOException;
import java.util.List;

final class e$a implements a<s<c>>, Runnable {
    private final a.a avI;
    public final r avJ = new r("HlsPlaylistTracker:MediaPlaylist");
    private final s<c> avK;
    public b avL;
    public long avM;
    private long avN;
    private long avO;
    private long avP;
    private boolean avQ;
    IOException avR;
    final /* synthetic */ e avS;

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        s sVar = (s) cVar;
        c cVar2 = (c) sVar.result;
        if (cVar2 instanceof b) {
            b((b) cVar2);
            if (((b) cVar2).auM) {
                this.avS.atP.kw();
            }
            this.avS.atP.a(sVar.asJ, j, j2, sVar.aBT);
            return;
        }
        this.avR = new o("Loaded playlist has unexpected type.");
    }

    public e$a(e eVar, a.a aVar) {
        this.avS = eVar;
        this.avI = aVar;
        this.avK = new s(eVar.atN.kT(), com.google.android.exoplayer2.i.s.k(eVar.ats.auW, aVar.url), eVar.atX);
    }

    public final void lg() {
        this.avP = 0;
        if (!this.avQ && !this.avJ.iD()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.avO) {
                this.avQ = true;
                this.avS.avB.postDelayed(this, this.avO - elapsedRealtime);
                return;
            }
            lh();
        }
    }

    public final void run() {
        this.avQ = false;
        lh();
    }

    private void lh() {
        this.avJ.a(this.avK, this, this.avS.avz);
    }

    private void b(b bVar) {
        Object obj;
        int size;
        b bVar2;
        b bVar3 = this.avL;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.avM = elapsedRealtime;
        e eVar = this.avS;
        if (bVar3 == null || bVar.auJ > bVar3.auJ) {
            obj = 1;
        } else {
            if (bVar.auJ >= bVar3.auJ) {
                size = bVar.auP.size();
                int size2 = bVar3.auP.size();
                if (size > size2 || (size == size2 && bVar.auM && !bVar3.auM)) {
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj == null) {
            bVar2 = bVar.auM ? bVar3.auM ? bVar3 : new b(bVar3.auF, bVar3.auW, bVar3.auX, bVar3.auG, bVar3.asN, bVar3.auH, bVar3.auI, bVar3.auJ, bVar3.version, bVar3.auK, bVar3.auL, true, bVar3.auN, bVar3.auO, bVar3.auP) : bVar3;
        } else {
            long j;
            int i;
            if (bVar.auN) {
                j = bVar.asN;
            } else {
                j = eVar.avG != null ? eVar.avG.asN : 0;
                if (bVar3 != null) {
                    size = bVar3.auP.size();
                    b.a a = e.a(bVar3, bVar);
                    if (a != null) {
                        j = bVar3.asN + a.auR;
                    } else if (size == bVar.auJ - bVar3.auJ) {
                        j = bVar3.lf();
                    }
                }
            }
            if (bVar.auH) {
                i = bVar.auI;
            } else {
                i = eVar.avG != null ? eVar.avG.auI : 0;
                if (bVar3 != null) {
                    b.a a2 = e.a(bVar3, bVar);
                    if (a2 != null) {
                        i = (bVar3.auI + a2.auQ) - ((b.a) bVar.auP.get(0)).auQ;
                    }
                }
            }
            bVar2 = new b(bVar.auF, bVar.auW, bVar.auX, bVar.auG, j, true, i, bVar.auJ, bVar.version, bVar.auK, bVar.auL, bVar.auM, bVar.auN, bVar.auO, bVar.auP);
        }
        this.avL = bVar2;
        if (this.avL != bVar3) {
            this.avR = null;
            this.avN = elapsedRealtime;
            e eVar2 = this.avS;
            a.a aVar = this.avI;
            b bVar4 = this.avL;
            if (aVar == eVar2.avF) {
                if (eVar2.avG == null) {
                    eVar2.avH = !bVar4.auM;
                }
                eVar2.avG = bVar4;
                eVar2.avC.a(bVar4);
            }
            int size3 = eVar2.avD.size();
            for (int i2 = 0; i2 < size3; i2++) {
                ((e$b) eVar2.avD.get(i2)).kY();
            }
        } else if (!this.avL.auM) {
            if (bVar.auJ + bVar.auP.size() < this.avL.auJ) {
                this.avR = new e.c(this.avI.url, (byte) 0);
            } else if (((double) (elapsedRealtime - this.avN)) > ((double) b.n(this.avL.auK)) * 3.5d) {
                this.avR = new d(this.avI.url, (byte) 0);
                li();
            }
        }
        this.avO = b.n(this.avL != bVar3 ? this.avL.auK : this.avL.auK / 2) + elapsedRealtime;
        if (this.avI == this.avS.avF && !this.avL.auM) {
            lg();
        }
    }

    private boolean li() {
        int i;
        this.avP = SystemClock.elapsedRealtime() + 60000;
        e eVar = this.avS;
        a.a aVar = this.avI;
        int size = eVar.avD.size();
        for (i = 0; i < size; i++) {
            ((e$b) eVar.avD.get(i)).b(aVar);
        }
        if (this.avS.avF == this.avI) {
            Object obj;
            eVar = this.avS;
            List list = eVar.ats.auC;
            size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (i = 0; i < size; i++) {
                e$a e_a = (e$a) eVar.avA.get(list.get(i));
                if (elapsedRealtime > e_a.avP) {
                    eVar.avF = e_a.avI;
                    e_a.lg();
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
