package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btg extends a {
    public String name;
    public long timestamp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            aVar.T(2, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = f.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.S(2, this.timestamp);
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
            btg btg = (btg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btg.name = aVar3.vHC.readString();
                    return 0;
                case 2:
                    btg.timestamp = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
