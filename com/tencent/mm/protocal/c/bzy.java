package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzy extends bhp {
    public int rZq;
    public int rxG;
    public long rxH;
    public int seq;
    public int svR;

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
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.seq);
            aVar.fT(5, this.rZq);
            aVar.fT(6, this.svR);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.seq)) + f.a.a.a.fQ(5, this.rZq)) + f.a.a.a.fQ(6, this.svR);
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
            bzy bzy = (bzy) objArr[1];
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
                        bzy.six = flVar;
                    }
                    return 0;
                case 2:
                    bzy.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bzy.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bzy.seq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzy.rZq = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bzy.svR = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
