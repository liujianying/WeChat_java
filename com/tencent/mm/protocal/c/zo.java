package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class zo extends bhp {
    public String hwU;
    public b hxt;
    public int rFu;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.hwU != null) {
                aVar.g(2, this.hwU);
            }
            aVar.fT(3, this.rFu);
            if (this.hxt == null) {
                return 0;
            }
            aVar.b(4, this.hxt);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hwU != null) {
                fS += f.a.a.b.b.a.h(2, this.hwU);
            }
            fS += f.a.a.a.fQ(3, this.rFu);
            if (this.hxt != null) {
                fS += f.a.a.a.a(4, this.hxt);
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
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            zo zoVar = (zo) objArr[1];
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
                        zoVar.six = flVar;
                    }
                    return 0;
                case 2:
                    zoVar.hwU = aVar3.vHC.readString();
                    return 0;
                case 3:
                    zoVar.rFu = aVar3.vHC.rY();
                    return 0;
                case 4:
                    zoVar.hxt = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
