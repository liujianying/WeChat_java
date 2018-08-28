package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class akh extends bhd {
    public String hbL;
    public int otY;
    public bhy rEu;
    public String rMW;
    public bhy reB;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.reB == null) {
                throw new b("Not all required fields were included: A2Key");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.reB != null) {
                aVar.fV(2, this.reB.boi());
                this.reB.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(3, this.hbL);
            }
            aVar.fT(4, this.otY);
            if (this.rMW != null) {
                aVar.g(5, this.rMW);
            }
            if (this.rEu == null) {
                return 0;
            }
            aVar.fV(6, this.rEu.boi());
            this.rEu.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.reB != null) {
                fS += f.a.a.a.fS(2, this.reB.boi());
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(3, this.hbL);
            }
            fS += f.a.a.a.fQ(4, this.otY);
            if (this.rMW != null) {
                fS += f.a.a.b.b.a.h(5, this.rMW);
            }
            if (this.rEu != null) {
                fS += f.a.a.a.fS(6, this.rEu.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.reB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: A2Key");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            akh akh = (akh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        akh.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        akh.reB = bhy;
                    }
                    return 0;
                case 3:
                    akh.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    akh.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    akh.rMW = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        akh.rEu = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
