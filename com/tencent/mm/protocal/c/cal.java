package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cal extends a {
    public int swR;
    public int swS;
    public int swT;
    public int swU;
    public int swV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.swR);
            aVar.fT(2, this.swS);
            aVar.fT(3, this.swT);
            aVar.fT(4, this.swU);
            aVar.fT(5, this.swV);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.swR) + 0) + f.a.a.a.fQ(2, this.swS)) + f.a.a.a.fQ(3, this.swT)) + f.a.a.a.fQ(4, this.swU)) + f.a.a.a.fQ(5, this.swV);
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
                cal cal = (cal) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cal.swR = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        cal.swS = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        cal.swT = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        cal.swU = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        cal.swV = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
