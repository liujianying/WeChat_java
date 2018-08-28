package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class sw extends a {
    public boolean rwc;
    public boolean rwd;
    public String rwe;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.rwc);
            aVar.av(2, this.rwd);
            if (this.rwe != null) {
                aVar.g(3, this.rwe);
            }
            return 0;
        } else if (i == 1) {
            ec = ((f.a.a.b.b.a.ec(1) + 1) + 0) + (f.a.a.b.b.a.ec(2) + 1);
            if (this.rwe != null) {
                return ec + f.a.a.b.b.a.h(3, this.rwe);
            }
            return ec;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sw swVar = (sw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    swVar.rwc = aVar3.cJQ();
                    return 0;
                case 2:
                    swVar.rwd = aVar3.cJQ();
                    return 0;
                case 3:
                    swVar.rwe = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
