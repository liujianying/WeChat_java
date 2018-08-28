package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwr extends bhp {
    public int rVq;
    public int rci;
    public long rcq;
    public String rdo;
    public String rmy;
    public int ssR;

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
            if (this.rdo != null) {
                aVar.g(2, this.rdo);
            }
            aVar.fT(3, this.rci);
            aVar.fT(4, this.rVq);
            aVar.fT(5, this.ssR);
            aVar.T(6, this.rcq);
            if (this.rmy == null) {
                return 0;
            }
            aVar.g(7, this.rmy);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rdo != null) {
                fS += f.a.a.b.b.a.h(2, this.rdo);
            }
            fS = (((fS + f.a.a.a.fQ(3, this.rci)) + f.a.a.a.fQ(4, this.rVq)) + f.a.a.a.fQ(5, this.ssR)) + f.a.a.a.S(6, this.rcq);
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(7, this.rmy);
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
            bwr bwr = (bwr) objArr[1];
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
                        bwr.six = flVar;
                    }
                    return 0;
                case 2:
                    bwr.rdo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwr.rci = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bwr.rVq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bwr.ssR = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bwr.rcq = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    bwr.rmy = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
