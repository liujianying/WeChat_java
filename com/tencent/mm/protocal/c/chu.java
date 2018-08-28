package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class chu extends a {
    public String bPS;
    public String sBN;
    public String sBO;
    public int sBP;
    public int sBQ;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.type);
            if (this.bPS != null) {
                aVar.g(2, this.bPS);
            }
            if (this.sBN != null) {
                aVar.g(3, this.sBN);
            }
            if (this.sBO != null) {
                aVar.g(4, this.sBO);
            }
            aVar.fT(5, this.sBP);
            aVar.fT(6, this.sBQ);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.bPS != null) {
                fQ += f.a.a.b.b.a.h(2, this.bPS);
            }
            if (this.sBN != null) {
                fQ += f.a.a.b.b.a.h(3, this.sBN);
            }
            if (this.sBO != null) {
                fQ += f.a.a.b.b.a.h(4, this.sBO);
            }
            return (fQ + f.a.a.a.fQ(5, this.sBP)) + f.a.a.a.fQ(6, this.sBQ);
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
            chu chu = (chu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chu.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    chu.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    chu.sBN = aVar3.vHC.readString();
                    return 0;
                case 4:
                    chu.sBO = aVar3.vHC.readString();
                    return 0;
                case 5:
                    chu.sBP = aVar3.vHC.rY();
                    return 0;
                case 6:
                    chu.sBQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
