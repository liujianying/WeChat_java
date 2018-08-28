package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cib extends a {
    public String jTB;
    public String jTC;
    public int jTD;
    public String jTz;
    public String rcY;
    public int sBY;
    public String sBZ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sBY);
            if (this.rcY != null) {
                aVar.g(2, this.rcY);
            }
            if (this.jTz != null) {
                aVar.g(3, this.jTz);
            }
            if (this.sBZ != null) {
                aVar.g(4, this.sBZ);
            }
            if (this.jTB != null) {
                aVar.g(5, this.jTB);
            }
            if (this.jTC != null) {
                aVar.g(6, this.jTC);
            }
            aVar.fT(7, this.jTD);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.sBY) + 0;
            if (this.rcY != null) {
                fQ += f.a.a.b.b.a.h(2, this.rcY);
            }
            if (this.jTz != null) {
                fQ += f.a.a.b.b.a.h(3, this.jTz);
            }
            if (this.sBZ != null) {
                fQ += f.a.a.b.b.a.h(4, this.sBZ);
            }
            if (this.jTB != null) {
                fQ += f.a.a.b.b.a.h(5, this.jTB);
            }
            if (this.jTC != null) {
                fQ += f.a.a.b.b.a.h(6, this.jTC);
            }
            return fQ + f.a.a.a.fQ(7, this.jTD);
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
            cib cib = (cib) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cib.sBY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cib.rcY = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cib.jTz = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cib.sBZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cib.jTB = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cib.jTC = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cib.jTD = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
