package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ayl extends a {
    public String cac;
    public String hwJ;
    public int sbp;
    public int sbq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.cac != null) {
                aVar.g(1, this.cac);
            }
            if (this.hwJ != null) {
                aVar.g(2, this.hwJ);
            }
            aVar.fT(3, this.sbp);
            aVar.fT(4, this.sbq);
            return 0;
        } else if (i == 1) {
            if (this.cac != null) {
                h = f.a.a.b.b.a.h(1, this.cac) + 0;
            } else {
                h = 0;
            }
            if (this.hwJ != null) {
                h += f.a.a.b.b.a.h(2, this.hwJ);
            }
            return (h + f.a.a.a.fQ(3, this.sbp)) + f.a.a.a.fQ(4, this.sbq);
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
            ayl ayl = (ayl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayl.cac = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ayl.hwJ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ayl.sbp = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ayl.sbq = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
