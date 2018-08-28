package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bzm extends a {
    public int hcE;
    public String svH;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            if (this.svH != null) {
                aVar.g(2, this.svH);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.svH != null) {
                return fQ + f.a.a.b.b.a.h(2, this.svH);
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
            bzm bzm = (bzm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzm.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bzm.svH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
