package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class sn extends bhp {
    public String hbL;
    public String jQb;
    public int rdV;
    public int rdW;
    public int rdX;
    public bhy rtW;
    public String rvP;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.jQb != null) {
                    aVar.g(2, this.jQb);
                }
                if (this.rvP != null) {
                    aVar.g(3, this.rvP);
                }
                if (this.hbL != null) {
                    aVar.g(4, this.hbL);
                }
                aVar.fT(5, this.rdV);
                aVar.fT(6, this.rdW);
                aVar.fT(7, this.rdX);
                if (this.rtW == null) {
                    return 0;
                }
                aVar.fV(8, this.rtW.boi());
                this.rtW.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.rvP != null) {
                fS += f.a.a.b.b.a.h(3, this.rvP);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(4, this.hbL);
            }
            fS = ((fS + f.a.a.a.fQ(5, this.rdV)) + f.a.a.a.fQ(6, this.rdW)) + f.a.a.a.fQ(7, this.rdX);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(8, this.rtW.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rtW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sn snVar = (sn) objArr[1];
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
                        snVar.six = flVar;
                    }
                    return 0;
                case 2:
                    snVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    snVar.rvP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    snVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    snVar.rdV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    snVar.rdW = aVar3.vHC.rY();
                    return 0;
                case 7:
                    snVar.rdX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        snVar.rtW = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
