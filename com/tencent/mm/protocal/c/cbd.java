package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cbd extends a {
    public String fMk;
    public int nc;
    public b rwb;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.nc);
            if (this.fMk != null) {
                aVar.g(2, this.fMk);
            }
            if (this.rwb != null) {
                aVar.b(3, this.rwb);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.nc) + 0;
            if (this.fMk != null) {
                fQ += f.a.a.b.b.a.h(2, this.fMk);
            }
            if (this.rwb != null) {
                return fQ + f.a.a.a.a(3, this.rwb);
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
            cbd cbd = (cbd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbd.nc = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cbd.fMk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbd.rwb = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
