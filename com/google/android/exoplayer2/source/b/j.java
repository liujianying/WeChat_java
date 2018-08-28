package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

final class j implements f, a<com.google.android.exoplayer2.source.a.a>, d, b, com.google.android.exoplayer2.source.j {
    m acW;
    final int aci;
    boolean adE;
    private final com.google.android.exoplayer2.h.b asl;
    private final int atO;
    final com.google.android.exoplayer2.source.a.a atP;
    private final a aua;
    final c aub;
    private final Format auc;
    final r aud = new r("Loader:HlsSampleStreamWrapper");
    private final c.b aue = new c.b();
    final LinkedList<f> auf = new LinkedList();
    private final Runnable aug = new Runnable() {
        public final void run() {
            j.this.ld();
        }
    };
    h[] auh = new h[0];
    private int[] aui = new int[0];
    boolean auj;
    int auk;
    Format aul;
    int aum;
    int aun;
    private boolean auo;
    boolean[] aup;
    private boolean[] auq;
    long aur;
    private long aus;
    boolean aut;
    boolean auu;
    boolean auv;
    final Handler handler = new Handler();
    boolean released;

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        c cVar2 = this.aub;
        if (aVar instanceof c.a) {
            c.a aVar2 = (c.a) aVar;
            cVar2.atf = aVar2.data;
            cVar2.a(aVar2.asJ.uri, aVar2.atm, aVar2.atn);
        }
        this.atP.a(aVar.asJ, aVar.type, this.aci, aVar.asK, aVar.asL, aVar.asM, aVar.asN, aVar.asO, j, j2, aVar.kP());
        if (this.adE) {
            this.aua.a(this);
            return;
        }
        G(this.aur);
    }

    public j(int i, a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, long j, Format format, int i2, com.google.android.exoplayer2.source.a.a aVar2) {
        this.aci = i;
        this.aua = aVar;
        this.aub = cVar;
        this.asl = bVar;
        this.auc = format;
        this.atO = i2;
        this.atP = aVar2;
        this.aur = j;
        this.aus = j;
    }

    public final void la() {
        if (!this.adE) {
            G(this.aur);
        }
    }

    public final boolean g(long j, boolean z) {
        this.aur = j;
        if (!(z || le())) {
            boolean z2;
            int length = this.auh.length;
            int i = 0;
            while (i < length) {
                h hVar = this.auh[i];
                hVar.rewind();
                if (!hVar.e(j, false) && (this.auq[i] || !this.auo)) {
                    z2 = false;
                    break;
                }
                hVar.L(hVar.asn.kK());
                i++;
            }
            z2 = true;
            if (z2) {
                return false;
            }
        }
        this.aus = j;
        this.auv = false;
        this.auf.clear();
        if (this.aud.iD()) {
            this.aud.lY();
        } else {
            lc();
        }
        return true;
    }

    public final long kA() {
        if (this.auv) {
            return Long.MIN_VALUE;
        }
        if (le()) {
            return this.aus;
        }
        long max;
        long j = this.aur;
        f fVar = (f) this.auf.getLast();
        if (!fVar.atM) {
            fVar = this.auf.size() > 1 ? (f) this.auf.get(this.auf.size() - 2) : null;
        }
        if (fVar != null) {
            max = Math.max(j, fVar.asO);
        } else {
            max = j;
        }
        for (h hVar : this.auh) {
            max = Math.max(max, hVar.asn.kI());
        }
        return max;
    }

    public final void lb() {
        lc();
    }

    public final void ak(boolean z) {
        this.aub.ate = z;
    }

    final void kC() {
        this.aud.kC();
        c cVar = this.aub;
        if (cVar.atg != null) {
            throw cVar.atg;
        } else if (cVar.ath != null) {
            cVar.atb.d(cVar.ath);
        }
    }

    final void lc() {
        for (h hVar : this.auh) {
            boolean z = this.aut;
            g gVar = hVar.asn;
            gVar.length = 0;
            gVar.asc = 0;
            gVar.asd = 0;
            gVar.ase = 0;
            gVar.ash = true;
            gVar.asf = Long.MIN_VALUE;
            gVar.asg = Long.MIN_VALUE;
            if (z) {
                gVar.asj = null;
                gVar.asi = true;
            }
            h.a aVar = hVar.asp;
            if (aVar.asz) {
                com.google.android.exoplayer2.h.a[] aVarArr = new com.google.android.exoplayer2.h.a[((hVar.asr.asz ? 1 : 0) + (((int) (hVar.asr.asy - aVar.asy)) / hVar.asm))];
                for (int i = 0; i < aVarArr.length; i++) {
                    aVarArr[i] = aVar.asA;
                    aVar = aVar.kN();
                }
                hVar.asl.a(aVarArr);
            }
            hVar.asp = new h.a(0, hVar.asm);
            hVar.asq = hVar.asp;
            hVar.asr = hVar.asp;
            hVar.anq = 0;
            hVar.asl.lM();
        }
        this.aut = false;
    }

    public final boolean G(long j) {
        if (this.auv || this.aud.iD()) {
            return false;
        }
        f fVar;
        int i;
        Object obj;
        boolean z;
        com.google.android.exoplayer2.source.a.a aVar;
        com.google.android.exoplayer2.source.b.a.a.a aVar2;
        c cVar = this.aub;
        if (this.auf.isEmpty()) {
            fVar = null;
        } else {
            fVar = (f) this.auf.getLast();
        }
        if (this.aus != -9223372036854775807L) {
            j = this.aus;
        }
        c.b bVar = this.aue;
        if (fVar == null) {
            i = -1;
        } else {
            i = cVar.atc.j(fVar.asK);
        }
        cVar.ath = null;
        if (fVar != null) {
            long j2;
            if (cVar.ati) {
                j2 = fVar.asO;
            } else {
                j2 = fVar.asN;
            }
            Math.max(0, j2 - j);
        }
        cVar.atl.kU();
        int lI = cVar.atl.lI();
        Object obj2;
        if (i != lI) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        com.google.android.exoplayer2.source.b.a.a.a aVar3 = cVar.ata[lI];
        e.a aVar4 = (e.a) cVar.atb.avA.get(aVar3);
        if (aVar4.avL != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000, com.google.android.exoplayer2.b.n(aVar4.avL.aet));
            if (aVar4.avL.auM || aVar4.avL.auF == 2 || aVar4.avL.auF == 1 || max + aVar4.avM > elapsedRealtime) {
                long j3;
                obj = 1;
                if (obj != null) {
                    bVar.atq = aVar3;
                    cVar.ath = aVar3;
                } else {
                    int a;
                    int i2;
                    com.google.android.exoplayer2.source.b.a.b bVar2;
                    com.google.android.exoplayer2.source.b.a.a.a aVar5;
                    int i3;
                    com.google.android.exoplayer2.source.b.a.b c = cVar.atb.c(aVar3);
                    cVar.ati = c.auL;
                    if (fVar == null || obj2 != null) {
                        if (fVar != null) {
                            j = cVar.ati ? fVar.asO : fVar.asN;
                        }
                        if (c.auM || j < c.lf()) {
                            com.google.android.exoplayer2.source.b.a.b bVar3;
                            List list = c.auP;
                            Object valueOf = Long.valueOf(j - c.asN);
                            z = !cVar.atb.avH || fVar == null;
                            a = t.a(list, valueOf, z) + c.auJ;
                            if (a >= c.auJ || fVar == null) {
                                bVar3 = c;
                                i = lI;
                            } else {
                                com.google.android.exoplayer2.source.b.a.a.a aVar6 = cVar.ata[i];
                                bVar3 = cVar.atb.c(aVar6);
                                a = fVar.asQ + 1;
                                aVar3 = aVar6;
                            }
                            i2 = a;
                            bVar2 = bVar3;
                            aVar5 = aVar3;
                            i3 = i;
                        } else {
                            i2 = c.auJ + c.auP.size();
                            bVar2 = c;
                            aVar5 = aVar3;
                            i3 = lI;
                        }
                    } else {
                        i2 = fVar.asQ + 1;
                        bVar2 = c;
                        aVar5 = aVar3;
                        i3 = lI;
                    }
                    if (i2 < bVar2.auJ) {
                        cVar.atg = new com.google.android.exoplayer2.source.b();
                    } else {
                        a = i2 - bVar2.auJ;
                        if (a < bVar2.auP.size()) {
                            i iVar;
                            q qVar;
                            com.google.android.exoplayer2.source.b.a.b.a aVar7 = (com.google.android.exoplayer2.source.b.a.b.a) bVar2.auP.get(a);
                            if (aVar7.amj) {
                                Uri k = s.k(bVar2.auW, aVar7.auS);
                                if (!k.equals(cVar.atj)) {
                                    bVar.ato = new c.a(cVar.asY, new i(k, (byte) 0), cVar.ata[i3].aep, cVar.atl.kW(), cVar.atl.kX(), cVar.atf, aVar7.auT);
                                } else if (!t.i(aVar7.auT, cVar.atk)) {
                                    cVar.a(k, aVar7.auT, cVar.aiS);
                                }
                            } else {
                                cVar.atj = null;
                                cVar.aiS = null;
                                cVar.atk = null;
                                cVar.asU = null;
                            }
                            com.google.android.exoplayer2.source.b.a.b.a aVar8 = bVar2.auO;
                            if (aVar8 != null) {
                                iVar = new i(s.k(bVar2.auW, aVar8.url), aVar8.auU, aVar8.auV);
                            } else {
                                iVar = null;
                            }
                            j3 = bVar2.asN + aVar7.auR;
                            int i4 = bVar2.auI + aVar7.auQ;
                            k kVar = cVar.asZ;
                            q qVar2 = (q) kVar.aux.get(i4);
                            if (qVar2 == null) {
                                q qVar3 = new q(Long.MAX_VALUE);
                                kVar.aux.put(i4, qVar3);
                            } else {
                                qVar = qVar2;
                            }
                            bVar.ato = new f(cVar.asX, new i(s.k(bVar2.auW, aVar7.url), aVar7.auU, aVar7.auV), iVar, aVar5, cVar.atd, cVar.atl.kW(), cVar.atl.kX(), j3, j3 + aVar7.aet, i2, i4, cVar.ate, qVar, fVar, cVar.aiS, cVar.asU);
                        } else if (bVar2.auM) {
                            bVar.atp = true;
                        } else {
                            bVar.atq = aVar5;
                            cVar.ath = aVar5;
                        }
                    }
                }
                z = this.aue.atp;
                aVar = this.aue.ato;
                aVar2 = this.aue.atq;
                this.aue.clear();
                if (z) {
                    this.aus = -9223372036854775807L;
                    this.auv = true;
                    return true;
                } else if (aVar == null) {
                    if (aVar2 != null) {
                        this.aua.a(aVar2);
                    }
                    return false;
                } else {
                    if (aVar instanceof f) {
                        this.aus = -9223372036854775807L;
                        f fVar2 = (f) aVar;
                        fVar2.atL = this;
                        int i5 = fVar2.uid;
                        boolean z2 = fVar2.atC;
                        this.aum = i5;
                        for (h hVar : this.auh) {
                            hVar.asn.ask = i5;
                        }
                        if (z2) {
                            for (h hVar2 : this.auh) {
                                hVar2.asw = true;
                            }
                        }
                        this.auf.add(fVar2);
                    }
                    long a2 = this.aud.a(aVar, this, this.atO);
                    com.google.android.exoplayer2.source.a.a aVar9 = this.atP;
                    i iVar2 = aVar.asJ;
                    int i6 = aVar.type;
                    int i7 = this.aci;
                    Format format = aVar.asK;
                    int i8 = aVar.asL;
                    Object obj3 = aVar.asM;
                    max = aVar.asN;
                    j3 = aVar.asO;
                    if (aVar9.aru != null) {
                        aVar9.handler.post(new a$a$1(aVar9, iVar2, i6, i7, format, i8, obj3, max, j3, a2));
                    }
                    return true;
                }
            }
        }
        obj = null;
        if (obj != null) {
            int a3;
            int i22;
            com.google.android.exoplayer2.source.b.a.b bVar22;
            com.google.android.exoplayer2.source.b.a.a.a aVar52;
            int i32;
            com.google.android.exoplayer2.source.b.a.b c2 = cVar.atb.c(aVar3);
            cVar.ati = c2.auL;
            if (fVar == null || obj2 != null) {
                if (fVar != null) {
                    j = cVar.ati ? fVar.asO : fVar.asN;
                }
                if (c2.auM || j < c2.lf()) {
                    com.google.android.exoplayer2.source.b.a.b bVar32;
                    List list2 = c2.auP;
                    Object valueOf2 = Long.valueOf(j - c2.asN);
                    z = !cVar.atb.avH || fVar == null;
                    a3 = t.a(list2, valueOf2, z) + c2.auJ;
                    if (a3 >= c2.auJ || fVar == null) {
                        bVar32 = c2;
                        i = lI;
                    } else {
                        com.google.android.exoplayer2.source.b.a.a.a aVar62 = cVar.ata[i];
                        bVar32 = cVar.atb.c(aVar62);
                        a3 = fVar.asQ + 1;
                        aVar3 = aVar62;
                    }
                    i22 = a3;
                    bVar22 = bVar32;
                    aVar52 = aVar3;
                    i32 = i;
                } else {
                    i22 = c2.auJ + c2.auP.size();
                    bVar22 = c2;
                    aVar52 = aVar3;
                    i32 = lI;
                }
            } else {
                i22 = fVar.asQ + 1;
                bVar22 = c2;
                aVar52 = aVar3;
                i32 = lI;
            }
            if (i22 < bVar22.auJ) {
                cVar.atg = new com.google.android.exoplayer2.source.b();
            } else {
                a3 = i22 - bVar22.auJ;
                if (a3 < bVar22.auP.size()) {
                    i iVar3;
                    q qVar4;
                    com.google.android.exoplayer2.source.b.a.b.a aVar72 = (com.google.android.exoplayer2.source.b.a.b.a) bVar22.auP.get(a3);
                    if (aVar72.amj) {
                        Uri k2 = s.k(bVar22.auW, aVar72.auS);
                        if (!k2.equals(cVar.atj)) {
                            bVar.ato = new c.a(cVar.asY, new i(k2, (byte) 0), cVar.ata[i32].aep, cVar.atl.kW(), cVar.atl.kX(), cVar.atf, aVar72.auT);
                        } else if (!t.i(aVar72.auT, cVar.atk)) {
                            cVar.a(k2, aVar72.auT, cVar.aiS);
                        }
                    } else {
                        cVar.atj = null;
                        cVar.aiS = null;
                        cVar.atk = null;
                        cVar.asU = null;
                    }
                    com.google.android.exoplayer2.source.b.a.b.a aVar82 = bVar22.auO;
                    if (aVar82 != null) {
                        iVar3 = new i(s.k(bVar22.auW, aVar82.url), aVar82.auU, aVar82.auV);
                    } else {
                        iVar3 = null;
                    }
                    j3 = bVar22.asN + aVar72.auR;
                    int i42 = bVar22.auI + aVar72.auQ;
                    k kVar2 = cVar.asZ;
                    q qVar22 = (q) kVar2.aux.get(i42);
                    if (qVar22 == null) {
                        q qVar32 = new q(Long.MAX_VALUE);
                        kVar2.aux.put(i42, qVar32);
                    } else {
                        qVar4 = qVar22;
                    }
                    bVar.ato = new f(cVar.asX, new i(s.k(bVar22.auW, aVar72.url), aVar72.auU, aVar72.auV), iVar3, aVar52, cVar.atd, cVar.atl.kW(), cVar.atl.kX(), j3, j3 + aVar72.aet, i22, i42, cVar.ate, qVar4, fVar, cVar.aiS, cVar.asU);
                } else if (bVar22.auM) {
                    bVar.atp = true;
                } else {
                    bVar.atq = aVar52;
                    cVar.ath = aVar52;
                }
            }
        } else {
            bVar.atq = aVar3;
            cVar.ath = aVar3;
        }
        z = this.aue.atp;
        aVar = this.aue.ato;
        aVar2 = this.aue.atq;
        this.aue.clear();
        if (z) {
            this.aus = -9223372036854775807L;
            this.auv = true;
            return true;
        } else if (aVar == null) {
            if (aVar2 != null) {
                this.aua.a(aVar2);
            }
            return false;
        } else {
            if (aVar instanceof f) {
                this.aus = -9223372036854775807L;
                f fVar22 = (f) aVar;
                fVar22.atL = this;
                int i52 = fVar22.uid;
                boolean z22 = fVar22.atC;
                this.aum = i52;
                for (h hVar3 : this.auh) {
                    hVar3.asn.ask = i52;
                }
                if (z22) {
                    for (h hVar22 : this.auh) {
                        hVar22.asw = true;
                    }
                }
                this.auf.add(fVar22);
            }
            long a22 = this.aud.a(aVar, this, this.atO);
            com.google.android.exoplayer2.source.a.a aVar92 = this.atP;
            i iVar22 = aVar.asJ;
            int i62 = aVar.type;
            int i72 = this.aci;
            Format format2 = aVar.asK;
            int i82 = aVar.asL;
            Object obj32 = aVar.asM;
            max = aVar.asN;
            j3 = aVar.asO;
            if (aVar92.aru != null) {
                aVar92.handler.post(new a$a$1(aVar92, iVar22, i62, i72, format2, i82, obj32, max, j3, a22));
            }
            return true;
        }
    }

    public final long kB() {
        if (le()) {
            return this.aus;
        }
        return this.auv ? Long.MIN_VALUE : ((f) this.auf.getLast()).asO;
    }

    /* renamed from: cL */
    public final h cp(int i) {
        int length = this.auh.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.aui[i2] == i) {
                return this.auh[i2];
            }
        }
        h hVar = new h(this.asl);
        hVar.asx = this;
        this.aui = Arrays.copyOf(this.aui, length + 1);
        this.aui[length] = i;
        this.auh = (h[]) Arrays.copyOf(this.auh, length + 1);
        this.auh[length] = hVar;
        return hVar;
    }

    public final void jU() {
        this.auj = true;
        this.handler.post(this.aug);
    }

    public final void kO() {
        this.handler.post(this.aug);
    }

    final void ld() {
        if (!this.released && !this.adE && this.auj) {
            h[] hVarArr = this.auh;
            int length = hVarArr.length;
            int i = 0;
            while (i < length) {
                if (hVarArr[i].asn.kH() != null) {
                    i++;
                } else {
                    return;
                }
            }
            int length2 = this.auh.length;
            int i2 = 0;
            i = -1;
            boolean z = false;
            while (i2 < length2) {
                String str = this.auh[i2].asn.kH().adW;
                boolean z2 = com.google.android.exoplayer2.i.g.au(str) ? true : com.google.android.exoplayer2.i.g.at(str) ? true : com.google.android.exoplayer2.i.g.av(str);
                if (z2 > z) {
                    i = i2;
                } else if (z2 != z || i == -1) {
                    z2 = z;
                } else {
                    i = -1;
                    z2 = z;
                }
                i2++;
                z = z2;
            }
            l lVar = this.aub.atc;
            int i3 = lVar.length;
            this.aun = -1;
            this.aup = new boolean[length2];
            this.auq = new boolean[length2];
            l[] lVarArr = new l[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                Format kH = this.auh[i4].asn.kH();
                String str2 = kH.adW;
                boolean z3 = com.google.android.exoplayer2.i.g.au(str2) || com.google.android.exoplayer2.i.g.at(str2);
                this.auq[i4] = z3;
                this.auo = z3 | this.auo;
                if (i4 == i) {
                    Format[] formatArr = new Format[i3];
                    for (i2 = 0; i2 < i3; i2++) {
                        formatArr[i2] = a(lVar.asb[i2], kH);
                    }
                    lVarArr[i4] = new l(formatArr);
                    this.aun = i4;
                } else {
                    Format format = (z && com.google.android.exoplayer2.i.g.at(kH.adW)) ? this.auc : null;
                    lVarArr[i4] = new l(a(format, kH));
                }
            }
            this.acW = new m(lVarArr);
            this.adE = true;
            this.aua.iy();
        }
    }

    final void q(int i, boolean z) {
        int i2 = 1;
        com.google.android.exoplayer2.i.a.ap(this.aup[i] != z);
        this.aup[i] = z;
        int i3 = this.auk;
        if (!z) {
            i2 = -1;
        }
        this.auk = i3 + i2;
    }

    private static Format a(Format format, Format format2) {
        if (format == null) {
            return format2;
        }
        String str = null;
        int ax = com.google.android.exoplayer2.i.g.ax(format2.adW);
        if (ax == 1) {
            str = i(format.adT, 1);
        } else if (ax == 2) {
            str = i(format.adT, 2);
        }
        return new Format(format.id, format2.adV, format2.adW, str, format.bitrate, format2.adX, format.width, format.height, format2.aea, format2.aeb, format2.aec, format2.aee, format2.aed, format2.aef, format2.aeg, format2.sampleRate, format2.aeh, format2.aei, format2.aej, format.ael, format.aem, format2.aen, format2.aek, format2.adY, format2.adZ, format2.adU);
    }

    final boolean le() {
        return this.aus != -9223372036854775807L;
    }

    private static String i(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.i.g.ax(com.google.android.exoplayer2.i.g.aw(str2))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        return null;
    }
}
