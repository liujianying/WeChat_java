package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class hz extends a {
    public String hyG;
    public String riF;
    public int riG;
    public String riJ;
    public String riL;
    public String riT;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riL != null) {
                aVar.g(1, this.riL);
            }
            if (this.hyG != null) {
                aVar.g(2, this.hyG);
            }
            aVar.fT(3, this.ver);
            if (this.riF != null) {
                aVar.g(4, this.riF);
            }
            if (this.riT != null) {
                aVar.g(5, this.riT);
            }
            aVar.fT(6, this.riG);
            if (this.riJ == null) {
                return 0;
            }
            aVar.g(7, this.riJ);
            return 0;
        } else if (i == 1) {
            if (this.riL != null) {
                h = f.a.a.b.b.a.h(1, this.riL) + 0;
            } else {
                h = 0;
            }
            if (this.hyG != null) {
                h += f.a.a.b.b.a.h(2, this.hyG);
            }
            h += f.a.a.a.fQ(3, this.ver);
            if (this.riF != null) {
                h += f.a.a.b.b.a.h(4, this.riF);
            }
            if (this.riT != null) {
                h += f.a.a.b.b.a.h(5, this.riT);
            }
            h += f.a.a.a.fQ(6, this.riG);
            if (this.riJ != null) {
                h += f.a.a.b.b.a.h(7, this.riJ);
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
            hz hzVar = (hz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hzVar.riL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    hzVar.hyG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hzVar.ver = aVar3.vHC.rY();
                    return 0;
                case 4:
                    hzVar.riF = aVar3.vHC.readString();
                    return 0;
                case 5:
                    hzVar.riT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    hzVar.riG = aVar3.vHC.rY();
                    return 0;
                case 7:
                    hzVar.riJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
