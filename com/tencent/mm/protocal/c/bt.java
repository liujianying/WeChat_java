package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bt extends a {
    public int hcE;
    public int rbY;
    public int rbZ;
    public int rca;
    public int rcb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rbY);
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.rbZ);
            aVar.fT(4, this.rca);
            aVar.fT(5, this.rcb);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.rbY) + 0) + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.rbZ)) + f.a.a.a.fQ(4, this.rca)) + f.a.a.a.fQ(5, this.rcb);
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
                bt btVar = (bt) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        btVar.rbY = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        btVar.hcE = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        btVar.rbZ = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        btVar.rca = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        btVar.rcb = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
