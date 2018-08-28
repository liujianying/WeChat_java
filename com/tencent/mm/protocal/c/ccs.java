package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class ccs extends a {
    public b syu;
    public b syv;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syu != null) {
                aVar.b(1, this.syu);
            }
            if (this.syv == null) {
                return 0;
            }
            aVar.b(2, this.syv);
            return 0;
        } else if (i == 1) {
            if (this.syu != null) {
                a = f.a.a.a.a(1, this.syu) + 0;
            } else {
                a = 0;
            }
            if (this.syv != null) {
                a += f.a.a.a.a(2, this.syv);
            }
            return a;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ccs ccs = (ccs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccs.syu = aVar3.cJR();
                    return 0;
                case 2:
                    ccs.syv = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
