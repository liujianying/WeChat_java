package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bbq extends bhp {
    public String sdN;
    public String sdO;
    public String sdP;
    public String sdQ;

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
            if (this.sdN != null) {
                aVar.g(2, this.sdN);
            }
            if (this.sdO != null) {
                aVar.g(3, this.sdO);
            }
            if (this.sdP != null) {
                aVar.g(4, this.sdP);
            }
            if (this.sdQ == null) {
                return 0;
            }
            aVar.g(5, this.sdQ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sdN != null) {
                fS += f.a.a.b.b.a.h(2, this.sdN);
            }
            if (this.sdO != null) {
                fS += f.a.a.b.b.a.h(3, this.sdO);
            }
            if (this.sdP != null) {
                fS += f.a.a.b.b.a.h(4, this.sdP);
            }
            if (this.sdQ != null) {
                fS += f.a.a.b.b.a.h(5, this.sdQ);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
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
            bbq bbq = (bbq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bbq.six = flVar;
                    }
                    return 0;
                case 2:
                    bbq.sdN = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbq.sdO = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbq.sdP = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbq.sdQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
