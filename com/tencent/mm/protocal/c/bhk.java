package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bhk extends a {
    public int sip;
    public String siq;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.siq == null) {
                throw new b("Not all required fields were included: ResKey");
            }
            aVar.fT(1, this.sip);
            if (this.siq != null) {
                aVar.g(2, this.siq);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.sip) + 0;
            if (this.siq != null) {
                return fQ + f.a.a.b.b.a.h(2, this.siq);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.siq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ResKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhk bhk = (bhk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhk.sip = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bhk.siq = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
