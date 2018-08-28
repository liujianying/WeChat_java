package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class axa extends a {
    public String ecE;
    public int rko;
    public int rth;
    public int ruE;
    public int saf;
    public int sag;
    public String sah;
    public int sai;
    public String saj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ecE != null) {
                aVar.g(1, this.ecE);
            }
            aVar.fT(2, this.saf);
            aVar.fT(3, this.sag);
            aVar.fT(4, this.rko);
            if (this.sah != null) {
                aVar.g(5, this.sah);
            }
            aVar.fT(6, this.ruE);
            aVar.fT(7, this.sai);
            aVar.fT(8, this.rth);
            if (this.saj == null) {
                return 0;
            }
            aVar.g(9, this.saj);
            return 0;
        } else if (i == 1) {
            if (this.ecE != null) {
                h = f.a.a.b.b.a.h(1, this.ecE) + 0;
            } else {
                h = 0;
            }
            h = ((h + f.a.a.a.fQ(2, this.saf)) + f.a.a.a.fQ(3, this.sag)) + f.a.a.a.fQ(4, this.rko);
            if (this.sah != null) {
                h += f.a.a.b.b.a.h(5, this.sah);
            }
            h = ((h + f.a.a.a.fQ(6, this.ruE)) + f.a.a.a.fQ(7, this.sai)) + f.a.a.a.fQ(8, this.rth);
            if (this.saj != null) {
                h += f.a.a.b.b.a.h(9, this.saj);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            axa axa = (axa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axa.ecE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    axa.saf = aVar3.vHC.rY();
                    return 0;
                case 3:
                    axa.sag = aVar3.vHC.rY();
                    return 0;
                case 4:
                    axa.rko = aVar3.vHC.rY();
                    return 0;
                case 5:
                    axa.sah = aVar3.vHC.readString();
                    return 0;
                case 6:
                    axa.ruE = aVar3.vHC.rY();
                    return 0;
                case 7:
                    axa.sai = aVar3.vHC.rY();
                    return 0;
                case 8:
                    axa.rth = aVar3.vHC.rY();
                    return 0;
                case 9:
                    axa.saj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
