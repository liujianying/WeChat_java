package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bap extends a {
    public String jPe;
    public int rHi;
    public String rxm;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rHi);
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            if (this.rxm != null) {
                aVar.g(3, this.rxm);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rHi) + 0;
            if (this.jPe != null) {
                fQ += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.rxm != null) {
                return fQ + f.a.a.b.b.a.h(3, this.rxm);
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
            bap bap = (bap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bap.rHi = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bap.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bap.rxm = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
