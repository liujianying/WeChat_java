package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class caq extends bhd {
    public int rth;
    public int rxG;
    public int soA;
    public int soB;
    public int soC;
    public int soD;
    public LinkedList<Integer> soE = new LinkedList();
    public int soF;
    public int soG;
    public LinkedList<Integer> soH = new LinkedList();
    public int soI;
    public int soJ;
    public int soz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.fT(3, this.soz);
            aVar.fT(4, this.rth);
            aVar.fT(5, this.soA);
            aVar.fT(6, this.soB);
            aVar.fT(7, this.soC);
            aVar.fT(8, this.soD);
            aVar.c(9, this.soE);
            aVar.fT(10, this.soF);
            aVar.fT(11, this.soG);
            aVar.c(12, this.soH);
            aVar.fT(13, this.soI);
            aVar.fT(14, this.soJ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((((((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.fQ(3, this.soz)) + f.a.a.a.fQ(4, this.rth)) + f.a.a.a.fQ(5, this.soA)) + f.a.a.a.fQ(6, this.soB)) + f.a.a.a.fQ(7, this.soC)) + f.a.a.a.fQ(8, this.soD)) + f.a.a.a.b(9, this.soE)) + f.a.a.a.fQ(10, this.soF)) + f.a.a.a.fQ(11, this.soG)) + f.a.a.a.b(12, this.soH)) + f.a.a.a.fQ(13, this.soI)) + f.a.a.a.fQ(14, this.soJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.soE.clear();
            this.soH.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            caq caq = (caq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        caq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    caq.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    caq.soz = aVar3.vHC.rY();
                    return 0;
                case 4:
                    caq.rth = aVar3.vHC.rY();
                    return 0;
                case 5:
                    caq.soA = aVar3.vHC.rY();
                    return 0;
                case 6:
                    caq.soB = aVar3.vHC.rY();
                    return 0;
                case 7:
                    caq.soC = aVar3.vHC.rY();
                    return 0;
                case 8:
                    caq.soD = aVar3.vHC.rY();
                    return 0;
                case 9:
                    caq.soE = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 10:
                    caq.soF = aVar3.vHC.rY();
                    return 0;
                case 11:
                    caq.soG = aVar3.vHC.rY();
                    return 0;
                case 12:
                    caq.soH = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 13:
                    caq.soI = aVar3.vHC.rY();
                    return 0;
                case 14:
                    caq.soJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
