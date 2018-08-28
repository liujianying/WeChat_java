package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aqk extends bhd {
    public String jQb;
    public int rKO;
    public cgg rSN;
    public chi rSO;
    public chd rSP;
    public chx rSQ;
    public chh rSR;
    public chj rSS;
    public int rST;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.rSN != null) {
                aVar.fV(3, this.rSN.boi());
                this.rSN.a(aVar);
            }
            aVar.fT(4, this.rKO);
            if (this.rSO != null) {
                aVar.fV(5, this.rSO.boi());
                this.rSO.a(aVar);
            }
            if (this.rSP != null) {
                aVar.fV(6, this.rSP.boi());
                this.rSP.a(aVar);
            }
            if (this.rSQ != null) {
                aVar.fV(7, this.rSQ.boi());
                this.rSQ.a(aVar);
            }
            if (this.rSR != null) {
                aVar.fV(8, this.rSR.boi());
                this.rSR.a(aVar);
            }
            if (this.rSS != null) {
                aVar.fV(9, this.rSS.boi());
                this.rSS.a(aVar);
            }
            aVar.fT(10, this.rST);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.rSN != null) {
                fS += f.a.a.a.fS(3, this.rSN.boi());
            }
            fS += f.a.a.a.fQ(4, this.rKO);
            if (this.rSO != null) {
                fS += f.a.a.a.fS(5, this.rSO.boi());
            }
            if (this.rSP != null) {
                fS += f.a.a.a.fS(6, this.rSP.boi());
            }
            if (this.rSQ != null) {
                fS += f.a.a.a.fS(7, this.rSQ.boi());
            }
            if (this.rSR != null) {
                fS += f.a.a.a.fS(8, this.rSR.boi());
            }
            if (this.rSS != null) {
                fS += f.a.a.a.fS(9, this.rSS.boi());
            }
            return fS + f.a.a.a.fQ(10, this.rST);
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
            aqk aqk = (aqk) objArr[1];
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
                        aqk.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aqk.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cgg cgg = new cgg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgg.a(aVar4, cgg, bhd.a(aVar4))) {
                        }
                        aqk.rSN = cgg;
                    }
                    return 0;
                case 4:
                    aqk.rKO = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chi chi = new chi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chi.a(aVar4, chi, bhd.a(aVar4))) {
                        }
                        aqk.rSO = chi;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chd chd = new chd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chd.a(aVar4, chd, bhd.a(aVar4))) {
                        }
                        aqk.rSP = chd;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chx chx = new chx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chx.a(aVar4, chx, bhd.a(aVar4))) {
                        }
                        aqk.rSQ = chx;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chh chh = new chh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chh.a(aVar4, chh, bhd.a(aVar4))) {
                        }
                        aqk.rSR = chh;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chj chj = new chj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chj.a(aVar4, chj, bhd.a(aVar4))) {
                        }
                        aqk.rSS = chj;
                    }
                    return 0;
                case 10:
                    aqk.rST = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
