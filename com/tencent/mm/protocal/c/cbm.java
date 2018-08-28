package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cbm extends a {
    public String bGB;
    public String bGC;
    public String sxC;
    public long timestamp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bGB != null) {
                aVar.g(1, this.bGB);
            }
            if (this.bGC != null) {
                aVar.g(2, this.bGC);
            }
            if (this.sxC != null) {
                aVar.g(3, this.sxC);
            }
            aVar.T(4, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.bGB != null) {
                h = f.a.a.b.b.a.h(1, this.bGB) + 0;
            } else {
                h = 0;
            }
            if (this.bGC != null) {
                h += f.a.a.b.b.a.h(2, this.bGC);
            }
            if (this.sxC != null) {
                h += f.a.a.b.b.a.h(3, this.sxC);
            }
            return h + f.a.a.a.S(4, this.timestamp);
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
            cbm cbm = (cbm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbm.bGB = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cbm.bGC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbm.sxC = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbm.timestamp = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
