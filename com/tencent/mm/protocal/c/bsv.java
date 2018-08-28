package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bsv extends a {
    public long sqk;
    public long sqm;
    public int sqn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.sqk);
            aVar.T(2, this.sqm);
            aVar.fT(3, this.sqn);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.S(1, this.sqk) + 0) + f.a.a.a.S(2, this.sqm)) + f.a.a.a.fQ(3, this.sqn);
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
                bsv bsv = (bsv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bsv.sqk = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        bsv.sqm = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        bsv.sqn = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
