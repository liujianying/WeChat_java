package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bdp extends a {
    public String iwF;
    public String ryU;
    public int sfQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.iwF != null) {
                aVar.g(1, this.iwF);
            }
            aVar.fT(2, this.sfQ);
            if (this.ryU == null) {
                return 0;
            }
            aVar.g(3, this.ryU);
            return 0;
        } else if (i == 1) {
            if (this.iwF != null) {
                h = f.a.a.b.b.a.h(1, this.iwF) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.sfQ);
            if (this.ryU != null) {
                h += f.a.a.b.b.a.h(3, this.ryU);
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
            bdp bdp = (bdp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdp.iwF = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bdp.sfQ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdp.ryU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
