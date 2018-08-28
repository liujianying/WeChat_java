package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int voA;
    public int voB;
    public int voC;
    public short[] voD;
    public b[] voE;
    public a[] voF;
    public int voz;

    public static class a implements Comparable<a> {
        public int offset;
        public int[] voG;
        public int[] voH;
        public int voI;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int b = c.b(this.voG, aVar.voG);
            if (b != 0) {
                return b;
            }
            b = c.b(this.voH, aVar.voH);
            return b == 0 ? c.fJ(this.voI, aVar.voI) : b;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.voG = iArr;
            this.voH = iArr2;
            this.voI = i;
            this.offset = i2;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int fJ = c.fJ(this.voz, gVar.voz);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.voA, gVar.voA);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.voB, gVar.voB);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.voC, gVar.voC);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.a(this.voD, gVar.voD);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.a(this.voE, gVar.voE);
        return fJ == 0 ? c.a(this.voF, gVar.voF) : fJ;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.voz = i2;
        this.voA = i3;
        this.voB = i4;
        this.voC = i5;
        this.voD = sArr;
        this.voE = bVarArr;
        this.voF = aVarArr;
    }
}
