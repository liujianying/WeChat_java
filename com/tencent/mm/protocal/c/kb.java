package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class kb extends a {
    public long rlK;
    public String rlL;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rlL == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.T(1, this.rlK);
            if (this.rlL != null) {
                aVar.g(2, this.rlL);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.rlK) + 0;
            if (this.rlL != null) {
                return S + f.a.a.b.b.a.h(2, this.rlL);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rlL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            kb kbVar = (kb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kbVar.rlK = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    kbVar.rlL = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
