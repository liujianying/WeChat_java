package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aag extends bhp {
    public anj rFL;
    public String rFM;
    public ane rFN;
    public int result;

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
            if (this.rFL != null) {
                aVar.fV(2, this.rFL.boi());
                this.rFL.a(aVar);
            }
            if (this.rFM != null) {
                aVar.g(3, this.rFM);
            }
            if (this.rFN != null) {
                aVar.fV(4, this.rFN.boi());
                this.rFN.a(aVar);
            }
            aVar.fT(5, this.result);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rFL != null) {
                fS += f.a.a.a.fS(2, this.rFL.boi());
            }
            if (this.rFM != null) {
                fS += f.a.a.b.b.a.h(3, this.rFM);
            }
            if (this.rFN != null) {
                fS += f.a.a.a.fS(4, this.rFN.boi());
            }
            return fS + f.a.a.a.fQ(5, this.result);
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
            aag aag = (aag) objArr[1];
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
                        aag.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        anj anj = new anj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anj.a(aVar4, anj, bhp.a(aVar4))) {
                        }
                        aag.rFL = anj;
                    }
                    return 0;
                case 3:
                    aag.rFM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ane ane = new ane();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ane.a(aVar4, ane, bhp.a(aVar4))) {
                        }
                        aag.rFN = ane;
                    }
                    return 0;
                case 5:
                    aag.result = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
