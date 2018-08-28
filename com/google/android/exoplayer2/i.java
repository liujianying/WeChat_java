package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.g.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.o;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.f;
import java.io.IOException;

final class i implements Callback, a, e.a, f.a {
    private final r[] acG;
    private final g acH;
    private final Handler acJ;
    private final com.google.android.exoplayer2.w.b acM;
    private final w.a acN;
    private boolean acP;
    private boolean acT;
    private w acU;
    private p acY;
    private b acZ;
    private final s[] ade;
    private final m adf;
    private final o adg;
    private final HandlerThread adh;
    private final f adi;
    private final n adj;
    private r adk;
    private com.google.android.exoplayer2.i.f adl;
    private f adm;
    private r[] adn;
    private boolean ado;
    int adp;
    private int adq;
    private long adr;
    private int ads;
    private c adt;
    private long adu;
    private a adv;
    private a adw;
    private a adx;
    final Handler handler;
    boolean released;
    private int repeatMode;
    private int state = 1;

    public static final class b {
        public final com.google.android.exoplayer2.source.f.b adJ;
        public final long adK;
        public final long adL;
        public volatile long adM;
        public volatile long adN;

        public b(long j) {
            this(new com.google.android.exoplayer2.source.f.b(0), j);
        }

        public b(com.google.android.exoplayer2.source.f.b bVar, long j) {
            this(bVar, j, -9223372036854775807L);
        }

        public b(com.google.android.exoplayer2.source.f.b bVar, long j, long j2) {
            this.adJ = bVar;
            this.adK = j;
            this.adL = j2;
            this.adM = j;
            this.adN = j;
        }
    }

    public i(r[] rVarArr, g gVar, m mVar, boolean z, int i, Handler handler, b bVar, f fVar) {
        this.acG = rVarArr;
        this.acH = gVar;
        this.adf = mVar;
        this.acP = z;
        this.repeatMode = i;
        this.acJ = handler;
        this.acZ = bVar;
        this.adi = fVar;
        this.ade = new s[rVarArr.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            rVarArr[i2].setIndex(i2);
            this.ade[i2] = rVarArr[i2].ip();
        }
        this.adg = new o();
        this.adn = new r[0];
        this.acM = new com.google.android.exoplayer2.w.b();
        this.acN = new w.a();
        this.adj = new n();
        gVar.aAv = this;
        this.acY = p.aew;
        this.adh = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.adh.start();
        this.handler = new Handler(this.adh.getLooper(), this);
    }

    public final void a(w wVar, int i, long j) {
        this.handler.obtainMessage(3, new c(wVar, i, j)).sendToTarget();
    }

