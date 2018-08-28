package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bns extends a {
    public int hcD;
    public b slN;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.slN == null) {
                throw new f.a.a.b("Not all required fields were included: Signature");
            }
            aVar.fT(1, this.hcD);
            if (this.slN != null) {
                aVar.b(2, this.slN);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcD) + 0;
            if (this.slN != null) {
                return fQ + f.a.a.a.a(2, this.slN);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.slN != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Signature");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bns bns = (bns) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bns.hcD = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bns.slN = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
