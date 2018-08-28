package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;

public final class n extends a {
    public String bPS;
    public int bWA;
    public String lRX;
    public String name;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.lRX != null) {
                aVar.g(3, this.lRX);
            }
            if (this.username != null) {
                aVar.g(4, this.username);
            }
            aVar.fT(5, this.bWA);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.lRX != null) {
                h += f.a.a.b.b.a.h(3, this.lRX);
            }
            if (this.username != null) {
                h += f.a.a.b.b.a.h(4, this.username);
            }
            return h + f.a.a.a.fQ(5, this.bWA);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nVar.lRX = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nVar.username = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nVar.bWA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
