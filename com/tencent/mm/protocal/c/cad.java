package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cad extends bhd {
    public int rth;
    public int rxG;
    public long rxH;
    public String seC;
    public int sef;
    public int soz;
    public cak suK;
    public cak suL;
    public long suO;
    public int svK;
    public int svV;
    public LinkedList<bhz> svW = new LinkedList();
    public int svX;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.suK == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.suL == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.seC != null) {
                    aVar.g(2, this.seC);
                }
                aVar.fT(3, this.svV);
                aVar.d(4, 8, this.svW);
                if (this.suK != null) {
                    aVar.fV(6, this.suK.boi());
                    this.suK.a(aVar);
                }
                if (this.suL != null) {
                    aVar.fV(7, this.suL.boi());
                    this.suL.a(aVar);
                }
                aVar.fT(8, this.rth);
                aVar.fT(9, this.soz);
                aVar.fT(10, this.rxG);
                aVar.T(11, this.rxH);
                aVar.fT(12, this.svK);
                aVar.T(13, this.suO);
                aVar.fT(14, this.svX);
                aVar.fT(15, this.sef);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.seC != null) {
                fS += f.a.a.b.b.a.h(2, this.seC);
            }
            fS = (fS + f.a.a.a.fQ(3, this.svV)) + f.a.a.a.c(4, 8, this.svW);
            if (this.suK != null) {
                fS += f.a.a.a.fS(6, this.suK.boi());
            }
            if (this.suL != null) {
                fS += f.a.a.a.fS(7, this.suL.boi());
            }
            return (((((((fS + f.a.a.a.fQ(8, this.rth)) + f.a.a.a.fQ(9, this.soz)) + f.a.a.a.fQ(10, this.rxG)) + f.a.a.a.S(11, this.rxH)) + f.a.a.a.fQ(12, this.svK)) + f.a.a.a.S(13, this.suO)) + f.a.a.a.fQ(14, this.svX)) + f.a.a.a.fQ(15, this.sef);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.svW.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.suK == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.suL != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cad cad = (cad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
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
                        cad.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cad.seC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cad.svV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        cad.svW.add(bhz);
                    }
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
                        cad.suK = cak;
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
                        cad.suL = cak;
                    }
                    return 0;
                case 8:
                    cad.rth = aVar3.vHC.rY();
                    return 0;
                case 9:
                    cad.soz = aVar3.vHC.rY();
                    return 0;
                case 10:
                    cad.rxG = aVar3.vHC.rY();
                    return 0;
                case 11:
                    cad.rxH = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    cad.svK = aVar3.vHC.rY();
                    return 0;
                case 13:
                    cad.suO = aVar3.vHC.rZ();
                    return 0;
                case 14:
                    cad.svX = aVar3.vHC.rY();
                    return 0;
                case 15:
                    cad.sef = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
