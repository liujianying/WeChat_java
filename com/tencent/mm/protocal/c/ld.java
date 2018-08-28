package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ld extends bhd {
    public int rnA;
    public int rnx;
    public bhy rny;
    public aqo rnz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rnx);
            if (this.rny != null) {
                aVar.fV(3, this.rny.boi());
                this.rny.a(aVar);
            }
            if (this.rnz != null) {
                aVar.fV(4, this.rnz.boi());
                this.rnz.a(aVar);
            }
            aVar.fT(5, this.rnA);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rnx);
            if (this.rny != null) {
                fS += f.a.a.a.fS(3, this.rny.boi());
            }
            if (this.rnz != null) {
                fS += f.a.a.a.fS(4, this.rnz.boi());
            }
            return fS + f.a.a.a.fQ(5, this.rnA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rny != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyBuf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ld ldVar = (ld) objArr[1];
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
                        ldVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ldVar.rnx = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        ldVar.rny = bhy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqo aqo = new aqo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqo.a(aVar4, aqo, bhd.a(aVar4))) {
                        }
                        ldVar.rnz = aqo;
                    }
                    return 0;
                case 5:
                    ldVar.rnA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
