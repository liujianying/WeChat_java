package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cek extends a {
    public String rdS;
    public long see;
    public boolean szt;

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
            aVar.T(2, this.see);
            aVar.av(3, this.szt);
            return 0;
        } else if (i == 1) {
            if (this.rdS != null) {
                h = f.a.a.b.b.a.h(1, this.rdS) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.S(2, this.see)) + (f.a.a.b.b.a.ec(3) + 1);
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
            cek cek = (cek) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cek.rdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cek.see = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    cek.szt = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
