package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cfi extends a {
    public int otY;
    public String rDH;
    public int rUH;
    public aqs rUI;
    public String rZE;
    public int rjC;
    public String rlo;
    public int shN;
    public int spQ;
    public int syI = 2;
    public String syL;
    public int szP;
    public LinkedList<ps> szQ = new LinkedList();
    public String szR;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rjC);
            aVar.fT(2, this.rUH);
            aVar.fT(3, this.shN);
            if (this.rDH != null) {
                aVar.g(4, this.rDH);
            }
            if (this.rUI != null) {
                aVar.fV(5, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.fT(6, this.otY);
            if (this.rlo != null) {
                aVar.g(7, this.rlo);
            }
            aVar.fT(8, this.szP);
            aVar.fT(9, this.syI);
            aVar.d(10, 8, this.szQ);
            if (this.syL != null) {
                aVar.g(11, this.syL);
            }
            if (this.rZE != null) {
                aVar.g(12, this.rZE);
            }
            aVar.fT(13, this.spQ);
            if (this.szR != null) {
                aVar.g(14, this.szR);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rjC) + 0) + f.a.a.a.fQ(2, this.rUH)) + f.a.a.a.fQ(3, this.shN);
            if (this.rDH != null) {
                fQ += f.a.a.b.b.a.h(4, this.rDH);
            }
            if (this.rUI != null) {
                fQ += f.a.a.a.fS(5, this.rUI.boi());
            }
            fQ += f.a.a.a.fQ(6, this.otY);
            if (this.rlo != null) {
                fQ += f.a.a.b.b.a.h(7, this.rlo);
            }
            fQ = ((fQ + f.a.a.a.fQ(8, this.szP)) + f.a.a.a.fQ(9, this.syI)) + f.a.a.a.c(10, 8, this.szQ);
            if (this.syL != null) {
                fQ += f.a.a.b.b.a.h(11, this.syL);
            }
            if (this.rZE != null) {
                fQ += f.a.a.b.b.a.h(12, this.rZE);
            }
            fQ += f.a.a.a.fQ(13, this.spQ);
            if (this.szR != null) {
                return fQ + f.a.a.b.b.a.h(14, this.szR);
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.szQ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfi cfi = (cfi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cfi.rjC = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cfi.rUH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfi.shN = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cfi.rDH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        cfi.rUI = aqs;
                    }
                    return 0;
                case 6:
                    cfi.otY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cfi.rlo = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cfi.szP = aVar3.vHC.rY();
                    return 0;
                case 9:
                    cfi.syI = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ps psVar = new ps();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = psVar.a(aVar4, psVar, a.a(aVar4))) {
                        }
                        cfi.szQ.add(psVar);
                    }
                    return 0;
                case 11:
                    cfi.syL = aVar3.vHC.readString();
                    return 0;
                case 12:
                    cfi.rZE = aVar3.vHC.readString();
                    return 0;
                case 13:
                    cfi.spQ = aVar3.vHC.rY();
                    return 0;
                case 14:
                    cfi.szR = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
