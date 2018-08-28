package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;

public final class l extends a {
    public int action;
    public int qXF;
    public int qXG;
    public int qXH;
    public int qXI;
    public int qXJ;
    public int qXK;
    public int qXL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qXF);
            aVar.fT(2, this.action);
            aVar.fT(3, this.qXG);
            aVar.fT(4, this.qXH);
            aVar.fT(5, this.qXI);
            aVar.fT(6, this.qXJ);
            aVar.fT(7, this.qXK);
            aVar.fT(8, this.qXL);
            return 0;
        } else if (i == 1) {
            return (((((((f.a.a.a.fQ(1, this.qXF) + 0) + f.a.a.a.fQ(2, this.action)) + f.a.a.a.fQ(3, this.qXG)) + f.a.a.a.fQ(4, this.qXH)) + f.a.a.a.fQ(5, this.qXI)) + f.a.a.a.fQ(6, this.qXJ)) + f.a.a.a.fQ(7, this.qXK)) + f.a.a.a.fQ(8, this.qXL);
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
                l lVar = (l) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        lVar.qXF = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        lVar.action = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        lVar.qXG = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        lVar.qXH = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        lVar.qXI = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        lVar.qXJ = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        lVar.qXK = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        lVar.qXL = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
