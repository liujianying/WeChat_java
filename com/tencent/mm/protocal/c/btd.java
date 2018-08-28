package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btd extends a {
    public String hFk;
    public String rFf;
    public String sign;
    public String sqy;
    public int sqz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sqy != null) {
                aVar.g(4, this.sqy);
            }
            if (this.sign != null) {
                aVar.g(5, this.sign);
            }
            if (this.hFk != null) {
                aVar.g(6, this.hFk);
            }
            aVar.fT(7, this.sqz);
            if (this.rFf == null) {
                return 0;
            }
            aVar.g(8, this.rFf);
            return 0;
        } else if (i == 1) {
            if (this.sqy != null) {
                h = f.a.a.b.b.a.h(4, this.sqy) + 0;
            } else {
                h = 0;
            }
            if (this.sign != null) {
                h += f.a.a.b.b.a.h(5, this.sign);
            }
            if (this.hFk != null) {
                h += f.a.a.b.b.a.h(6, this.hFk);
            }
            h += f.a.a.a.fQ(7, this.sqz);
            if (this.rFf != null) {
                h += f.a.a.b.b.a.h(8, this.rFf);
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
            btd btd = (btd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 4:
                    btd.sqy = aVar3.vHC.readString();
                    return 0;
                case 5:
                    btd.sign = aVar3.vHC.readString();
                    return 0;
                case 6:
                    btd.hFk = aVar3.vHC.readString();
                    return 0;
                case 7:
                    btd.sqz = aVar3.vHC.rY();
                    return 0;
                case 8:
                    btd.rFf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
