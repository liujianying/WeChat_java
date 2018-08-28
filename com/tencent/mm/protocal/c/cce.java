package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cce extends a {
    public int bzI;
    public String jSA;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.bzI);
            if (this.jSA != null) {
                aVar.g(2, this.jSA);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.bzI) + 0;
            if (this.jSA != null) {
                return fQ + f.a.a.b.b.a.h(2, this.jSA);
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
            cce cce = (cce) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cce.bzI = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cce.jSA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
