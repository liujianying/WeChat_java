package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class byb extends a {
    public String mEl;
    public String rEJ;
    public String siA;
    public String sud;
    public int sue;
    public String suf;
    public String sug;
    public int suh;
    public String sui;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.mEl != null) {
                aVar.g(1, this.mEl);
            }
            if (this.sud != null) {
                aVar.g(2, this.sud);
            }
            if (this.rEJ != null) {
                aVar.g(3, this.rEJ);
            }
            aVar.fT(4, this.sue);
            if (this.siA != null) {
                aVar.g(5, this.siA);
            }
            if (this.suf != null) {
                aVar.g(6, this.suf);
            }
            if (this.sug != null) {
                aVar.g(7, this.sug);
            }
            aVar.fT(8, this.suh);
            if (this.sui == null) {
                return 0;
            }
            aVar.g(9, this.sui);
            return 0;
        } else if (i == 1) {
            if (this.mEl != null) {
                h = f.a.a.b.b.a.h(1, this.mEl) + 0;
            } else {
                h = 0;
            }
            if (this.sud != null) {
                h += f.a.a.b.b.a.h(2, this.sud);
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(3, this.rEJ);
            }
            h += f.a.a.a.fQ(4, this.sue);
            if (this.siA != null) {
                h += f.a.a.b.b.a.h(5, this.siA);
            }
            if (this.suf != null) {
                h += f.a.a.b.b.a.h(6, this.suf);
            }
            if (this.sug != null) {
                h += f.a.a.b.b.a.h(7, this.sug);
            }
            h += f.a.a.a.fQ(8, this.suh);
            if (this.sui != null) {
                h += f.a.a.b.b.a.h(9, this.sui);
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
            byb byb = (byb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byb.mEl = aVar3.vHC.readString();
                    return 0;
                case 2:
                    byb.sud = aVar3.vHC.readString();
                    return 0;
                case 3:
                    byb.rEJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    byb.sue = aVar3.vHC.rY();
                    return 0;
                case 5:
                    byb.siA = aVar3.vHC.readString();
                    return 0;
                case 6:
                    byb.suf = aVar3.vHC.readString();
                    return 0;
                case 7:
                    byb.sug = aVar3.vHC.readString();
                    return 0;
                case 8:
                    byb.suh = aVar3.vHC.rY();
                    return 0;
                case 9:
                    byb.sui = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
