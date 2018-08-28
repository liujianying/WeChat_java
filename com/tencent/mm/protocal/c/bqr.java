package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bqr extends a {
    public String appName;
    public int blZ;
    public String soN;
    public boolean soO;
    public boolean soP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.soN != null) {
                aVar.g(1, this.soN);
            }
            if (this.appName != null) {
                aVar.g(2, this.appName);
            }
            aVar.fT(3, this.blZ);
            aVar.av(4, this.soO);
            aVar.av(5, this.soP);
            return 0;
        } else if (i == 1) {
            if (this.soN != null) {
                h = f.a.a.b.b.a.h(1, this.soN) + 0;
            } else {
                h = 0;
            }
            if (this.appName != null) {
                h += f.a.a.b.b.a.h(2, this.appName);
            }
            return ((h + f.a.a.a.fQ(3, this.blZ)) + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1);
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
            bqr bqr = (bqr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqr.soN = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bqr.appName = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bqr.blZ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bqr.soO = aVar3.cJQ();
                    return 0;
                case 5:
                    bqr.soP = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
