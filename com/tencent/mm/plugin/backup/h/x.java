package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class x extends a {
    public b hbs;
    public String hcI;
    public int hcJ;
    public int hcK;
    public int hcL;
    public int hcM;
    public int hcN;
    public int hcO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hcI == null) {
                throw new f.a.a.b("Not all required fields were included: DataID");
            }
            if (this.hcI != null) {
                aVar.g(1, this.hcI);
            }
            aVar.fT(2, this.hcJ);
            aVar.fT(3, this.hcK);
            aVar.fT(4, this.hcL);
            aVar.fT(5, this.hcM);
            aVar.fT(6, this.hcN);
            if (this.hbs != null) {
                aVar.b(7, this.hbs);
            }
            aVar.fT(8, this.hcO);
            return 0;
        } else if (i == 1) {
            if (this.hcI != null) {
                h = f.a.a.b.b.a.h(1, this.hcI) + 0;
            } else {
                h = 0;
            }
            h = ((((h + f.a.a.a.fQ(2, this.hcJ)) + f.a.a.a.fQ(3, this.hcK)) + f.a.a.a.fQ(4, this.hcL)) + f.a.a.a.fQ(5, this.hcM)) + f.a.a.a.fQ(6, this.hcN);
            if (this.hbs != null) {
                h += f.a.a.a.a(7, this.hbs);
            }
            return h + f.a.a.a.fQ(8, this.hcO);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hcI != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.hcI = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xVar.hcJ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    xVar.hcK = aVar3.vHC.rY();
                    return 0;
                case 4:
                    xVar.hcL = aVar3.vHC.rY();
                    return 0;
                case 5:
                    xVar.hcM = aVar3.vHC.rY();
                    return 0;
                case 6:
                    xVar.hcN = aVar3.vHC.rY();
                    return 0;
                case 7:
                    xVar.hbs = aVar3.cJR();
                    return 0;
                case 8:
                    xVar.hcO = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
