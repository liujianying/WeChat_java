package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bk.a;

public final class b extends a {
    public int bzI;
    public int mEb;
    public int mEc;
    public boolean mEd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.bzI);
            aVar.fT(2, this.mEb);
            aVar.fT(3, this.mEc);
            aVar.av(4, this.mEd);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.bzI) + 0) + f.a.a.a.fQ(2, this.mEb)) + f.a.a.a.fQ(3, this.mEc)) + (f.a.a.b.b.a.ec(4) + 1);
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
                b bVar = (b) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bVar.bzI = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bVar.mEb = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        bVar.mEc = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        bVar.mEd = aVar3.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
