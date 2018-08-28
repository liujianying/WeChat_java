package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cfa extends a {
    public int hbF;
    public int hcE;
    public String jTu;
    public int lOH;
    public int rWU;
    public String rco;
    public int szG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jTu != null) {
                aVar.g(1, this.jTu);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.hbF);
            aVar.fT(4, this.lOH);
            aVar.fT(5, this.rWU);
            if (this.rco != null) {
                aVar.g(6, this.rco);
            }
            aVar.fT(7, this.szG);
            return 0;
        } else if (i == 1) {
            if (this.jTu != null) {
                h = f.a.a.b.b.a.h(1, this.jTu) + 0;
            } else {
                h = 0;
            }
            h = (((h + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.hbF)) + f.a.a.a.fQ(4, this.lOH)) + f.a.a.a.fQ(5, this.rWU);
            if (this.rco != null) {
                h += f.a.a.b.b.a.h(6, this.rco);
            }
            return h + f.a.a.a.fQ(7, this.szG);
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
            cfa cfa = (cfa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfa.jTu = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cfa.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfa.hbF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cfa.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cfa.rWU = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cfa.rco = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cfa.szG = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
