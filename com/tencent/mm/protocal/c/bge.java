package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bge extends a {
    public int hcE;
    public int ixe;
    public b rvr;
    public int sdX;
    public String shm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.shm != null) {
                aVar.g(1, this.shm);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.ixe);
            aVar.fT(4, this.sdX);
            if (this.rvr == null) {
                return 0;
            }
            aVar.b(5, this.rvr);
            return 0;
        } else if (i == 1) {
            if (this.shm != null) {
                h = f.a.a.b.b.a.h(1, this.shm) + 0;
            } else {
                h = 0;
            }
            h = ((h + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.ixe)) + f.a.a.a.fQ(4, this.sdX);
            if (this.rvr != null) {
                h += f.a.a.a.a(5, this.rvr);
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
            bge bge = (bge) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bge.shm = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bge.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bge.ixe = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bge.sdX = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bge.rvr = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
