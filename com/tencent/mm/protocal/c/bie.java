package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bie extends a {
    public int hbF;
    public String rJU;
    public String sdV;
    public String sdW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rJU != null) {
                aVar.g(1, this.rJU);
            }
            if (this.sdW != null) {
                aVar.g(2, this.sdW);
            }
            aVar.fT(3, this.hbF);
            if (this.sdV == null) {
                return 0;
            }
            aVar.g(4, this.sdV);
            return 0;
        } else if (i == 1) {
            if (this.rJU != null) {
                h = f.a.a.b.b.a.h(1, this.rJU) + 0;
            } else {
                h = 0;
            }
            if (this.sdW != null) {
                h += f.a.a.b.b.a.h(2, this.sdW);
            }
            h += f.a.a.a.fQ(3, this.hbF);
            if (this.sdV != null) {
                h += f.a.a.b.b.a.h(4, this.sdV);
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
            bie bie = (bie) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bie.rJU = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bie.sdW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bie.hbF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bie.sdV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
