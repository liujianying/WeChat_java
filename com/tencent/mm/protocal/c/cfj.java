package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cfj extends bhp {
    public int rjC;
    public String rjK;
    public int syR;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.syR);
            aVar.fT(3, this.rjC);
            if (this.rjK == null) {
                return 0;
            }
            aVar.g(4, this.rjK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.syR)) + f.a.a.a.fQ(3, this.rjC);
            if (this.rjK != null) {
                fS += f.a.a.b.b.a.h(4, this.rjK);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfj cfj = (cfj) objArr[1];
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
                        cfj.six = flVar;
                    }
                    return 0;
                case 2:
                    cfj.syR = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfj.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cfj.rjK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
