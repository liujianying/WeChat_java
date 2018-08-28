package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class apv extends a {
    public int hbF;
    public int rSt;
    public b rSu;
    public int rSv;
    public int rSw;
    public int rvJ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rSt);
            if (this.rSu != null) {
                aVar.b(2, this.rSu);
            }
            aVar.fT(3, this.rSv);
            aVar.fT(4, this.rvJ);
            aVar.fT(5, this.hbF);
            aVar.fT(6, this.rSw);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rSt) + 0;
            if (this.rSu != null) {
                fQ += f.a.a.a.a(2, this.rSu);
            }
            return (((fQ + f.a.a.a.fQ(3, this.rSv)) + f.a.a.a.fQ(4, this.rvJ)) + f.a.a.a.fQ(5, this.hbF)) + f.a.a.a.fQ(6, this.rSw);
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
            apv apv = (apv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apv.rSt = aVar3.vHC.rY();
                    return 0;
                case 2:
                    apv.rSu = aVar3.cJR();
                    return 0;
                case 3:
                    apv.rSv = aVar3.vHC.rY();
                    return 0;
                case 4:
                    apv.rvJ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    apv.hbF = aVar3.vHC.rY();
                    return 0;
                case 6:
                    apv.rSw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
