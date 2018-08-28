package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btr extends a {
    public String rmC;
    public String rwn;
    public int sri;
    public int srj;
    public long srk;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sri);
            if (this.rmC != null) {
                aVar.g(2, this.rmC);
            }
            if (this.rwn != null) {
                aVar.g(3, this.rwn);
            }
            aVar.fT(4, this.srj);
            aVar.T(5, this.srk);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.sri) + 0;
            if (this.rmC != null) {
                fQ += f.a.a.b.b.a.h(2, this.rmC);
            }
            if (this.rwn != null) {
                fQ += f.a.a.b.b.a.h(3, this.rwn);
            }
            return (fQ + f.a.a.a.fQ(4, this.srj)) + f.a.a.a.S(5, this.srk);
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
            btr btr = (btr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btr.sri = aVar3.vHC.rY();
                    return 0;
                case 2:
                    btr.rmC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    btr.rwn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    btr.srj = aVar3.vHC.rY();
                    return 0;
                case 5:
                    btr.srk = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
