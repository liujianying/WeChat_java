package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class asa extends bhp {
    public String pRp;
    public String pRq;
    public String pRr;
    public int pRs;
    public String sign;

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
            if (this.pRp != null) {
                aVar.g(2, this.pRp);
            }
            if (this.pRr != null) {
                aVar.g(3, this.pRr);
            }
            if (this.pRq != null) {
                aVar.g(4, this.pRq);
            }
            if (this.sign != null) {
                aVar.g(5, this.sign);
            }
            aVar.fT(6, this.pRs);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.pRp != null) {
                fS += f.a.a.b.b.a.h(2, this.pRp);
            }
            if (this.pRr != null) {
                fS += f.a.a.b.b.a.h(3, this.pRr);
            }
            if (this.pRq != null) {
                fS += f.a.a.b.b.a.h(4, this.pRq);
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(5, this.sign);
            }
            return fS + f.a.a.a.fQ(6, this.pRs);
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
            asa asa = (asa) objArr[1];
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
                        asa.six = flVar;
                    }
                    return 0;
                case 2:
                    asa.pRp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    asa.pRr = aVar3.vHC.readString();
                    return 0;
                case 4:
                    asa.pRq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    asa.sign = aVar3.vHC.readString();
                    return 0;
                case 6:
                    asa.pRs = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
