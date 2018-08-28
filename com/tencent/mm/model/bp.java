package com.tencent.mm.model;

import com.tencent.mm.bk.a;

public final class bp extends a {
    public String dDi;
    public long dDj;
    public int key;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.key);
            if (this.dDi != null) {
                aVar.g(2, this.dDi);
            }
            aVar.T(3, this.dDj);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.key) + 0;
            if (this.dDi != null) {
                fQ += f.a.a.b.b.a.h(2, this.dDi);
            }
            return fQ + f.a.a.a.S(3, this.dDj);
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
            bp bpVar = (bp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpVar.key = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bpVar.dDi = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bpVar.dDj = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
