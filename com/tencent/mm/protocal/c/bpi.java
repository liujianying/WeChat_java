package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bpi extends a {
    public int nRo;
    public int nRp;
    public String rds;
    public String rdt;
    public String rdu;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rds != null) {
                aVar.g(1, this.rds);
            }
            if (this.rdt != null) {
                aVar.g(2, this.rdt);
            }
            if (this.rdu != null) {
                aVar.g(3, this.rdu);
            }
            aVar.fT(4, this.nRo);
            aVar.fT(5, this.nRp);
            return 0;
        } else if (i == 1) {
            if (this.rds != null) {
                h = f.a.a.b.b.a.h(1, this.rds) + 0;
            } else {
                h = 0;
            }
            if (this.rdt != null) {
                h += f.a.a.b.b.a.h(2, this.rdt);
            }
            if (this.rdu != null) {
                h += f.a.a.b.b.a.h(3, this.rdu);
            }
            return (h + f.a.a.a.fQ(4, this.nRo)) + f.a.a.a.fQ(5, this.nRp);
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
            bpi bpi = (bpi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpi.rds = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bpi.rdt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bpi.rdu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bpi.nRo = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bpi.nRp = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
