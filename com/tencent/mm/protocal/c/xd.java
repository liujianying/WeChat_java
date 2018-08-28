package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xd extends a {
    public boolean rCL;
    public boolean rCM;
    public boolean rCN;
    public boolean rCO;
    public boolean rCP;
    public boolean rCQ;
    public boolean rCR;
    public boolean rCS;
    public boolean rCT;
    public boolean rCU;
    public boolean rCV;
    public boolean rCW;
    public boolean rCX;
    public boolean rCY;
    public boolean rCZ;
    public boolean rDa;
    public boolean rDb;
    public boolean rDc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.rCL);
            aVar.av(2, this.rCM);
            aVar.av(3, this.rCN);
            aVar.av(4, this.rCO);
            aVar.av(5, this.rCP);
            aVar.av(6, this.rCQ);
            aVar.av(7, this.rCR);
            aVar.av(8, this.rCS);
            aVar.av(9, this.rCT);
            aVar.av(10, this.rCU);
            aVar.av(11, this.rCV);
            aVar.av(12, this.rCW);
            aVar.av(13, this.rCX);
            aVar.av(14, this.rCY);
            aVar.av(15, this.rCZ);
            aVar.av(16, this.rDa);
            aVar.av(17, this.rDb);
            aVar.av(18, this.rDc);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((((((f.a.a.b.b.a.ec(1) + 1) + 0) + (f.a.a.b.b.a.ec(2) + 1)) + (f.a.a.b.b.a.ec(3) + 1)) + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1)) + (f.a.a.b.b.a.ec(6) + 1)) + (f.a.a.b.b.a.ec(7) + 1)) + (f.a.a.b.b.a.ec(8) + 1)) + (f.a.a.b.b.a.ec(9) + 1)) + (f.a.a.b.b.a.ec(10) + 1)) + (f.a.a.b.b.a.ec(11) + 1)) + (f.a.a.b.b.a.ec(12) + 1)) + (f.a.a.b.b.a.ec(13) + 1)) + (f.a.a.b.b.a.ec(14) + 1)) + (f.a.a.b.b.a.ec(15) + 1)) + (f.a.a.b.b.a.ec(16) + 1)) + (f.a.a.b.b.a.ec(17) + 1)) + (f.a.a.b.b.a.ec(18) + 1);
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
                xd xdVar = (xd) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        xdVar.rCL = aVar3.cJQ();
                        return 0;
                    case 2:
                        xdVar.rCM = aVar3.cJQ();
                        return 0;
                    case 3:
                        xdVar.rCN = aVar3.cJQ();
                        return 0;
                    case 4:
                        xdVar.rCO = aVar3.cJQ();
                        return 0;
                    case 5:
                        xdVar.rCP = aVar3.cJQ();
                        return 0;
                    case 6:
                        xdVar.rCQ = aVar3.cJQ();
                        return 0;
                    case 7:
                        xdVar.rCR = aVar3.cJQ();
                        return 0;
                    case 8:
                        xdVar.rCS = aVar3.cJQ();
                        return 0;
                    case 9:
                        xdVar.rCT = aVar3.cJQ();
                        return 0;
                    case 10:
                        xdVar.rCU = aVar3.cJQ();
                        return 0;
                    case 11:
                        xdVar.rCV = aVar3.cJQ();
                        return 0;
                    case 12:
                        xdVar.rCW = aVar3.cJQ();
                        return 0;
                    case 13:
                        xdVar.rCX = aVar3.cJQ();
                        return 0;
                    case 14:
                        xdVar.rCY = aVar3.cJQ();
                        return 0;
                    case 15:
                        xdVar.rCZ = aVar3.cJQ();
                        return 0;
                    case 16:
                        xdVar.rDa = aVar3.cJQ();
                        return 0;
                    case 17:
                        xdVar.rDb = aVar3.cJQ();
                        return 0;
                    case 18:
                        xdVar.rDc = aVar3.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
