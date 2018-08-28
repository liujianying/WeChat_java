package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wn extends a {
    public String bJK;
    public String bWm;
    public int iVT;
    public String iVW;
    public int index;
    public int scene;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.scene);
            aVar.fT(2, this.iVT);
            aVar.fT(3, this.index);
            if (this.bJK != null) {
                aVar.g(4, this.bJK);
            }
            if (this.bWm != null) {
                aVar.g(5, this.bWm);
            }
            if (this.iVW != null) {
                aVar.g(6, this.iVW);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.scene) + 0) + f.a.a.a.fQ(2, this.iVT)) + f.a.a.a.fQ(3, this.index);
            if (this.bJK != null) {
                fQ += f.a.a.b.b.a.h(4, this.bJK);
            }
            if (this.bWm != null) {
                fQ += f.a.a.b.b.a.h(5, this.bWm);
            }
            if (this.iVW != null) {
                return fQ + f.a.a.b.b.a.h(6, this.iVW);
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
            wn wnVar = (wn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wnVar.scene = aVar3.vHC.rY();
                    return 0;
                case 2:
                    wnVar.iVT = aVar3.vHC.rY();
                    return 0;
                case 3:
                    wnVar.index = aVar3.vHC.rY();
                    return 0;
                case 4:
                    wnVar.bJK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    wnVar.bWm = aVar3.vHC.readString();
                    return 0;
                case 6:
                    wnVar.iVW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
