package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cba extends a {
    public boolean sxj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).av(1, this.sxj);
            return 0;
        } else if (i == 1) {
            return (f.a.a.b.b.a.ec(1) + 1) + 0;
        } else {
            if (i == 2) {
                f.a.a.a.a aVar = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar2 = (f.a.a.a.a) objArr[0];
                cba cba = (cba) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cba.sxj = aVar2.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
