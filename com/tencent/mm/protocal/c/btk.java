package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class btk extends a {
    public b rkW;
    public int rkX;
    public int srh;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(7, this.srh);
            if (this.rkW != null) {
                aVar.b(8, this.rkW);
            }
            aVar.fT(9, this.rkX);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(7, this.srh) + 0;
            if (this.rkW != null) {
                fQ += f.a.a.a.a(8, this.rkW);
            }
            return fQ + f.a.a.a.fQ(9, this.rkX);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            btk btk = (btk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    btk.srh = aVar3.vHC.rY();
                    return 0;
                case 8:
                    btk.rkW = aVar3.cJR();
                    return 0;
                case 9:
                    btk.rkX = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
