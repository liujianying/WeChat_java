package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ut extends a {
    public int ryb;
    public String ryc;
    public String ryd;
    public String rye;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.ryb);
            if (this.ryc != null) {
                aVar.g(2, this.ryc);
            }
            if (this.rye != null) {
                aVar.g(3, this.rye);
            }
            if (this.ryd != null) {
                aVar.g(4, this.ryd);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.ryb) + 0;
            if (this.ryc != null) {
                fQ += f.a.a.b.b.a.h(2, this.ryc);
            }
            if (this.rye != null) {
                fQ += f.a.a.b.b.a.h(3, this.rye);
            }
            if (this.ryd != null) {
                return fQ + f.a.a.b.b.a.h(4, this.ryd);
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
            ut utVar = (ut) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    utVar.ryb = aVar3.vHC.rY();
                    return 0;
                case 2:
                    utVar.ryc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    utVar.rye = aVar3.vHC.readString();
                    return 0;
                case 4:
                    utVar.ryd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
