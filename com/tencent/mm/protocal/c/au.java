package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class au extends a {
    public int hcE;
    public String jPG;
    public String jPe;
    public String jSA;
    public String lRx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            if (this.lRx != null) {
                aVar.g(2, this.lRx);
            }
            aVar.fT(3, this.hcE);
            if (this.jSA != null) {
                aVar.g(4, this.jSA);
            }
            if (this.jPG == null) {
                return 0;
            }
            aVar.g(5, this.jPG);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.lRx != null) {
                h += f.a.a.b.b.a.h(2, this.lRx);
            }
            h += f.a.a.a.fQ(3, this.hcE);
            if (this.jSA != null) {
                h += f.a.a.b.b.a.h(4, this.jSA);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(5, this.jPG);
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
            au auVar = (au) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    auVar.lRx = aVar3.vHC.readString();
                    return 0;
                case 3:
                    auVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    auVar.jSA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    auVar.jPG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
