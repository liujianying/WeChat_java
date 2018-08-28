package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btb extends a {
    public String lMY;
    public String path;
    public int showType;
    public String title;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.showType);
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.lMY != null) {
                aVar.g(3, this.lMY);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.showType) + 0;
            if (this.title != null) {
                fQ += f.a.a.b.b.a.h(2, this.title);
            }
            if (this.lMY != null) {
                fQ += f.a.a.b.b.a.h(3, this.lMY);
            }
            if (this.path != null) {
                return fQ + f.a.a.b.b.a.h(4, this.path);
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
            btb btb = (btb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btb.showType = aVar3.vHC.rY();
                    return 0;
                case 2:
                    btb.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    btb.lMY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    btb.path = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
