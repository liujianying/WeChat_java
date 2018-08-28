package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class hm extends a {
    public b rih;
    public b rii;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rih != null) {
                aVar.b(1, this.rih);
            }
            if (this.rii == null) {
                return 0;
            }
            aVar.b(2, this.rii);
            return 0;
        } else if (i == 1) {
            if (this.rih != null) {
                a = f.a.a.a.a(1, this.rih) + 0;
            } else {
                a = 0;
            }
            if (this.rii != null) {
                a += f.a.a.a.a(2, this.rii);
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
            hm hmVar = (hm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hmVar.rih = aVar3.cJR();
                    return 0;
                case 2:
                    hmVar.rii = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
