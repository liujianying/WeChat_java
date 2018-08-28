package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xq extends a {
    public String hbL;
    public String hcS;
    public String jPM;
    public int qZg;
    public String rDu;
    public String rDv;
    public String rDw;
    public String rbW;
    public String rhq;
    public String rsy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rbW != null) {
                aVar.g(1, this.rbW);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.hbL != null) {
                aVar.g(3, this.hbL);
            }
            if (this.jPM != null) {
                aVar.g(4, this.jPM);
            }
            if (this.rDu != null) {
                aVar.g(5, this.rDu);
            }
            if (this.rDv != null) {
                aVar.g(6, this.rDv);
            }
            if (this.rhq != null) {
                aVar.g(7, this.rhq);
            }
            if (this.rsy != null) {
                aVar.g(8, this.rsy);
            }
            if (this.rDw != null) {
                aVar.g(9, this.rDw);
            }
            aVar.fT(10, this.qZg);
            return 0;
        } else if (i == 1) {
            if (this.rbW != null) {
                h = f.a.a.b.b.a.h(1, this.rbW) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(3, this.hbL);
            }
            if (this.jPM != null) {
                h += f.a.a.b.b.a.h(4, this.jPM);
            }
            if (this.rDu != null) {
                h += f.a.a.b.b.a.h(5, this.rDu);
            }
            if (this.rDv != null) {
                h += f.a.a.b.b.a.h(6, this.rDv);
            }
            if (this.rhq != null) {
                h += f.a.a.b.b.a.h(7, this.rhq);
            }
            if (this.rsy != null) {
                h += f.a.a.b.b.a.h(8, this.rsy);
            }
            if (this.rDw != null) {
                h += f.a.a.b.b.a.h(9, this.rDw);
            }
            return h + f.a.a.a.fQ(10, this.qZg);
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
            xq xqVar = (xq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xqVar.rbW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xqVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    xqVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    xqVar.jPM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    xqVar.rDu = aVar3.vHC.readString();
                    return 0;
                case 6:
                    xqVar.rDv = aVar3.vHC.readString();
                    return 0;
                case 7:
                    xqVar.rhq = aVar3.vHC.readString();
                    return 0;
                case 8:
                    xqVar.rsy = aVar3.vHC.readString();
                    return 0;
                case 9:
                    xqVar.rDw = aVar3.vHC.readString();
                    return 0;
                case 10:
                    xqVar.qZg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
