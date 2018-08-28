package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class qt extends a {
    public int eJV;
    public String eJW;
    public String eJX;
    public String eJY;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.eJV);
            if (this.eJW != null) {
                aVar.g(2, this.eJW);
            }
            if (this.eJX != null) {
                aVar.g(3, this.eJX);
            }
            if (this.eJY != null) {
                aVar.g(4, this.eJY);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.eJV) + 0;
            if (this.eJW != null) {
                fQ += f.a.a.b.b.a.h(2, this.eJW);
            }
            if (this.eJX != null) {
                fQ += f.a.a.b.b.a.h(3, this.eJX);
            }
            if (this.eJY != null) {
                return fQ + f.a.a.b.b.a.h(4, this.eJY);
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
            qt qtVar = (qt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qtVar.eJV = aVar3.vHC.rY();
                    return 0;
                case 2:
                    qtVar.eJW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    qtVar.eJX = aVar3.vHC.readString();
                    return 0;
                case 4:
                    qtVar.eJY = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
