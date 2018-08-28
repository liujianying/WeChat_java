package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class dk extends a {
    public b rdG;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdG == null) {
                throw new f.a.a.b("Not all required fields were included: Cookies");
            } else if (this.rdG == null) {
                return 0;
            } else {
                aVar.b(1, this.rdG);
                return 0;
            }
        } else if (i == 1) {
            if (this.rdG != null) {
                a = f.a.a.a.a(1, this.rdG) + 0;
            } else {
                a = 0;
            }
            return a;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (this.rdG != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Cookies");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dk dkVar = (dk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkVar.rdG = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
