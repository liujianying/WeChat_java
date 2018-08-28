package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class asi extends a {
    public String bPS;
    public int otY;
    public int rRb;
    public int rUA;
    public int rUB;
    public String rUC;
    public int rUD;
    public int riv;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            aVar.fT(3, this.rRb);
            aVar.fT(4, this.riv);
            aVar.fT(5, this.otY);
            aVar.fT(6, this.rUA);
            aVar.fT(7, this.rUB);
            if (this.rUC != null) {
                aVar.g(8, this.rUC);
            }
            aVar.fT(9, this.rUD);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            if (this.username != null) {
                h += f.a.a.b.b.a.h(2, this.username);
            }
            h = ((((h + f.a.a.a.fQ(3, this.rRb)) + f.a.a.a.fQ(4, this.riv)) + f.a.a.a.fQ(5, this.otY)) + f.a.a.a.fQ(6, this.rUA)) + f.a.a.a.fQ(7, this.rUB);
            if (this.rUC != null) {
                h += f.a.a.b.b.a.h(8, this.rUC);
            }
            return h + f.a.a.a.fQ(9, this.rUD);
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
            asi asi = (asi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asi.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    asi.username = aVar3.vHC.readString();
                    return 0;
                case 3:
                    asi.rRb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    asi.riv = aVar3.vHC.rY();
                    return 0;
                case 5:
                    asi.otY = aVar3.vHC.rY();
                    return 0;
                case 6:
                    asi.rUA = aVar3.vHC.rY();
                    return 0;
                case 7:
                    asi.rUB = aVar3.vHC.rY();
                    return 0;
                case 8:
                    asi.rUC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    asi.rUD = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
