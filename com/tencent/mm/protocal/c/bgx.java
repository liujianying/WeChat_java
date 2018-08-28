package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bgx extends a {
    public int otY;
    public int rQf;
    public String rUM;
    public long rll;
    public int rtz;
    public long see;
    public String shJ;
    public String shK;
    public int shL;
    public int shM;
    public int shN;
    public String shO;
    public String shP;
    public String shQ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.otY);
            if (this.rUM != null) {
                aVar.g(2, this.rUM);
            }
            if (this.shJ != null) {
                aVar.g(3, this.shJ);
            }
            aVar.T(4, this.rll);
            if (this.shK != null) {
                aVar.g(5, this.shK);
            }
            aVar.fT(6, this.shL);
            aVar.fT(7, this.shM);
            aVar.fT(8, this.shN);
            aVar.T(9, this.see);
            aVar.fT(10, this.rQf);
            if (this.shO != null) {
                aVar.g(11, this.shO);
            }
            aVar.fT(12, this.rtz);
            if (this.shP != null) {
                aVar.g(13, this.shP);
            }
            if (this.shQ != null) {
                aVar.g(14, this.shQ);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.otY) + 0;
            if (this.rUM != null) {
                fQ += f.a.a.b.b.a.h(2, this.rUM);
            }
            if (this.shJ != null) {
                fQ += f.a.a.b.b.a.h(3, this.shJ);
            }
            fQ += f.a.a.a.S(4, this.rll);
            if (this.shK != null) {
                fQ += f.a.a.b.b.a.h(5, this.shK);
            }
            fQ = ((((fQ + f.a.a.a.fQ(6, this.shL)) + f.a.a.a.fQ(7, this.shM)) + f.a.a.a.fQ(8, this.shN)) + f.a.a.a.S(9, this.see)) + f.a.a.a.fQ(10, this.rQf);
            if (this.shO != null) {
                fQ += f.a.a.b.b.a.h(11, this.shO);
            }
            fQ += f.a.a.a.fQ(12, this.rtz);
            if (this.shP != null) {
                fQ += f.a.a.b.b.a.h(13, this.shP);
            }
            if (this.shQ != null) {
                return fQ + f.a.a.b.b.a.h(14, this.shQ);
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
            bgx bgx = (bgx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgx.otY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bgx.rUM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bgx.shJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bgx.rll = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bgx.shK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bgx.shL = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bgx.shM = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bgx.shN = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bgx.see = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    bgx.rQf = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bgx.shO = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bgx.rtz = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bgx.shP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bgx.shQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
