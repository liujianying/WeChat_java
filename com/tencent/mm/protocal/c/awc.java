package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class awc extends a {
    public int rSt;
    public int rZp;
    public int rZq;
    public int rZr;
    public int rZs;
    public int rZt;
    public int rZu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rSt);
            aVar.fT(2, this.rZp);
            aVar.fT(3, this.rZq);
            aVar.fT(4, this.rZr);
            aVar.fT(5, this.rZs);
            aVar.fT(6, this.rZt);
            aVar.fT(7, this.rZu);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.rSt) + 0) + f.a.a.a.fQ(2, this.rZp)) + f.a.a.a.fQ(3, this.rZq)) + f.a.a.a.fQ(4, this.rZr)) + f.a.a.a.fQ(5, this.rZs)) + f.a.a.a.fQ(6, this.rZt)) + f.a.a.a.fQ(7, this.rZu);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                awc awc = (awc) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        awc.rSt = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        awc.rZp = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        awc.rZq = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        awc.rZr = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        awc.rZs = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        awc.rZt = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        awc.rZu = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
