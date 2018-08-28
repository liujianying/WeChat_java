package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wm extends a {
    public String bHD;
    public String jOS;
    public int rcd;
    public String rce;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jOS != null) {
                aVar.g(2, this.jOS);
            }
            aVar.fT(3, this.rcd);
            if (this.rce == null) {
                return 0;
            }
            aVar.g(4, this.rce);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(2, this.jOS);
            }
            h += f.a.a.a.fQ(3, this.rcd);
            if (this.rce != null) {
                h += f.a.a.b.b.a.h(4, this.rce);
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
            wm wmVar = (wm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wmVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    wmVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    wmVar.rcd = aVar3.vHC.rY();
                    return 0;
                case 4:
                    wmVar.rce = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
