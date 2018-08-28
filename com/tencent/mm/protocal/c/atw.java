package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class atw extends a {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public String eJQ;
    public String hbL;
    public int hcE;
    public int rWZ;
    public int rXa;
    public String rqZ;
    public String rra;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.eJH);
            if (this.eJJ != null) {
                aVar.g(4, this.eJJ);
            }
            if (this.eJI != null) {
                aVar.g(5, this.eJI);
            }
            if (this.eJK != null) {
                aVar.g(6, this.eJK);
            }
            aVar.fT(7, this.rWZ);
            aVar.fT(8, this.rXa);
            if (this.eJQ != null) {
                aVar.g(9, this.eJQ);
            }
            if (this.rqZ != null) {
                aVar.g(10, this.rqZ);
            }
            if (this.rra == null) {
                return 0;
            }
            aVar.g(11, this.rra);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.eJH);
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(4, this.eJJ);
            }
            if (this.eJI != null) {
                h += f.a.a.b.b.a.h(5, this.eJI);
            }
            if (this.eJK != null) {
                h += f.a.a.b.b.a.h(6, this.eJK);
            }
            h = (h + f.a.a.a.fQ(7, this.rWZ)) + f.a.a.a.fQ(8, this.rXa);
            if (this.eJQ != null) {
                h += f.a.a.b.b.a.h(9, this.eJQ);
            }
            if (this.rqZ != null) {
                h += f.a.a.b.b.a.h(10, this.rqZ);
            }
            if (this.rra != null) {
                h += f.a.a.b.b.a.h(11, this.rra);
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
            atw atw = (atw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atw.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    atw.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    atw.eJH = aVar3.vHC.rY();
                    return 0;
                case 4:
                    atw.eJJ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    atw.eJI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    atw.eJK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    atw.rWZ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    atw.rXa = aVar3.vHC.rY();
                    return 0;
                case 9:
                    atw.eJQ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    atw.rqZ = aVar3.vHC.readString();
                    return 0;
                case 11:
                    atw.rra = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
