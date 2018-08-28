package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ade extends a {
    public bhy rcT;
    public String rem;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rem == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.rcT == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.rem != null) {
                    aVar.g(1, this.rem);
                }
                if (this.rcT == null) {
                    return 0;
                }
                aVar.fV(2, this.rcT.boi());
                this.rcT.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rem != null) {
                h = f.a.a.b.b.a.h(1, this.rem) + 0;
            } else {
                h = 0;
            }
            if (this.rcT != null) {
                h += f.a.a.a.fS(2, this.rcT.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rem == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.rcT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ade ade = (ade) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ade.rem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ade.rcT = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
