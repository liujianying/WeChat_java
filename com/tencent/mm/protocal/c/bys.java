package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bys extends bhd {
    public int rgC;
    public int rjC;
    public int rko;
    public bhy rtW;
    public bhz shU;
    public String sso;
    public int ssq;
    public int suC;
    public LinkedList<bhz> suD = new LinkedList();
    public int suE;

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
            if (this.rtW != null) {
                aVar.fV(2, this.rtW.boi());
                this.rtW.a(aVar);
            }
            aVar.fT(3, this.rjC);
            if (this.sso != null) {
                aVar.g(4, this.sso);
            }
            aVar.fT(5, this.rgC);
            aVar.fT(6, this.ssq);
            aVar.fT(7, this.rko);
            aVar.fT(8, this.suC);
            aVar.d(9, 8, this.suD);
            if (this.shU != null) {
                aVar.fV(10, this.shU.boi());
                this.shU.a(aVar);
            }
            aVar.fT(11, this.suE);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rtW != null) {
                fS += f.a.a.a.fS(2, this.rtW.boi());
            }
            fS += f.a.a.a.fQ(3, this.rjC);
            if (this.sso != null) {
                fS += f.a.a.b.b.a.h(4, this.sso);
            }
            fS = ((((fS + f.a.a.a.fQ(5, this.rgC)) + f.a.a.a.fQ(6, this.ssq)) + f.a.a.a.fQ(7, this.rko)) + f.a.a.a.fQ(8, this.suC)) + f.a.a.a.c(9, 8, this.suD);
            if (this.shU != null) {
                fS += f.a.a.a.fS(10, this.shU.boi());
            }
            return fS + f.a.a.a.fQ(11, this.suE);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.suD.clear();
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
            bys bys = (bys) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
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
                        bys.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bys.rtW = bhy;
                    }
                    return 0;
                case 3:
                    bys.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bys.sso = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bys.rgC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bys.ssq = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bys.rko = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bys.suC = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bys.suD.add(bhz);
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bys.shU = bhz;
                    }
                    return 0;
                case 11:
                    bys.suE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
