package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aze extends a {
    public String mPv;
    public long sbV;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.mPv != null) {
                aVar.g(1, this.mPv);
            }
            aVar.T(2, this.sbV);
            if (this.url == null) {
                return 0;
            }
            aVar.g(3, this.url);
            return 0;
        } else if (i == 1) {
            if (this.mPv != null) {
                h = f.a.a.b.b.a.h(1, this.mPv) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.S(2, this.sbV);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(3, this.url);
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
            aze aze = (aze) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aze.mPv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aze.sbV = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    aze.url = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
