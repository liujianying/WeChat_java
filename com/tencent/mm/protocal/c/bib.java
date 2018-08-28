package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bib extends a {
    public String jPe;
    public int lOH;
    public String reT;
    public String rvq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            if (this.rvq != null) {
                aVar.g(2, this.rvq);
            }
            if (this.reT != null) {
                aVar.g(3, this.reT);
            }
            aVar.fT(4, this.lOH);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.rvq != null) {
                h += f.a.a.b.b.a.h(2, this.rvq);
            }
            if (this.reT != null) {
                h += f.a.a.b.b.a.h(3, this.reT);
            }
            return h + f.a.a.a.fQ(4, this.lOH);
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
            bib bib = (bib) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bib.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bib.rvq = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bib.reT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bib.lOH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
