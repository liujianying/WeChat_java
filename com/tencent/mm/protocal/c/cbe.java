package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cbe extends a {
    public String category;
    public int egS;
    public b rwb;
    public int sjO;
    public int sxo;
    public int sxp;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.egS);
            aVar.fT(2, this.sxo);
            if (this.category != null) {
                aVar.g(3, this.category);
            }
            if (this.rwb != null) {
                aVar.b(4, this.rwb);
            }
            aVar.fT(5, this.sjO);
            aVar.fT(6, this.sxp);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.egS) + 0) + f.a.a.a.fQ(2, this.sxo);
            if (this.category != null) {
                fQ += f.a.a.b.b.a.h(3, this.category);
            }
            if (this.rwb != null) {
                fQ += f.a.a.a.a(4, this.rwb);
            }
            return (fQ + f.a.a.a.fQ(5, this.sjO)) + f.a.a.a.fQ(6, this.sxp);
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
            cbe cbe = (cbe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbe.egS = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cbe.sxo = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cbe.category = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbe.rwb = aVar3.cJR();
                    return 0;
                case 5:
                    cbe.sjO = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cbe.sxp = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
