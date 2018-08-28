package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cgu extends a {
    public int cbB;
    public String cbC;
    public String grK;
    public int grP;
    public int hcE;
    public int ixe;
    public String jQb;
    public int mEb;
    public int mEc;
    public int pPq;
    public String sAS;
    public String sAT;
    public int sAU;
    public String sAV;
    public String sAW;
    public int sAX;
    public String sAY;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.sAS != null) {
                aVar.g(3, this.sAS);
            }
            aVar.fT(4, this.mEb);
            aVar.fT(5, this.ixe);
            aVar.fT(6, this.mEc);
            if (this.sAT != null) {
                aVar.g(7, this.sAT);
            }
            aVar.fT(8, this.sAU);
            if (this.sAV != null) {
                aVar.g(9, this.sAV);
            }
            if (this.sAW != null) {
                aVar.g(10, this.sAW);
            }
            aVar.fT(11, this.pPq);
            aVar.fT(12, this.sAX);
            if (this.sAY != null) {
                aVar.g(13, this.sAY);
            }
            if (this.grK != null) {
                aVar.g(14, this.grK);
            }
            aVar.fT(15, this.cbB);
            if (this.cbC != null) {
                aVar.g(16, this.cbC);
            }
            aVar.fT(17, this.grP);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.jQb != null) {
                fQ += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.sAS != null) {
                fQ += f.a.a.b.b.a.h(3, this.sAS);
            }
            fQ = ((fQ + f.a.a.a.fQ(4, this.mEb)) + f.a.a.a.fQ(5, this.ixe)) + f.a.a.a.fQ(6, this.mEc);
            if (this.sAT != null) {
                fQ += f.a.a.b.b.a.h(7, this.sAT);
            }
            fQ += f.a.a.a.fQ(8, this.sAU);
            if (this.sAV != null) {
                fQ += f.a.a.b.b.a.h(9, this.sAV);
            }
            if (this.sAW != null) {
                fQ += f.a.a.b.b.a.h(10, this.sAW);
            }
            fQ = (fQ + f.a.a.a.fQ(11, this.pPq)) + f.a.a.a.fQ(12, this.sAX);
            if (this.sAY != null) {
                fQ += f.a.a.b.b.a.h(13, this.sAY);
            }
            if (this.grK != null) {
                fQ += f.a.a.b.b.a.h(14, this.grK);
            }
            fQ += f.a.a.a.fQ(15, this.cbB);
            if (this.cbC != null) {
                fQ += f.a.a.b.b.a.h(16, this.cbC);
            }
            return fQ + f.a.a.a.fQ(17, this.grP);
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
            cgu cgu = (cgu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgu.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cgu.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cgu.sAS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cgu.mEb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cgu.ixe = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cgu.mEc = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cgu.sAT = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cgu.sAU = aVar3.vHC.rY();
                    return 0;
                case 9:
                    cgu.sAV = aVar3.vHC.readString();
                    return 0;
                case 10:
                    cgu.sAW = aVar3.vHC.readString();
                    return 0;
                case 11:
                    cgu.pPq = aVar3.vHC.rY();
                    return 0;
                case 12:
                    cgu.sAX = aVar3.vHC.rY();
                    return 0;
                case 13:
                    cgu.sAY = aVar3.vHC.readString();
                    return 0;
                case 14:
                    cgu.grK = aVar3.vHC.readString();
                    return 0;
                case 15:
                    cgu.cbB = aVar3.vHC.rY();
                    return 0;
                case 16:
                    cgu.cbC = aVar3.vHC.readString();
                    return 0;
                case 17:
                    cgu.grP = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
