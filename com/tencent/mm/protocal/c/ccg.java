package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ccg extends a {
    public String eJQ;
    public String syk;
    public int syl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syk != null) {
                aVar.g(1, this.syk);
            }
            if (this.eJQ != null) {
                aVar.g(2, this.eJQ);
            }
            aVar.fT(3, this.syl);
            return 0;
        } else if (i == 1) {
            if (this.syk != null) {
                h = f.a.a.b.b.a.h(1, this.syk) + 0;
            } else {
                h = 0;
            }
            if (this.eJQ != null) {
                h += f.a.a.b.b.a.h(2, this.eJQ);
            }
            return h + f.a.a.a.fQ(3, this.syl);
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
            ccg ccg = (ccg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccg.syk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ccg.eJQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ccg.syl = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
