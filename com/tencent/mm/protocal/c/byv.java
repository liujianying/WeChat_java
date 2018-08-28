package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class byv extends bhd {
    public int rth;
    public int rxG;
    public long rxH;
    public String seC;
    public int suJ;
    public cak suK;
    public cak suL;
    public String suM;
    public int suN;
    public long suO;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            if (this.seC != null) {
                aVar.g(4, this.seC);
            }
            aVar.fT(5, this.suJ);
            if (this.suK != null) {
                aVar.fV(6, this.suK.boi());
                this.suK.a(aVar);
            }
            if (this.suL != null) {
                aVar.fV(7, this.suL.boi());
                this.suL.a(aVar);
            }
            aVar.fT(8, this.rth);
            if (this.suM != null) {
                aVar.g(9, this.suM);
            }
            aVar.fT(10, this.suN);
            aVar.T(11, this.suO);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH);
            if (this.seC != null) {
                fS += f.a.a.b.b.a.h(4, this.seC);
            }
            fS += f.a.a.a.fQ(5, this.suJ);
            if (this.suK != null) {
                fS += f.a.a.a.fS(6, this.suK.boi());
            }
            if (this.suL != null) {
                fS += f.a.a.a.fS(7, this.suL.boi());
            }
            fS += f.a.a.a.fQ(8, this.rth);
            if (this.suM != null) {
                fS += f.a.a.b.b.a.h(9, this.suM);
            }
            return (fS + f.a.a.a.fQ(10, this.suN)) + f.a.a.a.S(11, this.suO);
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
            byv byv = (byv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            cak cak;
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
                        byv.shX = fkVar;
                    }
                    return 0;
                case 2:
                    byv.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    byv.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    byv.seC = aVar3.vHC.readString();
                    return 0;
                case 5:
                    byv.suJ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, bhd.a(aVar4))) {
                        }
                        byv.suK = cak;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, bhd.a(aVar4))) {
                        }
                        byv.suL = cak;
                    }
                    return 0;
                case 8:
                    byv.rth = aVar3.vHC.rY();
                    return 0;
                case 9:
                    byv.suM = aVar3.vHC.readString();
                    return 0;
                case 10:
                    byv.suN = aVar3.vHC.rY();
                    return 0;
                case 11:
                    byv.suO = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
