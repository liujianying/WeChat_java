package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cbh extends a {
    public String sxy;
    public int sxz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxy != null) {
                aVar.g(1, this.sxy);
            }
            aVar.fT(2, this.sxz);
            return 0;
        } else if (i == 1) {
            if (this.sxy != null) {
                h = f.a.a.b.b.a.h(1, this.sxy) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.fQ(2, this.sxz);
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
            cbh cbh = (cbh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbh.sxy = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cbh.sxz = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
