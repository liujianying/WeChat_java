package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwa extends bhd {
    public String hbL;
    public int rdY;
    public int reb;
    public int rgC;
    public int rjC;
    public bhy rtW;
    public String sso;
    public int ssp;
    public int ssq;

    protected final int a(int i, Object... objArr) {
        int fS;
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
            return ((((fS + f.a.a.a.fQ(6, this.rgC)) + f.a.a.a.fQ(7, this.ssp)) + f.a.a.a.fQ(8, this.reb)) + f.a.a.a.fQ(9, this.ssq)) + f.a.a.a.fQ(10, this.rdY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bwa bwa = (bwa) objArr[1];
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
                        bwa.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bwa.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwa.rtW = bhy;
                    }
                    return 0;
                case 4:
                    bwa.rjC = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bwa.sso = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bwa.rgC = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bwa.ssp = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bwa.reb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bwa.ssq = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bwa.rdY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
