package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class td extends a {
    public long rcq;
    public int rdV;
    public int rdW;
    public int rfn;
    public String rwt;
    public int rwz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rfn);
            aVar.fT(2, this.rdW);
            aVar.fT(3, this.rdV);
            if (this.rwt != null) {
                aVar.g(4, this.rwt);
            }
            aVar.fT(5, this.rwz);
            aVar.T(6, this.rcq);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rfn) + 0) + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV);
            if (this.rwt != null) {
                fQ += f.a.a.b.b.a.h(4, this.rwt);
            }
            return (fQ + f.a.a.a.fQ(5, this.rwz)) + f.a.a.a.S(6, this.rcq);
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
            td tdVar = (td) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tdVar.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    tdVar.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    tdVar.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    tdVar.rwt = aVar3.vHC.readString();
                    return 0;
                case 5:
                    tdVar.rwz = aVar3.vHC.rY();
                    return 0;
                case 6:
                    tdVar.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
