package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class t extends a {
    public int qYA;
    public long qYl;
    public String qYy;
    public long qYz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qYy != null) {
                aVar.g(1, this.qYy);
            }
            aVar.T(2, this.qYl);
            aVar.T(3, this.qYz);
            aVar.fT(4, this.qYA);
            return 0;
        } else if (i == 1) {
            if (this.qYy != null) {
                h = f.a.a.b.b.a.h(1, this.qYy) + 0;
            } else {
                h = 0;
            }
            return ((h + f.a.a.a.S(2, this.qYl)) + f.a.a.a.S(3, this.qYz)) + f.a.a.a.fQ(4, this.qYA);
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
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.qYy = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tVar.qYl = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    tVar.qYz = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    tVar.qYA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
