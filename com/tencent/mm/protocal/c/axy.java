package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class axy extends a {
    public b saV;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.saV == null) {
                throw new f.a.a.b("Not all required fields were included: buf");
            }
            aVar.fT(1, this.type);
            if (this.saV != null) {
                aVar.b(2, this.saV);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.saV != null) {
                return fQ + f.a.a.a.a(2, this.saV);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.saV != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: buf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            axy axy = (axy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axy.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    axy.saV = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
