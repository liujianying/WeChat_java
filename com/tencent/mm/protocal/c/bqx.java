package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bqx extends a {
    public int egL;
    public String nIO;
    public String soZ;
    public int source;
    public String spa;
    public int spb;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.egL);
            if (this.soZ != null) {
                aVar.g(2, this.soZ);
            }
            if (this.spa != null) {
                aVar.g(3, this.spa);
            }
            aVar.fT(4, this.source);
            if (this.nIO != null) {
                aVar.g(5, this.nIO);
            }
            aVar.fT(6, this.spb);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.egL) + 0;
            if (this.soZ != null) {
                fQ += f.a.a.b.b.a.h(2, this.soZ);
            }
            if (this.spa != null) {
                fQ += f.a.a.b.b.a.h(3, this.spa);
            }
            fQ += f.a.a.a.fQ(4, this.source);
            if (this.nIO != null) {
                fQ += f.a.a.b.b.a.h(5, this.nIO);
            }
            return fQ + f.a.a.a.fQ(6, this.spb);
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
            bqx bqx = (bqx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqx.egL = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bqx.soZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bqx.spa = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bqx.source = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bqx.nIO = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bqx.spb = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
