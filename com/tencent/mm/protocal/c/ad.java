package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ad extends bhp {
    public int qZA;
    public int qZk;
    public String qZl;
    public bnr qZm;
    public bfw qZn;
    public int qZu;
    public pv qZy;
    public boolean qZz;

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
            if (this.qZl != null) {
                aVar.g(3, this.qZl);
            }
            if (this.qZm != null) {
                aVar.fV(4, this.qZm.boi());
                this.qZm.a(aVar);
            }
            if (this.qZn != null) {
                aVar.fV(5, this.qZn.boi());
                this.qZn.a(aVar);
            }
            aVar.fT(6, this.qZu);
            if (this.qZy != null) {
                aVar.fV(7, this.qZy.boi());
                this.qZy.a(aVar);
            }
            aVar.av(8, this.qZz);
            aVar.fT(9, this.qZA);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.qZk);
            if (this.qZl != null) {
                fS += f.a.a.b.b.a.h(3, this.qZl);
            }
            if (this.qZm != null) {
                fS += f.a.a.a.fS(4, this.qZm.boi());
            }
            if (this.qZn != null) {
                fS += f.a.a.a.fS(5, this.qZn.boi());
            }
            fS += f.a.a.a.fQ(6, this.qZu);
            if (this.qZy != null) {
                fS += f.a.a.a.fS(7, this.qZy.boi());
            }
            return (fS + (f.a.a.b.b.a.ec(8) + 1)) + f.a.a.a.fQ(9, this.qZA);
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
            ad adVar = (ad) objArr[1];
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
                        adVar.six = flVar;
                    }
                    return 0;
                case 2:
                    adVar.qZk = aVar3.vHC.rY();
                    return 0;
                case 3:
                    adVar.qZl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnr bnr = new bnr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnr.a(aVar4, bnr, bhp.a(aVar4))) {
                        }
                        adVar.qZm = bnr;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfw bfw = new bfw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfw.a(aVar4, bfw, bhp.a(aVar4))) {
                        }
                        adVar.qZn = bfw;
                    }
                    return 0;
                case 6:
                    adVar.qZu = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pv pvVar = new pv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pvVar.a(aVar4, pvVar, bhp.a(aVar4))) {
                        }
                        adVar.qZy = pvVar;
                    }
                    return 0;
                case 8:
                    adVar.qZz = aVar3.cJQ();
                    return 0;
                case 9:
                    adVar.qZA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
