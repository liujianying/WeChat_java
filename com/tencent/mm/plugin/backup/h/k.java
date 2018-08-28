package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class k extends a {
    public int hbJ;
    public int hbK;
    public String hbL;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            }
            aVar.fT(1, this.hbJ);
            aVar.fT(2, this.hbK);
            if (this.hbL != null) {
                aVar.g(3, this.hbL);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.hbJ) + 0) + f.a.a.a.fQ(2, this.hbK);
            if (this.hbL != null) {
                return fQ + f.a.a.b.b.a.h(3, this.hbL);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.hbL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.hbJ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    kVar.hbK = aVar3.vHC.rY();
                    return 0;
                case 3:
                    kVar.hbL = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
