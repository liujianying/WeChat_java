package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class d extends a<d> {
    public int vog;
    public int[][] voh;
    public int[][] voi;
    public int[][] voj;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.vog != dVar.vog) {
            return c.fI(this.vog, dVar.vog);
        }
        int length = this.voh.length;
        int length2 = this.voi.length;
        int length3 = this.voj.length;
        int length4 = dVar.voh.length;
        int length5 = dVar.voi.length;
        int length6 = dVar.voj.length;
        if (length != length4) {
            return c.fJ(length, length4);
        }
        if (length2 != length5) {
            return c.fJ(length2, length5);
        }
        if (length3 != length6) {
            return c.fJ(length3, length6);
        }
        int i;
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.voh[length4][0];
            length6 = this.voh[length4][1];
            i = dVar.voh[length4][0];
            int i2 = dVar.voh[length4][1];
            if (length5 != i) {
                return c.fI(length5, i);
            }
            if (length6 != i2) {
                return c.fJ(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.voi[length4][0];
            length5 = this.voi[length4][1];
            length6 = dVar.voi[length4][0];
            i = dVar.voi[length4][1];
            if (length != length6) {
                return c.fI(length, length6);
            }
            if (length5 != i) {
                return c.fJ(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.voj[length4][0];
            length2 = this.voj[length4][1];
            length5 = dVar.voj[length4][0];
            length6 = dVar.voj[length4][1];
            if (length != length5) {
                return c.fI(length, length5);
            }
            if (length2 != length6) {
                return c.fJ(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.vog = i2;
        this.voh = iArr;
        this.voi = iArr2;
        this.voj = iArr3;
    }
}
