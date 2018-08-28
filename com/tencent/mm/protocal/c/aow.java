package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aow extends bhp {
    public String eJK;
    public String qZf;
    public String qZs;
    public aof rRd;
    public String rRf;
    public String rRg;
    public String rRh;
    public int rRi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.rRd != null) {
                aVar.fV(2, this.rRd.boi());
                this.rRd.a(aVar);
            }
            if (this.rRg != null) {
                aVar.g(3, this.rRg);
            }
            if (this.qZs != null) {
                aVar.g(4, this.qZs);
            }
            if (this.qZf != null) {
                aVar.g(5, this.qZf);
            }
            if (this.rRh != null) {
                aVar.g(6, this.rRh);
            }
            aVar.fT(7, this.rRi);
            if (this.rRf != null) {
                aVar.g(8, this.rRf);
            }
            if (this.eJK == null) {
                return 0;
            }
            aVar.g(9, this.eJK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rRd != null) {
                fS += f.a.a.a.fS(2, this.rRd.boi());
            }
            if (this.rRg != null) {
                fS += f.a.a.b.b.a.h(3, this.rRg);
            }
            if (this.qZs != null) {
                fS += f.a.a.b.b.a.h(4, this.qZs);
            }
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(5, this.qZf);
            }
            if (this.rRh != null) {
                fS += f.a.a.b.b.a.h(6, this.rRh);
            }
            fS += f.a.a.a.fQ(7, this.rRi);
            if (this.rRf != null) {
                fS += f.a.a.b.b.a.h(8, this.rRf);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(9, this.eJK);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aow aow = (aow) objArr[1];
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
                        aow.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aof aof = new aof();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aof.a(aVar4, aof, bhp.a(aVar4))) {
                        }
                        aow.rRd = aof;
                    }
                    return 0;
                case 3:
                    aow.rRg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aow.qZs = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aow.qZf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aow.rRh = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aow.rRi = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aow.rRf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aow.eJK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
