package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class yo extends bhd {
    public String hbL;
    public int otY;
    public int qZc;
    public int rEA;
    public bhy rEB;
    public bhz rEn;
    public bhz rEo;
    public bhz rEp;
    public bhz rEq;
    public String rEr;
    public int rEs;
    public String rEt;
    public bhy rEu;
    public int rEv;
    public int rEw;
    public String rEx;
    public int rEy;
    public String rEz;
    public int rbZ;
    public bhy reB;
    public int rrv;
    public int rrw;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.qZc);
            if (this.reB != null) {
                aVar.fV(3, this.reB.boi());
                this.reB.a(aVar);
            }
            if (this.rEn != null) {
                aVar.fV(4, this.rEn.boi());
                this.rEn.a(aVar);
            }
            if (this.rEo != null) {
                aVar.fV(5, this.rEo.boi());
                this.rEo.a(aVar);
            }
            if (this.rEp != null) {
                aVar.fV(6, this.rEp.boi());
                this.rEp.a(aVar);
            }
            if (this.rEq != null) {
                aVar.fV(7, this.rEq.boi());
                this.rEq.a(aVar);
            }
            if (this.rEr != null) {
                aVar.g(8, this.rEr);
            }
            aVar.fT(9, this.rEs);
            aVar.fT(10, this.otY);
            if (this.hbL != null) {
                aVar.g(11, this.hbL);
            }
            if (this.rEt != null) {
                aVar.g(12, this.rEt);
            }
            if (this.rEu != null) {
                aVar.fV(13, this.rEu.boi());
                this.rEu.a(aVar);
            }
            aVar.fT(14, this.rEv);
            aVar.fT(15, this.rEw);
            aVar.fT(16, this.rbZ);
            if (this.rEx != null) {
                aVar.g(17, this.rEx);
            }
            aVar.fT(18, this.rrv);
            aVar.fT(19, this.rrw);
            aVar.fT(20, this.rEy);
            if (this.rEz != null) {
                aVar.g(21, this.rEz);
            }
            aVar.fT(22, this.rEA);
            if (this.rEB == null) {
                return 0;
            }
            aVar.fV(23, this.rEB.boi());
            this.rEB.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.qZc);
            if (this.reB != null) {
                fS += f.a.a.a.fS(3, this.reB.boi());
            }
            if (this.rEn != null) {
                fS += f.a.a.a.fS(4, this.rEn.boi());
            }
            if (this.rEo != null) {
                fS += f.a.a.a.fS(5, this.rEo.boi());
            }
            if (this.rEp != null) {
                fS += f.a.a.a.fS(6, this.rEp.boi());
            }
            if (this.rEq != null) {
                fS += f.a.a.a.fS(7, this.rEq.boi());
            }
            if (this.rEr != null) {
                fS += f.a.a.b.b.a.h(8, this.rEr);
            }
            fS = (fS + f.a.a.a.fQ(9, this.rEs)) + f.a.a.a.fQ(10, this.otY);
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(11, this.hbL);
            }
            if (this.rEt != null) {
                fS += f.a.a.b.b.a.h(12, this.rEt);
            }
            if (this.rEu != null) {
                fS += f.a.a.a.fS(13, this.rEu.boi());
            }
            fS = ((fS + f.a.a.a.fQ(14, this.rEv)) + f.a.a.a.fQ(15, this.rEw)) + f.a.a.a.fQ(16, this.rbZ);
            if (this.rEx != null) {
                fS += f.a.a.b.b.a.h(17, this.rEx);
            }
            fS = ((fS + f.a.a.a.fQ(18, this.rrv)) + f.a.a.a.fQ(19, this.rrw)) + f.a.a.a.fQ(20, this.rEy);
            if (this.rEz != null) {
                fS += f.a.a.b.b.a.h(21, this.rEz);
            }
            fS += f.a.a.a.fQ(22, this.rEA);
            if (this.rEB != null) {
                fS += f.a.a.a.fS(23, this.rEB.boi());
            }
            return fS;
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
            yo yoVar = (yo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            bhz bhz;
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
                        yoVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    yoVar.qZc = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        yoVar.reB = bhy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        yoVar.rEn = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        yoVar.rEo = bhz;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        yoVar.rEp = bhz;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        yoVar.rEq = bhz;
                    }
                    return 0;
                case 8:
                    yoVar.rEr = aVar3.vHC.readString();
                    return 0;
                case 9:
                    yoVar.rEs = aVar3.vHC.rY();
                    return 0;
                case 10:
                    yoVar.otY = aVar3.vHC.rY();
                    return 0;
                case 11:
                    yoVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 12:
                    yoVar.rEt = aVar3.vHC.readString();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        yoVar.rEu = bhy;
                    }
                    return 0;
                case 14:
                    yoVar.rEv = aVar3.vHC.rY();
                    return 0;
                case 15:
                    yoVar.rEw = aVar3.vHC.rY();
                    return 0;
                case 16:
                    yoVar.rbZ = aVar3.vHC.rY();
                    return 0;
                case 17:
                    yoVar.rEx = aVar3.vHC.readString();
                    return 0;
                case 18:
                    yoVar.rrv = aVar3.vHC.rY();
                    return 0;
                case 19:
                    yoVar.rrw = aVar3.vHC.rY();
                    return 0;
                case 20:
                    yoVar.rEy = aVar3.vHC.rY();
                    return 0;
                case 21:
                    yoVar.rEz = aVar3.vHC.readString();
                    return 0;
                case 22:
                    yoVar.rEA = aVar3.vHC.rY();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        yoVar.rEB = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
