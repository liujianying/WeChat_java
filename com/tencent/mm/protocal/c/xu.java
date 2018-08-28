package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xu extends a {
    public boolean rDB;
    public boolean rDC;
    public boolean rDD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.rDB);
            aVar.av(2, this.rDC);
            aVar.av(3, this.rDD);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.b.b.a.ec(1) + 1) + 0) + (f.a.a.b.b.a.ec(2) + 1)) + (f.a.a.b.b.a.ec(3) + 1);
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
                xu xuVar = (xu) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        xuVar.rDB = aVar3.cJQ();
                        return 0;
                    case 2:
                        xuVar.rDC = aVar3.cJQ();
                        return 0;
                    case 3:
                        xuVar.rDD = aVar3.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
