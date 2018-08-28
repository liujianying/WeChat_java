package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class vt extends a {
    public String hbL;
    public String hcS;
    public int hcd;
    public String rwN;
    public String ryZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.ryZ != null) {
                aVar.g(2, this.ryZ);
            }
            if (this.hcS != null) {
                aVar.g(3, this.hcS);
            }
            if (this.rwN != null) {
                aVar.g(4, this.rwN);
            }
            aVar.fT(5, this.hcd);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.ryZ != null) {
                h += f.a.a.b.b.a.h(2, this.ryZ);
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(3, this.hcS);
            }
            if (this.rwN != null) {
                h += f.a.a.b.b.a.h(4, this.rwN);
            }
            return h + f.a.a.a.fQ(5, this.hcd);
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
            vt vtVar = (vt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vtVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    vtVar.ryZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vtVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    vtVar.rwN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vtVar.hcd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
