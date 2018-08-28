package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class chy extends a {
    public int otY;
    public int rRb;
    public int riv;
    public int sBT;
    public int sBU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rRb);
            aVar.fT(2, this.riv);
            aVar.fT(3, this.sBT);
            aVar.fT(4, this.otY);
            aVar.fT(10, this.sBU);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.rRb) + 0) + f.a.a.a.fQ(2, this.riv)) + f.a.a.a.fQ(3, this.sBT)) + f.a.a.a.fQ(4, this.otY)) + f.a.a.a.fQ(10, this.sBU);
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
                chy chy = (chy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        chy.rRb = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        chy.riv = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        chy.sBT = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        chy.otY = aVar3.vHC.rY();
                        return 0;
                    case 10:
                        chy.sBU = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
