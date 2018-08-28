package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bcm extends a {
    public int iwS;
    public String iwT;
    public int kpu;
    public String kpv;
    public int sdf;
    public int seG;
    public int seH;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sdf);
            aVar.fT(2, this.seH);
            aVar.fT(3, this.seG);
            aVar.fT(4, this.iwS);
            if (this.iwT != null) {
                aVar.g(5, this.iwT);
            }
            aVar.fT(6, this.kpu);
            if (this.kpv != null) {
                aVar.g(7, this.kpv);
            }
            return 0;
        } else if (i == 1) {
            fQ = (((f.a.a.a.fQ(1, this.sdf) + 0) + f.a.a.a.fQ(2, this.seH)) + f.a.a.a.fQ(3, this.seG)) + f.a.a.a.fQ(4, this.iwS);
            if (this.iwT != null) {
                fQ += f.a.a.b.b.a.h(5, this.iwT);
            }
            fQ += f.a.a.a.fQ(6, this.kpu);
            if (this.kpv != null) {
                return fQ + f.a.a.b.b.a.h(7, this.kpv);
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
            bcm bcm = (bcm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcm.sdf = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bcm.seH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bcm.seG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bcm.iwS = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bcm.iwT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bcm.kpu = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bcm.kpv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
