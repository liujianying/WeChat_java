package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class byp extends a {
    public int rdW;
    public bhy suA;
    public int suy;
    public int suz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.suA == null) {
                throw new b("Not all required fields were included: PieceData");
            }
            aVar.fT(1, this.rdW);
            aVar.fT(2, this.suy);
            aVar.fT(3, this.suz);
            if (this.suA != null) {
                aVar.fV(4, this.suA.boi());
                this.suA.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rdW) + 0) + f.a.a.a.fQ(2, this.suy)) + f.a.a.a.fQ(3, this.suz);
            if (this.suA != null) {
                return fQ + f.a.a.a.fS(4, this.suA.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.suA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PieceData");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            byp byp = (byp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    byp.rdW = aVar3.vHC.rY();
                    return 0;
                case 2:
                    byp.suy = aVar3.vHC.rY();
                    return 0;
                case 3:
                    byp.suz = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        byp.suA = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
