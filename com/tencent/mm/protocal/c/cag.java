package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cag extends a {
    public int hcE;
    public int swA;
    public int swB;
    public int swC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            aVar.fT(2, this.swA);
            aVar.fT(3, this.swB);
            aVar.fT(4, this.swC);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.hcE) + 0) + f.a.a.a.fQ(2, this.swA)) + f.a.a.a.fQ(3, this.swB)) + f.a.a.a.fQ(4, this.swC);
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
                cag cag = (cag) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cag.hcE = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        cag.swA = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        cag.swB = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        cag.swC = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
