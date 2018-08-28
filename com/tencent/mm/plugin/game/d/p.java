package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class p extends a {
    public String jPP;
    public String jPQ;
    public String jPR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPP != null) {
                aVar.g(1, this.jPP);
            }
            if (this.jPQ != null) {
                aVar.g(2, this.jPQ);
            }
            if (this.jPR == null) {
                return 0;
            }
            aVar.g(3, this.jPR);
            return 0;
        } else if (i == 1) {
            if (this.jPP != null) {
                h = f.a.a.b.b.a.h(1, this.jPP) + 0;
            } else {
                h = 0;
            }
            if (this.jPQ != null) {
                h += f.a.a.b.b.a.h(2, this.jPQ);
            }
            if (this.jPR != null) {
                h += f.a.a.b.b.a.h(3, this.jPR);
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
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.jPP = aVar3.vHC.readString();
                    return 0;
                case 2:
                    pVar.jPQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    pVar.jPR = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
