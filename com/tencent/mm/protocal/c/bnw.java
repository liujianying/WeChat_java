package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bnw extends a {
    public String rem;
    public int rgz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rem == null) {
                throw new b("Not all required fields were included: ProductID");
            }
            if (this.rem != null) {
                aVar.g(1, this.rem);
            }
            aVar.fT(2, this.rgz);
            return 0;
        } else if (i == 1) {
            if (this.rem != null) {
                h = f.a.a.b.b.a.h(1, this.rem) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.fQ(2, this.rgz);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rem != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ProductID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bnw bnw = (bnw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnw.rem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bnw.rgz = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
