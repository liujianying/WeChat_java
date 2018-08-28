package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bsc extends a {
    public String spJ;
    public int spK;
    public int spL;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.spJ != null) {
                aVar.g(1, this.spJ);
            }
            aVar.fT(2, this.spK);
            aVar.fT(3, this.spL);
            return 0;
        } else if (i == 1) {
            if (this.spJ != null) {
                h = f.a.a.b.b.a.h(1, this.spJ) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.fQ(2, this.spK)) + f.a.a.a.fQ(3, this.spL);
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
            bsc bsc = (bsc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsc.spJ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bsc.spK = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bsc.spL = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
