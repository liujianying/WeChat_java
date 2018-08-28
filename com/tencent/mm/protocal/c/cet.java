package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cet extends a {
    public b rdU;
    public int szE;
    public long szl;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdU == null) {
                throw new f.a.a.b("Not all required fields were included: VoiceData");
            }
            aVar.T(1, this.szl);
            if (this.rdU != null) {
                aVar.b(2, this.rdU);
            }
            aVar.fT(3, this.szE);
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.szl) + 0;
            if (this.rdU != null) {
                S += f.a.a.a.a(2, this.rdU);
            }
            return S + f.a.a.a.fQ(3, this.szE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rdU != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: VoiceData");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cet cet = (cet) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cet.szl = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    cet.rdU = aVar3.cJR();
                    return 0;
                case 3:
                    cet.szE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
