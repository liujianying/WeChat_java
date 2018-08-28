package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ccd extends a {
    public String bHD;
    public String rem;
    public String sdK;
    public int syc;
    public String syd;
    public String sye;
    public String syf;
    public String syg;
    public String syh;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.rem != null) {
                aVar.g(2, this.rem);
            }
            aVar.fT(3, this.syc);
            if (this.syd != null) {
                aVar.g(4, this.syd);
            }
            if (this.sdK != null) {
                aVar.g(5, this.sdK);
            }
            if (this.sye != null) {
                aVar.g(6, this.sye);
            }
            if (this.syf != null) {
                aVar.g(7, this.syf);
            }
            if (this.syg != null) {
                aVar.g(8, this.syg);
            }
            if (this.syh == null) {
                return 0;
            }
            aVar.g(9, this.syh);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.rem != null) {
                h += f.a.a.b.b.a.h(2, this.rem);
            }
            h += f.a.a.a.fQ(3, this.syc);
            if (this.syd != null) {
                h += f.a.a.b.b.a.h(4, this.syd);
            }
            if (this.sdK != null) {
                h += f.a.a.b.b.a.h(5, this.sdK);
            }
            if (this.sye != null) {
                h += f.a.a.b.b.a.h(6, this.sye);
            }
            if (this.syf != null) {
                h += f.a.a.b.b.a.h(7, this.syf);
            }
            if (this.syg != null) {
                h += f.a.a.b.b.a.h(8, this.syg);
            }
            if (this.syh != null) {
                h += f.a.a.b.b.a.h(9, this.syh);
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
            ccd ccd = (ccd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccd.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ccd.rem = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ccd.syc = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ccd.syd = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ccd.sdK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ccd.sye = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ccd.syf = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ccd.syg = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ccd.syh = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
