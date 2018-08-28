package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class f extends a<f> {
    public int vop;
    public int vos;
    public int vot;
    public int vou;
    public int vov;
    public int vow;
    public int vox;
    public int voy;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int fI = c.fI(this.vos, fVar.vos);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.vop, fVar.vop);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.vot, fVar.vot);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.vou, fVar.vou);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.vov, fVar.vov);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.vow, fVar.vow);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.vox, fVar.vox);
        return fI == 0 ? c.fJ(this.voy, fVar.voy) : fI;
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.vos = i2;
        this.vop = i3;
        this.vot = i4;
        this.vou = i5;
        this.vov = i6;
        this.vow = i7;
        this.vox = i8;
        this.voy = i9;
    }
}
