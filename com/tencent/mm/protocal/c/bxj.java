package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bxj extends a {
    public int bzI;
    public String jOS;
    public bhy stO;
    public bhy stP;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.stO == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.stP == null) {
                throw new b("Not all required fields were included: HDIcon");
            } else {
                aVar.fT(1, this.bzI);
                if (this.jOS != null) {
                    aVar.g(2, this.jOS);
                }
                if (this.stO != null) {
                    aVar.fV(3, this.stO.boi());
                    this.stO.a(aVar);
                }
                if (this.stP != null) {
                    aVar.fV(4, this.stP.boi());
                    this.stP.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.bzI) + 0;
            if (this.jOS != null) {
                fQ += f.a.a.b.b.a.h(2, this.jOS);
            }
            if (this.stO != null) {
                fQ += f.a.a.a.fS(3, this.stO.boi());
            }
            if (this.stP != null) {
                return fQ + f.a.a.a.fS(4, this.stP.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.stO == null) {
                throw new b("Not all required fields were included: Icon");
            } else if (this.stP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HDIcon");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bxj bxj = (bxj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhy bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bxj.bzI = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bxj.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bxj.stO = bhy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bxj.stP = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
