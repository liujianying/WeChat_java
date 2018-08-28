package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bor extends bhd {
    public int hcE;
    public int rdV;
    public int rdW;
    public String smD;
    public int smE;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rdW);
            aVar.fT(3, this.rdV);
            if (this.smD != null) {
                aVar.g(4, this.smD);
            }
            aVar.fT(5, this.hcE);
            aVar.fT(6, this.smE);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV);
            if (this.smD != null) {
                fS += f.a.a.b.b.a.h(4, this.smD);
            }
            return (fS + f.a.a.a.fQ(5, this.hcE)) + f.a.a.a.fQ(6, this.smE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bor bor = (bor) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bor.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bor.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bor.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bor.smD = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bor.hcE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bor.smE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
