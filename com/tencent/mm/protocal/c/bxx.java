package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bxx extends bhd {
    public int lOM;
    public String rem;
    public String sdK;
    public String sdL;
    public int sdM;
    public String sdN;
    public bhy stX;
    public int stY;
    public int stZ;
    public String sua;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.stX == null) {
                throw new b("Not all required fields were included: Receipt");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.stX != null) {
                aVar.fV(2, this.stX.boi());
                this.stX.a(aVar);
            }
            if (this.rem != null) {
                aVar.g(3, this.rem);
            }
            aVar.fT(4, this.stY);
            aVar.fT(5, this.lOM);
            if (this.sdK != null) {
                aVar.g(6, this.sdK);
            }
            if (this.sdL != null) {
                aVar.g(7, this.sdL);
            }
            if (this.sdN != null) {
                aVar.g(8, this.sdN);
            }
            aVar.fT(9, this.stZ);
            if (this.sua != null) {
                aVar.g(10, this.sua);
            }
            aVar.fT(11, this.sdM);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.stX != null) {
                fS += f.a.a.a.fS(2, this.stX.boi());
            }
            if (this.rem != null) {
                fS += f.a.a.b.b.a.h(3, this.rem);
            }
            fS = (fS + f.a.a.a.fQ(4, this.stY)) + f.a.a.a.fQ(5, this.lOM);
            if (this.sdK != null) {
                fS += f.a.a.b.b.a.h(6, this.sdK);
            }
            if (this.sdL != null) {
                fS += f.a.a.b.b.a.h(7, this.sdL);
            }
            if (this.sdN != null) {
                fS += f.a.a.b.b.a.h(8, this.sdN);
            }
            fS += f.a.a.a.fQ(9, this.stZ);
            if (this.sua != null) {
                fS += f.a.a.b.b.a.h(10, this.sua);
            }
            return fS + f.a.a.a.fQ(11, this.sdM);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.stX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Receipt");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bxx bxx = (bxx) objArr[1];
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
                        bxx.shX = fkVar;
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
                        bxx.stX = bhy;
                    }
                    return 0;
                case 3:
                    bxx.rem = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bxx.stY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bxx.lOM = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bxx.sdK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bxx.sdL = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bxx.sdN = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bxx.stZ = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bxx.sua = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bxx.sdM = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
