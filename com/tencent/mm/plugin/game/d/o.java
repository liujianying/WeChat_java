package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class o extends a {
    public String bHD;
    public String jOS;
    public String jPO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jOS != null) {
                aVar.g(2, this.jOS);
            }
            if (this.jPO == null) {
                return 0;
            }
            aVar.g(3, this.jPO);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(2, this.jOS);
            }
            if (this.jPO != null) {
                h += f.a.a.b.b.a.h(3, this.jPO);
            }
            return h;
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
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    oVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    oVar.jPO = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
