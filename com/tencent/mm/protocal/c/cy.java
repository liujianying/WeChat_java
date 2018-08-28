package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cy extends a {
    public int jPZ;
    public String jPg;
    public String rcY;
    public long rcZ;
    public String rda;
    public String rdb;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcY != null) {
                aVar.g(1, this.rcY);
            }
            if (this.jPg != null) {
                aVar.g(2, this.jPg);
            }
            aVar.T(3, this.rcZ);
            if (this.rda != null) {
                aVar.g(4, this.rda);
            }
            if (this.rdb != null) {
                aVar.g(5, this.rdb);
            }
            aVar.fT(6, this.jPZ);
            return 0;
        } else if (i == 1) {
            if (this.rcY != null) {
                h = f.a.a.b.b.a.h(1, this.rcY) + 0;
            } else {
                h = 0;
            }
            if (this.jPg != null) {
                h += f.a.a.b.b.a.h(2, this.jPg);
            }
            h += f.a.a.a.S(3, this.rcZ);
            if (this.rda != null) {
                h += f.a.a.b.b.a.h(4, this.rda);
            }
            if (this.rdb != null) {
                h += f.a.a.b.b.a.h(5, this.rdb);
            }
            return h + f.a.a.a.fQ(6, this.jPZ);
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
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.rcY = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cyVar.jPg = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cyVar.rcZ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    cyVar.rda = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cyVar.rdb = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cyVar.jPZ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
