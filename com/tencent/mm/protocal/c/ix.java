package com.tencent.mm.protocal.c;

import com.tencent.mm.ac.d;
import com.tencent.mm.bk.a;
import com.tencent.mm.storage.ab;
import f.a.a.b;

public final class ix extends a {
    public ab guS;
    public d lUs;
    public String userName;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.userName == null) {
                throw new b("Not all required fields were included: userName");
            } else if (this.userName == null) {
                return 0;
            } else {
                aVar.g(1, this.userName);
                return 0;
            }
        } else if (i == 1) {
            if (this.userName != null) {
                h = f.a.a.b.b.a.h(1, this.userName) + 0;
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
            if (this.userName != null) {
                return 0;
            }
            throw new b("Not all required fields were included: userName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ix ixVar = (ix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ixVar.userName = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
