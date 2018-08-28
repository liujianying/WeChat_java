package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bqh extends a {
    public int rSI;
    public int rvt;
    public int sog;
    public int soh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rvt);
            aVar.fT(2, this.rSI);
            aVar.fT(3, this.sog);
            aVar.fT(4, this.soh);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.rvt) + 0) + f.a.a.a.fQ(2, this.rSI)) + f.a.a.a.fQ(3, this.sog)) + f.a.a.a.fQ(4, this.soh);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                bqh bqh = (bqh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bqh.rvt = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bqh.rSI = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        bqh.sog = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        bqh.soh = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
