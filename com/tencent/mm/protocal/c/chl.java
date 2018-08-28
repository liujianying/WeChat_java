package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class chl extends a {
    public int sBq;
    public int sBr;
    public int sBs;
    public int sBt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sBq);
            aVar.fT(2, this.sBr);
            aVar.fT(3, this.sBs);
            aVar.fT(4, this.sBt);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.sBq) + 0) + f.a.a.a.fQ(2, this.sBr)) + f.a.a.a.fQ(3, this.sBs)) + f.a.a.a.fQ(4, this.sBt);
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
                chl chl = (chl) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        chl.sBq = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        chl.sBr = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        chl.sBs = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        chl.sBt = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
