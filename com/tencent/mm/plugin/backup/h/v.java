package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class v extends a {
    public String ID;
    public b hbs;
    public int hcC;
    public int hcD;
    public int hcE;
    public int hcF;
    public int hcG;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new f.a.a.b("Not all required fields were included: ID");
            }
            aVar.fT(1, this.hcC);
            if (this.ID != null) {
                aVar.g(2, this.ID);
            }
            if (this.hbs != null) {
                aVar.b(3, this.hbs);
            }
            aVar.fT(4, this.hcD);
            aVar.fT(5, this.hcE);
            aVar.fT(6, this.hcF);
            aVar.fT(7, this.hcG);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcC) + 0;
            if (this.ID != null) {
                fQ += f.a.a.b.b.a.h(2, this.ID);
            }
            if (this.hbs != null) {
                fQ += f.a.a.a.a(3, this.hbs);
            }
            return (((fQ + f.a.a.a.fQ(4, this.hcD)) + f.a.a.a.fQ(5, this.hcE)) + f.a.a.a.fQ(6, this.hcF)) + f.a.a.a.fQ(7, this.hcG);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.hcC = aVar3.vHC.rY();
                    return 0;
                case 2:
                    vVar.ID = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vVar.hbs = aVar3.cJR();
                    return 0;
                case 4:
                    vVar.hcD = aVar3.vHC.rY();
                    return 0;
                case 5:
                    vVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    vVar.hcF = aVar3.vHC.rY();
                    return 0;
                case 7:
                    vVar.hcG = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
