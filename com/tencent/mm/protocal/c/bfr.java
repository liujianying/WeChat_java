package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bfr extends a {
    public String bSc;
    public int number;
    public String type;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.type != null) {
                aVar.g(1, this.type);
            }
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            aVar.fT(3, this.number);
            return 0;
        } else if (i == 1) {
            if (this.type != null) {
                h = f.a.a.b.b.a.h(1, this.type) + 0;
            } else {
                h = 0;
            }
            if (this.bSc != null) {
                h += f.a.a.b.b.a.h(2, this.bSc);
            }
            return h + f.a.a.a.fQ(3, this.number);
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
            bfr bfr = (bfr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfr.type = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bfr.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bfr.number = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
