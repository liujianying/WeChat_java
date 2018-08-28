package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bar extends a {
    public String sdc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sdc == null) {
                throw new b("Not all required fields were included: PhoneNum");
            } else if (this.sdc == null) {
                return 0;
            } else {
                aVar.g(1, this.sdc);
                return 0;
            }
        } else if (i == 1) {
            if (this.sdc != null) {
                h = f.a.a.b.b.a.h(1, this.sdc) + 0;
            } else {
                h = 0;
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.sdc != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PhoneNum");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bar bar = (bar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bar.sdc = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
