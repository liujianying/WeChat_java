package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bqd extends a {
    public int eJS;
    public String eJT;
    public long eJU;
    public int sod;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.eJS);
            if (this.eJT != null) {
                aVar.g(2, this.eJT);
            }
            aVar.T(3, this.eJU);
            aVar.fT(4, this.sod);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.eJS) + 0;
            if (this.eJT != null) {
                fQ += f.a.a.b.b.a.h(2, this.eJT);
            }
            return (fQ + f.a.a.a.S(3, this.eJU)) + f.a.a.a.fQ(4, this.sod);
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
            bqd bqd = (bqd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqd.eJS = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bqd.eJT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bqd.eJU = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bqd.sod = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
