package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bk extends a {
    public apy rbM;
    public LinkedList<apz> rbN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rbM == null) {
                throw new b("Not all required fields were included: LogHead");
            }
            if (this.rbM != null) {
                aVar.fV(1, this.rbM.boi());
                this.rbM.a(aVar);
            }
            aVar.d(2, 8, this.rbN);
            return 0;
        } else if (i == 1) {
            if (this.rbM != null) {
                fS = f.a.a.a.fS(1, this.rbM.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS + f.a.a.a.c(2, 8, this.rbN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rbN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rbM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LogHead");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bk bkVar = (bk) objArr[1];
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
                        apy apy = new apy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = apy.a(aVar4, apy, a.a(aVar4))) {
                        }
                        bkVar.rbM = apy;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        apz apz = new apz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = apz.a(aVar4, apz, a.a(aVar4))) {
                        }
                        bkVar.rbN.add(apz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
