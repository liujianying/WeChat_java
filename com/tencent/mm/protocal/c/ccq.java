package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class ccq extends a {
    public b syp;
    public b syq;
    public b syr;
    public b sys;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syp != null) {
                aVar.b(1, this.syp);
            }
            if (this.syq != null) {
                aVar.b(2, this.syq);
            }
            if (this.syr != null) {
                aVar.b(3, this.syr);
            }
            if (this.sys == null) {
                return 0;
            }
            aVar.b(4, this.sys);
            return 0;
        } else if (i == 1) {
            if (this.syp != null) {
                a = f.a.a.a.a(1, this.syp) + 0;
            } else {
                a = 0;
            }
            if (this.syq != null) {
                a += f.a.a.a.a(2, this.syq);
            }
            if (this.syr != null) {
                a += f.a.a.a.a(3, this.syr);
            }
            if (this.sys != null) {
                a += f.a.a.a.a(4, this.sys);
            }
            return a;
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
            ccq ccq = (ccq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccq.syp = aVar3.cJR();
                    return 0;
                case 2:
                    ccq.syq = aVar3.cJR();
                    return 0;
                case 3:
                    ccq.syr = aVar3.cJR();
                    return 0;
                case 4:
                    ccq.sys = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
