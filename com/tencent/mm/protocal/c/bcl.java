package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bcl extends bhp {
    public int iwS;
    public String iwT;
    public int kpJ;
    public int kpu;
    public String kpv;
    public int rxG;
    public long rxH;
    public int seD;
    public int seF;
    public int seG;

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
            aVar.fT(3, this.rxG);
            aVar.T(4, this.rxH);
            aVar.fT(5, this.seF);
            aVar.fT(6, this.seD);
            aVar.fT(7, this.kpJ);
            aVar.fT(8, this.seG);
            aVar.fT(9, this.iwS);
            if (this.iwT != null) {
                aVar.g(10, this.iwT);
            }
            aVar.fT(11, this.kpu);
            if (this.kpv == null) {
                return 0;
            }
            aVar.g(12, this.kpv);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((fS + f.a.a.a.fQ(3, this.rxG)) + f.a.a.a.S(4, this.rxH)) + f.a.a.a.fQ(5, this.seF)) + f.a.a.a.fQ(6, this.seD)) + f.a.a.a.fQ(7, this.kpJ)) + f.a.a.a.fQ(8, this.seG)) + f.a.a.a.fQ(9, this.iwS);
            if (this.iwT != null) {
                fS += f.a.a.b.b.a.h(10, this.iwT);
            }
            fS += f.a.a.a.fQ(11, this.kpu);
            if (this.kpv != null) {
                fS += f.a.a.b.b.a.h(12, this.kpv);
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
            bcl bcl = (bcl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bcl.six = flVar;
                    }
                    return 0;
                case 3:
                    bcl.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bcl.rxH = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bcl.seF = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bcl.seD = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bcl.kpJ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bcl.seG = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bcl.iwS = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bcl.iwT = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bcl.kpu = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bcl.kpv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
