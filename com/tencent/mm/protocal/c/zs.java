package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class zs extends bhp {
    public ep jng;
    public int qZg;
    public int qZk;
    public String qZl;
    public bnr qZm;
    public int qZu;

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
            aVar.fT(2, this.qZk);
            aVar.fT(3, this.qZu);
            if (this.qZl != null) {
                aVar.g(4, this.qZl);
            }
            if (this.qZm != null) {
                aVar.fV(5, this.qZm.boi());
                this.qZm.a(aVar);
            }
            if (this.jng != null) {
                aVar.fV(6, this.jng.boi());
                this.jng.a(aVar);
            }
            aVar.fT(7, this.qZg);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.qZk)) + f.a.a.a.fQ(3, this.qZu);
            if (this.qZl != null) {
                fS += f.a.a.b.b.a.h(4, this.qZl);
            }
            if (this.qZm != null) {
                fS += f.a.a.a.fS(5, this.qZm.boi());
            }
            if (this.jng != null) {
                fS += f.a.a.a.fS(6, this.jng.boi());
            }
            return fS + f.a.a.a.fQ(7, this.qZg);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
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
            zs zsVar = (zs) objArr[1];
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
                        com.tencent.mm.bk.a flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zsVar.six = flVar;
                    }
                    return 0;
                case 2:
                    zsVar.qZk = aVar3.vHC.rY();
                    return 0;
                case 3:
                    zsVar.qZu = aVar3.vHC.rY();
                    return 0;
                case 4:
                    zsVar.qZl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnr bnr = new bnr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnr.a(aVar4, bnr, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zsVar.qZm = bnr;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ep epVar = new ep();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = epVar.a(aVar4, epVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zsVar.jng = epVar;
                    }
                    return 0;
                case 7:
                    zsVar.qZg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
