package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bnn extends a {
    public String hUt;
    public String kRu;
    public String kRv;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.kRu != null) {
                aVar.g(1, this.kRu);
            }
            if (this.kRv != null) {
                aVar.g(2, this.kRv);
            }
            if (this.hUt == null) {
                return 0;
            }
            aVar.g(3, this.hUt);
            return 0;
        } else if (i == 1) {
            if (this.kRu != null) {
                h = f.a.a.b.b.a.h(1, this.kRu) + 0;
            } else {
                h = 0;
            }
            if (this.kRv != null) {
                h += f.a.a.b.b.a.h(2, this.kRv);
            }
            if (this.hUt != null) {
                h += f.a.a.b.b.a.h(3, this.hUt);
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
            bnn bnn = (bnn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnn.kRu = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bnn.kRv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bnn.hUt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
