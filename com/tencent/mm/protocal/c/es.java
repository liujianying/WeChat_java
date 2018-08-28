package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class es extends a {
    public long endTime;
    public long startTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.startTime);
            aVar.T(2, this.endTime);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.S(1, this.startTime) + 0) + f.a.a.a.S(2, this.endTime);
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
                es esVar = (es) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        esVar.startTime = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        esVar.endTime = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
