package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbk extends bhd {
    public int rtK;
    public int sdC;
    public int sdD;
    public fe sdE;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.sdC);
            aVar.fT(3, this.sdD);
            if (this.sdE != null) {
                aVar.fV(4, this.sdE.boi());
                this.sdE.a(aVar);
            }
            aVar.fT(5, this.rtK);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.sdC)) + f.a.a.a.fQ(3, this.sdD);
            if (this.sdE != null) {
                fS += f.a.a.a.fS(4, this.sdE.boi());
            }
            return fS + f.a.a.a.fQ(5, this.rtK);
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
            bbk bbk = (bbk) objArr[1];
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
                        bbk.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bbk.sdC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bbk.sdD = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fe feVar = new fe();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bhd.a(aVar4))) {
                        }
                        bbk.sdE = feVar;
                    }
                    return 0;
                case 5:
                    bbk.rtK = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
