package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;

public final class g extends a {
    public String country;
    public String csK;
    public String csL;
    public String dRH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.g(1, this.country);
            }
            if (this.csK != null) {
                aVar.g(2, this.csK);
            }
            if (this.csL != null) {
                aVar.g(3, this.csL);
            }
            if (this.dRH == null) {
                return 0;
            }
            aVar.g(4, this.dRH);
            return 0;
        } else if (i == 1) {
            if (this.country != null) {
                h = f.a.a.b.b.a.h(1, this.country) + 0;
            } else {
                h = 0;
            }
            if (this.csK != null) {
                h += f.a.a.b.b.a.h(2, this.csK);
            }
            if (this.csL != null) {
                h += f.a.a.b.b.a.h(3, this.csL);
            }
            if (this.dRH != null) {
                h += f.a.a.b.b.a.h(4, this.dRH);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.country = aVar3.vHC.readString();
                    return 0;
                case 2:
                    gVar.csK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    gVar.csL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    gVar.dRH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
