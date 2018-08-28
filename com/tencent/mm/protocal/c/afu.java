package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class afu extends bhd {
    public int otY;
    public int qZc;
    public String rDH;
    public bhy rIW;
    public int rIY;
    public double rJG;
    public double rJH;
    public double rji;
    public double rjj;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rIW == null) {
                throw new b("Not all required fields were included: Buff");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.otY);
            aVar.fT(3, this.qZc);
            if (this.rDH != null) {
                aVar.g(4, this.rDH);
            }
            if (this.rIW != null) {
                aVar.fV(5, this.rIW.boi());
                this.rIW.a(aVar);
            }
            aVar.c(6, this.rji);
            aVar.c(7, this.rjj);
            aVar.c(8, this.rJG);
            aVar.c(9, this.rJH);
            aVar.fT(10, this.rIY);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.otY)) + f.a.a.a.fQ(3, this.qZc);
            if (this.rDH != null) {
                fS += f.a.a.b.b.a.h(4, this.rDH);
            }
            if (this.rIW != null) {
                fS += f.a.a.a.fS(5, this.rIW.boi());
            }
            return ((((fS + (f.a.a.b.b.a.ec(6) + 8)) + (f.a.a.b.b.a.ec(7) + 8)) + (f.a.a.b.b.a.ec(8) + 8)) + (f.a.a.b.b.a.ec(9) + 8)) + f.a.a.a.fQ(10, this.rIY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rIW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buff");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            afu afu = (afu) objArr[1];
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
                        afu.shX = fkVar;
                    }
                    return 0;
                case 2:
                    afu.otY = aVar3.vHC.rY();
                    return 0;
                case 3:
                    afu.qZc = aVar3.vHC.rY();
                    return 0;
                case 4:
                    afu.rDH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        afu.rIW = bhy;
                    }
                    return 0;
                case 6:
                    afu.rji = aVar3.vHC.readDouble();
                    return 0;
                case 7:
                    afu.rjj = aVar3.vHC.readDouble();
                    return 0;
                case 8:
                    afu.rJG = aVar3.vHC.readDouble();
                    return 0;
                case 9:
                    afu.rJH = aVar3.vHC.readDouble();
                    return 0;
                case 10:
                    afu.rIY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
