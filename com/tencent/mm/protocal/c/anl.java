package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class anl extends a {
    public int bHC;
    public int rQa;
    public int rQb;
    public int rQc;
    public int rQd;
    public int rQe;
    public int rQf;
    public int rQg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rQa);
            aVar.fT(2, this.bHC);
            aVar.fT(3, this.rQb);
            aVar.fT(4, this.rQc);
            aVar.fT(5, this.rQd);
            aVar.fT(6, this.rQe);
            aVar.fT(7, this.rQf);
            aVar.fT(8, this.rQg);
            return 0;
        } else if (i == 1) {
            return (((((((f.a.a.a.fQ(1, this.rQa) + 0) + f.a.a.a.fQ(2, this.bHC)) + f.a.a.a.fQ(3, this.rQb)) + f.a.a.a.fQ(4, this.rQc)) + f.a.a.a.fQ(5, this.rQd)) + f.a.a.a.fQ(6, this.rQe)) + f.a.a.a.fQ(7, this.rQf)) + f.a.a.a.fQ(8, this.rQg);
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
                anl anl = (anl) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        anl.rQa = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        anl.bHC = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        anl.rQb = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        anl.rQc = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        anl.rQd = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        anl.rQe = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        anl.rQf = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        anl.rQg = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
