package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.a;
import com.google.android.exoplayer2.i.h.b;
import java.util.Arrays;

public final class j implements h {
    private k alX;
    private String amX;
    private final boolean anA;
    private final boolean anB;
    private final n anC = new n(7);
    private final n anD = new n(8);
    private final n anE = new n(6);
    private a anF;
    private final com.google.android.exoplayer2.i.j anG = new com.google.android.exoplayer2.i.j();
    private boolean anb;
    private final boolean[] ano = new boolean[3];
    private long anq;
    private long ans;
    private final r anz;

    public j(r rVar, boolean z, boolean z2) {
        this.anz = rVar;
        this.anA = z;
        this.anB = z2;
    }

    public final void jX() {
        h.b(this.ano);
        this.anC.reset();
        this.anD.reset();
        this.anE.reset();
        this.anF.reset();
        this.anq = 0;
    }

    public final void a(f fVar, u$d u_d) {
        u_d.kf();
        this.amX = u_d.kh();
        this.alX = fVar.cp(u_d.kg());
        this.anF = new a(this.alX, this.anA, this.anB);
        this.anz.a(fVar, u_d);
    }

    public final void d(long j, boolean z) {
        this.ans = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j r22) {
        /*
        r21 = this;
        r0 = r22;
        r2 = r0.position;
        r0 = r22;
        r10 = r0.limit;
        r0 = r22;
        r11 = r0.data;
        r0 = r21;
        r4 = r0.anq;
        r3 = r22.me();
        r6 = (long) r3;
        r4 = r4 + r6;
        r0 = r21;
        r0.anq = r4;
        r0 = r21;
        r3 = r0.alX;
        r4 = r22.me();
        r0 = r22;
        r3.a(r0, r4);
    L_0x0027:
        r0 = r21;
        r3 = r0.ano;
        r12 = com.google.android.exoplayer2.i.h.a(r11, r2, r10, r3);
        if (r12 != r10) goto L_0x0037;
    L_0x0031:
        r0 = r21;
        r0.e(r11, r2, r10);
        return;
    L_0x0037:
        r13 = com.google.android.exoplayer2.i.h.j(r11, r12);
        r3 = r12 - r2;
        if (r3 <= 0) goto L_0x0044;
    L_0x003f:
        r0 = r21;
        r0.e(r11, r2, r12);
    L_0x0044:
        r9 = r10 - r12;
        r0 = r21;
        r4 = r0.anq;
        r6 = (long) r9;
        r14 = r4 - r6;
        if (r3 >= 0) goto L_0x02d0;
    L_0x004f:
        r2 = -r3;
        r8 = r2;
    L_0x0051:
        r0 = r21;
        r0 = r0.ans;
        r16 = r0;
        r0 = r21;
        r2 = r0.anb;
        if (r2 == 0) goto L_0x0065;
    L_0x005d:
        r0 = r21;
        r2 = r0.anF;
        r2 = r2.anB;
        if (r2 == 0) goto L_0x011c;
    L_0x0065:
        r0 = r21;
        r2 = r0.anC;
        r2.cC(r8);
        r0 = r21;
        r2 = r0.anD;
        r2.cC(r8);
        r0 = r21;
        r2 = r0.anb;
        if (r2 != 0) goto L_0x02d4;
    L_0x0079:
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aoy;
        if (r2 == 0) goto L_0x011c;
    L_0x0081:
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.aoy;
        if (r2 == 0) goto L_0x011c;
    L_0x0089:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aoz;
        r0 = r21;
        r3 = r0.anC;
        r3 = r3.aoA;
        r2 = java.util.Arrays.copyOf(r2, r3);
        r6.add(r2);
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.aoz;
        r0 = r21;
        r3 = r0.anD;
        r3 = r3.aoA;
        r2 = java.util.Arrays.copyOf(r2, r3);
        r6.add(r2);
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aoz;
        r3 = 3;
        r0 = r21;
        r4 = r0.anC;
        r4 = r4.aoA;
        r18 = com.google.android.exoplayer2.i.h.j(r2, r3, r4);
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.aoz;
        r0 = r21;
        r3 = r0.anD;
        r3 = r3.aoA;
        r19 = com.google.android.exoplayer2.i.h.l(r2, r3);
        r0 = r21;
        r0 = r0.alX;
        r20 = r0;
        r0 = r21;
        r2 = r0.amX;
        r3 = "video/avc";
        r0 = r18;
        r4 = r0.width;
        r0 = r18;
        r5 = r0.height;
        r0 = r18;
        r7 = r0.aCi;
        r2 = com.google.android.exoplayer2.Format.a(r2, r3, r4, r5, r6, r7);
        r0 = r20;
        r0.f(r2);
        r2 = 1;
        r0 = r21;
        r0.anb = r2;
        r0 = r21;
        r2 = r0.anF;
        r0 = r18;
        r2.a(r0);
        r0 = r21;
        r2 = r0.anF;
        r0 = r19;
        r2.a(r0);
        r0 = r21;
        r2 = r0.anC;
        r2.reset();
        r0 = r21;
        r2 = r0.anD;
        r2.reset();
    L_0x011c:
        r0 = r21;
        r2 = r0.anE;
        r2 = r2.cC(r8);
        if (r2 == 0) goto L_0x0158;
    L_0x0126:
        r0 = r21;
        r2 = r0.anE;
        r2 = r2.aoz;
        r0 = r21;
        r3 = r0.anE;
        r3 = r3.aoA;
        r2 = com.google.android.exoplayer2.i.h.i(r2, r3);
        r0 = r21;
        r3 = r0.anG;
        r0 = r21;
        r4 = r0.anE;
        r4 = r4.aoz;
        r3.m(r4, r2);
        r0 = r21;
        r2 = r0.anG;
        r3 = 4;
        r2.setPosition(r3);
        r0 = r21;
        r2 = r0.anz;
        r0 = r21;
        r3 = r0.anG;
        r0 = r16;
        r2.a(r0, r3);
    L_0x0158:
        r0 = r21;
        r0 = r0.anF;
        r16 = r0;
        r0 = r16;
        r2 = r0.anL;
        r3 = 9;
        if (r2 == r3) goto L_0x01f3;
    L_0x0166:
        r0 = r16;
        r2 = r0.anB;
        if (r2 == 0) goto L_0x0239;
    L_0x016c:
        r0 = r16;
        r2 = r0.anP;
        r0 = r16;
        r3 = r0.anO;
        r4 = r2.anR;
        if (r4 == 0) goto L_0x0325;
    L_0x0178:
        r4 = r3.anR;
        if (r4 == 0) goto L_0x01f0;
    L_0x017c:
        r4 = r2.anW;
        r5 = r3.anW;
        if (r4 != r5) goto L_0x01f0;
    L_0x0182:
        r4 = r2.anX;
        r5 = r3.anX;
        if (r4 != r5) goto L_0x01f0;
    L_0x0188:
        r4 = r2.anY;
        r5 = r3.anY;
        if (r4 != r5) goto L_0x01f0;
    L_0x018e:
        r4 = r2.anZ;
        if (r4 == 0) goto L_0x019c;
    L_0x0192:
        r4 = r3.anZ;
        if (r4 == 0) goto L_0x019c;
    L_0x0196:
        r4 = r2.aoa;
        r5 = r3.aoa;
        if (r4 != r5) goto L_0x01f0;
    L_0x019c:
        r4 = r2.anU;
        r5 = r3.anU;
        if (r4 == r5) goto L_0x01aa;
    L_0x01a2:
        r4 = r2.anU;
        if (r4 == 0) goto L_0x01f0;
    L_0x01a6:
        r4 = r3.anU;
        if (r4 == 0) goto L_0x01f0;
    L_0x01aa:
        r4 = r2.anT;
        r4 = r4.aCm;
        if (r4 != 0) goto L_0x01c2;
    L_0x01b0:
        r4 = r3.anT;
        r4 = r4.aCm;
        if (r4 != 0) goto L_0x01c2;
    L_0x01b6:
        r4 = r2.aod;
        r5 = r3.aod;
        if (r4 != r5) goto L_0x01f0;
    L_0x01bc:
        r4 = r2.aoe;
        r5 = r3.aoe;
        if (r4 != r5) goto L_0x01f0;
    L_0x01c2:
        r4 = r2.anT;
        r4 = r4.aCm;
        r5 = 1;
        if (r4 != r5) goto L_0x01dc;
    L_0x01c9:
        r4 = r3.anT;
        r4 = r4.aCm;
        r5 = 1;
        if (r4 != r5) goto L_0x01dc;
    L_0x01d0:
        r4 = r2.aof;
        r5 = r3.aof;
        if (r4 != r5) goto L_0x01f0;
    L_0x01d6:
        r4 = r2.aog;
        r5 = r3.aog;
        if (r4 != r5) goto L_0x01f0;
    L_0x01dc:
        r4 = r2.aob;
        r5 = r3.aob;
        if (r4 != r5) goto L_0x01f0;
    L_0x01e2:
        r4 = r2.aob;
        if (r4 == 0) goto L_0x0325;
    L_0x01e6:
        r4 = r3.aob;
        if (r4 == 0) goto L_0x0325;
    L_0x01ea:
        r2 = r2.aoc;
        r3 = r3.aoc;
        if (r2 == r3) goto L_0x0325;
    L_0x01f0:
        r2 = 1;
    L_0x01f1:
        if (r2 == 0) goto L_0x0239;
    L_0x01f3:
        r0 = r16;
        r2 = r0.anQ;
        if (r2 == 0) goto L_0x021f;
    L_0x01f9:
        r0 = r16;
        r2 = r0.anM;
        r2 = r14 - r2;
        r2 = (int) r2;
        r8 = r9 + r2;
        r0 = r16;
        r2 = r0.anu;
        if (r2 == 0) goto L_0x0328;
    L_0x0208:
        r6 = 1;
    L_0x0209:
        r0 = r16;
        r2 = r0.anM;
        r0 = r16;
        r4 = r0.ant;
        r2 = r2 - r4;
        r7 = (int) r2;
        r0 = r16;
        r3 = r0.alX;
        r0 = r16;
        r4 = r0.anl;
        r9 = 0;
        r3.a(r4, r6, r7, r8, r9);
    L_0x021f:
        r0 = r16;
        r2 = r0.anM;
        r0 = r16;
        r0.ant = r2;
        r0 = r16;
        r2 = r0.anN;
        r0 = r16;
        r0.anl = r2;
        r2 = 0;
        r0 = r16;
        r0.anu = r2;
        r2 = 1;
        r0 = r16;
        r0.anQ = r2;
    L_0x0239:
        r0 = r16;
        r3 = r0.anu;
        r0 = r16;
        r2 = r0.anL;
        r4 = 5;
        if (r2 == r4) goto L_0x0266;
    L_0x0244:
        r0 = r16;
        r2 = r0.anA;
        if (r2 == 0) goto L_0x032e;
    L_0x024a:
        r0 = r16;
        r2 = r0.anL;
        r4 = 1;
        if (r2 != r4) goto L_0x032e;
    L_0x0251:
        r0 = r16;
        r2 = r0.anP;
        r4 = r2.anS;
        if (r4 == 0) goto L_0x032b;
    L_0x0259:
        r4 = r2.anV;
        r5 = 7;
        if (r4 == r5) goto L_0x0263;
    L_0x025e:
        r2 = r2.anV;
        r4 = 2;
        if (r2 != r4) goto L_0x032b;
    L_0x0263:
        r2 = 1;
    L_0x0264:
        if (r2 == 0) goto L_0x032e;
    L_0x0266:
        r2 = 1;
    L_0x0267:
        r2 = r2 | r3;
        r0 = r16;
        r0.anu = r2;
        r0 = r21;
        r2 = r0.ans;
        r0 = r21;
        r4 = r0.anb;
        if (r4 == 0) goto L_0x027e;
    L_0x0276:
        r0 = r21;
        r4 = r0.anF;
        r4 = r4.anB;
        if (r4 == 0) goto L_0x028c;
    L_0x027e:
        r0 = r21;
        r4 = r0.anC;
        r4.cB(r13);
        r0 = r21;
        r4 = r0.anD;
        r4.cB(r13);
    L_0x028c:
        r0 = r21;
        r4 = r0.anE;
        r4.cB(r13);
        r0 = r21;
        r4 = r0.anF;
        r4.anL = r13;
        r4.anN = r2;
        r4.anM = r14;
        r2 = r4.anA;
        if (r2 == 0) goto L_0x02a6;
    L_0x02a1:
        r2 = r4.anL;
        r3 = 1;
        if (r2 == r3) goto L_0x02b9;
    L_0x02a6:
        r2 = r4.anB;
        if (r2 == 0) goto L_0x02cc;
    L_0x02aa:
        r2 = r4.anL;
        r3 = 5;
        if (r2 == r3) goto L_0x02b9;
    L_0x02af:
        r2 = r4.anL;
        r3 = 1;
        if (r2 == r3) goto L_0x02b9;
    L_0x02b4:
        r2 = r4.anL;
        r3 = 2;
        if (r2 != r3) goto L_0x02cc;
    L_0x02b9:
        r2 = r4.anO;
        r3 = r4.anP;
        r4.anO = r3;
        r4.anP = r2;
        r2 = r4.anP;
        r2.clear();
        r2 = 0;
        r4.anK = r2;
        r2 = 1;
        r4.anx = r2;
    L_0x02cc:
        r2 = r12 + 3;
        goto L_0x0027;
    L_0x02d0:
        r2 = 0;
        r8 = r2;
        goto L_0x0051;
    L_0x02d4:
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aoy;
        if (r2 == 0) goto L_0x02fd;
    L_0x02dc:
        r0 = r21;
        r2 = r0.anC;
        r2 = r2.aoz;
        r3 = 3;
        r0 = r21;
        r4 = r0.anC;
        r4 = r4.aoA;
        r2 = com.google.android.exoplayer2.i.h.j(r2, r3, r4);
        r0 = r21;
        r3 = r0.anF;
        r3.a(r2);
        r0 = r21;
        r2 = r0.anC;
        r2.reset();
        goto L_0x011c;
    L_0x02fd:
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.aoy;
        if (r2 == 0) goto L_0x011c;
    L_0x0305:
        r0 = r21;
        r2 = r0.anD;
        r2 = r2.aoz;
        r0 = r21;
        r3 = r0.anD;
        r3 = r3.aoA;
        r2 = com.google.android.exoplayer2.i.h.l(r2, r3);
        r0 = r21;
        r3 = r0.anF;
        r3.a(r2);
        r0 = r21;
        r2 = r0.anD;
        r2.reset();
        goto L_0x011c;
    L_0x0325:
        r2 = 0;
        goto L_0x01f1;
    L_0x0328:
        r6 = 0;
        goto L_0x0209;
    L_0x032b:
        r2 = 0;
        goto L_0x0264;
    L_0x032e:
        r2 = 0;
        goto L_0x0267;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.j.b(com.google.android.exoplayer2.i.j):void");
    }

    public final void jY() {
    }

    private void e(byte[] bArr, int i, int i2) {
        if (!this.anb || this.anF.anB) {
            this.anC.f(bArr, i, i2);
            this.anD.f(bArr, i, i2);
        }
        this.anE.f(bArr, i, i2);
        a aVar = this.anF;
        if (aVar.anx) {
            int i3 = i2 - i;
            if (aVar.buffer.length < aVar.anK + i3) {
                aVar.buffer = Arrays.copyOf(aVar.buffer, (aVar.anK + i3) * 2);
            }
            System.arraycopy(bArr, i, aVar.buffer, aVar.anK, i3);
            aVar.anK = i3 + aVar.anK;
            aVar.anJ.k(aVar.buffer, 0, aVar.anK);
            if (aVar.anJ.db(8)) {
                aVar.anJ.mk();
                int cY = aVar.anJ.cY(2);
                aVar.anJ.cX(5);
                if (aVar.anJ.ml()) {
                    aVar.anJ.mn();
                    if (aVar.anJ.ml()) {
                        int mn = aVar.anJ.mn();
                        if (!aVar.anB) {
                            aVar.anx = false;
                            a aVar2 = aVar.anP;
                            aVar2.anV = mn;
                            aVar2.anS = true;
                        } else if (aVar.anJ.ml()) {
                            int mn2 = aVar.anJ.mn();
                            if (aVar.anI.indexOfKey(mn2) < 0) {
                                aVar.anx = false;
                                return;
                            }
                            a aVar3 = (a) aVar.anI.get(mn2);
                            b bVar = (b) aVar.anH.get(aVar3.aCg);
                            if (bVar.aCj) {
                                if (aVar.anJ.db(2)) {
                                    aVar.anJ.cX(2);
                                } else {
                                    return;
                                }
                            }
                            if (aVar.anJ.db(bVar.aCl)) {
                                boolean z = false;
                                boolean z2 = false;
                                boolean z3 = false;
                                int cY2 = aVar.anJ.cY(bVar.aCl);
                                if (!bVar.aCk) {
                                    if (aVar.anJ.db(1)) {
                                        z = aVar.anJ.mb();
                                        if (z) {
                                            if (aVar.anJ.db(1)) {
                                                z3 = aVar.anJ.mb();
                                                z2 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                boolean z4 = aVar.anL == 5;
                                int i4 = 0;
                                if (z4) {
                                    if (aVar.anJ.ml()) {
                                        i4 = aVar.anJ.mn();
                                    } else {
                                        return;
                                    }
                                }
                                int i5 = 0;
                                int i6 = 0;
                                int i7 = 0;
                                if (bVar.aCm != 0) {
                                    if (bVar.aCm == 1 && !bVar.aCo) {
                                        if (aVar.anJ.ml()) {
                                            i7 = aVar.anJ.mm();
                                            if (aVar3.aCh && !z) {
                                                if (aVar.anJ.ml()) {
                                                    i3 = aVar.anJ.mm();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    i3 = 0;
                                } else if (aVar.anJ.db(bVar.aCn)) {
                                    i5 = aVar.anJ.cY(bVar.aCn);
                                    if (aVar3.aCh && !z) {
                                        if (aVar.anJ.ml()) {
                                            i6 = aVar.anJ.mm();
                                            i3 = 0;
                                        } else {
                                            return;
                                        }
                                    }
                                    i3 = 0;
                                } else {
                                    return;
                                }
                                a aVar4 = aVar.anP;
                                aVar4.anT = bVar;
                                aVar4.anU = cY;
                                aVar4.anV = mn;
                                aVar4.anW = cY2;
                                aVar4.anX = mn2;
                                aVar4.anY = z;
                                aVar4.anZ = z2;
                                aVar4.aoa = z3;
                                aVar4.aob = z4;
                                aVar4.aoc = i4;
                                aVar4.aod = i5;
                                aVar4.aoe = i6;
                                aVar4.aof = i7;
                                aVar4.aog = i3;
                                aVar4.anR = true;
                                aVar4.anS = true;
                                aVar.anx = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
