package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cbr extends a {
    public LinkedList<cbe> sxB = new LinkedList();
    public cay sxM;
    public int sxN;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxM == null) {
                throw new b("Not all required fields were included: base_request");
            }
            if (this.sxM != null) {
                aVar.fV(1, this.sxM.boi());
                this.sxM.a(aVar);
            }
            aVar.d(2, 8, this.sxB);
            aVar.fT(3, this.sxN);
            return 0;
        } else if (i == 1) {
            if (this.sxM != null) {
                fS = f.a.a.a.fS(1, this.sxM.boi()) + 0;
            } else {
                fS = 0;
            }
            return (fS + f.a.a.a.c(2, 8, this.sxB)) + f.a.a.a.fQ(3, this.sxN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sxB.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sxM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_request");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cbr cbr = (cbr) objArr[1];
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
                        cay cay = new cay();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cay.a(aVar4, cay, a.a(aVar4))) {
                        }
                        cbr.sxM = cay;
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
                        cbr.sxB.add(cbe);
                    }
                    return 0;
                case 3:
                    cbr.sxN = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
