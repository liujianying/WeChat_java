package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bug extends a {
    public int srG;
    public int srH;
    public String srI;
    public b srJ;
    public int srK;
    public int srL;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.srG);
            aVar.fT(2, this.srH);
            if (this.srI != null) {
                aVar.g(3, this.srI);
            }
            if (this.srJ != null) {
                aVar.b(4, this.srJ);
            }
            aVar.fT(5, this.srK);
            aVar.fT(6, this.srL);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.srG) + 0) + f.a.a.a.fQ(2, this.srH);
            if (this.srI != null) {
                fQ += f.a.a.b.b.a.h(3, this.srI);
            }
            if (this.srJ != null) {
                fQ += f.a.a.a.a(4, this.srJ);
            }
            return (fQ + f.a.a.a.fQ(5, this.srK)) + f.a.a.a.fQ(6, this.srL);
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
            bug bug = (bug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bug.srG = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bug.srH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bug.srI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bug.srJ = aVar3.cJR();
                    return 0;
                case 5:
                    bug.srK = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bug.srL = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
