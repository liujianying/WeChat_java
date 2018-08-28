package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class uy extends a {
    public int ryb;
    public String ryc;
    public String ryd;
    public String ryp;
    public String ryq;
    public int ryr;
    public int rys;
    public String ryt;
    public String ryu;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.ryb);
            if (this.ryc != null) {
                aVar.g(2, this.ryc);
            }
            if (this.ryp != null) {
                aVar.g(3, this.ryp);
            }
            if (this.ryq != null) {
                aVar.g(4, this.ryq);
            }
            aVar.fT(5, this.ryr);
            aVar.fT(6, this.rys);
            if (this.ryt != null) {
                aVar.g(7, this.ryt);
            }
            if (this.ryd != null) {
                aVar.g(8, this.ryd);
            }
            if (this.ryu != null) {
                aVar.g(9, this.ryu);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.ryb) + 0;
            if (this.ryc != null) {
                fQ += f.a.a.b.b.a.h(2, this.ryc);
            }
            if (this.ryp != null) {
                fQ += f.a.a.b.b.a.h(3, this.ryp);
            }
            if (this.ryq != null) {
                fQ += f.a.a.b.b.a.h(4, this.ryq);
            }
            fQ = (fQ + f.a.a.a.fQ(5, this.ryr)) + f.a.a.a.fQ(6, this.rys);
            if (this.ryt != null) {
                fQ += f.a.a.b.b.a.h(7, this.ryt);
            }
            if (this.ryd != null) {
                fQ += f.a.a.b.b.a.h(8, this.ryd);
            }
            if (this.ryu != null) {
                return fQ + f.a.a.b.b.a.h(9, this.ryu);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            uy uyVar = (uy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uyVar.ryb = aVar3.vHC.rY();
                    return 0;
                case 2:
                    uyVar.ryc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    uyVar.ryp = aVar3.vHC.readString();
                    return 0;
                case 4:
                    uyVar.ryq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    uyVar.ryr = aVar3.vHC.rY();
                    return 0;
                case 6:
                    uyVar.rys = aVar3.vHC.rY();
                    return 0;
                case 7:
                    uyVar.ryt = aVar3.vHC.readString();
                    return 0;
                case 8:
                    uyVar.ryd = aVar3.vHC.readString();
                    return 0;
                case 9:
                    uyVar.ryu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
