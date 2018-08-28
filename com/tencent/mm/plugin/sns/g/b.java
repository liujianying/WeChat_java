package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bk.a;
import com.tencent.mm.protocal.c.ate;
import java.util.LinkedList;

public final class b extends a {
    public ate caK;
    public int dTR;
    public String nuP;
    public int nuQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.caK != null) {
                aVar.fV(1, this.caK.boi());
                this.caK.a(aVar);
            }
            if (this.nuP != null) {
                aVar.g(2, this.nuP);
            }
            aVar.fT(3, this.dTR);
            aVar.fT(4, this.nuQ);
            return 0;
        } else if (i == 1) {
            if (this.caK != null) {
                fS = f.a.a.a.fS(1, this.caK.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.nuP != null) {
                fS += f.a.a.b.b.a.h(2, this.nuP);
            }
            return (fS + f.a.a.a.fQ(3, this.dTR)) + f.a.a.a.fQ(4, this.nuQ);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ate ate = new ate();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ate.a(aVar4, ate, a.a(aVar4))) {
                        }
                        bVar.caK = ate;
                    }
                    return 0;
                case 2:
                    bVar.nuP = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.dTR = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bVar.nuQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
