package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ts extends a {
    public String jPG;
    public String rem;
    public String rwQ;
    public String rwR;
    public String rwS;
    public String rwT;
    public int rwU;
    public int rwV;
    public String rwY;
    public int rwZ;
    public String rxA;
    public String rxB;
    public String rxa;
    public String rxb;
    public String rxc;
    public String rxd;
    public String rxh;
    public int rxy;
    public String rxz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rem != null) {
                aVar.g(1, this.rem);
            }
            if (this.jPG != null) {
                aVar.g(2, this.jPG);
            }
            if (this.rwQ != null) {
                aVar.g(3, this.rwQ);
            }
            if (this.rwR != null) {
                aVar.g(4, this.rwR);
            }
            if (this.rwS != null) {
                aVar.g(5, this.rwS);
            }
            if (this.rwT != null) {
                aVar.g(6, this.rwT);
            }
            aVar.fT(7, this.rwU);
            aVar.fT(8, this.rwV);
            if (this.rwY != null) {
                aVar.g(9, this.rwY);
            }
            aVar.fT(10, this.rwZ);
            if (this.rxa != null) {
                aVar.g(11, this.rxa);
            }
            aVar.fT(12, this.rxy);
            if (this.rxd != null) {
                aVar.g(13, this.rxd);
            }
            if (this.rxb != null) {
                aVar.g(14, this.rxb);
            }
            if (this.rxc != null) {
                aVar.g(15, this.rxc);
            }
            if (this.rxz != null) {
                aVar.g(16, this.rxz);
            }
            if (this.rxh != null) {
                aVar.g(17, this.rxh);
            }
            if (this.rxA != null) {
                aVar.g(18, this.rxA);
            }
            if (this.rxB == null) {
                return 0;
            }
            aVar.g(19, this.rxB);
            return 0;
        } else if (i == 1) {
            if (this.rem != null) {
                h = f.a.a.b.b.a.h(1, this.rem) + 0;
            } else {
                h = 0;
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(2, this.jPG);
            }
            if (this.rwQ != null) {
                h += f.a.a.b.b.a.h(3, this.rwQ);
            }
            if (this.rwR != null) {
                h += f.a.a.b.b.a.h(4, this.rwR);
            }
            if (this.rwS != null) {
                h += f.a.a.b.b.a.h(5, this.rwS);
            }
            if (this.rwT != null) {
                h += f.a.a.b.b.a.h(6, this.rwT);
            }
            h = (h + f.a.a.a.fQ(7, this.rwU)) + f.a.a.a.fQ(8, this.rwV);
            if (this.rwY != null) {
                h += f.a.a.b.b.a.h(9, this.rwY);
            }
            h += f.a.a.a.fQ(10, this.rwZ);
            if (this.rxa != null) {
                h += f.a.a.b.b.a.h(11, this.rxa);
            }
            h += f.a.a.a.fQ(12, this.rxy);
            if (this.rxd != null) {
                h += f.a.a.b.b.a.h(13, this.rxd);
            }
            if (this.rxb != null) {
                h += f.a.a.b.b.a.h(14, this.rxb);
            }
            if (this.rxc != null) {
                h += f.a.a.b.b.a.h(15, this.rxc);
            }
            if (this.rxz != null) {
                h += f.a.a.b.b.a.h(16, this.rxz);
            }
            if (this.rxh != null) {
                h += f.a.a.b.b.a.h(17, this.rxh);
            }
            if (this.rxA != null) {
                h += f.a.a.b.b.a.h(18, this.rxA);
            }
            if (this.rxB != null) {
                h += f.a.a.b.b.a.h(19, this.rxB);
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
            ts tsVar = (ts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tsVar.rem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tsVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    tsVar.rwQ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    tsVar.rwR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    tsVar.rwS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    tsVar.rwT = aVar3.vHC.readString();
                    return 0;
                case 7:
                    tsVar.rwU = aVar3.vHC.rY();
                    return 0;
                case 8:
                    tsVar.rwV = aVar3.vHC.rY();
                    return 0;
                case 9:
                    tsVar.rwY = aVar3.vHC.readString();
                    return 0;
                case 10:
                    tsVar.rwZ = aVar3.vHC.rY();
                    return 0;
                case 11:
                    tsVar.rxa = aVar3.vHC.readString();
                    return 0;
                case 12:
                    tsVar.rxy = aVar3.vHC.rY();
                    return 0;
                case 13:
                    tsVar.rxd = aVar3.vHC.readString();
                    return 0;
                case 14:
                    tsVar.rxb = aVar3.vHC.readString();
                    return 0;
                case 15:
                    tsVar.rxc = aVar3.vHC.readString();
                    return 0;
                case 16:
                    tsVar.rxz = aVar3.vHC.readString();
                    return 0;
                case 17:
                    tsVar.rxh = aVar3.vHC.readString();
                    return 0;
                case 18:
                    tsVar.rxA = aVar3.vHC.readString();
                    return 0;
                case 19:
                    tsVar.rxB = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
