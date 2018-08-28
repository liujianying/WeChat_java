package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class w extends a {
    public String ID;
    public b hbs;
    public int hcC;
    public int hcD;
    public int hcE;
    public int hcF;
    public b hcH;
    public int hcd;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new f.a.a.b("Not all required fields were included: ID");
            }
            aVar.fT(1, this.hcC);
            aVar.fT(2, this.hcd);
            if (this.ID != null) {
                aVar.g(3, this.ID);
            }
            if (this.hbs != null) {
                aVar.b(4, this.hbs);
            }
            aVar.fT(5, this.hcD);
            aVar.fT(6, this.hcE);
            aVar.fT(7, this.hcF);
            if (this.hcH != null) {
                aVar.b(8, this.hcH);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.hcC) + 0) + f.a.a.a.fQ(2, this.hcd);
            if (this.ID != null) {
                fQ += f.a.a.b.b.a.h(3, this.ID);
            }
            if (this.hbs != null) {
                fQ += f.a.a.a.a(4, this.hbs);
            }
            fQ = ((fQ + f.a.a.a.fQ(5, this.hcD)) + f.a.a.a.fQ(6, this.hcE)) + f.a.a.a.fQ(7, this.hcF);
            if (this.hcH != null) {
                return fQ + f.a.a.a.a(8, this.hcH);
            }
            return fQ;
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
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.hcC = aVar3.vHC.rY();
                    return 0;
                case 2:
                    wVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    wVar.ID = aVar3.vHC.readString();
                    return 0;
                case 4:
                    wVar.hbs = aVar3.cJR();
                    return 0;
                case 5:
                    wVar.hcD = aVar3.vHC.rY();
                    return 0;
                case 6:
                    wVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 7:
                    wVar.hcF = aVar3.vHC.rY();
                    return 0;
                case 8:
                    wVar.hcH = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
