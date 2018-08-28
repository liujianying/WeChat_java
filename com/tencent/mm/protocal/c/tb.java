package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class tb extends a {
    public int rwr;
    public String rws;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rws == null) {
                throw new b("Not all required fields were included: TagDesc");
            }
            aVar.fT(1, this.rwr);
            if (this.rws != null) {
                aVar.g(2, this.rws);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rwr) + 0;
            if (this.rws != null) {
                return fQ + f.a.a.b.b.a.h(2, this.rws);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rws != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TagDesc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            tb tbVar = (tb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tbVar.rwr = aVar3.vHC.rY();
                    return 0;
                case 2:
                    tbVar.rws = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
