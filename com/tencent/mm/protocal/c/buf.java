package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class buf extends a {
    public b srD;
    public String srE;
    public b srF;
    public int uin;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.srD != null) {
                aVar.b(1, this.srD);
            }
            if (this.srE != null) {
                aVar.g(2, this.srE);
            }
            if (this.srF != null) {
                aVar.b(3, this.srF);
            }
            aVar.fT(4, this.uin);
            return 0;
        } else if (i == 1) {
            if (this.srD != null) {
                a = f.a.a.a.a(1, this.srD) + 0;
            } else {
                a = 0;
            }
            if (this.srE != null) {
                a += f.a.a.b.b.a.h(2, this.srE);
            }
            if (this.srF != null) {
                a += f.a.a.a.a(3, this.srF);
            }
            return a + f.a.a.a.fQ(4, this.uin);
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
            buf buf = (buf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buf.srD = aVar3.cJR();
                    return 0;
                case 2:
                    buf.srE = aVar3.vHC.readString();
                    return 0;
                case 3:
                    buf.srF = aVar3.cJR();
                    return 0;
                case 4:
                    buf.uin = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
