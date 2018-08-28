package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amn extends a {
    public String bWP;
    public int huV;
    public String hwg;
    public String rIw;
    public int rPk;
    public long rPl;
    public long rPm;
    public String rrW;
    public long ruW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rrW != null) {
                aVar.g(1, this.rrW);
            }
            aVar.T(2, this.ruW);
            aVar.fT(3, this.rPk);
            aVar.T(4, this.rPl);
            aVar.T(5, this.rPm);
            if (this.rIw != null) {
                aVar.g(6, this.rIw);
            }
            if (this.hwg != null) {
                aVar.g(7, this.hwg);
            }
            aVar.fT(8, this.huV);
            if (this.bWP == null) {
                return 0;
            }
            aVar.g(9, this.bWP);
            return 0;
        } else if (i == 1) {
            if (this.rrW != null) {
                h = f.a.a.b.b.a.h(1, this.rrW) + 0;
            } else {
                h = 0;
            }
            h = (((h + f.a.a.a.S(2, this.ruW)) + f.a.a.a.fQ(3, this.rPk)) + f.a.a.a.S(4, this.rPl)) + f.a.a.a.S(5, this.rPm);
            if (this.rIw != null) {
                h += f.a.a.b.b.a.h(6, this.rIw);
            }
            if (this.hwg != null) {
                h += f.a.a.b.b.a.h(7, this.hwg);
            }
            h += f.a.a.a.fQ(8, this.huV);
            if (this.bWP != null) {
                h += f.a.a.b.b.a.h(9, this.bWP);
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
            amn amn = (amn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amn.rrW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amn.ruW = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    amn.rPk = aVar3.vHC.rY();
                    return 0;
                case 4:
                    amn.rPl = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    amn.rPm = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    amn.rIw = aVar3.vHC.readString();
                    return 0;
                case 7:
                    amn.hwg = aVar3.vHC.readString();
                    return 0;
                case 8:
                    amn.huV = aVar3.vHC.rY();
                    return 0;
                case 9:
                    amn.bWP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
