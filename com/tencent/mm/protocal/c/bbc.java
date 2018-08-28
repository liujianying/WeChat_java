package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bbc extends a {
    public String peY;
    public int rNB;
    public String rvK;
    public String sdq;
    public String sdr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sdq != null) {
                aVar.g(1, this.sdq);
            }
            if (this.sdr != null) {
                aVar.g(2, this.sdr);
            }
            if (this.peY != null) {
                aVar.g(3, this.peY);
            }
            if (this.rvK != null) {
                aVar.g(4, this.rvK);
            }
            aVar.fT(5, this.rNB);
            return 0;
        } else if (i == 1) {
            if (this.sdq != null) {
                h = f.a.a.b.b.a.h(1, this.sdq) + 0;
            } else {
                h = 0;
            }
            if (this.sdr != null) {
                h += f.a.a.b.b.a.h(2, this.sdr);
            }
            if (this.peY != null) {
                h += f.a.a.b.b.a.h(3, this.peY);
            }
            if (this.rvK != null) {
                h += f.a.a.b.b.a.h(4, this.rvK);
            }
            return h + f.a.a.a.fQ(5, this.rNB);
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
            bbc bbc = (bbc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbc.sdq = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bbc.sdr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbc.peY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbc.rvK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbc.rNB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
