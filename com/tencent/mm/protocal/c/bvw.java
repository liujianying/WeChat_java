package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bvw extends bhd {
    public String rcc;
    public int rdV;
    public int rdW;
    public int rdX;
    public bhy rtW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rcc != null) {
                aVar.g(2, this.rcc);
            }
            aVar.fT(3, this.rdV);
            aVar.fT(4, this.rdW);
            aVar.fT(5, this.rdX);
            if (this.rtW == null) {
                return 0;
            }
            aVar.fV(6, this.rtW.boi());
            this.rtW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcc != null) {
                fS += f.a.a.b.b.a.h(2, this.rcc);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.rdV)) + f.a.a.a.fQ(4, this.rdW)) + f.a.a.a.fQ(5, this.rdX);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(6, this.rtW.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bvw bvw = (bvw) objArr[1];
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
                        bvw.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvw.rcc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvw.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bvw.rdW = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bvw.rdX = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bvw.rtW = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
