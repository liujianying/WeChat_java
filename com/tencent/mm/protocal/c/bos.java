package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bos extends bhp {
    public int hcE;
    public int rdV;
    public int rdW;
    public bhy rfy;
    public String smD;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rfy == null) {
                throw new b("Not all required fields were included: Buffer");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rdW);
                aVar.fT(3, this.rdV);
                if (this.rfy != null) {
                    aVar.fV(4, this.rfy.boi());
                    this.rfy.a(aVar);
                }
                if (this.smD != null) {
                    aVar.g(5, this.smD);
                }
                aVar.fT(6, this.hcE);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV);
            if (this.rfy != null) {
                fS += f.a.a.a.fS(4, this.rfy.boi());
            }
            if (this.smD != null) {
                fS += f.a.a.b.b.a.h(5, this.smD);
            }
            return fS + f.a.a.a.fQ(6, this.hcE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rfy != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bos bos = (bos) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bos.six = flVar;
                    }
                    return 0;
                case 2:
                    bos.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bos.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bos.rfy = bhy;
                    }
                    return 0;
                case 5:
                    bos.smD = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bos.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
