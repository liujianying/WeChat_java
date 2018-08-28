package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class hs extends a {
    public String name;
    public String riE;
    public String riF;
    public int riG;
    public int riH;
    public String riI;
    public String riJ;
    public int type;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riE != null) {
                aVar.g(1, this.riE);
            }
            aVar.fT(2, this.type);
            if (this.riF != null) {
                aVar.g(3, this.riF);
            }
            if (this.name != null) {
                aVar.g(4, this.name);
            }
            aVar.fT(5, this.ver);
            aVar.fT(6, this.riG);
            aVar.fT(7, this.riH);
            if (this.riI != null) {
                aVar.g(8, this.riI);
            }
            if (this.riJ == null) {
                return 0;
            }
            aVar.g(9, this.riJ);
            return 0;
        } else if (i == 1) {
            if (this.riE != null) {
                h = f.a.a.b.b.a.h(1, this.riE) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.type);
            if (this.riF != null) {
                h += f.a.a.b.b.a.h(3, this.riF);
            }
            if (this.name != null) {
                h += f.a.a.b.b.a.h(4, this.name);
            }
            h = ((h + f.a.a.a.fQ(5, this.ver)) + f.a.a.a.fQ(6, this.riG)) + f.a.a.a.fQ(7, this.riH);
            if (this.riI != null) {
                h += f.a.a.b.b.a.h(8, this.riI);
            }
            if (this.riJ != null) {
                h += f.a.a.b.b.a.h(9, this.riJ);
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
            hs hsVar = (hs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hsVar.riE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    hsVar.type = aVar3.vHC.rY();
                    return 0;
                case 3:
                    hsVar.riF = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hsVar.name = aVar3.vHC.readString();
                    return 0;
                case 5:
                    hsVar.ver = aVar3.vHC.rY();
                    return 0;
                case 6:
                    hsVar.riG = aVar3.vHC.rY();
                    return 0;
                case 7:
                    hsVar.riH = aVar3.vHC.rY();
                    return 0;
                case 8:
                    hsVar.riI = aVar3.vHC.readString();
                    return 0;
                case 9:
                    hsVar.riJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
