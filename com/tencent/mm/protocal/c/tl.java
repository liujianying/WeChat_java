package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class tl extends a {
    public String jPG;
    public int rgA;
    public String rwK;
    public String rwL;
    public int rwM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwL != null) {
                aVar.g(1, this.rwL);
            }
            aVar.fT(2, this.rgA);
            aVar.fT(3, this.rwM);
            if (this.jPG != null) {
                aVar.g(4, this.jPG);
            }
            if (this.rwK == null) {
                return 0;
            }
            aVar.g(5, this.rwK);
            return 0;
        } else if (i == 1) {
            if (this.rwL != null) {
                h = f.a.a.b.b.a.h(1, this.rwL) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.rgA)) + f.a.a.a.fQ(3, this.rwM);
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(4, this.jPG);
            }
            if (this.rwK != null) {
                h += f.a.a.b.b.a.h(5, this.rwK);
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
            tl tlVar = (tl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tlVar.rwL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tlVar.rgA = aVar3.vHC.rY();
                    return 0;
                case 3:
                    tlVar.rwM = aVar3.vHC.rY();
                    return 0;
                case 4:
                    tlVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 5:
                    tlVar.rwK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
