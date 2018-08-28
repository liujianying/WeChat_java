package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class alr extends a {
    public String kRt;
    public String kRu;
    public String kRv;
    public String kRw;
    public int qYW;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qYW);
            if (this.kRt != null) {
                aVar.g(2, this.kRt);
            }
            if (this.kRu != null) {
                aVar.g(3, this.kRu);
            }
            if (this.kRv != null) {
                aVar.g(4, this.kRv);
            }
            if (this.kRw != null) {
                aVar.g(5, this.kRw);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.qYW) + 0;
            if (this.kRt != null) {
                fQ += f.a.a.b.b.a.h(2, this.kRt);
            }
            if (this.kRu != null) {
                fQ += f.a.a.b.b.a.h(3, this.kRu);
            }
            if (this.kRv != null) {
                fQ += f.a.a.b.b.a.h(4, this.kRv);
            }
            if (this.kRw != null) {
                return fQ + f.a.a.b.b.a.h(5, this.kRw);
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
            alr alr = (alr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alr.qYW = aVar3.vHC.rY();
                    return 0;
                case 2:
                    alr.kRt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    alr.kRu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    alr.kRv = aVar3.vHC.readString();
                    return 0;
                case 5:
                    alr.kRw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
