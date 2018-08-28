package com.tencent.mm.protocal.b.a;

import f.a.a.b;

public final class a extends com.tencent.mm.bk.a {
    public int actionType;
    public int id;
    public String qXW;
    public String qXX;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qXW == null) {
                throw new b("Not all required fields were included: btnStr");
            }
            aVar.fT(1, this.id);
            aVar.fT(2, this.actionType);
            if (this.qXW != null) {
                aVar.g(3, this.qXW);
            }
            if (this.qXX != null) {
                aVar.g(4, this.qXX);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.id) + 0) + f.a.a.a.fQ(2, this.actionType);
            if (this.qXW != null) {
                fQ += f.a.a.b.b.a.h(3, this.qXW);
            }
            if (this.qXX != null) {
                return fQ + f.a.a.b.b.a.h(4, this.qXX);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = com.tencent.mm.bk.a.a(aVar2); fQ > 0; fQ = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.qXW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: btnStr");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aVar4.qXW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aVar4.qXX = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
