package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cgg extends a {
    public int otY;
    public int rRb;
    public int rUA;
    public int rUB;
    public String rUC;
    public int riv;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rRb);
            aVar.fT(2, this.riv);
            aVar.fT(3, this.otY);
            if (this.rUC != null) {
                aVar.g(4, this.rUC);
            }
            aVar.fT(5, this.rUB);
            aVar.fT(6, this.rUA);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rRb) + 0) + f.a.a.a.fQ(2, this.riv)) + f.a.a.a.fQ(3, this.otY);
            if (this.rUC != null) {
                fQ += f.a.a.b.b.a.h(4, this.rUC);
            }
            return (fQ + f.a.a.a.fQ(5, this.rUB)) + f.a.a.a.fQ(6, this.rUA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cgg cgg = (cgg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgg.rRb = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cgg.riv = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cgg.otY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cgg.rUC = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cgg.rUB = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cgg.rUA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
