package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xc extends a {
    public String rCA;
    public long rCB;
    public String rCC;
    public String rCD;
    public String rCE;
    public String rCF;
    public String rCG;
    public String rCH;
    public int rCI;
    public String rCJ;
    public int rCK;
    public long rCx;
    public long rCy;
    public long rCz;
    public String rqo;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rCx);
            aVar.T(2, this.rCy);
            aVar.T(3, this.rCz);
            if (this.rCA != null) {
                aVar.g(4, this.rCA);
            }
            aVar.T(5, this.rCB);
            if (this.rCC != null) {
                aVar.g(6, this.rCC);
            }
            if (this.rCD != null) {
                aVar.g(7, this.rCD);
            }
            if (this.rCE != null) {
                aVar.g(8, this.rCE);
            }
            if (this.rCF != null) {
                aVar.g(9, this.rCF);
            }
            if (this.rCG != null) {
                aVar.g(10, this.rCG);
            }
            if (this.rCH != null) {
                aVar.g(11, this.rCH);
            }
            aVar.fT(12, this.rCI);
            if (this.rCJ != null) {
                aVar.g(13, this.rCJ);
            }
            aVar.fT(14, this.rCK);
            if (this.rqo != null) {
                aVar.g(15, this.rqo);
            }
            return 0;
        } else if (i == 1) {
            S = ((f.a.a.a.S(1, this.rCx) + 0) + f.a.a.a.S(2, this.rCy)) + f.a.a.a.S(3, this.rCz);
            if (this.rCA != null) {
                S += f.a.a.b.b.a.h(4, this.rCA);
            }
            S += f.a.a.a.S(5, this.rCB);
            if (this.rCC != null) {
                S += f.a.a.b.b.a.h(6, this.rCC);
            }
            if (this.rCD != null) {
                S += f.a.a.b.b.a.h(7, this.rCD);
            }
            if (this.rCE != null) {
                S += f.a.a.b.b.a.h(8, this.rCE);
            }
            if (this.rCF != null) {
                S += f.a.a.b.b.a.h(9, this.rCF);
            }
            if (this.rCG != null) {
                S += f.a.a.b.b.a.h(10, this.rCG);
            }
            if (this.rCH != null) {
                S += f.a.a.b.b.a.h(11, this.rCH);
            }
            S += f.a.a.a.fQ(12, this.rCI);
            if (this.rCJ != null) {
                S += f.a.a.b.b.a.h(13, this.rCJ);
            }
            S += f.a.a.a.fQ(14, this.rCK);
            if (this.rqo != null) {
                return S + f.a.a.b.b.a.h(15, this.rqo);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xc xcVar = (xc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xcVar.rCx = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    xcVar.rCy = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    xcVar.rCz = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    xcVar.rCA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    xcVar.rCB = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    xcVar.rCC = aVar3.vHC.readString();
                    return 0;
                case 7:
                    xcVar.rCD = aVar3.vHC.readString();
                    return 0;
                case 8:
                    xcVar.rCE = aVar3.vHC.readString();
                    return 0;
                case 9:
                    xcVar.rCF = aVar3.vHC.readString();
                    return 0;
                case 10:
                    xcVar.rCG = aVar3.vHC.readString();
                    return 0;
                case 11:
                    xcVar.rCH = aVar3.vHC.readString();
                    return 0;
                case 12:
                    xcVar.rCI = aVar3.vHC.rY();
                    return 0;
                case 13:
                    xcVar.rCJ = aVar3.vHC.readString();
                    return 0;
                case 14:
                    xcVar.rCK = aVar3.vHC.rY();
                    return 0;
                case 15:
                    xcVar.rqo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
