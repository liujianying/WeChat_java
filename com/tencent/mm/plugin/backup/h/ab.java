package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class ab extends a {
    public int hbr;
    public b hbs;
    public int hcT;
    public int hcU;
    public long hcV;
    public long hcc;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hbr);
            if (this.hbs != null) {
                aVar.b(2, this.hbs);
            }
            aVar.fT(3, this.hcT);
            aVar.fT(4, this.hcU);
            aVar.T(5, this.hcV);
            aVar.T(6, this.hcc);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hbr) + 0;
            if (this.hbs != null) {
                fQ += f.a.a.a.a(2, this.hbs);
            }
            return (((fQ + f.a.a.a.fQ(3, this.hcT)) + f.a.a.a.fQ(4, this.hcU)) + f.a.a.a.S(5, this.hcV)) + f.a.a.a.S(6, this.hcc);
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
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.hbr = aVar3.vHC.rY();
                    return 0;
                case 2:
                    abVar.hbs = aVar3.cJR();
                    return 0;
                case 3:
                    abVar.hcT = aVar3.vHC.rY();
                    return 0;
                case 4:
                    abVar.hcU = aVar3.vHC.rY();
                    return 0;
                case 5:
                    abVar.hcV = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    abVar.hcc = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
