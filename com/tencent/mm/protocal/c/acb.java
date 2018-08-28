package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class acb extends bhp {
    public int hcd;
    public int rGF;
    public int rGG;
    public int rGH;
    public int rGI;
    public String rGJ;
    public int rGK;

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
            aVar.fT(2, this.hcd);
            aVar.fT(3, this.rGF);
            aVar.fT(4, this.rGG);
            aVar.fT(5, this.rGH);
            aVar.fT(6, this.rGI);
            if (this.rGJ != null) {
                aVar.g(7, this.rGJ);
            }
            aVar.fT(8, this.rGK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.hcd)) + f.a.a.a.fQ(3, this.rGF)) + f.a.a.a.fQ(4, this.rGG)) + f.a.a.a.fQ(5, this.rGH)) + f.a.a.a.fQ(6, this.rGI);
            if (this.rGJ != null) {
                fS += f.a.a.b.b.a.h(7, this.rGJ);
            }
            return fS + f.a.a.a.fQ(8, this.rGK);
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
            acb acb = (acb) objArr[1];
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
                        acb.six = flVar;
                    }
                    return 0;
                case 2:
                    acb.hcd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    acb.rGF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    acb.rGG = aVar3.vHC.rY();
                    return 0;
                case 5:
                    acb.rGH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    acb.rGI = aVar3.vHC.rY();
                    return 0;
                case 7:
                    acb.rGJ = aVar3.vHC.readString();
                    return 0;
                case 8:
                    acb.rGK = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
