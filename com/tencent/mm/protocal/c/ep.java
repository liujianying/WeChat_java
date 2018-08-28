package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ep extends a {
    public String eJK;
    public String hbL;
    public String hcS;
    public int joi;
    public String rbW;
    public int rfa;
    public String rfb;
    public String rfc;

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
            aVar.fT(4, this.rfa);
            if (this.rfb != null) {
                aVar.g(5, this.rfb);
            }
            if (this.eJK != null) {
                aVar.g(6, this.eJK);
            }
            if (this.rfc != null) {
                aVar.g(7, this.rfc);
            }
            aVar.fT(8, this.joi);
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
            h += f.a.a.a.fQ(4, this.rfa);
            if (this.rfb != null) {
                h += f.a.a.b.b.a.h(5, this.rfb);
            }
            if (this.eJK != null) {
                h += f.a.a.b.b.a.h(6, this.eJK);
            }
            if (this.rfc != null) {
                h += f.a.a.b.b.a.h(7, this.rfc);
            }
            return h + f.a.a.a.fQ(8, this.joi);
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
            ep epVar = (ep) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epVar.rbW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    epVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    epVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    epVar.rfa = aVar3.vHC.rY();
                    return 0;
                case 5:
                    epVar.rfb = aVar3.vHC.readString();
                    return 0;
                case 6:
                    epVar.eJK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    epVar.rfc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    epVar.joi = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
