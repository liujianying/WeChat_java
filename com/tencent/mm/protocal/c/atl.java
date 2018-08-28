package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class atl extends a {
    public String bHD;
    public String lPl;
    public int rDF;
    public String rDG;
    public int rWO;
    public int rWP;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.lPl == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                aVar.fT(1, this.rWO);
                if (this.bHD != null) {
                    aVar.g(2, this.bHD);
                }
                if (this.lPl != null) {
                    aVar.g(3, this.lPl);
                }
                aVar.fT(4, this.rDF);
                if (this.rDG != null) {
                    aVar.g(5, this.rDG);
                }
                aVar.fT(6, this.rWP);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rWO) + 0;
            if (this.bHD != null) {
                fQ += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.lPl != null) {
                fQ += f.a.a.b.b.a.h(3, this.lPl);
            }
            fQ += f.a.a.a.fQ(4, this.rDF);
            if (this.rDG != null) {
                fQ += f.a.a.b.b.a.h(5, this.rDG);
            }
            return fQ + f.a.a.a.fQ(6, this.rWP);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.lPl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            atl atl = (atl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atl.rWO = aVar3.vHC.rY();
                    return 0;
                case 2:
                    atl.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    atl.lPl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    atl.rDF = aVar3.vHC.rY();
                    return 0;
                case 5:
                    atl.rDG = aVar3.vHC.readString();
                    return 0;
                case 6:
                    atl.rWP = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
