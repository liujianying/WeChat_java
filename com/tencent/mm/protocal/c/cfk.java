package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cfk extends a {
    public long szS;
    public iv szT;
    public int szU;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.szS);
            if (this.szT != null) {
                aVar.fV(2, this.szT.boi());
                this.szT.a(aVar);
            }
            aVar.fT(3, this.szU);
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.szS) + 0;
            if (this.szT != null) {
                S += f.a.a.a.fS(2, this.szT.boi());
            }
            return S + f.a.a.a.fQ(3, this.szU);
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
            cfk cfk = (cfk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cfk.szS = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        iv ivVar = new iv();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ivVar.a(aVar4, ivVar, a.a(aVar4))) {
                        }
                        cfk.szT = ivVar;
                    }
                    return 0;
                case 3:
                    cfk.szU = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
