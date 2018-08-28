package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ald extends a {
    public String hbL;
    public String hcS;
    public String rEJ;
    public String rNU;
    public String rNV;
    public int rfn;
    public String rhh;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhh != null) {
                aVar.g(1, this.rhh);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            if (this.rNU != null) {
                aVar.g(3, this.rNU);
            }
            if (this.rNV != null) {
                aVar.g(4, this.rNV);
            }
            aVar.fT(5, this.rfn);
            if (this.hcS != null) {
                aVar.g(6, this.hcS);
            }
            if (this.rEJ == null) {
                return 0;
            }
            aVar.g(7, this.rEJ);
            return 0;
        } else if (i == 1) {
            if (this.rhh != null) {
                h = f.a.a.b.b.a.h(1, this.rhh) + 0;
            } else {
                h = 0;
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(2, this.hbL);
            }
            if (this.rNU != null) {
                h += f.a.a.b.b.a.h(3, this.rNU);
            }
            if (this.rNV != null) {
                h += f.a.a.b.b.a.h(4, this.rNV);
            }
            h += f.a.a.a.fQ(5, this.rfn);
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(6, this.hcS);
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(7, this.rEJ);
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
            ald ald = (ald) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ald.rhh = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ald.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ald.rNU = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ald.rNV = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ald.rfn = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ald.hcS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ald.rEJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
