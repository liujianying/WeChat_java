package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class anb extends a {
    public int hcy;
    public String jPK;
    public String jPe;
    public String rwk;
    public String rxo;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rxo != null) {
                aVar.g(1, this.rxo);
            }
            aVar.fT(2, this.hcy);
            if (this.rwk != null) {
                aVar.g(3, this.rwk);
            }
            if (this.jPK != null) {
                aVar.g(4, this.jPK);
            }
            if (this.jPe == null) {
                return 0;
            }
            aVar.g(5, this.jPe);
            return 0;
        } else if (i == 1) {
            if (this.rxo != null) {
                h = f.a.a.b.b.a.h(1, this.rxo) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.hcy);
            if (this.rwk != null) {
                h += f.a.a.b.b.a.h(3, this.rwk);
            }
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(4, this.jPK);
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(5, this.jPe);
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
            anb anb = (anb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anb.rxo = aVar3.vHC.readString();
                    return 0;
                case 2:
                    anb.hcy = aVar3.vHC.rY();
                    return 0;
                case 3:
                    anb.rwk = aVar3.vHC.readString();
                    return 0;
                case 4:
                    anb.jPK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    anb.jPe = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
