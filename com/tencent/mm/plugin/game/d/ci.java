package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class ci extends a {
    public String bHD;
    public String jOS;
    public String jOT;
    public String jSN;

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
            if (this.jOT != null) {
                aVar.g(3, this.jOT);
            }
            if (this.jSN == null) {
                return 0;
            }
            aVar.g(4, this.jSN);
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
            if (this.jOT != null) {
                h += f.a.a.b.b.a.h(3, this.jOT);
            }
            if (this.jSN != null) {
                h += f.a.a.b.b.a.h(4, this.jSN);
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
            ci ciVar = (ci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ciVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ciVar.jOT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ciVar.jSN = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
