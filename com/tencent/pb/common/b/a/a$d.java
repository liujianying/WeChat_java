package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.m;

public final class a$d extends e {
    public int netType;
    public String vcI;
    public at vcK;
    public int[] vcL;
    public ba vcM;
    public int vcN;
    public int vcO;
    public ay vcP;
    public String vcQ;
    public String[] vcR;
    public m[] vcS;
    public int vcT;

    public a$d() {
        this.vcK = null;
        this.vcL = g.bfQ;
        this.vcM = null;
        this.vcN = 0;
        this.vcO = 0;
        this.vcP = null;
        this.vcI = "";
        this.vcQ = "";
        this.netType = 0;
        this.vcR = g.EMPTY_STRING_ARRAY;
        this.vcS = m.cEs();
        this.vcT = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (this.vcK != null) {
            bVar.a(1, this.vcK);
        }
        if (this.vcL != null && this.vcL.length > 0) {
            for (int aF : this.vcL) {
                bVar.aF(2, aF);
            }
        }
        if (this.vcM != null) {
            bVar.a(3, this.vcM);
        }
        if (this.vcN != 0) {
            bVar.aF(4, this.vcN);
        }
        if (this.vcO != 0) {
            bVar.aF(5, this.vcO);
        }
        if (this.vcP != null) {
            bVar.a(6, this.vcP);
        }
        if (!this.vcI.equals("")) {
            bVar.g(7, this.vcI);
        }
        if (!this.vcQ.equals("")) {
            bVar.g(8, this.vcQ);
        }
        if (this.netType != 0) {
            bVar.aF(9, this.netType);
        }
        if (this.vcR != null && this.vcR.length > 0) {
            for (String str : this.vcR) {
                if (str != null) {
                    bVar.g(100, str);
                }
            }
        }
        if (this.vcS != null && this.vcS.length > 0) {
            while (i < this.vcS.length) {
                e eVar = this.vcS[i];
                if (eVar != null) {
                    bVar.a(202, eVar);
                }
                i++;
            }
        }
        if (this.vcT != 0) {
            bVar.aF(240, this.vcT);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int i;
        int i2;
        int i3 = 0;
        int sl = super.sl();
        if (this.vcK != null) {
            sl += b.b(1, this.vcK);
        }
        if (this.vcL != null && this.vcL.length > 0) {
            i = 0;
            for (int i22 : this.vcL) {
                i += b.ee(i22);
            }
            sl = (sl + i) + (this.vcL.length * 1);
        }
        if (this.vcM != null) {
            sl += b.b(3, this.vcM);
        }
        if (this.vcN != 0) {
            sl += b.aH(4, this.vcN);
        }
        if (this.vcO != 0) {
            sl += b.aH(5, this.vcO);
        }
        if (this.vcP != null) {
            sl += b.b(6, this.vcP);
        }
        if (!this.vcI.equals("")) {
            sl += b.h(7, this.vcI);
        }
        if (!this.vcQ.equals("")) {
            sl += b.h(8, this.vcQ);
        }
        if (this.netType != 0) {
            sl += b.aH(9, this.netType);
        }
        if (this.vcR != null && this.vcR.length > 0) {
            i = 0;
            i22 = 0;
            for (String str : this.vcR) {
                if (str != null) {
                    i22++;
                    i += b.bE(str);
                }
            }
            sl = (sl + i) + (i22 * 2);
        }
        if (this.vcS != null && this.vcS.length > 0) {
            while (i3 < this.vcS.length) {
                e eVar = this.vcS[i3];
                if (eVar != null) {
                    sl += b.b(202, eVar);
                }
                i3++;
            }
        }
        if (this.vcT != 0) {
            return sl + b.aH(240, this.vcT);
        }
        return sl;
    }
}
