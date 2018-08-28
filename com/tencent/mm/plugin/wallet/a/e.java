package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;

public final class e extends a {
    public String pdS;
    public String pdT;
    public String pdU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.pdS != null) {
                aVar.g(1, this.pdS);
            }
            if (this.pdT != null) {
                aVar.g(2, this.pdT);
            }
            if (this.pdU == null) {
                return 0;
            }
            aVar.g(3, this.pdU);
            return 0;
        } else if (i == 1) {
            if (this.pdS != null) {
                h = f.a.a.b.b.a.h(1, this.pdS) + 0;
            } else {
                h = 0;
            }
            if (this.pdT != null) {
                h += f.a.a.b.b.a.h(2, this.pdT);
            }
            if (this.pdU != null) {
                h += f.a.a.b.b.a.h(3, this.pdU);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.pdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    eVar.pdT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    eVar.pdU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
