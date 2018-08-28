package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bhr extends a {
    public String jOU;
    public int jRb;
    public String siy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.siy != null) {
                aVar.g(1, this.siy);
            }
            aVar.fT(2, this.jRb);
            if (this.jOU == null) {
                return 0;
            }
            aVar.g(3, this.jOU);
            return 0;
        } else if (i == 1) {
            if (this.siy != null) {
                h = f.a.a.b.b.a.h(1, this.siy) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.jRb);
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(3, this.jOU);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhr bhr = (bhr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhr.siy = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bhr.jRb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bhr.jOU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
