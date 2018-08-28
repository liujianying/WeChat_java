package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class c extends a {
    public boolean mEd;
    public int mEk;
    public String mEl;
    public boolean mEm;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.mEl == null) {
                throw new b("Not all required fields were included: Value");
            }
            aVar.fT(1, this.mEk);
            if (this.mEl != null) {
                aVar.g(2, this.mEl);
            }
            aVar.av(3, this.mEm);
            aVar.av(4, this.mEd);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.mEk) + 0;
            if (this.mEl != null) {
                fQ += f.a.a.b.b.a.h(2, this.mEl);
            }
            return (fQ + (f.a.a.b.b.a.ec(3) + 1)) + (f.a.a.b.b.a.ec(4) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.mEl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Value");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.mEk = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cVar.mEl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cVar.mEm = aVar3.cJQ();
                    return 0;
                case 4:
                    cVar.mEd = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
