package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bgq extends a {
    public String hcq;
    public int ngG;
    public String rjL;
    public String rjM;
    public String rjN;
    public String rjO;
    public int shA;
    public int shB;
    public String shC;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hcq != null) {
                aVar.g(1, this.hcq);
            }
            aVar.fT(2, this.shA);
            if (this.rjL != null) {
                aVar.g(3, this.rjL);
            }
            if (this.rjM != null) {
                aVar.g(4, this.rjM);
            }
            aVar.fT(5, this.ngG);
            aVar.fT(6, this.shB);
            if (this.rjN != null) {
                aVar.g(7, this.rjN);
            }
            if (this.rjO != null) {
                aVar.g(8, this.rjO);
            }
            if (this.shC == null) {
                return 0;
            }
            aVar.g(9, this.shC);
            return 0;
        } else if (i == 1) {
            if (this.hcq != null) {
                h = f.a.a.b.b.a.h(1, this.hcq) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.shA);
            if (this.rjL != null) {
                h += f.a.a.b.b.a.h(3, this.rjL);
            }
            if (this.rjM != null) {
                h += f.a.a.b.b.a.h(4, this.rjM);
            }
            h = (h + f.a.a.a.fQ(5, this.ngG)) + f.a.a.a.fQ(6, this.shB);
            if (this.rjN != null) {
                h += f.a.a.b.b.a.h(7, this.rjN);
            }
            if (this.rjO != null) {
                h += f.a.a.b.b.a.h(8, this.rjO);
            }
            if (this.shC != null) {
                h += f.a.a.b.b.a.h(9, this.shC);
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
            bgq bgq = (bgq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgq.hcq = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bgq.shA = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bgq.rjL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bgq.rjM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bgq.ngG = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bgq.shB = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bgq.rjN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bgq.rjO = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bgq.shC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
