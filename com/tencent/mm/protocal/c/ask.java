package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ask extends a {
    public int otY;
    public long rUF;
    public long rUG;
    public String rjK;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.otY);
            if (this.rjK != null) {
                aVar.g(2, this.rjK);
            }
            aVar.T(3, this.rUG);
            aVar.T(4, this.rUF);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.otY) + 0;
            if (this.rjK != null) {
                fQ += f.a.a.b.b.a.h(2, this.rjK);
            }
            return (fQ + f.a.a.a.S(3, this.rUG)) + f.a.a.a.S(4, this.rUF);
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
            ask ask = (ask) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ask.otY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ask.rjK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ask.rUG = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    ask.rUF = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
