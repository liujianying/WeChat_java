package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bbe extends a {
    public double rji;
    public double rjj;
    public double sds;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.c(1, this.rjj);
            aVar.c(2, this.rji);
            aVar.c(3, this.sds);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.b.b.a.ec(1) + 8) + 0) + (f.a.a.b.b.a.ec(2) + 8)) + (f.a.a.b.b.a.ec(3) + 8);
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
                bbe bbe = (bbe) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bbe.rjj = aVar3.vHC.readDouble();
                        return 0;
                    case 2:
                        bbe.rji = aVar3.vHC.readDouble();
                        return 0;
                    case 3:
                        bbe.sds = aVar3.vHC.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
