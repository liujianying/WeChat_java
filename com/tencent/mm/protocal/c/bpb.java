package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bpb extends a {
    public int jRb;
    public long rlK;
    public bhy sbD;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rlK);
            aVar.fT(2, this.jRb);
            if (this.sbD != null) {
                aVar.fV(3, this.sbD.boi());
                this.sbD.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rlK) + 0) + f.a.a.a.fQ(2, this.jRb);
            if (this.sbD != null) {
                return S + f.a.a.a.fS(3, this.sbD.boi());
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
            bpb bpb = (bpb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bpb.rlK = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    bpb.jRb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bpb.sbD = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
