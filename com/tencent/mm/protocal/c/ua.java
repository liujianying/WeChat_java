package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ua extends a {
    public String dxh;
    public int mun;
    public String muo;
    public String mup;
    public int muq;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.mun);
            if (this.muo != null) {
                aVar.g(2, this.muo);
            }
            if (this.mup != null) {
                aVar.g(3, this.mup);
            }
            aVar.fT(4, this.muq);
            if (this.dxh != null) {
                aVar.g(5, this.dxh);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.mun) + 0;
            if (this.muo != null) {
                fQ += f.a.a.b.b.a.h(2, this.muo);
            }
            if (this.mup != null) {
                fQ += f.a.a.b.b.a.h(3, this.mup);
            }
            fQ += f.a.a.a.fQ(4, this.muq);
            if (this.dxh != null) {
                return fQ + f.a.a.b.b.a.h(5, this.dxh);
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
            ua uaVar = (ua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uaVar.mun = aVar3.vHC.rY();
                    return 0;
                case 2:
                    uaVar.muo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    uaVar.mup = aVar3.vHC.readString();
                    return 0;
                case 4:
                    uaVar.muq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    uaVar.dxh = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
