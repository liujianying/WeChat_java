package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class amh extends a {
    public long cfh;
    public b rOX;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.cfh);
            if (this.rOX != null) {
                aVar.b(2, this.rOX);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.cfh) + 0;
            if (this.rOX != null) {
                return S + f.a.a.a.a(2, this.rOX);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            amh amh = (amh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amh.cfh = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    amh.rOX = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
