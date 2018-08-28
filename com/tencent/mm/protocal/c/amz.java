package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amz extends a {
    public String bHD;
    public int hcE;
    public String jPK;
    public String jSv;
    public String rPM;
    public String rPN;
    public String rPO;
    public String rPP;
    public int rPQ;
    public String rPR;
    public String rst;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.rPM != null) {
                aVar.g(2, this.rPM);
            }
            aVar.fT(3, this.hcE);
            if (this.jPK != null) {
                aVar.g(4, this.jPK);
            }
            if (this.rPN != null) {
                aVar.g(5, this.rPN);
            }
            if (this.rst != null) {
                aVar.g(6, this.rst);
            }
            if (this.rPO != null) {
                aVar.g(7, this.rPO);
            }
            if (this.jSv != null) {
                aVar.g(8, this.jSv);
            }
            if (this.rPP != null) {
                aVar.g(9, this.rPP);
            }
            aVar.fT(10, this.rPQ);
            if (this.rPR == null) {
                return 0;
            }
            aVar.g(11, this.rPR);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.rPM != null) {
                h += f.a.a.b.b.a.h(2, this.rPM);
            }
            h += f.a.a.a.fQ(3, this.hcE);
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(4, this.jPK);
            }
            if (this.rPN != null) {
                h += f.a.a.b.b.a.h(5, this.rPN);
            }
            if (this.rst != null) {
                h += f.a.a.b.b.a.h(6, this.rst);
            }
            if (this.rPO != null) {
                h += f.a.a.b.b.a.h(7, this.rPO);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(8, this.jSv);
            }
            if (this.rPP != null) {
                h += f.a.a.b.b.a.h(9, this.rPP);
            }
            h += f.a.a.a.fQ(10, this.rPQ);
            if (this.rPR != null) {
                h += f.a.a.b.b.a.h(11, this.rPR);
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
            amz amz = (amz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amz.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amz.rPM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    amz.hcE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    amz.jPK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    amz.rPN = aVar3.vHC.readString();
                    return 0;
                case 6:
                    amz.rst = aVar3.vHC.readString();
                    return 0;
                case 7:
                    amz.rPO = aVar3.vHC.readString();
                    return 0;
                case 8:
                    amz.jSv = aVar3.vHC.readString();
                    return 0;
                case 9:
                    amz.rPP = aVar3.vHC.readString();
                    return 0;
                case 10:
                    amz.rPQ = aVar3.vHC.rY();
                    return 0;
                case 11:
                    amz.rPR = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
