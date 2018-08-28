package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class qd extends a {
    public int hcd;
    public int rci;
    public long rcq;
    public String ruD;
    public int ruE;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rci);
            if (this.ruD != null) {
                aVar.g(2, this.ruD);
            }
            aVar.fT(3, this.hcd);
            aVar.fT(4, this.ruE);
            aVar.T(5, this.rcq);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rci) + 0;
            if (this.ruD != null) {
                fQ += f.a.a.b.b.a.h(2, this.ruD);
            }
            return ((fQ + f.a.a.a.fQ(3, this.hcd)) + f.a.a.a.fQ(4, this.ruE)) + f.a.a.a.S(5, this.rcq);
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
            qd qdVar = (qd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qdVar.rci = aVar3.vHC.rY();
                    return 0;
                case 2:
                    qdVar.ruD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    qdVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 4:
                    qdVar.ruE = aVar3.vHC.rY();
                    return 0;
                case 5:
                    qdVar.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
