package com.tencent.mm.br;

import com.tencent.mm.bk.a;

public final class d extends a {
    public int max;
    public int min;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.min);
            aVar.fT(2, this.max);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.min) + 0) + f.a.a.a.fQ(2, this.max);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                d dVar = (d) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        dVar.min = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        dVar.max = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
