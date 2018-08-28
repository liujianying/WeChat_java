package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.tencent.smtt.sdk.WebView;
import java.util.Collections;

public final class k implements h {
    private com.google.android.exoplayer2.c.k alX;
    private String amX;
    private final n anC = new n(33);
    private final n anD = new n(34);
    private final j anG = new j();
    private boolean anb;
    private final boolean[] ano = new boolean[3];
    private long anq;
    private long ans;
    private final r anz;
    private a aoh;
    private final n aoi = new n(32);
    private final n aoj = new n(39);
    private final n aok = new n(40);

    public k(r rVar) {
        this.anz = rVar;
    }

    public final void jX() {
        h.b(this.ano);
        this.aoi.reset();
        this.anC.reset();
        this.anD.reset();
        this.aoj.reset();
        this.aok.reset();
        a aVar = this.aoh;
        aVar.aon = false;
        aVar.aoo = false;
        aVar.aop = false;
        aVar.anQ = false;
        aVar.aoq = false;
        this.anq = 0;
    }

    public final void a(f fVar, d dVar) {
        dVar.kf();
        this.amX = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
        this.aoh = new a(this.alX);
        this.anz.a(fVar, dVar);
    }

    public final void d(long j, boolean z) {
        this.ans = j;
    }

    public final void b(j jVar) {
        while (jVar.me() > 0) {
            int i = jVar.position;
            int i2 = jVar.limit;
            byte[] bArr = jVar.data;
            this.anq += (long) jVar.me();
            this.alX.a(jVar, jVar.me());
            while (i < i2) {
                int a = h.a(bArr, i, i2, this.ano);
                if (a == i2) {
                    e(bArr, i, i2);
                    return;
                }
                int k = h.k(bArr, a);
                int i3 = a - i;
                if (i3 > 0) {
                    e(bArr, i, a);
                }
                int i4 = i2 - a;
                long j = this.anq - ((long) i4);
                int i5 = i3 < 0 ? -i3 : 0;
                long j2 = this.ans;
                if (this.anb) {
                    a aVar = this.aoh;
                    if (aVar.aoq && aVar.aoo) {
                        aVar.anu = aVar.aol;
                        aVar.aoq = false;
                    } else if (aVar.aop || aVar.aoo) {
                        if (aVar.anQ) {
                            aVar.cA(((int) (j - aVar.anM)) + i4);
                        }
                        aVar.ant = aVar.anM;
                        aVar.anl = aVar.anN;
                        aVar.anQ = true;
                        aVar.anu = aVar.aol;
                    }
                } else {
                    this.aoi.cC(i5);
                    this.anC.cC(i5);
                    this.anD.cC(i5);
                    if (this.aoi.aoy && this.anC.aoy && this.anD.aoy) {
                        int i6;
                        int mn;
                        int mn2;
                        int mn3;
                        int i7;
                        float f;
                        com.google.android.exoplayer2.c.k kVar = this.alX;
                        String str = this.amX;
                        n nVar = this.aoi;
                        n nVar2 = this.anC;
                        n nVar3 = this.anD;
                        Object obj = new byte[((nVar.aoA + nVar2.aoA) + nVar3.aoA)];
                        System.arraycopy(nVar.aoz, 0, obj, 0, nVar.aoA);
                        System.arraycopy(nVar2.aoz, 0, obj, nVar.aoA, nVar2.aoA);
                        System.arraycopy(nVar3.aoz, 0, obj, nVar.aoA + nVar2.aoA, nVar3.aoA);
                        com.google.android.exoplayer2.i.k kVar2 = new com.google.android.exoplayer2.i.k(nVar2.aoz, 0, nVar2.aoA);
                        kVar2.cX(44);
                        int cY = kVar2.cY(3);
                        kVar2.mk();
                        kVar2.cX(88);
                        kVar2.cX(8);
                        i3 = 0;
                        for (i6 = 0; i6 < cY; i6++) {
                            if (kVar2.mb()) {
                                i3 += 89;
                            }
                            if (kVar2.mb()) {
                                i3 += 8;
                            }
                        }
                        kVar2.cX(i3);
                        if (cY > 0) {
                            kVar2.cX((8 - cY) * 2);
                        }
                        kVar2.mn();
                        int mn4 = kVar2.mn();
                        if (mn4 == 3) {
                            kVar2.mk();
                        }
                        i6 = kVar2.mn();
                        int mn5 = kVar2.mn();
                        if (kVar2.mb()) {
                            mn = kVar2.mn();
                            mn2 = kVar2.mn();
                            mn3 = kVar2.mn();
                            int mn6 = kVar2.mn();
                            i7 = (mn4 == 1 || mn4 == 2) ? 2 : 1;
                            i6 -= i7 * (mn + mn2);
                            mn5 -= (mn4 == 1 ? 2 : 1) * (mn3 + mn6);
                        }
                        kVar2.mn();
                        kVar2.mn();
                        mn = kVar2.mn();
                        i3 = kVar2.mb() ? 0 : cY;
                        while (i3 <= cY) {
                            kVar2.mn();
                            kVar2.mn();
                            kVar2.mn();
                            i3++;
                        }
                        kVar2.mn();
                        kVar2.mn();
                        kVar2.mn();
                        kVar2.mn();
                        kVar2.mn();
                        kVar2.mn();
                        if (kVar2.mb() && kVar2.mb()) {
                            i3 = 0;
                            while (true) {
                                i7 = i3;
                                if (i7 >= 4) {
                                    break;
                                }
                                i3 = 0;
                                while (true) {
                                    cY = i3;
                                    if (cY >= 6) {
                                        break;
                                    }
                                    if (kVar2.mb()) {
                                        mn4 = Math.min(64, 1 << ((i7 << 1) + 4));
                                        if (i7 > 1) {
                                            kVar2.mm();
                                        }
                                        for (i3 = 0; i3 < mn4; i3++) {
                                            kVar2.mm();
                                        }
                                    } else {
                                        kVar2.mn();
                                    }
                                    i3 = (i7 == 3 ? 3 : 1) + cY;
                                }
                                i3 = i7 + 1;
                            }
                        }
                        kVar2.cX(2);
                        if (kVar2.mb()) {
                            kVar2.cX(8);
                            kVar2.mn();
                            kVar2.mn();
                            kVar2.mk();
                        }
                        mn2 = kVar2.mn();
                        boolean z = false;
                        i3 = 0;
                        i7 = 0;
                        while (true) {
                            mn4 = i7;
                            if (mn4 >= mn2) {
                                break;
                            }
                            boolean z2;
                            if (mn4 != 0) {
                                i7 = kVar2.mb();
                            } else {
                                z2 = z;
                            }
                            if (z2) {
                                kVar2.mk();
                                kVar2.mn();
                                z = false;
                                while (z <= i3) {
                                    if (kVar2.mb()) {
                                        kVar2.mk();
                                    }
                                    z++;
                                }
                            } else {
                                mn3 = kVar2.mn();
                                boolean mn7 = kVar2.mn();
                                i3 = mn3 + mn7;
                                for (cY = 0; cY < mn3; cY++) {
                                    kVar2.mn();
                                    kVar2.mk();
                                }
                                z = false;
                                while (z < mn7) {
                                    kVar2.mn();
                                    kVar2.mk();
                                    z++;
                                }
                            }
                            mn4++;
                        }
                        if (kVar2.mb()) {
                            for (i3 = 0; i3 < kVar2.mn(); i3++) {
                                kVar2.cX((mn + 4) + 1);
                            }
                        }
                        kVar2.cX(2);
                        float f2 = 1.0f;
                        if (kVar2.mb() && kVar2.mb()) {
                            cY = kVar2.cY(8);
                            if (cY == WebView.NORMAL_MODE_ALPHA) {
                                cY = kVar2.cY(16);
                                i7 = kVar2.cY(16);
                                if (!(cY == 0 || i7 == 0)) {
                                    f2 = ((float) cY) / ((float) i7);
                                }
                                f = f2;
                            } else if (cY < h.aCd.length) {
                                f = h.aCd[cY];
                            }
                            kVar.f(Format.a(str, "video/hevc", i6, mn5, Collections.singletonList(obj), f));
                            this.anb = true;
                        }
                        f = 1.0f;
                        kVar.f(Format.a(str, "video/hevc", i6, mn5, Collections.singletonList(obj), f));
                        this.anb = true;
                    }
                }
                if (this.aoj.cC(i5)) {
                    this.anG.m(this.aoj.aoz, h.i(this.aoj.aoz, this.aoj.aoA));
                    this.anG.da(5);
                    this.anz.a(j2, this.anG);
                }
                if (this.aok.cC(i5)) {
                    this.anG.m(this.aok.aoz, h.i(this.aok.aoz, this.aok.aoA));
                    this.anG.da(5);
                    this.anz.a(j2, this.anG);
                }
                long j3 = this.ans;
                if (this.anb) {
                    a aVar2 = this.aoh;
                    aVar2.aoo = false;
                    aVar2.aop = false;
                    aVar2.anN = j3;
                    aVar2.aom = 0;
                    aVar2.anM = j;
                    if (k >= 32) {
                        if (!aVar2.aoq && aVar2.anQ) {
                            aVar2.cA(i4);
                            aVar2.anQ = false;
                        }
                        if (k <= 34) {
                            aVar2.aop = !aVar2.aoq;
                            aVar2.aoq = true;
                        }
                    }
                    boolean z3 = k >= 16 && k <= 21;
                    aVar2.aol = z3;
                    z3 = aVar2.aol || k <= 9;
                    aVar2.aon = z3;
                } else {
                    this.aoi.cB(k);
                    this.anC.cB(k);
                    this.anD.cB(k);
                }
                this.aoj.cB(k);
                this.aok.cB(k);
                i = a + 3;
            }
        }
    }

    public final void jY() {
    }

    private void e(byte[] bArr, int i, int i2) {
        if (this.anb) {
            a aVar = this.aoh;
            if (aVar.aon) {
                int i3 = (i + 2) - aVar.aom;
                if (i3 < i2) {
                    aVar.aoo = (bArr[i3] & 128) != 0;
                    aVar.aon = false;
                } else {
                    aVar.aom += i2 - i;
                }
            }
        } else {
            this.aoi.f(bArr, i, i2);
            this.anC.f(bArr, i, i2);
            this.anD.f(bArr, i, i2);
        }
        this.aoj.f(bArr, i, i2);
        this.aok.f(bArr, i, i2);
    }
}
