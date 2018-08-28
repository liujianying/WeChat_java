package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class chk extends a {
    public String sAz;
    public int sBm;
    public int sBn;
    public String sBo;
    public int sBp;
    public String srZ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sBm);
            aVar.fT(2, this.sBn);
            if (this.srZ != null) {
                aVar.g(3, this.srZ);
            }
            if (this.sBo != null) {
                aVar.g(4, this.sBo);
            }
            if (this.sAz != null) {
                aVar.g(5, this.sAz);
            }
            aVar.fT(6, this.sBp);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.sBm) + 0) + f.a.a.a.fQ(2, this.sBn);
            if (this.srZ != null) {
                fQ += f.a.a.b.b.a.h(3, this.srZ);
            }
            if (this.sBo != null) {
                fQ += f.a.a.b.b.a.h(4, this.sBo);
            }
            if (this.sAz != null) {
                fQ += f.a.a.b.b.a.h(5, this.sAz);
            }
            return fQ + f.a.a.a.fQ(6, this.sBp);
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
            chk chk = (chk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chk.sBm = aVar3.vHC.rY();
                    return 0;
                case 2:
                    chk.sBn = aVar3.vHC.rY();
                    return 0;
                case 3:
                    chk.srZ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    chk.sBo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    chk.sAz = aVar3.vHC.readString();
                    return 0;
                case 6:
                    chk.sBp = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
