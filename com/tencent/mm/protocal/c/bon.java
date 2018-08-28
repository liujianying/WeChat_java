package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bon extends a {
    public int hcE;
    public String jSA;
    public int lOH;
    public String rTW;
    public int rXs;
    public String rdS;
    public int rdq;
    public String smB;
    public int smg;
    public int smh;
    public int smi;
    public long smj;
    public long smk;
    public int smm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdS != null) {
                aVar.g(1, this.rdS);
            }
            if (this.rTW != null) {
                aVar.g(2, this.rTW);
            }
            aVar.fT(3, this.rdq);
            aVar.fT(4, this.hcE);
            if (this.jSA != null) {
                aVar.g(5, this.jSA);
            }
            aVar.fT(6, this.lOH);
            aVar.fT(7, this.smh);
            aVar.fT(8, this.smg);
            if (this.smB != null) {
                aVar.g(9, this.smB);
            }
            aVar.fT(10, this.smi);
            aVar.T(11, this.smj);
            aVar.T(12, this.smk);
            aVar.fT(13, this.rXs);
            aVar.fT(14, this.smm);
            return 0;
        } else if (i == 1) {
            if (this.rdS != null) {
                h = f.a.a.b.b.a.h(1, this.rdS) + 0;
            } else {
                h = 0;
            }
            if (this.rTW != null) {
                h += f.a.a.b.b.a.h(2, this.rTW);
            }
            h = (h + f.a.a.a.fQ(3, this.rdq)) + f.a.a.a.fQ(4, this.hcE);
            if (this.jSA != null) {
                h += f.a.a.b.b.a.h(5, this.jSA);
            }
            h = ((h + f.a.a.a.fQ(6, this.lOH)) + f.a.a.a.fQ(7, this.smh)) + f.a.a.a.fQ(8, this.smg);
            if (this.smB != null) {
                h += f.a.a.b.b.a.h(9, this.smB);
            }
            return ((((h + f.a.a.a.fQ(10, this.smi)) + f.a.a.a.S(11, this.smj)) + f.a.a.a.S(12, this.smk)) + f.a.a.a.fQ(13, this.rXs)) + f.a.a.a.fQ(14, this.smm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bon bon = (bon) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bon.rdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bon.rTW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bon.rdq = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bon.hcE = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bon.jSA = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bon.lOH = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bon.smh = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bon.smg = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bon.smB = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bon.smi = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bon.smj = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    bon.smk = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    bon.rXs = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bon.smm = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
