package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cdm extends a {
    public String hbP;
    public String reT;
    public String rjL;
    public String rjM;
    public String rjN;
    public String rjO;
    public String syX;
    public String syY;
    public String syZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.reT != null) {
                aVar.g(1, this.reT);
            }
            if (this.rjM != null) {
                aVar.g(2, this.rjM);
            }
            if (this.rjL != null) {
                aVar.g(3, this.rjL);
            }
            if (this.hbP != null) {
                aVar.g(4, this.hbP);
            }
            if (this.syX != null) {
                aVar.g(5, this.syX);
            }
            if (this.rjN != null) {
                aVar.g(6, this.rjN);
            }
            if (this.rjO != null) {
                aVar.g(7, this.rjO);
            }
            if (this.syY != null) {
                aVar.g(8, this.syY);
            }
            if (this.syZ == null) {
                return 0;
            }
            aVar.g(9, this.syZ);
            return 0;
        } else if (i == 1) {
            if (this.reT != null) {
                h = f.a.a.b.b.a.h(1, this.reT) + 0;
            } else {
                h = 0;
            }
            if (this.rjM != null) {
                h += f.a.a.b.b.a.h(2, this.rjM);
            }
            if (this.rjL != null) {
                h += f.a.a.b.b.a.h(3, this.rjL);
            }
            if (this.hbP != null) {
                h += f.a.a.b.b.a.h(4, this.hbP);
            }
            if (this.syX != null) {
                h += f.a.a.b.b.a.h(5, this.syX);
            }
            if (this.rjN != null) {
                h += f.a.a.b.b.a.h(6, this.rjN);
            }
            if (this.rjO != null) {
                h += f.a.a.b.b.a.h(7, this.rjO);
            }
            if (this.syY != null) {
                h += f.a.a.b.b.a.h(8, this.syY);
            }
            if (this.syZ != null) {
                h += f.a.a.b.b.a.h(9, this.syZ);
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
            cdm cdm = (cdm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdm.reT = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cdm.rjM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cdm.rjL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cdm.hbP = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cdm.syX = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cdm.rjN = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cdm.rjO = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cdm.syY = aVar3.vHC.readString();
                    return 0;
                case 9:
                    cdm.syZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
