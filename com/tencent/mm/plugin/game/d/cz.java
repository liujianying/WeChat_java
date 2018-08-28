package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class cz extends a {
    public String bHD;
    public String jOT;
    public String jOU;
    public int jTr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jOU != null) {
                aVar.g(2, this.jOU);
            }
            if (this.jOT != null) {
                aVar.g(3, this.jOT);
            }
            aVar.fT(4, this.jTr);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(2, this.jOU);
            }
            if (this.jOT != null) {
                h += f.a.a.b.b.a.h(3, this.jOT);
            }
            return h + f.a.a.a.fQ(4, this.jTr);
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
            cz czVar = (cz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    czVar.jOU = aVar3.vHC.readString();
                    return 0;
                case 3:
                    czVar.jOT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    czVar.jTr = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
