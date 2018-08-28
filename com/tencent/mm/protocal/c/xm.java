package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xm extends a {
    public int bMH;
    public String id;
    public int jkI;
    public String rDq;
    public long rDr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            aVar.fT(2, this.jkI);
            if (this.rDq != null) {
                aVar.g(3, this.rDq);
            }
            aVar.T(4, this.rDr);
            aVar.fT(5, this.bMH);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                h = f.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.jkI);
            if (this.rDq != null) {
                h += f.a.a.b.b.a.h(3, this.rDq);
            }
            return (h + f.a.a.a.S(4, this.rDr)) + f.a.a.a.fQ(5, this.bMH);
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
            xm xmVar = (xm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xmVar.id = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xmVar.jkI = aVar3.vHC.rY();
                    return 0;
                case 3:
                    xmVar.rDq = aVar3.vHC.readString();
                    return 0;
                case 4:
                    xmVar.rDr = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    xmVar.bMH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
