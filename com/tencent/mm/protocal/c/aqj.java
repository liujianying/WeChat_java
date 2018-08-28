package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aqj extends a {
    public int qZk;
    public String rMD;
    public String rSK;
    public boolean rSL;
    public String rSM;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qZk);
            if (this.rSK != null) {
                aVar.g(2, this.rSK);
            }
            aVar.av(3, this.rSL);
            if (this.rSM != null) {
                aVar.g(4, this.rSM);
            }
            if (this.rMD != null) {
                aVar.g(5, this.rMD);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.qZk) + 0;
            if (this.rSK != null) {
                fQ += f.a.a.b.b.a.h(2, this.rSK);
            }
            fQ += f.a.a.b.b.a.ec(3) + 1;
            if (this.rSM != null) {
                fQ += f.a.a.b.b.a.h(4, this.rSM);
            }
            if (this.rMD != null) {
                return fQ + f.a.a.b.b.a.h(5, this.rMD);
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
            aqj aqj = (aqj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqj.qZk = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aqj.rSK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aqj.rSL = aVar3.cJQ();
                    return 0;
                case 4:
                    aqj.rSM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aqj.rMD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