    public final synchronized void b(c... cVarArr) {
        if (!this.released) {
            int i = this.adp;
            this.adp = i + 1;
            this.handler.obtainMessage(11, cVarArr).sendToTarget();
            Object obj = null;
            while (this.adq <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void release() {
        if (!this.released) {
            this.handler.sendEmptyMessage(6);
            Object obj = null;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            this.adh.quit();
        }
    }

    public final void a(w wVar, Object obj) {
        this.handler.obtainMessage(7, Pair.create(wVar, obj)).sendToTarget();
    }

    public final void a(e eVar) {
        this.handler.obtainMessage(8, eVar).sendToTarget();
    }

    public final boolean handleMessage(Message message) {
        long iL;
        long longValue;
        com.google.android.exoplayer2.source.f.b d;
        int i;
        try {
            Object obj;
            boolean z;
            n nVar;
            n.a a;
            int a2;
            int i2;
            int intValue;
            com.google.android.exoplayer2.source.f.b bVar;
            int i3;
            a aVar;
            r rVar;
            Object obj2;
            a aVar2;
            long kA;
            Pair a3;
            int i4;
            a aVar3;
            e eVar;
            switch (message.what) {
                case 0:
                    f fVar = (f) message.obj;
                    obj = message.arg1 != 0 ? 1 : null;
                    this.acJ.sendEmptyMessage(0);
                    ah(true);
                    this.adf.iy();
                    if (obj != null) {
                        this.acZ = new b(-9223372036854775807L);
                    } else {
                        this.acZ = new b(this.acZ.adJ, this.acZ.adM, this.acZ.adL);
                    }
                    this.adm = fVar;
                    if (fVar != null) {
                        fVar.a(this);
                    }
                    setState(2);
                    this.handler.sendEmptyMessage(2);
                    return true;
                case 1:
                    z = message.arg1 != 0;
                    this.ado = false;
                    this.acP = z;
                    if (!z) {
                        iG();
                        iH();
                    } else if (this.state == 3) {
                        iF();
                        this.handler.sendEmptyMessage(2);
                    } else if (this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    return true;
                case 2:
                    Object obj3;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.acU != null || this.adm == null) {
                        if (this.adv == null) {
                            nVar = this.adj;
                            b bVar2 = this.acZ;
                            a = nVar.a(bVar2.adJ, bVar2.adL, bVar2.adK);
                        } else {
                            if (!this.adv.adD.aev && this.adv.iM() && this.adv.adD.aet != -9223372036854775807L && (this.adx == null || this.adv.index - this.adx.index != 100)) {
                                n nVar2 = this.adj;
                                n.a aVar4 = this.adv.adD;
                                iL = this.adv.iL();
                                long j = this.adu;
                                if (aVar4.aeu) {
                                    a2 = nVar2.acU.a(aVar4.aer.arU, nVar2.acN, nVar2.acM, nVar2.repeatMode);
                                    if (a2 == -1) {
                                        a = null;
                                    } else {
                                        i2 = nVar2.acU.a(a2, nVar2.acN, false).adO;
                                        if (nVar2.acU.a(i2, nVar2.acM, 0).afj == a2) {
                                            Pair a4 = nVar2.acU.a(nVar2.acM, nVar2.acN, i2, -9223372036854775807L, Math.max(0, (aVar4.aet + iL) - j));
                                            if (a4 == null) {
                                                a = null;
                                            } else {
                                                intValue = ((Integer) a4.first).intValue();
                                                longValue = ((Long) a4.second).longValue();
                                                a2 = intValue;
                                            }
                                        } else {
                                            longValue = 0;
                                        }
                                        a = nVar2.a(nVar2.d(a2, longValue), longValue, longValue);
                                    }
                                } else {
                                    bVar = aVar4.aer;
                                    if (bVar.kF()) {
                                        i3 = bVar.arV;
                                        nVar2.acU.a(bVar.arU, nVar2.acN, false);
                                        intValue = nVar2.acN.afa[i3];
                                        if (intValue == -1) {
                                            a = null;
                                        } else {
                                            i2 = bVar.arW + 1;
                                            if (i2 < intValue) {
                                                a = !nVar2.acN.aq(i3, i2) ? null : nVar2.b(bVar.arU, i3, i2, aVar4.adL);
                                            } else {
                                                intValue = nVar2.acN.w(aVar4.adL);
                                                a = nVar2.b(bVar.arU, aVar4.adL, intValue == -1 ? Long.MIN_VALUE : nVar2.acN.aeZ[intValue]);
                                            }
                                        }
                                    } else if (aVar4.aes != Long.MIN_VALUE) {
                                        i3 = nVar2.acN.v(aVar4.aes);
                                        a = !nVar2.acN.aq(i3, 0) ? null : nVar2.b(bVar.arU, i3, 0, aVar4.aes);
                                    } else {
                                        i3 = nVar2.acN.iW();
                                        if (i3 != 0) {
                                            if (nVar2.acN.aeZ[i3 - 1] == Long.MIN_VALUE && !nVar2.acN.cc(i3 - 1) && nVar2.acN.aq(i3 - 1, 0)) {
                                                a = nVar2.b(bVar.arU, i3 - 1, 0, nVar2.acN.aet);
                                            }
                                        }
                                        a = null;
                                    }
                                }
                            }
                            if (this.adv != null || this.adv.iM()) {
                                ag(false);
                            } else if (!(this.adv == null || this.acT)) {
                                iK();
                            }
                            if (this.adx != null) {
                                while (this.adx != this.adw && this.adu >= this.adx.adG.adC) {
                                    this.adx.release();
                                    b(this.adx.adG);
                                    this.acZ = new b(this.adx.adD.aer, this.adx.adD.adK, this.adx.adD.adL);
                                    iH();
                                    this.acJ.obtainMessage(5, this.acZ).sendToTarget();
                                }
                                r rVar2;
                                com.google.android.exoplayer2.source.i iVar;
                                if (this.adw.adD.aev) {
                                    for (a2 = 0; a2 < this.acG.length; a2++) {
                                        rVar2 = this.acG[a2];
                                        iVar = this.adw.adA[a2];
                                        if (iVar != null && rVar2.ir() == iVar && rVar2.is()) {
                                            rVar2.it();
                                        }
                                    }
                                } else {
                                    a2 = 0;
                                    while (a2 < this.acG.length) {
                                        rVar2 = this.acG[a2];
                                        iVar = this.adw.adA[a2];
                                        if (rVar2.ir() == iVar && (iVar == null || rVar2.is())) {
                                            a2++;
                                        }
                                    }
                                    if (this.adw.adG != null && this.adw.adG.adE) {
                                        h hVar = this.adw.adH;
                                        this.adw = this.adw.adG;
                                        h hVar2 = this.adw.adH;
                                        obj = this.adw.ady.kz() != -9223372036854775807L ? 1 : null;
                                        for (intValue = 0; intValue < this.acG.length; intValue++) {
                                            r rVar3 = this.acG[intValue];
                                            if (hVar.aAx.aAu[intValue] != null) {
                                                if (obj == null) {
                                                    if (!rVar3.iu()) {
                                                        com.google.android.exoplayer2.g.e eVar2 = hVar2.aAx.aAu[intValue];
                                                        obj3 = hVar.aAz[intValue];
                                                        t tVar = hVar2.aAz[intValue];
                                                        if (eVar2 != null && tVar.equals(obj3)) {
                                                            Format[] formatArr = new Format[eVar2.length()];
                                                            for (i3 = 0; i3 < formatArr.length; i3++) {
                                                                formatArr[i3] = eVar2.cS(i3);
                                                            }
                                                            rVar3.a(formatArr, this.adw.adA[intValue], this.adw.iL());
                                                        }
                                                    }
                                                }
                                                rVar3.it();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a == null) {
                            this.adm.kD();
                        } else {
                            aVar = new a(this.acG, this.ade, this.adv == null ? 60000000 : this.adv.iL() + this.adv.adD.aet, this.acH, this.adf, this.adm, this.acU.a(a.aer.arU, this.acN, true).adz, this.adv == null ? 0 : this.adv.index + 1, a);
                            if (this.adv != null) {
                                this.adv.adG = aVar;
                            }
                            this.adv = aVar;
                            this.adv.ady.a(this, a.adK);
                            ag(true);
                        }
                        if (this.adv != null) {
                            break;
                        }
                        ag(false);
                        if (this.adx != null) {
                            while (this.adx != this.adw && this.adu >= this.adx.adG.adC) {
                                this.adx.release();
                                b(this.adx.adG);
                                this.acZ = new b(this.adx.adD.aer, this.adx.adD.adK, this.adx.adD.adL);
                                iH();
                                this.acJ.obtainMessage(5, this.acZ).sendToTarget();
                            }
                            r rVar22;
                            com.google.android.exoplayer2.source.i iVar2;
                            if (this.adw.adD.aev) {
                                for (a2 = 0; a2 < this.acG.length; a2++) {
                                    rVar22 = this.acG[a2];
                                    iVar2 = this.adw.adA[a2];
                                    if (iVar2 != null && rVar22.ir() == iVar2 && rVar22.is()) {
                                        rVar22.it();
                                    }
                                }
                            } else {
                                a2 = 0;
                                while (a2 < this.acG.length) {
                                    rVar22 = this.acG[a2];
                                    iVar2 = this.adw.adA[a2];
                                    if (rVar22.ir() == iVar2 && (iVar2 == null || rVar22.is())) {
                                        a2++;
                                    }
                                }
                                if (this.adw.adG != null && this.adw.adG.adE) {
                                    h hVar3 = this.adw.adH;
                                    this.adw = this.adw.adG;
                                    h hVar22 = this.adw.adH;
                                    obj = this.adw.ady.kz() != -9223372036854775807L ? 1 : null;
                                    for (intValue = 0; intValue < this.acG.length; intValue++) {
                                        r rVar32 = this.acG[intValue];
                                        if (hVar3.aAx.aAu[intValue] != null) {
                                            if (obj == null) {
                                                if (!rVar32.iu()) {
                                                    com.google.android.exoplayer2.g.e eVar22 = hVar22.aAx.aAu[intValue];
                                                    obj3 = hVar3.aAz[intValue];
                                                    t tVar2 = hVar22.aAz[intValue];
                                                    if (eVar22 != null && tVar2.equals(obj3)) {
                                                        Format[] formatArr2 = new Format[eVar22.length()];
                                                        for (i3 = 0; i3 < formatArr2.length; i3++) {
                                                            formatArr2[i3] = eVar22.cS(i3);
                                                        }
                                                        rVar32.a(formatArr2, this.adw.adA[intValue], this.adw.iL());
                                                    }
                                                }
                                            }
                                            rVar32.it();
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        this.adm.kD();
                    }
                    if (this.adx == null) {
                        iJ();
                        b(elapsedRealtime, 10);
                    } else {
                        r.beginSection("doSomeWork");
                        iH();
                        this.adx.ady.E(this.acZ.adM);
                        obj3 = 1;
                        z = true;
                        for (r rVar4 : this.adn) {
                            rVar4.c(this.adu, this.adr);
                            obj3 = (obj3 == null || !rVar4.iT()) ? null : 1;
                            obj2 = (rVar4.hv() || rVar4.iT()) ? 1 : null;
                            if (obj2 == null) {
                                rVar4.iv();
                            }
                            z = z && obj2 != null;
                        }
                        if (!z) {
                            iJ();
                        }
                        if (this.adl != null) {
                            p ju = this.adl.ju();
                            if (!ju.equals(this.acY)) {
                                this.acY = ju;
                                this.adg.a(this.adl);
                                this.acJ.obtainMessage(7, ju).sendToTarget();
                            }
                        }
                        iL = this.adx.adD.aet;
                        if (obj3 != null && ((iL == -9223372036854775807L || iL <= this.acZ.adM) && this.adx.adD.aev)) {
                            setState(4);
                            iG();
                        } else if (this.state == 2) {
                            if (this.adn.length > 0) {
                                if (z) {
                                    aVar2 = this.adv;
                                    boolean z2 = this.ado;
                                    iL = this.adu;
                                    kA = !aVar2.adE ? aVar2.adD.adK : aVar2.ady.kA();
                                    if (kA == Long.MIN_VALUE) {
                                        if (aVar2.adD.aev) {
                                            z = true;
                                            if (z) {
                                                z = true;
                                            }
                                        } else {
                                            kA = aVar2.adD.aet;
                                        }
                                    }
                                    z = aVar2.adf.c(kA - (iL - aVar2.iL()), z2);
                                    if (z) {
                                        z = true;
                                    }
                                }
                                z = false;
                            } else {
                                z = s(iL);
                            }
                            if (z) {
                                setState(3);
                                if (this.acP) {
                                    iF();
                                }
                            }
                        } else if (this.state == 3) {
                            if (this.adn.length <= 0) {
                                z = s(iL);
                            }
                            if (!z) {
                                this.ado = this.acP;
                                setState(2);
                                iG();
                            }
                        }
                        if (this.state == 2) {
                            for (r iv : this.adn) {
                                iv.iv();
                            }
                        }
                        if ((this.acP && this.state == 3) || this.state == 2) {
                            b(elapsedRealtime, 10);
                        } else if (this.adn.length == 0 || this.state == 4) {
                            this.handler.removeMessages(2);
                        } else {
                            b(elapsedRealtime, 1000);
                        }
                        r.endSection();
                    }
                    return true;
                case 3:
                    c cVar = (c) message.obj;
                    if (this.acU == null) {
                        this.ads++;
                        this.adt = cVar;
                    } else {
                        a3 = a(cVar);
                        if (a3 == null) {
                            this.acZ = new b(0);
                            this.acJ.obtainMessage(4, 1, 0, this.acZ).sendToTarget();
                            this.acZ = new b(-9223372036854775807L);
                            setState(4);
                            ah(false);
                        } else {
                            i4 = cVar.adP == -9223372036854775807L ? 1 : 0;
                            i3 = ((Integer) a3.first).intValue();
                            iL = ((Long) a3.second).longValue();
                            d = this.adj.d(i3, iL);
                            if (d.kF()) {
                                longValue = 0;
                                i = 1;
                            } else {
                                longValue = iL;
                                i = i4;
                            }
                            if (d.equals(this.acZ.adJ) && longValue / 1000 == this.acZ.adM / 1000) {
                                this.acZ = new b(d, longValue, iL);
                                this.acJ.obtainMessage(4, i != 0 ? 1 : 0, 0, this.acZ).sendToTarget();
                            } else {
                                long a5 = a(d, longValue);
                                i4 = i | (longValue != a5 ? 1 : 0);
                                this.acZ = new b(d, a5, iL);
                                this.acJ.obtainMessage(4, i4 != 0 ? 1 : 0, 0, this.acZ).sendToTarget();
                            }
                        }
                    }
                    return true;
                case 4:
                    p pVar = (p) message.obj;
                    pVar = this.adl != null ? this.adl.b(pVar) : this.adg.b(pVar);
                    this.acY = pVar;
                    this.acJ.obtainMessage(7, pVar).sendToTarget();
                    return true;
                case 5:
                    iI();
                    return true;
                case 6:
                    ah(true);
                    this.adf.iz();
                    setState(1);
                    synchronized (this) {
                        this.released = true;
                        notifyAll();
                    }
                    return true;
                case 7:
                    Pair pair = (Pair) message.obj;
                    w wVar = this.acU;
                    this.acU = (w) pair.first;
                    this.adj.acU = this.acU;
                    Object obj4 = pair.second;
                    if (wVar != null) {
                        intValue = this.acZ.adJ.arU;
                        a aVar5 = this.adx != null ? this.adx : this.adv;
                        if (aVar5 != null || intValue < wVar.iV()) {
                            i4 = this.acU.V(aVar5 == null ? wVar.a(intValue, this.acN, true).adz : aVar5.adz);
                            if (i4 == -1) {
                                a2 = a(intValue, wVar, this.acU);
                                if (a2 == -1) {
                                    l(obj4, 0);
                                } else {
                                    a3 = ca(this.acU.a(a2, this.acN, false).adO);
                                    i3 = ((Integer) a3.first).intValue();
                                    iL = ((Long) a3.second).longValue();
                                    this.acU.a(i3, this.acN, true);
                                    if (aVar5 != null) {
                                        obj2 = this.acN.adz;
                                        aVar5.adD = aVar5.adD.iR();
                                        aVar3 = aVar5;
                                        while (aVar3.adG != null) {
                                            aVar3 = aVar3.adG;
                                            if (aVar3.adz.equals(obj2)) {
                                                aVar3.adD = this.adj.a(aVar3.adD, i3);
                                            } else {
                                                aVar3.adD = aVar3.adD.iR();
                                            }
                                        }
                                    }
                                    bVar = new com.google.android.exoplayer2.source.f.b(i3);
                                    this.acZ = new b(bVar, a(bVar, iL));
                                }
                            } else {
                                if (i4 != intValue) {
                                    b bVar3 = this.acZ;
                                    b bVar4 = new b(bVar3.adJ.cF(i4), bVar3.adK, bVar3.adL);
                                    bVar4.adM = bVar3.adM;
                                    bVar4.adN = bVar3.adN;
                                    this.acZ = bVar4;
                                }
                                if (this.acZ.adJ.kF()) {
                                    d = this.adj.d(i4, this.acZ.adL);
                                    if (!(d.kF() && d.arW == this.acZ.adJ.arW)) {
                                        this.acZ = new b(d, a(d, this.acZ.adL), d.kF() ? this.acZ.adL : -9223372036854775807L);
                                    }
                                }
                                if (aVar5 != null) {
                                    aVar = a(aVar5, i4);
                                    a2 = i4;
                                    while (aVar.adG != null) {
                                        aVar2 = aVar.adG;
                                        a2 = this.acU.a(a2, this.acN, this.acM, this.repeatMode);
                                        if (a2 == -1 || !aVar2.adz.equals(this.acU.a(a2, this.acN, true).adz)) {
                                            obj = (this.adw == null || this.adw.index >= aVar2.index) ? null : 1;
                                            if (obj == null) {
                                                this.acZ = new b(this.adx.adD.aer, a(this.adx.adD.aer, this.acZ.adM), this.acZ.adL);
                                            } else {
                                                this.adv = aVar;
                                                this.adv.adG = null;
                                                a(aVar2);
                                            }
                                        } else {
                                            aVar = a(aVar2, a2);
                                        }
                                    }
                                }
                            }
                        }
                        m(obj4, 0);
                    } else if (this.ads > 0) {
                        a3 = a(this.adt);
                        i4 = this.ads;
                        this.ads = 0;
                        this.adt = null;
                        if (a3 == null) {
                            l(obj4, i4);
                        } else {
                            i3 = ((Integer) a3.first).intValue();
                            iL = ((Long) a3.second).longValue();
                            d = this.adj.d(i3, iL);
                            this.acZ = new b(d, d.kF() ? 0 : iL, iL);
                            m(obj4, i4);
                        }
                    } else {
                        if (this.acZ.adK == -9223372036854775807L) {
                            if (this.acU.isEmpty()) {
                                l(obj4, 0);
                            } else {
                                a3 = ca(0);
                                i3 = ((Integer) a3.first).intValue();
                                iL = ((Long) a3.second).longValue();
                                d = this.adj.d(i3, iL);
                                this.acZ = new b(d, d.kF() ? 0 : iL, iL);
                            }
                        }
                        m(obj4, 0);
                    }
                    return true;
                case 8:
                    eVar = (e) message.obj;
                    if (this.adv != null && this.adv.ady == eVar) {
                        a aVar6 = this.adv;
                        aVar6.adE = true;
                        aVar6.iN();
                        longValue = aVar6.t(aVar6.adD.adK);
                        a = aVar6.adD;
                        aVar6.adD = new n.a(a.aer, longValue, a.aes, a.adL, a.aet, a.aeu, a.aev);
                        if (this.adx == null) {
                            this.adw = this.adv;
                            r(this.adw.adD.adK);
                            b(this.adw);
                        }
                        iK();
                    }
                    return true;
                case 9:
                    eVar = (e) message.obj;
                    if (this.adv != null && this.adv.ady == eVar) {
                        iK();
                    }
                    return true;
                case 10:
                    if (this.adx != null) {
                        obj = 1;
                        a aVar7 = this.adx;
                        while (aVar7 != null && aVar7.adE) {
                            if (aVar7.iN()) {
                                if (obj != null) {
                                    z = this.adw != this.adx;
                                    a(this.adx.adG);
                                    this.adx.adG = null;
                                    this.adv = this.adx;
                                    this.adw = this.adx;
                                    boolean[] zArr = new boolean[this.acG.length];
                                    kA = this.adx.a(this.acZ.adM, z, zArr);
                                    if (kA != this.acZ.adM) {
                                        this.acZ.adM = kA;
                                        r(kA);
                                    }
                                    a2 = 0;
                                    boolean[] zArr2 = new boolean[this.acG.length];
                                    intValue = 0;
                                    while (true) {
                                        i3 = intValue;
                                        if (i3 < this.acG.length) {
                                            rVar4 = this.acG[i3];
                                            zArr2[i3] = rVar4.getState() != 0;
                                            com.google.android.exoplayer2.source.i iVar3 = this.adx.adA[i3];
                                            if (iVar3 != null) {
                                                a2++;
                                            }
                                            if (zArr2[i3]) {
                                                if (iVar3 != rVar4.ir()) {
                                                    if (rVar4 == this.adk) {
                                                        if (iVar3 == null) {
                                                            this.adg.a(this.adl);
                                                        }
                                                        this.adl = null;
                                                        this.adk = null;
                                                    }
                                                    a(rVar4);
                                                    rVar4.disable();
                                                } else if (zArr[i3]) {
                                                    rVar4.m(this.adu);
                                                }
                                            }
                                            intValue = i3 + 1;
                                        } else {
                                            this.acJ.obtainMessage(3, aVar7.adH).sendToTarget();
                                            b(zArr2, a2);
                                        }
                                    }
                                } else {
                                    this.adv = aVar7;
                                    for (aVar3 = this.adv.adG; aVar3 != null; aVar3 = aVar3.adG) {
                                        aVar3.release();
                                    }
                                    this.adv.adG = null;
                                    if (this.adv.adE) {
                                        this.adv.t(Math.max(this.adv.adD.adK, this.adu - this.adv.iL()));
                                    }
                                }
                                iK();
                                iH();
                                this.handler.sendEmptyMessage(2);
                            } else {
                                if (aVar7 == this.adw) {
                                    obj = null;
                                }
                                aVar7 = aVar7.adG;
                            }
                        }
                    }
                    return true;
                case 11:
                    for (c cVar2 : (c[]) message.obj) {
                        cVar2.acD.d(cVar2.acE, cVar2.acF);
                    }
                    if (this.state == 3 || this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    synchronized (this) {
                        this.adq++;
                        notifyAll();
                    }
                    return true;
                case 12:
                    intValue = message.arg1;
                    this.repeatMode = intValue;
                    this.adj.repeatMode = intValue;
                    aVar3 = this.adx != null ? this.adx : this.adv;
                    if (aVar3 != null) {
                        while (true) {
                            i2 = this.acU.a(aVar3.adD.aer.arU, this.acN, this.acM, intValue);
                            while (true) {
                                aVar2 = aVar3;
                                if (aVar2.adG != null && !aVar2.adD.aeu) {
                                    aVar3 = aVar2.adG;
                                }
                            }
                            if (i2 == -1 || aVar2.adG == null || aVar2.adG.adD.aer.arU != i2) {
                                i2 = this.adv.index;
                            } else {
                                aVar3 = aVar2.adG;
                            }
                        }
                        i2 = this.adv.index;
                        intValue = this.adw != null ? this.adw.index : -1;
                        if (aVar2.adG != null) {
                            a(aVar2.adG);
                            aVar2.adG = null;
                        }
                        nVar = this.adj;
                        n.a aVar8 = aVar2.adD;
                        aVar2.adD = nVar.a(aVar8, aVar8.aer);
                        if ((i2 <= aVar2.index ? 1 : null) == null) {
                            this.adv = aVar2;
                        }
                        obj = (intValue == -1 || intValue > aVar2.index) ? null : 1;
                        if (obj == null && this.adx != null) {
                            d = this.adx.adD.aer;
                            this.acZ = new b(d, a(d, this.acZ.adM), this.acZ.adL);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        } catch (e e) {
            this.acJ.obtainMessage(8, e).sendToTarget();
            iI();
            return true;
        } catch (IOException e2) {
            this.acJ.obtainMessage(8, e.a(e2)).sendToTarget();
            iI();
            return true;
        } catch (RuntimeException e3) {
            this.acJ.obtainMessage(8, e.b(e3)).sendToTarget();
            iI();
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.acZ = new b(d, longValue, iL);
            this.acJ.obtainMessage(4, i != 0 ? 1 : 0, 0, this.acZ).sendToTarget();
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.acJ.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void ag(boolean z) {
        if (this.acT != z) {
            int i;
            this.acT = z;
            Handler handler = this.acJ;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void iF() {
        int i = 0;
        this.ado = false;
        o oVar = this.adg;
        if (!oVar.started) {
            oVar.aCE = SystemClock.elapsedRealtime();
            oVar.started = true;
        }
        r[] rVarArr = this.adn;
        int length = rVarArr.length;
        while (i < length) {
            rVarArr[i].start();
            i++;
        }
    }

    private void iG() {
        this.adg.stop();
        for (r a : this.adn) {
            a(a);
        }
    }

    private void iH() {
        if (this.adx != null) {
            long kz = this.adx.ady.kz();
            if (kz != -9223372036854775807L) {
                r(kz);
            } else {
                if (this.adk == null || this.adk.iT()) {
                    this.adu = this.adg.jn();
                } else {
                    this.adu = this.adl.jn();
                    this.adg.O(this.adu);
                }
                kz = this.adu - this.adx.iL();
            }
            this.acZ.adM = kz;
            this.adr = SystemClock.elapsedRealtime() * 1000;
            if (this.adn.length == 0) {
                kz = Long.MIN_VALUE;
            } else {
                kz = this.adx.ady.kA();
            }
            b bVar = this.acZ;
            if (kz == Long.MIN_VALUE) {
                kz = this.adx.adD.aet;
            }
            bVar.adN = kz;
        }
    }

    private void b(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private long a(com.google.android.exoplayer2.source.f.b bVar, long j) {
        a aVar;
        iG();
        this.ado = false;
        setState(2);
        if (this.adx != null) {
            a aVar2 = this.adx;
            aVar = null;
            while (aVar2 != null) {
                if (aVar == null) {
                    boolean z;
                    if (bVar.equals(aVar2.adD.aer) && aVar2.adE) {
                        this.acU.a(aVar2.adD.aer.arU, this.acN, false);
                        int w = this.acN.w(j);
                        if (w == -1 || this.acN.aeZ[w] == aVar2.adD.aes) {
                            z = true;
                            if (z) {
                                aVar = aVar2;
                                aVar2 = aVar2.adG;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        aVar = aVar2;
                        aVar2 = aVar2.adG;
                    }
                }
                aVar2.release();
                aVar2 = aVar2.adG;
            }
        } else if (this.adv != null) {
            this.adv.release();
            aVar = null;
        } else {
            aVar = null;
        }
        if (!(this.adx == aVar && this.adx == this.adw)) {
            for (r disable : this.adn) {
                disable.disable();
            }
            this.adn = new r[0];
            this.adl = null;
            this.adk = null;
            this.adx = null;
        }
        if (aVar != null) {
            aVar.adG = null;
            this.adv = aVar;
            this.adw = aVar;
            b(aVar);
            if (this.adx.adF) {
                j = this.adx.ady.F(j);
            }
            r(j);
            iK();
        } else {
            this.adv = null;
            this.adw = null;
            this.adx = null;
            r(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void r(long j) {
        long j2;
        if (this.adx == null) {
            j2 = 60000000 + j;
        } else {
            j2 = this.adx.iL() + j;
        }
        this.adu = j2;
        this.adg.O(this.adu);
        for (r m : this.adn) {
            m.m(this.adu);
        }
    }

    private void iI() {
        ah(true);
        this.adf.onStopped();
        setState(1);
    }

    private void ah(boolean z) {
        this.handler.removeMessages(2);
        this.ado = false;
        this.adg.stop();
        this.adl = null;
        this.adk = null;
        this.adu = 60000000;
        for (r rVar : this.adn) {
            try {
                a(rVar);
                rVar.disable();
            } catch (e e) {
            } catch (RuntimeException e2) {
            }
        }
        this.adn = new r[0];
        a(this.adx != null ? this.adx : this.adv);
        this.adv = null;
        this.adw = null;
        this.adx = null;
        ag(false);
        if (z) {
            if (this.adm != null) {
                this.adm.kE();
                this.adm = null;
            }
            this.adj.acU = null;
            this.acU = null;
        }
    }

    private static void a(r rVar) {
        if (rVar.getState() == 2) {
            rVar.stop();
        }
    }

    private boolean s(long j) {
        return j == -9223372036854775807L || this.acZ.adM < j || (this.adx.adG != null && (this.adx.adG.adE || this.adx.adG.adD.aer.kF()));
    }

    private void iJ() {
        if (this.adv != null && !this.adv.adE) {
            if (this.adw == null || this.adw.adG == this.adv) {
                r[] rVarArr = this.adn;
                int length = rVarArr.length;
                int i = 0;
                while (i < length) {
                    if (rVarArr[i].is()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.adv.ady.kx();
            }
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.adD = this.adj.a(aVar.adD, i);
            if (aVar.adD.aeu || aVar.adG == null) {
                return aVar;
            }
            aVar = aVar.adG;
        }
        return aVar;
    }

    private void l(Object obj, int i) {
        this.acZ = new b(0);
        m(obj, i);
        this.acZ = new b(-9223372036854775807L);
        setState(4);
        ah(false);
    }

    private void m(Object obj, int i) {
        this.acJ.obtainMessage(6, new d(this.acU, obj, this.acZ, i)).sendToTarget();
    }

    private int a(int i, w wVar, w wVar2) {
        int iV = wVar.iV();
        int i2 = -1;
        for (int i3 = 0; i3 < iV && i2 == -1; i3++) {
            i = wVar.a(i, this.acN, this.acM, this.repeatMode);
            if (i == -1) {
                break;
            }
            i2 = wVar2.V(wVar.a(i, this.acN, true).adz);
        }
        return i2;
    }

    private Pair<Integer, Long> a(c cVar) {
        w wVar = cVar.acU;
        if (wVar.isEmpty()) {
            wVar = this.acU;
        }
        try {
            Pair<Integer, Long> a = wVar.a(this.acM, this.acN, cVar.adO, cVar.adP);
            if (this.acU == wVar) {
                return a;
            }
            int V = this.acU.V(wVar.a(((Integer) a.first).intValue(), this.acN, true).adz);
            if (V != -1) {
                return Pair.create(Integer.valueOf(V), a.second);
            }
            int a2 = a(((Integer) a.first).intValue(), wVar, this.acU);
            if (a2 != -1) {
                return ca(this.acU.a(a2, this.acN, false).adO);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new l(this.acU, cVar.adO, cVar.adP);
        }
    }

    private Pair<Integer, Long> ca(int i) {
        return this.acU.a(this.acM, this.acN, i, -9223372036854775807L);
    }

    private void iK() {
        a aVar = this.adv;
        long j = this.adu;
        long kB = !aVar.adE ? 0 : aVar.ady.kB();
        boolean p = kB == Long.MIN_VALUE ? false : aVar.adf.p(kB - (j - aVar.iL()));
        ag(p);
        if (p) {
            a aVar2 = this.adv;
            aVar2.ady.G(this.adu - aVar2.iL());
        }
    }

    private static void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.adG;
        }
    }

    private void b(a aVar) {
        if (this.adx != aVar) {
            boolean[] zArr = new boolean[this.acG.length];
            int i = 0;
            int i2 = 0;
            while (i < this.acG.length) {
                boolean z;
                r rVar = this.acG[i];
                if (rVar.getState() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i] = z;
                com.google.android.exoplayer2.g.e eVar = aVar.adH.aAx.aAu[i];
                if (eVar != null) {
                    i2++;
                }
                if (zArr[i] && (eVar == null || (rVar.iu() && rVar.ir() == this.adx.adA[i]))) {
                    if (rVar == this.adk) {
                        this.adg.a(this.adl);
                        this.adl = null;
                        this.adk = null;
                    }
                    a(rVar);
                    rVar.disable();
                }
                i++;
            }
            this.adx = aVar;
            this.acJ.obtainMessage(3, aVar.adH).sendToTarget();
            b(zArr, i2);
        }
    }

    private void b(boolean[] zArr, int i) {
        this.adn = new r[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.acG.length) {
                r rVar = this.acG[i4];
                com.google.android.exoplayer2.g.e eVar = this.adx.adH.aAx.aAu[i4];
                if (eVar != null) {
                    int i5 = i2 + 1;
                    this.adn[i2] = rVar;
                    if (rVar.getState() == 0) {
                        t tVar = this.adx.adH.aAz[i4];
                        Object obj = (this.acP && this.state == 3) ? 1 : null;
                        boolean z = (zArr[i4] || obj == null) ? false : true;
                        Format[] formatArr = new Format[eVar.length()];
                        for (int i6 = 0; i6 < formatArr.length; i6++) {
                            formatArr[i6] = eVar.cS(i6);
                        }
                        rVar.a(tVar, formatArr, this.adx.adA[i4], this.adu, z, this.adx.iL());
                        com.google.android.exoplayer2.i.f iq = rVar.iq();
                        if (iq != null) {
                            if (this.adl != null) {
                                throw e.b(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                            this.adl = iq;
                            this.adk = rVar;
                            this.adl.b(this.acY);
                        }
                        if (obj != null) {
                            rVar.start();
                        }
                    }
                    i2 = i5;
                }
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }
}
