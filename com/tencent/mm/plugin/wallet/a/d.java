package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;

public final class d extends a {
    public String dzE;
    public String name;
    public String pdR;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.pdR != null) {
                aVar.g(3, this.pdR);
            }
            if (this.dzE == null) {
                return 0;
            }
            aVar.g(4, this.dzE);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                h = f.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.pdR != null) {
                h += f.a.a.b.b.a.h(3, this.pdR);
            }
            if (this.dzE != null) {
                h += f.a.a.b.b.a.h(4, this.dzE);
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.url = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dVar.pdR = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dVar.dzE = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
