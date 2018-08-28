package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bsq extends bhd {
    public int rPs;
    public int rPt;
    public bhy rPu;
    public bhy scR;
    public String sign;
    public String spW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rPu == null) {
                throw new b("Not all required fields were included: ReqText");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rPs);
            aVar.fT(3, this.rPt);
            if (this.rPu != null) {
                aVar.fV(4, this.rPu.boi());
                this.rPu.a(aVar);
            }
            if (this.scR != null) {
                aVar.fV(5, this.scR.boi());
                this.scR.a(aVar);
            }
            if (this.sign != null) {
                aVar.g(6, this.sign);
            }
            if (this.spW == null) {
                return 0;
            }
            aVar.g(7, this.spW);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rPs)) + f.a.a.a.fQ(3, this.rPt);
            if (this.rPu != null) {
                fS += f.a.a.a.fS(4, this.rPu.boi());
            }
            if (this.scR != null) {
                fS += f.a.a.a.fS(5, this.scR.boi());
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(6, this.sign);
            }
            if (this.spW != null) {
                fS += f.a.a.b.b.a.h(7, this.spW);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rPu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqText");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bsq bsq = (bsq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        bsq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bsq.rPs = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bsq.rPt = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bsq.rPu = bhy;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bsq.scR = bhy;
                    }
                    return 0;
                case 6:
                    bsq.sign = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bsq.spW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
