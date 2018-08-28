package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class apy extends a {
    public int rSA;
    public String rjL;
    public String rjM;
    public String rjN;
    public String rjO;
    public String rjP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rjL != null) {
                aVar.g(1, this.rjL);
            }
            if (this.rjM != null) {
                aVar.g(2, this.rjM);
            }
            if (this.rjN != null) {
                aVar.g(3, this.rjN);
            }
            if (this.rjO != null) {
                aVar.g(4, this.rjO);
            }
            if (this.rjP != null) {
                aVar.g(5, this.rjP);
            }
            aVar.fT(6, this.rSA);
            return 0;
        } else if (i == 1) {
            if (this.rjL != null) {
                h = f.a.a.b.b.a.h(1, this.rjL) + 0;
            } else {
                h = 0;
            }
            if (this.rjM != null) {
                h += f.a.a.b.b.a.h(2, this.rjM);
            }
            if (this.rjN != null) {
                h += f.a.a.b.b.a.h(3, this.rjN);
            }
            if (this.rjO != null) {
                h += f.a.a.b.b.a.h(4, this.rjO);
            }
            if (this.rjP != null) {
                h += f.a.a.b.b.a.h(5, this.rjP);
            }
            return h + f.a.a.a.fQ(6, this.rSA);
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
            apy apy = (apy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apy.rjL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    apy.rjM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    apy.rjN = aVar3.vHC.readString();
                    return 0;
                case 4:
                    apy.rjO = aVar3.vHC.readString();
                    return 0;
                case 5:
                    apy.rjP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    apy.rSA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
