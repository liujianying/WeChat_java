package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class iy extends a {
    public int port;
    public b rkk;
    public b rkl;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.type);
            aVar.fT(2, this.port);
            if (this.rkk != null) {
                aVar.b(3, this.rkk);
            }
            if (this.rkl != null) {
                aVar.b(4, this.rkl);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.type) + 0) + f.a.a.a.fQ(2, this.port);
            if (this.rkk != null) {
                fQ += f.a.a.a.a(3, this.rkk);
            }
            if (this.rkl != null) {
                return fQ + f.a.a.a.a(4, this.rkl);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            iy iyVar = (iy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iyVar.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    iyVar.port = aVar3.vHC.rY();
                    return 0;
                case 3:
                    iyVar.rkk = aVar3.cJR();
                    return 0;
                case 4:
                    iyVar.rkl = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
