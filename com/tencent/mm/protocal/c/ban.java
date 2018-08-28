package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ban extends a {
    public String jSv;
    public String lOE;
    public String lOG;
    public int lOH;
    public String lOI;
    public int lOJ;
    public String lOK;
    public int lOL;
    public int lOM;
    public String lOO;
    public String lOP;
    public String lOQ;
    public String lOR;
    public int scI;
    public String scU;
    public String scV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lOE != null) {
                aVar.g(1, this.lOE);
            }
            aVar.fT(2, this.scI);
            if (this.lOG != null) {
                aVar.g(3, this.lOG);
            }
            aVar.fT(4, this.lOH);
            if (this.lOI != null) {
                aVar.g(5, this.lOI);
            }
            aVar.fT(6, this.lOJ);
            if (this.lOK != null) {
                aVar.g(7, this.lOK);
            }
            aVar.fT(8, this.lOL);
            aVar.fT(9, this.lOM);
            if (this.jSv != null) {
                aVar.g(11, this.jSv);
            }
            if (this.lOO != null) {
                aVar.g(12, this.lOO);
            }
            if (this.lOP != null) {
                aVar.g(13, this.lOP);
            }
            if (this.lOQ != null) {
                aVar.g(14, this.lOQ);
            }
            if (this.lOR != null) {
                aVar.g(15, this.lOR);
            }
            if (this.scU != null) {
                aVar.g(18, this.scU);
            }
            if (this.scV == null) {
                return 0;
            }
            aVar.g(19, this.scV);
            return 0;
        } else if (i == 1) {
            if (this.lOE != null) {
                h = f.a.a.b.b.a.h(1, this.lOE) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.scI);
            if (this.lOG != null) {
                h += f.a.a.b.b.a.h(3, this.lOG);
            }
            h += f.a.a.a.fQ(4, this.lOH);
            if (this.lOI != null) {
                h += f.a.a.b.b.a.h(5, this.lOI);
            }
            h += f.a.a.a.fQ(6, this.lOJ);
            if (this.lOK != null) {
                h += f.a.a.b.b.a.h(7, this.lOK);
            }
            h = (h + f.a.a.a.fQ(8, this.lOL)) + f.a.a.a.fQ(9, this.lOM);
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(11, this.jSv);
            }
            if (this.lOO != null) {
                h += f.a.a.b.b.a.h(12, this.lOO);
            }
            if (this.lOP != null) {
                h += f.a.a.b.b.a.h(13, this.lOP);
            }
            if (this.lOQ != null) {
                h += f.a.a.b.b.a.h(14, this.lOQ);
            }
            if (this.lOR != null) {
                h += f.a.a.b.b.a.h(15, this.lOR);
            }
            if (this.scU != null) {
                h += f.a.a.b.b.a.h(18, this.scU);
            }
            if (this.scV != null) {
                h += f.a.a.b.b.a.h(19, this.scV);
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
            ban ban = (ban) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ban.lOE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ban.scI = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ban.lOG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ban.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ban.lOI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ban.lOJ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ban.lOK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ban.lOL = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ban.lOM = aVar3.vHC.rY();
                    return 0;
                case 11:
                    ban.jSv = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ban.lOO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    ban.lOP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    ban.lOQ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ban.lOR = aVar3.vHC.readString();
                    return 0;
                case 18:
                    ban.scU = aVar3.vHC.readString();
                    return 0;
                case 19:
                    ban.scV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
