package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class m extends a {
    public String jOX;
    public int jPL;
    public String jPd;
    public String jPe;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jPd == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                aVar.fT(1, this.jPL);
                if (this.jPe != null) {
                    aVar.g(2, this.jPe);
                }
                if (this.jPd != null) {
                    aVar.g(3, this.jPd);
                }
                if (this.jOX != null) {
                    aVar.g(4, this.jOX);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jPL) + 0;
            if (this.jPe != null) {
                fQ += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.jPd != null) {
                fQ += f.a.a.b.b.a.h(3, this.jPd);
            }
            if (this.jOX != null) {
                return fQ + f.a.a.b.b.a.h(4, this.jOX);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jPd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.jPL = aVar3.vHC.rY();
                    return 0;
                case 2:
                    mVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mVar.jPd = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mVar.jOX = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
