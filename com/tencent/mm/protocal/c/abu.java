package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class abu extends bhp {
    public int rFA;
    public bem rGq;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rGq == null) {
                throw new b("Not all required fields were included: CertValue");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rGq != null) {
                    aVar.fV(2, this.rGq.boi());
                    this.rGq.a(aVar);
                }
                aVar.fT(3, this.rFA);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rGq != null) {
                fS += f.a.a.a.fS(2, this.rGq.boi());
            }
            return fS + f.a.a.a.fQ(3, this.rFA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rGq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CertValue");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            abu abu = (abu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            com.tencent.mm.bk.a flVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        abu.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bem();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        abu.rGq = flVar;
                    }
                    return 0;
                case 3:
                    abu.rFA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}