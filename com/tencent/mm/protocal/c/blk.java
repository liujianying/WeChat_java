package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class blk extends a {
    public b rSu;
    public b skr;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.skr == null) {
                throw new f.a.a.b("Not all required fields were included: Name");
            } else if (this.rSu == null) {
                throw new f.a.a.b("Not all required fields were included: Value");
            } else {
                if (this.skr != null) {
                    aVar.b(1, this.skr);
                }
                if (this.rSu == null) {
                    return 0;
                }
                aVar.b(2, this.rSu);
                return 0;
            }
        } else if (i == 1) {
            if (this.skr != null) {
                a = f.a.a.a.a(1, this.skr) + 0;
            } else {
                a = 0;
            }
            if (this.rSu != null) {
                a += f.a.a.a.a(2, this.rSu);
            }
            return a;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (this.skr == null) {
                throw new f.a.a.b("Not all required fields were included: Name");
            } else if (this.rSu != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: Value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            blk blk = (blk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blk.skr = aVar3.cJR();
                    return 0;
                case 2:
                    blk.rSu = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
