package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class chd extends a {
    public int rUD;
    public int rca;
    public int sBh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rUD);
            aVar.fT(2, this.rca);
            aVar.fT(3, this.sBh);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.fQ(1, this.rUD) + 0) + f.a.a.a.fQ(2, this.rca)) + f.a.a.a.fQ(3, this.sBh);
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
                chd chd = (chd) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        chd.rUD = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        chd.rca = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        chd.sBh = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
