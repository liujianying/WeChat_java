package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class un extends a {
    public int rxV;
    public int rxW;
    public int rxX;
    public String rxY;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rxV);
            aVar.fT(2, this.rxW);
            aVar.fT(3, this.rxX);
            if (this.rxY != null) {
                aVar.g(4, this.rxY);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rxV) + 0) + f.a.a.a.fQ(2, this.rxW)) + f.a.a.a.fQ(3, this.rxX);
            if (this.rxY != null) {
                return fQ + f.a.a.b.b.a.h(4, this.rxY);
            }
            return fQ;
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
            un unVar = (un) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    unVar.rxV = aVar3.vHC.rY();
                    return 0;
                case 2:
                    unVar.rxW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    unVar.rxX = aVar3.vHC.rY();
                    return 0;
                case 4:
                    unVar.rxY = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
