package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class sr extends bhp {
    public int rci;
    public long rcq;
    public String rdo;
    public int rgC;
    public int rjC;
    public bhy rtW;
    public int rvV;
    public int rvX;
    public int rvY;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.fT(1, this.rci);
                aVar.fT(2, this.rjC);
                aVar.fT(3, this.rvV);
                aVar.fT(5, this.rvX);
                if (this.rdo != null) {
                    aVar.g(6, this.rdo);
                }
                if (this.rtW != null) {
                    aVar.fV(7, this.rtW.boi());
                    this.rtW.a(aVar);
                }
                aVar.fT(8, this.rgC);
                if (this.six != null) {
                    aVar.fV(9, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(10, this.rvY);
                aVar.T(11, this.rcq);
                return 0;
            }
        } else if (i == 1) {
            fQ = (((f.a.a.a.fQ(1, this.rci) + 0) + f.a.a.a.fQ(2, this.rjC)) + f.a.a.a.fQ(3, this.rvV)) + f.a.a.a.fQ(5, this.rvX);
            if (this.rdo != null) {
                fQ += f.a.a.b.b.a.h(6, this.rdo);
            }
            if (this.rtW != null) {
                fQ += f.a.a.a.fS(7, this.rtW.boi());
            }
            fQ += f.a.a.a.fQ(8, this.rgC);
            if (this.six != null) {
                fQ += f.a.a.a.fS(9, this.six.boi());
            }
            return (fQ + f.a.a.a.fQ(10, this.rvY)) + f.a.a.a.S(11, this.rcq);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = bhp.a(aVar2); fQ > 0; fQ = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.six != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sr srVar = (sr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    srVar.rci = aVar3.vHC.rY();
                    return 0;
                case 2:
                    srVar.rjC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    srVar.rvV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    srVar.rvX = aVar3.vHC.rY();
                    return 0;
                case 6:
                    srVar.rdo = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        srVar.rtW = bhy;
                    }
                    return 0;
                case 8:
                    srVar.rgC = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        srVar.six = flVar;
                    }
                    return 0;
                case 10:
                    srVar.rvY = aVar3.vHC.rY();
                    return 0;
                case 11:
                    srVar.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
