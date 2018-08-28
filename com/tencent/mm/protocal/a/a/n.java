package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;

public final class n extends a {
    public int qXP;
    public int qXQ;
    public int qXR;
    public int qXS;
    public int qXT;
    public int qXU;
    public int qXg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qXg);
            aVar.fT(2, this.qXP);
            aVar.fT(3, this.qXQ);
            aVar.fT(4, this.qXR);
            aVar.fT(5, this.qXS);
            aVar.fT(6, this.qXT);
            aVar.fT(7, this.qXU);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.qXg) + 0) + f.a.a.a.fQ(2, this.qXP)) + f.a.a.a.fQ(3, this.qXQ)) + f.a.a.a.fQ(4, this.qXR)) + f.a.a.a.fQ(5, this.qXS)) + f.a.a.a.fQ(6, this.qXT)) + f.a.a.a.fQ(7, this.qXU);
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
                n nVar = (n) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        nVar.qXg = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        nVar.qXP = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        nVar.qXQ = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        nVar.qXR = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        nVar.qXS = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        nVar.qXT = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        nVar.qXU = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
