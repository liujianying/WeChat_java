package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wg extends a {
    public int hcd;
    public int rbY;
    public int rbZ;
    public int rca;
    public int rcb;
    public String rcf;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rbY);
            aVar.fT(2, this.hcd);
            if (this.rcf != null) {
                aVar.g(3, this.rcf);
            }
            aVar.fT(4, this.rbZ);
            aVar.fT(5, this.rca);
            aVar.fT(6, this.rcb);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.rbY) + 0) + f.a.a.a.fQ(2, this.hcd);
            if (this.rcf != null) {
                fQ += f.a.a.b.b.a.h(3, this.rcf);
            }
            return ((fQ + f.a.a.a.fQ(4, this.rbZ)) + f.a.a.a.fQ(5, this.rca)) + f.a.a.a.fQ(6, this.rcb);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            wg wgVar = (wg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wgVar.rbY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    wgVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    wgVar.rcf = aVar3.vHC.readString();
                    return 0;
                case 4:
                    wgVar.rbZ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    wgVar.rca = aVar3.vHC.rY();
                    return 0;
                case 6:
                    wgVar.rcb = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
