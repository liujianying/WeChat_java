package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class axb extends a {
    public int rko;
    public int rth;
    public int sai;
    public String saj;
    public String sak;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rko);
            if (this.sak != null) {
                aVar.g(3, this.sak);
            }
            aVar.fT(4, this.sai);
            aVar.fT(5, this.rth);
            if (this.saj != null) {
                aVar.g(6, this.saj);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rko) + 0;
            if (this.sak != null) {
                fQ += f.a.a.b.b.a.h(3, this.sak);
            }
            fQ = (fQ + f.a.a.a.fQ(4, this.sai)) + f.a.a.a.fQ(5, this.rth);
            if (this.saj != null) {
                return fQ + f.a.a.b.b.a.h(6, this.saj);
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
            axb axb = (axb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axb.rko = aVar3.vHC.rY();
                    return 0;
                case 3:
                    axb.sak = aVar3.vHC.readString();
                    return 0;
                case 4:
                    axb.sai = aVar3.vHC.rY();
                    return 0;
                case 5:
                    axb.rth = aVar3.vHC.rY();
                    return 0;
                case 6:
                    axb.saj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
