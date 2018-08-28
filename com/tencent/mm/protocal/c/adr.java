package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class adr extends bhp {
    public long hcc;
    public int rIb;
    public int rIc;
    public int rId;
    public long rcg;

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
            aVar.T(2, this.rcg);
            aVar.T(3, this.hcc);
            aVar.fT(4, this.rIb);
            aVar.fT(5, this.rIc);
            aVar.fT(6, this.rId);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((fS + f.a.a.a.S(2, this.rcg)) + f.a.a.a.S(3, this.hcc)) + f.a.a.a.fQ(4, this.rIb)) + f.a.a.a.fQ(5, this.rIc)) + f.a.a.a.fQ(6, this.rId);
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
            adr adr = (adr) objArr[1];
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
                        adr.six = flVar;
                    }
                    return 0;
                case 2:
                    adr.rcg = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    adr.hcc = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    adr.rIb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    adr.rIc = aVar3.vHC.rY();
                    return 0;
                case 6:
                    adr.rId = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
