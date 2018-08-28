package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class dh extends a {
    public int rdA;
    public int rdB;
    public int rdC;
    public int rdD;
    public String rdE;
    public long rdx;
    public int rdy;
    public int rdz;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rdx);
            aVar.fT(2, this.rdy);
            aVar.fT(3, this.rdz);
            aVar.fT(4, this.rdA);
            aVar.fT(5, this.rdB);
            aVar.fT(6, this.rdC);
            aVar.fT(7, this.rdD);
            if (this.rdE != null) {
                aVar.g(8, this.rdE);
            }
            return 0;
        } else if (i == 1) {
            S = ((((((f.a.a.a.S(1, this.rdx) + 0) + f.a.a.a.fQ(2, this.rdy)) + f.a.a.a.fQ(3, this.rdz)) + f.a.a.a.fQ(4, this.rdA)) + f.a.a.a.fQ(5, this.rdB)) + f.a.a.a.fQ(6, this.rdC)) + f.a.a.a.fQ(7, this.rdD);
            if (this.rdE != null) {
                return S + f.a.a.b.b.a.h(8, this.rdE);
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
            dh dhVar = (dh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dhVar.rdx = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    dhVar.rdy = aVar3.vHC.rY();
                    return 0;
                case 3:
                    dhVar.rdz = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dhVar.rdA = aVar3.vHC.rY();
                    return 0;
                case 5:
                    dhVar.rdB = aVar3.vHC.rY();
                    return 0;
                case 6:
                    dhVar.rdC = aVar3.vHC.rY();
                    return 0;
                case 7:
                    dhVar.rdD = aVar3.vHC.rY();
                    return 0;
                case 8:
                    dhVar.rdE = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
