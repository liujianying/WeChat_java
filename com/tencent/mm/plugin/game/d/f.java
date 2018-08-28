package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class f extends a {
    public int jPu;
    public int jPv;
    public int jPw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.jPu);
            aVar.fT(2, this.jPv);
            aVar.fT(3, this.jPw);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.fQ(1, this.jPu) + 0) + f.a.a.a.fQ(2, this.jPv)) + f.a.a.a.fQ(3, this.jPw);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.jPu = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        fVar.jPv = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        fVar.jPw = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
