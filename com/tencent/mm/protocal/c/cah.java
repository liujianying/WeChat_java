package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cah extends a {
    public String eSH;
    public int swD;
    public int swE;
    public int swF;
    public String userName;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.swD);
            aVar.fT(2, this.swE);
            aVar.fT(3, this.swF);
            if (this.userName != null) {
                aVar.g(4, this.userName);
            }
            if (this.eSH != null) {
                aVar.g(5, this.eSH);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.swD) + 0) + f.a.a.a.fQ(2, this.swE)) + f.a.a.a.fQ(3, this.swF);
            if (this.userName != null) {
                fQ += f.a.a.b.b.a.h(4, this.userName);
            }
            if (this.eSH != null) {
                return fQ + f.a.a.b.b.a.h(5, this.eSH);
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
            cah cah = (cah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cah.swD = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cah.swE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cah.swF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cah.userName = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cah.eSH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
