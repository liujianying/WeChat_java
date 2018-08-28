package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bcx extends a {
    public String rDt;
    public int rKb;
    public String rwt;
    public int rxJ;
    public int sfd;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rKb);
            if (this.rDt != null) {
                aVar.g(2, this.rDt);
            }
            if (this.rwt != null) {
                aVar.g(3, this.rwt);
            }
            aVar.fT(4, this.rxJ);
            aVar.fT(5, this.sfd);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rKb) + 0;
            if (this.rDt != null) {
                fQ += f.a.a.b.b.a.h(2, this.rDt);
            }
            if (this.rwt != null) {
                fQ += f.a.a.b.b.a.h(3, this.rwt);
            }
            return (fQ + f.a.a.a.fQ(4, this.rxJ)) + f.a.a.a.fQ(5, this.sfd);
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
            bcx bcx = (bcx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcx.rKb = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bcx.rDt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bcx.rwt = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bcx.rxJ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bcx.sfd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
