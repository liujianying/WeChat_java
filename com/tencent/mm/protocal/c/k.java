package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class k extends a {
    public long cfh;
    public String qYc;
    public String qYd;
    public String qYm;
    public int qYn;
    public String qYo;
    public String qYp;
    public int state;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qYc != null) {
                aVar.g(1, this.qYc);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.T(3, this.cfh);
            if (this.qYm != null) {
                aVar.g(5, this.qYm);
            }
            aVar.fT(10, this.state);
            aVar.fT(11, this.qYn);
            if (this.qYo != null) {
                aVar.g(12, this.qYo);
            }
            if (this.qYd != null) {
                aVar.g(13, this.qYd);
            }
            if (this.qYp == null) {
                return 0;
            }
            aVar.g(14, this.qYp);
            return 0;
        } else if (i == 1) {
            if (this.qYc != null) {
                h = f.a.a.b.b.a.h(1, this.qYc) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(2, this.title);
            }
            h += f.a.a.a.S(3, this.cfh);
            if (this.qYm != null) {
                h += f.a.a.b.b.a.h(5, this.qYm);
            }
            h = (h + f.a.a.a.fQ(10, this.state)) + f.a.a.a.fQ(11, this.qYn);
            if (this.qYo != null) {
                h += f.a.a.b.b.a.h(12, this.qYo);
            }
            if (this.qYd != null) {
                h += f.a.a.b.b.a.h(13, this.qYd);
            }
            if (this.qYp != null) {
                h += f.a.a.b.b.a.h(14, this.qYp);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.qYc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    kVar.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kVar.cfh = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    kVar.qYm = aVar3.vHC.readString();
                    return 0;
                case 10:
                    kVar.state = aVar3.vHC.rY();
                    return 0;
                case 11:
                    kVar.qYn = aVar3.vHC.rY();
                    return 0;
                case 12:
                    kVar.qYo = aVar3.vHC.readString();
                    return 0;
                case 13:
                    kVar.qYd = aVar3.vHC.readString();
                    return 0;
                case 14:
                    kVar.qYp = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
