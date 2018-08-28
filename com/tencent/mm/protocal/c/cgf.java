package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cgf extends a {
    public String rKY;
    public bhy rLb;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rLb == null) {
                throw new b("Not all required fields were included: VerifyBuff");
            }
            if (this.rKY != null) {
                aVar.g(1, this.rKY);
            }
            if (this.rLb == null) {
                return 0;
            }
            aVar.fV(2, this.rLb.boi());
            this.rLb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rKY != null) {
                h = f.a.a.b.b.a.h(1, this.rKY) + 0;
            } else {
                h = 0;
            }
            if (this.rLb != null) {
                h += f.a.a.a.fS(2, this.rLb.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rLb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: VerifyBuff");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cgf cgf = (cgf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgf.rKY = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        a bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        cgf.rLb = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
