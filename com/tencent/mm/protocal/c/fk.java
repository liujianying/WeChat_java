package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class fk extends a {
    public int iwE;
    public int otY;
    public b rgr;
    public b rgs;
    public int rgt;
    public b rgu;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rgr != null) {
                aVar.b(1, this.rgr);
            }
            aVar.fT(2, this.iwE);
            if (this.rgs != null) {
                aVar.b(3, this.rgs);
            }
            aVar.fT(4, this.rgt);
            if (this.rgu != null) {
                aVar.b(5, this.rgu);
            }
            aVar.fT(6, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.rgr != null) {
                a = f.a.a.a.a(1, this.rgr) + 0;
            } else {
                a = 0;
            }
            a += f.a.a.a.fQ(2, this.iwE);
            if (this.rgs != null) {
                a += f.a.a.a.a(3, this.rgs);
            }
            a += f.a.a.a.fQ(4, this.rgt);
            if (this.rgu != null) {
                a += f.a.a.a.a(5, this.rgu);
            }
            return a + f.a.a.a.fQ(6, this.otY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            fk fkVar = (fk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fkVar.rgr = aVar3.cJR();
                    return 0;
                case 2:
                    fkVar.iwE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    fkVar.rgs = aVar3.cJR();
                    return 0;
                case 4:
                    fkVar.rgt = aVar3.vHC.rY();
                    return 0;
                case 5:
                    fkVar.rgu = aVar3.cJR();
                    return 0;
                case 6:
                    fkVar.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
