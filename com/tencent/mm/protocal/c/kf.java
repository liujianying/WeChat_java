package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class kf extends a {
    public int rlR;
    public int rlS;
    public int rlT;
    public int rlU;
    public int rlV;
    public int rlW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rlR);
            aVar.fT(2, this.rlS);
            aVar.fT(3, this.rlT);
            aVar.fT(4, this.rlU);
            aVar.fT(5, this.rlV);
            aVar.fT(6, this.rlW);
            return 0;
        } else if (i == 1) {
            return (((((f.a.a.a.fQ(1, this.rlR) + 0) + f.a.a.a.fQ(2, this.rlS)) + f.a.a.a.fQ(3, this.rlT)) + f.a.a.a.fQ(4, this.rlU)) + f.a.a.a.fQ(5, this.rlV)) + f.a.a.a.fQ(6, this.rlW);
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
                kf kfVar = (kf) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        kfVar.rlR = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        kfVar.rlS = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        kfVar.rlT = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        kfVar.rlU = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        kfVar.rlV = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        kfVar.rlW = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
