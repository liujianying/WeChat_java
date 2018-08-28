package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class awp extends a {
    public String desc;
    public String fJU;
    public int rZQ;
    public String scope;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.fT(3, this.rZQ);
            if (this.fJU == null) {
                return 0;
            }
            aVar.g(4, this.fJU);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                h = f.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            h += f.a.a.a.fQ(3, this.rZQ);
            if (this.fJU != null) {
                h += f.a.a.b.b.a.h(4, this.fJU);
            }
            return h;
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
            awp awp = (awp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awp.scope = aVar3.vHC.readString();
                    return 0;
                case 2:
                    awp.desc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    awp.rZQ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    awp.fJU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
