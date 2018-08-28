package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class la extends a {
    public float bSx;
    public float bUg;
    public String country;
    public String csK;
    public String csL;
    public String dRH;
    public String descriptor;
    public String hvl;
    public String hwI;
    public String name;
    public float rnu;
    public String rnv;
    public String rnw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.g(2, this.descriptor);
            }
            if (this.hvl != null) {
                aVar.g(3, this.hvl);
            }
            if (this.country != null) {
                aVar.g(4, this.country);
            }
            if (this.csK != null) {
                aVar.g(5, this.csK);
            }
            if (this.csL != null) {
                aVar.g(6, this.csL);
            }
            if (this.dRH != null) {
                aVar.g(7, this.dRH);
            }
            aVar.l(8, this.rnu);
            aVar.l(9, this.bUg);
            aVar.l(10, this.bSx);
            if (this.hwI != null) {
                aVar.g(11, this.hwI);
            }
            if (this.rnv != null) {
                aVar.g(12, this.rnv);
            }
            if (this.rnw == null) {
                return 0;
            }
            aVar.g(13, this.rnw);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = f.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            if (this.descriptor != null) {
                h += f.a.a.b.b.a.h(2, this.descriptor);
            }
            if (this.hvl != null) {
                h += f.a.a.b.b.a.h(3, this.hvl);
            }
            if (this.country != null) {
                h += f.a.a.b.b.a.h(4, this.country);
            }
            if (this.csK != null) {
                h += f.a.a.b.b.a.h(5, this.csK);
            }
            if (this.csL != null) {
                h += f.a.a.b.b.a.h(6, this.csL);
            }
            if (this.dRH != null) {
                h += f.a.a.b.b.a.h(7, this.dRH);
            }
            h = ((h + (f.a.a.b.b.a.ec(8) + 4)) + (f.a.a.b.b.a.ec(9) + 4)) + (f.a.a.b.b.a.ec(10) + 4);
            if (this.hwI != null) {
                h += f.a.a.b.b.a.h(11, this.hwI);
            }
            if (this.rnv != null) {
                h += f.a.a.b.b.a.h(12, this.rnv);
            }
            if (this.rnw != null) {
                h += f.a.a.b.b.a.h(13, this.rnw);
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
            la laVar = (la) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    laVar.name = aVar3.vHC.readString();
                    return 0;
                case 2:
                    laVar.descriptor = aVar3.vHC.readString();
                    return 0;
                case 3:
                    laVar.hvl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    laVar.country = aVar3.vHC.readString();
                    return 0;
                case 5:
                    laVar.csK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    laVar.csL = aVar3.vHC.readString();
                    return 0;
                case 7:
                    laVar.dRH = aVar3.vHC.readString();
                    return 0;
                case 8:
                    laVar.rnu = aVar3.vHC.readFloat();
                    return 0;
                case 9:
                    laVar.bUg = aVar3.vHC.readFloat();
                    return 0;
                case 10:
                    laVar.bSx = aVar3.vHC.readFloat();
                    return 0;
                case 11:
                    laVar.hwI = aVar3.vHC.readString();
                    return 0;
                case 12:
                    laVar.rnv = aVar3.vHC.readString();
                    return 0;
                case 13:
                    laVar.rnw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
