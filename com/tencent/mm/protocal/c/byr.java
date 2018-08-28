package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class byr extends a {
    public int rgC;
    public String rsZ;
    public bhy ssr;
    public int suB;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ssr == null) {
                throw new b("Not all required fields were included: Text");
            }
            if (this.ssr != null) {
                aVar.fV(1, this.ssr.boi());
                this.ssr.a(aVar);
            }
            if (this.rsZ != null) {
                aVar.g(2, this.rsZ);
            }
            aVar.fT(3, this.rgC);
            aVar.fT(4, this.suB);
            return 0;
        } else if (i == 1) {
            if (this.ssr != null) {
                fS = f.a.a.a.fS(1, this.ssr.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rsZ != null) {
                fS += f.a.a.b.b.a.h(2, this.rsZ);
            }
            return (fS + f.a.a.a.fQ(3, this.rgC)) + f.a.a.a.fQ(4, this.suB);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ssr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Text");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            byr byr = (byr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        byr.ssr = bhy;
                    }
                    return 0;
                case 2:
                    byr.rsZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    byr.rgC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    byr.suB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
