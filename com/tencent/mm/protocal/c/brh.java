package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class brh extends a {
    public String dyJ;
    public int dyK;
    public String dyL;
    public String dyM;
    public String dyN;
    public String dyO;
    public String dyP;
    public String dyQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.dyJ != null) {
                aVar.g(1, this.dyJ);
            }
            aVar.fT(2, this.dyK);
            if (this.dyM != null) {
                aVar.g(3, this.dyM);
            }
            if (this.dyN != null) {
                aVar.g(4, this.dyN);
            }
            if (this.dyL != null) {
                aVar.g(5, this.dyL);
            }
            if (this.dyO != null) {
                aVar.g(6, this.dyO);
            }
            if (this.dyP != null) {
                aVar.g(7, this.dyP);
            }
            if (this.dyQ == null) {
                return 0;
            }
            aVar.g(8, this.dyQ);
            return 0;
        } else if (i == 1) {
            if (this.dyJ != null) {
                h = f.a.a.b.b.a.h(1, this.dyJ) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.dyK);
            if (this.dyM != null) {
                h += f.a.a.b.b.a.h(3, this.dyM);
            }
            if (this.dyN != null) {
                h += f.a.a.b.b.a.h(4, this.dyN);
            }
            if (this.dyL != null) {
                h += f.a.a.b.b.a.h(5, this.dyL);
            }
            if (this.dyO != null) {
                h += f.a.a.b.b.a.h(6, this.dyO);
            }
            if (this.dyP != null) {
                h += f.a.a.b.b.a.h(7, this.dyP);
            }
            if (this.dyQ != null) {
                h += f.a.a.b.b.a.h(8, this.dyQ);
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
            brh brh = (brh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brh.dyJ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    brh.dyK = aVar3.vHC.rY();
                    return 0;
                case 3:
                    brh.dyM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    brh.dyN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    brh.dyL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    brh.dyO = aVar3.vHC.readString();
                    return 0;
                case 7:
                    brh.dyP = aVar3.vHC.readString();
                    return 0;
                case 8:
                    brh.dyQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
