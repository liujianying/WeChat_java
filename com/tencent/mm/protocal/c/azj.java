package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class azj extends a {
    public String bPS;
    public String huW;
    public String rnD;
    public int scb;
    public String scc;
    public String scd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            aVar.fT(2, this.scb);
            if (this.scc != null) {
                aVar.g(3, this.scc);
            }
            if (this.scd != null) {
                aVar.g(4, this.scd);
            }
            if (this.rnD != null) {
                aVar.g(5, this.rnD);
            }
            if (this.huW == null) {
                return 0;
            }
            aVar.g(6, this.huW);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.scb);
            if (this.scc != null) {
                h += f.a.a.b.b.a.h(3, this.scc);
            }
            if (this.scd != null) {
                h += f.a.a.b.b.a.h(4, this.scd);
            }
            if (this.rnD != null) {
                h += f.a.a.b.b.a.h(5, this.rnD);
            }
            if (this.huW != null) {
                h += f.a.a.b.b.a.h(6, this.huW);
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
            azj azj = (azj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azj.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    azj.scb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    azj.scc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azj.scd = aVar3.vHC.readString();
                    return 0;
                case 5:
                    azj.rnD = aVar3.vHC.readString();
                    return 0;
                case 6:
                    azj.huW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
