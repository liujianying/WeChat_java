package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bdo extends bhp {
    public int balance;
    public int cej;
    public int hwV;
    public String hwW;
    public int rtK;
    public String seK;
    public String seM;
    public String sfA;
    public int sfB;
    public LinkedList<sj> sfC = new LinkedList();
    public int sfD;
    public LinkedList<sj> sfE = new LinkedList();
    public sj sfF;
    public LinkedList<sj> sfG = new LinkedList();
    public sj sfH;
    public atr sfI;
    public String sfJ;
    public int sfK;
    public String sfL;
    public int sfM;
    public boolean sfN;
    public String sfO;
    public String sfP;
    public String sfx;
    public String sfy;
    public String sfz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            aVar.fT(4, this.balance);
            if (this.sfy != null) {
                aVar.g(5, this.sfy);
            }
            if (this.sfz != null) {
                aVar.g(6, this.sfz);
            }
            if (this.sfA != null) {
                aVar.g(7, this.sfA);
            }
            aVar.fT(8, this.sfB);
            aVar.d(9, 8, this.sfC);
            aVar.fT(10, this.cej);
            aVar.fT(11, this.sfD);
            aVar.d(12, 8, this.sfE);
            if (this.seK != null) {
                aVar.g(13, this.seK);
            }
            if (this.sfF != null) {
                aVar.fV(14, this.sfF.boi());
                this.sfF.a(aVar);
            }
            aVar.d(15, 8, this.sfG);
            if (this.sfH != null) {
                aVar.fV(16, this.sfH.boi());
                this.sfH.a(aVar);
            }
            if (this.sfI != null) {
                aVar.fV(17, this.sfI.boi());
                this.sfI.a(aVar);
            }
            if (this.sfJ != null) {
                aVar.g(18, this.sfJ);
            }
            aVar.fT(19, this.sfK);
            if (this.sfL != null) {
                aVar.g(20, this.sfL);
            }
            if (this.sfx != null) {
                aVar.g(21, this.sfx);
            }
            aVar.fT(22, this.sfM);
            aVar.av(23, this.sfN);
            aVar.fT(24, this.rtK);
            if (this.seM != null) {
                aVar.g(25, this.seM);
            }
            if (this.sfO != null) {
                aVar.g(26, this.sfO);
            }
            if (this.sfP == null) {
                return 0;
            }
            aVar.g(27, this.sfP);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            fS += f.a.a.a.fQ(4, this.balance);
            if (this.sfy != null) {
                fS += f.a.a.b.b.a.h(5, this.sfy);
            }
            if (this.sfz != null) {
                fS += f.a.a.b.b.a.h(6, this.sfz);
            }
            if (this.sfA != null) {
                fS += f.a.a.b.b.a.h(7, this.sfA);
            }
            fS = ((((fS + f.a.a.a.fQ(8, this.sfB)) + f.a.a.a.c(9, 8, this.sfC)) + f.a.a.a.fQ(10, this.cej)) + f.a.a.a.fQ(11, this.sfD)) + f.a.a.a.c(12, 8, this.sfE);
            if (this.seK != null) {
                fS += f.a.a.b.b.a.h(13, this.seK);
            }
            if (this.sfF != null) {
                fS += f.a.a.a.fS(14, this.sfF.boi());
            }
            fS += f.a.a.a.c(15, 8, this.sfG);
            if (this.sfH != null) {
                fS += f.a.a.a.fS(16, this.sfH.boi());
            }
            if (this.sfI != null) {
                fS += f.a.a.a.fS(17, this.sfI.boi());
            }
            if (this.sfJ != null) {
                fS += f.a.a.b.b.a.h(18, this.sfJ);
            }
            fS += f.a.a.a.fQ(19, this.sfK);
            if (this.sfL != null) {
                fS += f.a.a.b.b.a.h(20, this.sfL);
            }
            if (this.sfx != null) {
                fS += f.a.a.b.b.a.h(21, this.sfx);
            }
            fS = ((fS + f.a.a.a.fQ(22, this.sfM)) + (f.a.a.b.b.a.ec(23) + 1)) + f.a.a.a.fQ(24, this.rtK);
            if (this.seM != null) {
                fS += f.a.a.b.b.a.h(25, this.seM);
            }
            if (this.sfO != null) {
                fS += f.a.a.b.b.a.h(26, this.sfO);
            }
            if (this.sfP != null) {
                fS += f.a.a.b.b.a.h(27, this.sfP);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sfC.clear();
            this.sfE.clear();
            this.sfG.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bdo bdo = (bdo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            sj sjVar;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bdo.six = flVar;
                    }
                    return 0;
                case 2:
                    bdo.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdo.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bdo.balance = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bdo.sfy = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bdo.sfz = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bdo.sfA = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bdo.sfB = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        bdo.sfC.add(sjVar);
                    }
                    return 0;
                case 10:
                    bdo.cej = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bdo.sfD = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        bdo.sfE.add(sjVar);
                    }
                    return 0;
                case 13:
                    bdo.seK = aVar3.vHC.readString();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        bdo.sfF = sjVar;
                    }
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        bdo.sfG.add(sjVar);
                    }
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        bdo.sfH = sjVar;
                    }
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atr atr = new atr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atr.a(aVar4, atr, bhp.a(aVar4))) {
                        }
                        bdo.sfI = atr;
                    }
                    return 0;
                case 18:
                    bdo.sfJ = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bdo.sfK = aVar3.vHC.rY();
                    return 0;
                case 20:
                    bdo.sfL = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bdo.sfx = aVar3.vHC.readString();
                    return 0;
                case 22:
                    bdo.sfM = aVar3.vHC.rY();
                    return 0;
                case 23:
                    bdo.sfN = aVar3.cJQ();
                    return 0;
                case 24:
                    bdo.rtK = aVar3.vHC.rY();
                    return 0;
                case 25:
                    bdo.seM = aVar3.vHC.readString();
                    return 0;
                case 26:
                    bdo.sfO = aVar3.vHC.readString();
                    return 0;
                case 27:
                    bdo.sfP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
