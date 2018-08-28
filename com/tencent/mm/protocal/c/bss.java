package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bss extends bhd {
    public int jQd;
    public String rVk;
    public int rdV;
    public int rdW;
    public bhy ruy;
    public int rvX;
    public int sde;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruy == null) {
                throw new b("Not all required fields were included: Content");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.jQd);
            aVar.fT(3, this.sde);
            if (this.ruy != null) {
                aVar.fV(4, this.ruy.boi());
                this.ruy.a(aVar);
            }
            aVar.fT(5, this.rdW);
            aVar.fT(6, this.rdV);
            if (this.rVk != null) {
                aVar.g(7, this.rVk);
            }
            aVar.fT(8, this.rvX);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.jQd)) + f.a.a.a.fQ(3, this.sde);
            if (this.ruy != null) {
                fS += f.a.a.a.fS(4, this.ruy.boi());
            }
            fS = (fS + f.a.a.a.fQ(5, this.rdW)) + f.a.a.a.fQ(6, this.rdV);
            if (this.rVk != null) {
                fS += f.a.a.b.b.a.h(7, this.rVk);
            }
            return fS + f.a.a.a.fQ(8, this.rvX);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Content");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bss bss = (bss) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
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
                        bss.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bss.jQd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bss.sde = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bss.ruy = bhy;
                    }
                    return 0;
                case 5:
                    bss.rdW = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bss.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bss.rVk = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bss.rvX = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
