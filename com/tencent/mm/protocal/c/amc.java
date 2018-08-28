package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class amc extends a {
    public b rOO;
    public b rgs;
    public b rgu;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rgu != null) {
                aVar.b(1, this.rgu);
            }
            if (this.rgs != null) {
                aVar.b(2, this.rgs);
            }
            if (this.rOO == null) {
                return 0;
            }
            aVar.b(3, this.rOO);
            return 0;
        } else if (i == 1) {
            if (this.rgu != null) {
                a = f.a.a.a.a(1, this.rgu) + 0;
            } else {
                a = 0;
            }
            if (this.rgs != null) {
                a += f.a.a.a.a(2, this.rgs);
            }
            if (this.rOO != null) {
                a += f.a.a.a.a(3, this.rOO);
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
            amc amc = (amc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amc.rgu = aVar3.cJR();
                    return 0;
                case 2:
                    amc.rgs = aVar3.cJR();
                    return 0;
                case 3:
                    amc.rOO = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
