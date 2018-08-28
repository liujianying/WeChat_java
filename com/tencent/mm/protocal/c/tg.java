package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class tg extends a {
    public String jPG;
    public String jPe;
    public String rwC;
    public int rwD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            if (this.jPG != null) {
                aVar.g(2, this.jPG);
            }
            if (this.rwC != null) {
                aVar.g(3, this.rwC);
            }
            aVar.fT(4, this.rwD);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(2, this.jPG);
            }
            if (this.rwC != null) {
                h += f.a.a.b.b.a.h(3, this.rwC);
            }
            return h + f.a.a.a.fQ(4, this.rwD);
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
            tg tgVar = (tg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tgVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tgVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    tgVar.rwC = aVar3.vHC.readString();
                    return 0;
                case 4:
                    tgVar.rwD = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
