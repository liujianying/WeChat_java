package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class alw extends a {
    public long rOp;
    public int rOq;
    public long rOr;
    public int rOs;
    public long rOt;
    public int rOu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rOp);
            aVar.fT(2, this.rOq);
            aVar.T(3, this.rOr);
            aVar.fT(4, this.rOs);
            aVar.T(5, this.rOt);
            aVar.fT(6, this.rOu);
            return 0;
        } else if (i == 1) {
            return (((((f.a.a.a.S(1, this.rOp) + 0) + f.a.a.a.fQ(2, this.rOq)) + f.a.a.a.S(3, this.rOr)) + f.a.a.a.fQ(4, this.rOs)) + f.a.a.a.S(5, this.rOt)) + f.a.a.a.fQ(6, this.rOu);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                alw alw = (alw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        alw.rOp = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        alw.rOq = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        alw.rOr = aVar3.vHC.rZ();
                        return 0;
                    case 4:
                        alw.rOs = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        alw.rOt = aVar3.vHC.rZ();
                        return 0;
                    case 6:
                        alw.rOu = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
