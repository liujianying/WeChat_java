package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class af extends a {
    public String qZE;
    public int qZF;
    public int qZG;
    public int qZH;
    public int qZI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qZE != null) {
                aVar.g(1, this.qZE);
            }
            aVar.fT(2, this.qZF);
            aVar.fT(3, this.qZG);
            aVar.fT(4, this.qZH);
            aVar.fT(5, this.qZI);
            return 0;
        } else if (i == 1) {
            if (this.qZE != null) {
                h = f.a.a.b.b.a.h(1, this.qZE) + 0;
            } else {
                h = 0;
            }
            return (((h + f.a.a.a.fQ(2, this.qZF)) + f.a.a.a.fQ(3, this.qZG)) + f.a.a.a.fQ(4, this.qZH)) + f.a.a.a.fQ(5, this.qZI);
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
            af afVar = (af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afVar.qZE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    afVar.qZF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    afVar.qZG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    afVar.qZH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    afVar.qZI = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
