package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cfe extends a {
    public b rdU;
    public int rvV;
    public boolean szM;
    public boolean szN;
    public String szk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            }
            if (this.szk != null) {
                aVar.g(1, this.szk);
            }
            aVar.fT(2, this.rvV);
            if (this.rdU != null) {
                aVar.b(3, this.rdU);
            }
            aVar.av(4, this.szM);
            aVar.av(5, this.szN);
            return 0;
        } else if (i == 1) {
            if (this.szk != null) {
                h = f.a.a.b.b.a.h(1, this.szk) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rvV);
            if (this.rdU != null) {
                h += f.a.a.a.a(3, this.rdU);
            }
            return (h + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.szk != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfe cfe = (cfe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfe.szk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cfe.rvV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfe.rdU = aVar3.cJR();
                    return 0;
                case 4:
                    cfe.szM = aVar3.cJQ();
                    return 0;
                case 5:
                    cfe.szN = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
