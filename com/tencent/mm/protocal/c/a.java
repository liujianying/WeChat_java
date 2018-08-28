package com.tencent.mm.protocal.c;

public final class a extends com.tencent.mm.bk.a {
    public String bSc;
    public int bWA;
    public String hUt;
    public String kRu;
    public String kRv;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.bWA);
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            if (this.kRu != null) {
                aVar.g(3, this.kRu);
            }
            if (this.kRv != null) {
                aVar.g(4, this.kRv);
            }
            if (this.hUt != null) {
                aVar.g(5, this.hUt);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.bWA) + 0;
            if (this.bSc != null) {
                fQ += f.a.a.b.b.a.h(2, this.bSc);
            }
            if (this.kRu != null) {
                fQ += f.a.a.b.b.a.h(3, this.kRu);
            }
            if (this.kRv != null) {
                fQ += f.a.a.b.b.a.h(4, this.kRv);
            }
            if (this.hUt != null) {
                return fQ + f.a.a.b.b.a.h(5, this.hUt);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = com.tencent.mm.bk.a.a(aVar2); fQ > 0; fQ = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.bWA = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aVar4.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aVar4.kRu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aVar4.kRv = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aVar4.hUt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
