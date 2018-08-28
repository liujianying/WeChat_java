package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class avk extends a {
    public double rYh;
    public long rYi;
    public String rdS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdS == null) {
                throw new b("Not all required fields were included: Username");
            }
            if (this.rdS != null) {
                aVar.g(1, this.rdS);
            }
            aVar.c(2, this.rYh);
            aVar.T(3, this.rYi);
            return 0;
        } else if (i == 1) {
            if (this.rdS != null) {
                h = f.a.a.b.b.a.h(1, this.rdS) + 0;
            } else {
                h = 0;
            }
            return (h + (f.a.a.b.b.a.ec(2) + 8)) + f.a.a.a.S(3, this.rYi);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rdS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Username");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            avk avk = (avk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avk.rdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    avk.rYh = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    avk.rYi = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
