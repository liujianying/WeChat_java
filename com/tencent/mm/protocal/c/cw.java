package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cw extends a {
    public int hcE;
    public String jQb;
    public int rcV;
    public String rcW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb != null) {
                aVar.g(1, this.jQb);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.rcV);
            if (this.rcW == null) {
                return 0;
            }
            aVar.g(4, this.rcW);
            return 0;
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.rcV);
            if (this.rcW != null) {
                h += f.a.a.b.b.a.h(4, this.rcW);
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
            cw cwVar = (cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cwVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cwVar.rcV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cwVar.rcW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
