package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class pg extends a {
    public String hcr;
    public int otY;
    public String rtC;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rtC == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.rtC != null) {
                aVar.g(1, this.rtC);
            }
            if (this.hcr != null) {
                aVar.g(2, this.hcr);
            }
            aVar.fT(3, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.rtC != null) {
                h = f.a.a.b.b.a.h(1, this.rtC) + 0;
            } else {
                h = 0;
            }
            if (this.hcr != null) {
                h += f.a.a.b.b.a.h(2, this.hcr);
            }
            return h + f.a.a.a.fQ(3, this.otY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rtC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            pg pgVar = (pg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pgVar.rtC = aVar3.vHC.readString();
                    return 0;
                case 2:
                    pgVar.hcr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    pgVar.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
