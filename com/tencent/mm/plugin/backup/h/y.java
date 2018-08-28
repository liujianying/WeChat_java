package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class y extends a {
    public String hcI;
    public int hcJ;
    public int hcL;
    public int hcM;
    public int hcd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hcI == null) {
                throw new b("Not all required fields were included: DataID");
            }
            if (this.hcI != null) {
                aVar.g(1, this.hcI);
            }
            aVar.fT(2, this.hcJ);
            aVar.fT(3, this.hcL);
            aVar.fT(4, this.hcM);
            aVar.fT(5, this.hcd);
            return 0;
        } else if (i == 1) {
            if (this.hcI != null) {
                h = f.a.a.b.b.a.h(1, this.hcI) + 0;
            } else {
                h = 0;
            }
            return (((h + f.a.a.a.fQ(2, this.hcJ)) + f.a.a.a.fQ(3, this.hcL)) + f.a.a.a.fQ(4, this.hcM)) + f.a.a.a.fQ(5, this.hcd);
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
            throw new b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.hcI = aVar3.vHC.readString();
                    return 0;
                case 2:
                    yVar.hcJ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    yVar.hcL = aVar3.vHC.rY();
                    return 0;
                case 4:
                    yVar.hcM = aVar3.vHC.rY();
                    return 0;
                case 5:
                    yVar.hcd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
