package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bnq extends a {
    public int actionType;
    public String bSc;
    public String hwC;
    public String id;
    public long slJ;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            aVar.T(3, this.slJ);
            aVar.fT(4, this.actionType);
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            if (this.title != null) {
                aVar.g(6, this.title);
            }
            if (this.hwC == null) {
                return 0;
            }
            aVar.g(7, this.hwC);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                h = f.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                h = 0;
            }
            if (this.bSc != null) {
                h += f.a.a.b.b.a.h(2, this.bSc);
            }
            h = (h + f.a.a.a.S(3, this.slJ)) + f.a.a.a.fQ(4, this.actionType);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(5, this.url);
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(6, this.title);
            }
            if (this.hwC != null) {
                h += f.a.a.b.b.a.h(7, this.hwC);
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
            bnq bnq = (bnq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnq.id = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bnq.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bnq.slJ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bnq.actionType = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bnq.url = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bnq.title = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bnq.hwC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
