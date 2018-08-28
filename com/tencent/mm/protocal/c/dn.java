package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class dn extends a {
    public int rdH;
    public int rdI;
    public int rdP;
    public do rdQ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rdH);
            aVar.fT(2, this.rdI);
            aVar.fT(3, this.rdP);
            if (this.rdQ != null) {
                aVar.fV(4, this.rdQ.boi());
                this.rdQ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rdH) + 0) + f.a.a.a.fQ(2, this.rdI)) + f.a.a.a.fQ(3, this.rdP);
            if (this.rdQ != null) {
                return fQ + f.a.a.a.fS(4, this.rdQ.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dn dnVar = (dn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dnVar.rdH = aVar3.vHC.rY();
                    return 0;
                case 2:
                    dnVar.rdI = aVar3.vHC.rY();
                    return 0;
                case 3:
                    dnVar.rdP = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        do doVar = new do();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = doVar.a(aVar4, doVar, a.a(aVar4))) {
                        }
                        dnVar.rdQ = doVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
