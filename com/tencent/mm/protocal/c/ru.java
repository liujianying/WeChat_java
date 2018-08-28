package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ru extends a {
    public String rvv;
    public int rvw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvv != null) {
                aVar.g(1, this.rvv);
            }
            aVar.fT(2, this.rvw);
            return 0;
        } else if (i == 1) {
            if (this.rvv != null) {
                h = f.a.a.b.b.a.h(1, this.rvv) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.fQ(2, this.rvw);
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
            ru ruVar = (ru) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ruVar.rvv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ruVar.rvw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
