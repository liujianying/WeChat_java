package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class r extends a {
    public String jOZ;
    public int jQa;
    public String jQb;
    public int jQc;
    public int jQd;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.jQa);
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            aVar.fT(3, this.jQc);
            if (this.jOZ != null) {
                aVar.g(4, this.jOZ);
            }
            aVar.fT(5, this.jQd);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jQa) + 0;
            if (this.jQb != null) {
                fQ += f.a.a.b.b.a.h(2, this.jQb);
            }
            fQ += f.a.a.a.fQ(3, this.jQc);
            if (this.jOZ != null) {
                fQ += f.a.a.b.b.a.h(4, this.jOZ);
            }
            return fQ + f.a.a.a.fQ(5, this.jQd);
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
            r rVar = (r) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rVar.jQa = aVar3.vHC.rY();
                    return 0;
                case 2:
                    rVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    rVar.jQc = aVar3.vHC.rY();
                    return 0;
                case 4:
                    rVar.jOZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    rVar.jQd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
