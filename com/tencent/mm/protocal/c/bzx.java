package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzx extends bhd {
    public bhy rfy;
    public int rxG;
    public long rxH;
    public int seq;
    public int svM;
    public int svN;
    public int svO;
    public int svP;
    public int svQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rfy == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.seq);
            aVar.fT(5, this.svM);
            aVar.fT(6, this.svN);
            aVar.fT(7, this.svO);
            aVar.fT(8, this.svP);
            aVar.fT(9, this.svQ);
            if (this.rfy == null) {
                return 0;
            }
            aVar.fV(10, this.rfy.boi());
            this.rfy.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.seq)) + f.a.a.a.fQ(5, this.svM)) + f.a.a.a.fQ(6, this.svN)) + f.a.a.a.fQ(7, this.svO)) + f.a.a.a.fQ(8, this.svP)) + f.a.a.a.fQ(9, this.svQ);
            if (this.rfy != null) {
                fS += f.a.a.a.fS(10, this.rfy.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
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
            bzx bzx = (bzx) objArr[1];
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
                        bzx.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bzx.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bzx.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bzx.seq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzx.svM = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bzx.svN = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bzx.svO = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bzx.svP = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bzx.svQ = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bzx.rfy = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
