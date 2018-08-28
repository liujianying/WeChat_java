package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class brd extends a {
    public int hcC;
    public int rxy;
    public int spm;
    public int spn;
    public int spo;
    public int spp;
    public int spq;
    public int spr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcC);
            aVar.fT(2, this.rxy);
            aVar.fT(3, this.spm);
            aVar.fT(4, this.spn);
            aVar.fT(5, this.spo);
            aVar.fT(6, this.spp);
            aVar.fT(7, this.spq);
            aVar.fT(8, this.spr);
            return 0;
        } else if (i == 1) {
            return (((((((f.a.a.a.fQ(1, this.hcC) + 0) + f.a.a.a.fQ(2, this.rxy)) + f.a.a.a.fQ(3, this.spm)) + f.a.a.a.fQ(4, this.spn)) + f.a.a.a.fQ(5, this.spo)) + f.a.a.a.fQ(6, this.spp)) + f.a.a.a.fQ(7, this.spq)) + f.a.a.a.fQ(8, this.spr);
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
                brd brd = (brd) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        brd.hcC = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        brd.rxy = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        brd.spm = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        brd.spn = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        brd.spo = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        brd.spp = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        brd.spq = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        brd.spr = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
