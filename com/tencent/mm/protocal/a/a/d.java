package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class d extends a {
    public int count;
    public int mXw;
    public int qXg;
    public b qXp;
    public int qXq;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qXp == null) {
                throw new f.a.a.b("Not all required fields were included: value");
            }
            aVar.fT(1, this.qXg);
            if (this.qXp != null) {
                aVar.b(2, this.qXp);
            }
            aVar.fT(3, this.qXq);
            aVar.fT(4, this.mXw);
            aVar.fT(5, this.count);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.qXg) + 0;
            if (this.qXp != null) {
                fQ += f.a.a.a.a(2, this.qXp);
            }
            return ((fQ + f.a.a.a.fQ(3, this.qXq)) + f.a.a.a.fQ(4, this.mXw)) + f.a.a.a.fQ(5, this.count);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.qXp != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: value");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.qXg = aVar3.vHC.rY();
                    return 0;
                case 2:
                    dVar.qXp = aVar3.cJR();
                    return 0;
                case 3:
                    dVar.qXq = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dVar.mXw = aVar3.vHC.rY();
                    return 0;
                case 5:
                    dVar.count = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
