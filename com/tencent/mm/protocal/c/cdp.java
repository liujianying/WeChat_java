package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cdp extends a {
    public String rdS;
    public long sza;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdS == null) {
                throw new b("Not all required fields were included: Username");
            }
            aVar.T(1, this.sza);
            if (this.rdS != null) {
                aVar.g(2, this.rdS);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.sza) + 0;
            if (this.rdS != null) {
                return S + f.a.a.b.b.a.h(2, this.rdS);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
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
            cdp cdp = (cdp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdp.sza = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    cdp.rdS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
