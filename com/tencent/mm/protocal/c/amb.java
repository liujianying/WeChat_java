package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class amb extends a {
    public int hcE;
    public int lOH;
    public long rON;
    public bhy rfy;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfy == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            aVar.T(1, this.rON);
            aVar.fT(2, this.lOH);
            if (this.rfy != null) {
                aVar.fV(3, this.rfy.boi());
                this.rfy.a(aVar);
            }
            aVar.fT(4, this.hcE);
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rON) + 0) + f.a.a.a.fQ(2, this.lOH);
            if (this.rfy != null) {
                S += f.a.a.a.fS(3, this.rfy.boi());
            }
            return S + f.a.a.a.fQ(4, this.hcE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rfy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            amb amb = (amb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    amb.rON = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    amb.lOH = aVar3.vHC.rY();
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
                        amb.rfy = bhy;
                    }
                    return 0;
                case 4:
                    amb.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
