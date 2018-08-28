package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cf extends a {
    public String eJI;
    public String eJJ;
    public String eJQ;
    public String hbL;
    public String jQf;
    public String rcA;
    public String rcz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.eJQ != null) {
                aVar.g(1, this.eJQ);
            }
            if (this.eJI != null) {
                aVar.g(2, this.eJI);
            }
            if (this.eJJ != null) {
                aVar.g(3, this.eJJ);
            }
            if (this.jQf != null) {
                aVar.g(4, this.jQf);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            if (this.rcz != null) {
                aVar.g(6, this.rcz);
            }
            if (this.rcA == null) {
                return 0;
            }
            aVar.g(7, this.rcA);
            return 0;
        } else if (i == 1) {
            if (this.eJQ != null) {
                h = f.a.a.b.b.a.h(1, this.eJQ) + 0;
            } else {
                h = 0;
            }
            if (this.eJI != null) {
                h += f.a.a.b.b.a.h(2, this.eJI);
            }
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(3, this.eJJ);
            }
            if (this.jQf != null) {
                h += f.a.a.b.b.a.h(4, this.jQf);
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(5, this.hbL);
            }
            if (this.rcz != null) {
                h += f.a.a.b.b.a.h(6, this.rcz);
            }
            if (this.rcA != null) {
                h += f.a.a.b.b.a.h(7, this.rcA);
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
            cf cfVar = (cf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfVar.eJQ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cfVar.eJI = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cfVar.eJJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cfVar.jQf = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cfVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cfVar.rcz = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cfVar.rcA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
