package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;

public final class s extends a {
    public long hbZ;
    public long hcw;
    public long hcx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.hbZ);
            aVar.T(2, this.hcw);
            aVar.T(3, this.hcx);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.S(1, this.hbZ) + 0) + f.a.a.a.S(2, this.hcw)) + f.a.a.a.S(3, this.hcx);
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
                s sVar = (s) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        sVar.hbZ = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        sVar.hcw = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        sVar.hcx = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
