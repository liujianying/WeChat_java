package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bzb extends a {
    public int svq;
    public int svr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.svq);
            aVar.fT(2, this.svr);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.svq) + 0) + f.a.a.a.fQ(2, this.svr);
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
                bzb bzb = (bzb) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bzb.svq = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bzb.svr = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
