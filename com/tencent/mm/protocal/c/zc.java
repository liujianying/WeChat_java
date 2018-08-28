package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class zc extends a {
    public int hcE;
    public String jQb;
    public int rFj;
    public int rcV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb != null) {
                aVar.g(1, this.jQb);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.rcV);
            aVar.fT(4, this.rFj);
            return 0;
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            return ((h + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.rcV)) + f.a.a.a.fQ(4, this.rFj);
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
            zc zcVar = (zc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zcVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    zcVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    zcVar.rcV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    zcVar.rFj = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
