package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class adh extends bhp {
    public int rHB;
    public LinkedList<ts> rHC = new LinkedList();
    public th rHD;
    public int rHE;
    public LinkedList<th> rHF = new LinkedList();
    public int rHG;
    public LinkedList<tl> rHH = new LinkedList();
    public int rHI;
    public LinkedList<tj> rHJ = new LinkedList();
    public int rHK;
    public int rHL;
    public int rHM;
    public LinkedList<tj> rHN = new LinkedList();
    public bhy rcT;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rcT == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rcT != null) {
                    aVar.fV(2, this.rcT.boi());
                    this.rcT.a(aVar);
                }
                aVar.fT(3, this.rHB);
                aVar.d(4, 8, this.rHC);
                if (this.rHD != null) {
                    aVar.fV(5, this.rHD.boi());
                    this.rHD.a(aVar);
                }
                aVar.fT(6, this.rHE);
                aVar.d(7, 8, this.rHF);
                aVar.fT(8, this.rHG);
                aVar.d(9, 8, this.rHH);
                aVar.fT(10, this.rHI);
                aVar.d(11, 8, this.rHJ);
                aVar.fT(12, this.rHK);
                aVar.fT(13, this.rHL);
                aVar.fT(14, this.rHM);
                aVar.d(15, 8, this.rHN);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcT != null) {
                fS += f.a.a.a.fS(2, this.rcT.boi());
            }
            fS = (fS + f.a.a.a.fQ(3, this.rHB)) + f.a.a.a.c(4, 8, this.rHC);
            if (this.rHD != null) {
                fS += f.a.a.a.fS(5, this.rHD.boi());
            }
            return (((((((((fS + f.a.a.a.fQ(6, this.rHE)) + f.a.a.a.c(7, 8, this.rHF)) + f.a.a.a.fQ(8, this.rHG)) + f.a.a.a.c(9, 8, this.rHH)) + f.a.a.a.fQ(10, this.rHI)) + f.a.a.a.c(11, 8, this.rHJ)) + f.a.a.a.fQ(12, this.rHK)) + f.a.a.a.fQ(13, this.rHL)) + f.a.a.a.fQ(14, this.rHM)) + f.a.a.a.c(15, 8, this.rHN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHC.clear();
            this.rHF.clear();
            this.rHH.clear();
            this.rHJ.clear();
            this.rHN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rcT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            adh adh = (adh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            th thVar;
            tj tjVar;
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
                        adh.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        adh.rcT = bhy;
                    }
                    return 0;
                case 3:
                    adh.rHB = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ts tsVar = new ts();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tsVar.a(aVar4, tsVar, bhp.a(aVar4))) {
                        }
                        adh.rHC.add(tsVar);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        thVar = new th();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = thVar.a(aVar4, thVar, bhp.a(aVar4))) {
                        }
                        adh.rHD = thVar;
                    }
                    return 0;
                case 6:
                    adh.rHE = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        thVar = new th();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = thVar.a(aVar4, thVar, bhp.a(aVar4))) {
                        }
                        adh.rHF.add(thVar);
                    }
                    return 0;
                case 8:
                    adh.rHG = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tl tlVar = new tl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tlVar.a(aVar4, tlVar, bhp.a(aVar4))) {
                        }
                        adh.rHH.add(tlVar);
                    }
                    return 0;
                case 10:
                    adh.rHI = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tjVar = new tj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tjVar.a(aVar4, tjVar, bhp.a(aVar4))) {
                        }
                        adh.rHJ.add(tjVar);
                    }
                    return 0;
                case 12:
                    adh.rHK = aVar3.vHC.rY();
                    return 0;
                case 13:
                    adh.rHL = aVar3.vHC.rY();
                    return 0;
                case 14:
                    adh.rHM = aVar3.vHC.rY();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tjVar = new tj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tjVar.a(aVar4, tjVar, bhp.a(aVar4))) {
                        }
                        adh.rHN.add(tjVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
