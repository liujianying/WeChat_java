package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wz extends a {
    public int rBY;
    public int rBZ;
    public int rCa;
    public int rCb;
    public int rCc;
    public int rCd;
    public int rCe;
    public int rCf;
    public int rCg;
    public int rCh;
    public int rCi;
    public int rCj;
    public int rCk;
    public int rCl;
    public int rCm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rBY);
            aVar.fT(2, this.rBZ);
            aVar.fT(3, this.rCa);
            aVar.fT(4, this.rCb);
            aVar.fT(5, this.rCc);
            aVar.fT(6, this.rCd);
            aVar.fT(7, this.rCe);
            aVar.fT(8, this.rCf);
            aVar.fT(9, this.rCg);
            aVar.fT(10, this.rCh);
            aVar.fT(11, this.rCi);
            aVar.fT(12, this.rCj);
            aVar.fT(13, this.rCk);
            aVar.fT(14, this.rCl);
            aVar.fT(15, this.rCm);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((f.a.a.a.fQ(1, this.rBY) + 0) + f.a.a.a.fQ(2, this.rBZ)) + f.a.a.a.fQ(3, this.rCa)) + f.a.a.a.fQ(4, this.rCb)) + f.a.a.a.fQ(5, this.rCc)) + f.a.a.a.fQ(6, this.rCd)) + f.a.a.a.fQ(7, this.rCe)) + f.a.a.a.fQ(8, this.rCf)) + f.a.a.a.fQ(9, this.rCg)) + f.a.a.a.fQ(10, this.rCh)) + f.a.a.a.fQ(11, this.rCi)) + f.a.a.a.fQ(12, this.rCj)) + f.a.a.a.fQ(13, this.rCk)) + f.a.a.a.fQ(14, this.rCl)) + f.a.a.a.fQ(15, this.rCm);
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
                wz wzVar = (wz) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        wzVar.rBY = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        wzVar.rBZ = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        wzVar.rCa = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        wzVar.rCb = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        wzVar.rCc = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        wzVar.rCd = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        wzVar.rCe = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        wzVar.rCf = aVar3.vHC.rY();
                        return 0;
                    case 9:
                        wzVar.rCg = aVar3.vHC.rY();
                        return 0;
                    case 10:
                        wzVar.rCh = aVar3.vHC.rY();
                        return 0;
                    case 11:
                        wzVar.rCi = aVar3.vHC.rY();
                        return 0;
                    case 12:
                        wzVar.rCj = aVar3.vHC.rY();
                        return 0;
                    case 13:
                        wzVar.rCk = aVar3.vHC.rY();
                        return 0;
                    case 14:
                        wzVar.rCl = aVar3.vHC.rY();
                        return 0;
                    case 15:
                        wzVar.rCm = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
