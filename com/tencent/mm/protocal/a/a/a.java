package com.tencent.mm.protocal.a.a;

public final class a extends com.tencent.mm.bk.a {
    public int count;
    public int qXg;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qXg);
            aVar.fT(2, this.value);
            aVar.fT(3, this.count);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.fQ(1, this.qXg) + 0) + f.a.a.a.fQ(2, this.value)) + f.a.a.a.fQ(3, this.count);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.bk.a.a(aVar2); a > 0; a = com.tencent.mm.bk.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aVar4.qXg = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        aVar4.value = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        aVar4.count = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
