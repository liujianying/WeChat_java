package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class di extends a {
    public String jPc;
    public String jRd;
    public int rdF;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc != null) {
                aVar.g(1, this.jPc);
            }
            aVar.fT(2, this.rdF);
            if (this.jRd == null) {
                return 0;
            }
            aVar.g(3, this.jRd);
            return 0;
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rdF);
            if (this.jRd != null) {
                h += f.a.a.b.b.a.h(3, this.jRd);
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
            di diVar = (di) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    diVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    diVar.rdF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    diVar.jRd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
