package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class asj extends a {
    public int hcE;
    public long rUE;
    public long rUF;
    public String rjK;
    public String rlo;
    public int scene;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.scene);
            if (this.rjK != null) {
                aVar.g(2, this.rjK);
            }
            aVar.T(3, this.rUE);
            aVar.T(4, this.rUF);
            if (this.rlo != null) {
                aVar.g(5, this.rlo);
            }
            aVar.fT(6, this.hcE);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.scene) + 0;
            if (this.rjK != null) {
                fQ += f.a.a.b.b.a.h(2, this.rjK);
            }
            fQ = (fQ + f.a.a.a.S(3, this.rUE)) + f.a.a.a.S(4, this.rUF);
            if (this.rlo != null) {
                fQ += f.a.a.b.b.a.h(5, this.rlo);
            }
            return fQ + f.a.a.a.fQ(6, this.hcE);
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
            asj asj = (asj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asj.scene = aVar3.vHC.rY();
                    return 0;
                case 2:
                    asj.rjK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    asj.rUE = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    asj.rUF = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    asj.rlo = aVar3.vHC.readString();
                    return 0;
                case 6:
                    asj.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
