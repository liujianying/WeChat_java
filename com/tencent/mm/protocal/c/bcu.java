package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bcu extends a {
    public String hbL;
    public String rqY;
    public int ruw;
    public int seX;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.rqY != null) {
                aVar.g(2, this.rqY);
            }
            aVar.fT(3, this.seX);
            aVar.fT(4, this.ruw);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.rqY != null) {
                h += f.a.a.b.b.a.h(2, this.rqY);
            }
            return (h + f.a.a.a.fQ(3, this.seX)) + f.a.a.a.fQ(4, this.ruw);
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
            bcu bcu = (bcu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcu.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bcu.rqY = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bcu.seX = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bcu.ruw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
