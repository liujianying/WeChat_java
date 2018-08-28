package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class avz extends a {
    public String hbL;
    public String hcS;
    public int iwE;
    public int rQA;
    public String rYV;
    public String rhg;
    public String rul;
    public int rxW;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.iwE);
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.rhg != null) {
                aVar.g(3, this.rhg);
            }
            if (this.rul != null) {
                aVar.g(4, this.rul);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            aVar.fT(6, this.rQA);
            aVar.fT(7, this.rxW);
            if (this.rYV != null) {
                aVar.g(8, this.rYV);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.iwE) + 0;
            if (this.hcS != null) {
                fQ += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.rhg != null) {
                fQ += f.a.a.b.b.a.h(3, this.rhg);
            }
            if (this.rul != null) {
                fQ += f.a.a.b.b.a.h(4, this.rul);
            }
            if (this.hbL != null) {
                fQ += f.a.a.b.b.a.h(5, this.hbL);
            }
            fQ = (fQ + f.a.a.a.fQ(6, this.rQA)) + f.a.a.a.fQ(7, this.rxW);
            if (this.rYV != null) {
                return fQ + f.a.a.b.b.a.h(8, this.rYV);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            avz avz = (avz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avz.iwE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    avz.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    avz.rhg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    avz.rul = aVar3.vHC.readString();
                    return 0;
                case 5:
                    avz.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    avz.rQA = aVar3.vHC.rY();
                    return 0;
                case 7:
                    avz.rxW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    avz.rYV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
