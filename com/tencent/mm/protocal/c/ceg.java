package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class ceg extends a {
    public String hcS;
    public String szk;
    public long szm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szk == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.hcS == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.szk != null) {
                    aVar.g(1, this.szk);
                }
                if (this.hcS != null) {
                    aVar.g(2, this.hcS);
                }
                aVar.T(3, this.szm);
                return 0;
            }
        } else if (i == 1) {
            if (this.szk != null) {
                h = f.a.a.b.b.a.h(1, this.szk) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            return h + f.a.a.a.S(3, this.szm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.szk == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.hcS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ceg ceg = (ceg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ceg.szk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ceg.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ceg.szm = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
