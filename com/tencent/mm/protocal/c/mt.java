package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class mt extends a {
    public String lMY;
    public int rqH;
    public String rqI;
    public String rqJ;
    public String rqK;
    public int rqL;
    public String rqM;
    public int rqN;
    public String rqO;
    public int rqP;
    public String rqQ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rqH);
            if (this.rqI != null) {
                aVar.g(2, this.rqI);
            }
            if (this.rqJ != null) {
                aVar.g(3, this.rqJ);
            }
            if (this.rqK != null) {
                aVar.g(4, this.rqK);
            }
            aVar.fT(5, this.rqL);
            if (this.rqM != null) {
                aVar.g(6, this.rqM);
            }
            aVar.fT(7, this.rqN);
            if (this.lMY != null) {
                aVar.g(8, this.lMY);
            }
            if (this.rqO != null) {
                aVar.g(9, this.rqO);
            }
            aVar.fT(10, this.rqP);
            if (this.rqQ != null) {
                aVar.g(11, this.rqQ);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rqH) + 0;
            if (this.rqI != null) {
                fQ += f.a.a.b.b.a.h(2, this.rqI);
            }
            if (this.rqJ != null) {
                fQ += f.a.a.b.b.a.h(3, this.rqJ);
            }
            if (this.rqK != null) {
                fQ += f.a.a.b.b.a.h(4, this.rqK);
            }
            fQ += f.a.a.a.fQ(5, this.rqL);
            if (this.rqM != null) {
                fQ += f.a.a.b.b.a.h(6, this.rqM);
            }
            fQ += f.a.a.a.fQ(7, this.rqN);
            if (this.lMY != null) {
                fQ += f.a.a.b.b.a.h(8, this.lMY);
            }
            if (this.rqO != null) {
                fQ += f.a.a.b.b.a.h(9, this.rqO);
            }
            fQ += f.a.a.a.fQ(10, this.rqP);
            if (this.rqQ != null) {
                return fQ + f.a.a.b.b.a.h(11, this.rqQ);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            mt mtVar = (mt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mtVar.rqH = aVar3.vHC.rY();
                    return 0;
                case 2:
                    mtVar.rqI = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mtVar.rqJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mtVar.rqK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mtVar.rqL = aVar3.vHC.rY();
                    return 0;
                case 6:
                    mtVar.rqM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    mtVar.rqN = aVar3.vHC.rY();
                    return 0;
                case 8:
                    mtVar.lMY = aVar3.vHC.readString();
                    return 0;
                case 9:
                    mtVar.rqO = aVar3.vHC.readString();
                    return 0;
                case 10:
                    mtVar.rqP = aVar3.vHC.rY();
                    return 0;
                case 11:
                    mtVar.rqQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
