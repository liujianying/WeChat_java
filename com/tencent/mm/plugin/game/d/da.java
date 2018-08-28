package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class da extends a {
    public String jPe;
    public int jSc;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            }
            aVar.fT(1, this.jSc);
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jSc) + 0;
            if (this.jPe != null) {
                return fQ + f.a.a.b.b.a.h(2, this.jPe);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.jPe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Name");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            da daVar = (da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    daVar.jSc = aVar3.vHC.rY();
                    return 0;
                case 2:
                    daVar.jPe = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
