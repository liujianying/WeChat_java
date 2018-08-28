package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bym extends bhd {
    public String hbL;
    public int rdY;
    public int reb;
    public int rgC;
    public int rjC;
    public bhy rtW;
    public String sso;
    public int ssp;
    public int ssq;
    public int sut;
    public int suu;
    public LinkedList<bhz> suv = new LinkedList();
    public LinkedList<bhy> suw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            if (this.rtW != null) {
                aVar.fV(3, this.rtW.boi());
                this.rtW.a(aVar);
            }
            aVar.fT(4, this.rjC);
            if (this.sso != null) {
                aVar.g(5, this.sso);
            }
            aVar.fT(6, this.rgC);
            aVar.fT(7, this.ssp);
            aVar.fT(8, this.reb);
            aVar.fT(9, this.ssq);
            aVar.fT(10, this.rdY);
            aVar.fT(11, this.sut);
            aVar.fT(12, this.suu);
            aVar.d(13, 8, this.suv);
            aVar.d(14, 8, this.suw);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(2, this.hbL);
            }
            if (this.rtW != null) {
                fS += f.a.a.a.fS(3, this.rtW.boi());
            }
            fS += f.a.a.a.fQ(4, this.rjC);
            if (this.sso != null) {
                fS += f.a.a.b.b.a.h(5, this.sso);
            }
            return ((((((((fS + f.a.a.a.fQ(6, this.rgC)) + f.a.a.a.fQ(7, this.ssp)) + f.a.a.a.fQ(8, this.reb)) + f.a.a.a.fQ(9, this.ssq)) + f.a.a.a.fQ(10, this.rdY)) + f.a.a.a.fQ(11, this.sut)) + f.a.a.a.fQ(12, this.suu)) + f.a.a.a.c(13, 8, this.suv)) + f.a.a.a.c(14, 8, this.suw);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.suv.clear();
            this.suw.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bym bym = (bym) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
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
                        bym.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bym.hbL = aVar3.vHC.readString();
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
                        bym.rtW = bhy;
                    }
                    return 0;
                case 4:
                    bym.rjC = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bym.sso = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bym.rgC = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bym.ssp = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bym.reb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bym.ssq = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bym.rdY = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bym.sut = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bym.suu = aVar3.vHC.rY();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bym.suv.add(bhz);
                    }
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bym.suw.add(bhy);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
