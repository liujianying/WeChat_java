package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;

public final class b extends a {
    public int hbr;
    public com.tencent.mm.bk.b hbs;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hbr);
            if (this.hbs != null) {
                aVar.b(2, this.hbs);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hbr) + 0;
            if (this.hbs != null) {
                return fQ + f.a.a.a.a(2, this.hbs);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.hbr = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bVar.hbs = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
