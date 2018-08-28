package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class hy extends bhp {
    public bej riQ;
    public LinkedList<hw> riR = new LinkedList();
    public boolean riS;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.riQ == null) {
                throw new b("Not all required fields were included: qy_base_resp");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.riQ != null) {
                    aVar.fV(2, this.riQ.boi());
                    this.riQ.a(aVar);
                }
                aVar.d(3, 8, this.riR);
                aVar.av(4, this.riS);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.riQ != null) {
                fS += f.a.a.a.fS(2, this.riQ.boi());
            }
            return (fS + f.a.a.a.c(3, 8, this.riR)) + (f.a.a.b.b.a.ec(4) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.riR.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.riQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qy_base_resp");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            hy hyVar = (hy) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        hyVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bej bej = new bej();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bej.a(aVar4, bej, bhp.a(aVar4))) {
                        }
                        hyVar.riQ = bej;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hw hwVar = new hw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, bhp.a(aVar4))) {
                        }
                        hyVar.riR.add(hwVar);
                    }
                    return 0;
                case 4:
                    hyVar.riS = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
