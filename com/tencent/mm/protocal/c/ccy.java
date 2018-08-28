package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ccy extends a {
    public int eIy;
    public String lPe;
    public int otY;
    public String rUM;
    public String shK;
    public String syA;
    public String syB;
    public String syC;
    public String syD;
    public String syz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syz != null) {
                aVar.g(1, this.syz);
            }
            if (this.syA != null) {
                aVar.g(2, this.syA);
            }
            if (this.rUM != null) {
                aVar.g(3, this.rUM);
            }
            if (this.shK != null) {
                aVar.g(4, this.shK);
            }
            aVar.fT(5, this.eIy);
            if (this.lPe != null) {
                aVar.g(6, this.lPe);
            }
            if (this.syB != null) {
                aVar.g(7, this.syB);
            }
            if (this.syC != null) {
                aVar.g(8, this.syC);
            }
            aVar.fT(9, this.otY);
            if (this.syD == null) {
                return 0;
            }
            aVar.g(19, this.syD);
            return 0;
        } else if (i == 1) {
            if (this.syz != null) {
                h = f.a.a.b.b.a.h(1, this.syz) + 0;
            } else {
                h = 0;
            }
            if (this.syA != null) {
                h += f.a.a.b.b.a.h(2, this.syA);
            }
            if (this.rUM != null) {
                h += f.a.a.b.b.a.h(3, this.rUM);
            }
            if (this.shK != null) {
                h += f.a.a.b.b.a.h(4, this.shK);
            }
            h += f.a.a.a.fQ(5, this.eIy);
            if (this.lPe != null) {
                h += f.a.a.b.b.a.h(6, this.lPe);
            }
            if (this.syB != null) {
                h += f.a.a.b.b.a.h(7, this.syB);
            }
            if (this.syC != null) {
                h += f.a.a.b.b.a.h(8, this.syC);
            }
            h += f.a.a.a.fQ(9, this.otY);
            if (this.syD != null) {
                h += f.a.a.b.b.a.h(19, this.syD);
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
            ccy ccy = (ccy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccy.syz = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ccy.syA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ccy.rUM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ccy.shK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ccy.eIy = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ccy.lPe = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ccy.syB = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ccy.syC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ccy.otY = aVar3.vHC.rY();
                    return 0;
                case 19:
                    ccy.syD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
