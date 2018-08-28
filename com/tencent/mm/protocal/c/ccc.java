package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ccc extends a {
    public LinkedList<cbe> sxB = new LinkedList();
    public caz sxO;
    public int syb;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxO == null) {
                throw new b("Not all required fields were included: base_response");
            }
            if (this.sxO != null) {
                aVar.fV(1, this.sxO.boi());
                this.sxO.a(aVar);
            }
            aVar.d(2, 8, this.sxB);
            aVar.fT(3, this.syb);
            return 0;
        } else if (i == 1) {
            if (this.sxO != null) {
                fS = f.a.a.a.fS(1, this.sxO.boi()) + 0;
            } else {
                fS = 0;
            }
            return (fS + f.a.a.a.c(2, 8, this.sxB)) + f.a.a.a.fQ(3, this.syb);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sxB.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sxO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_response");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ccc ccc = (ccc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caz caz = new caz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caz.a(aVar4, caz, a.a(aVar4))) {
                        }
                        ccc.sxO = caz;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cbe cbe = new cbe();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbe.a(aVar4, cbe, a.a(aVar4))) {
                        }
                        ccc.sxB.add(cbe);
                    }
                    return 0;
                case 3:
                    ccc.syb = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
