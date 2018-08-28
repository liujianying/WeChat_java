package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class byk extends a {
    public String bJT;
    public String bPS;
    public String hFk;
    public String rQE;
    public String rQn;
    public String sus;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            if (this.bJT != null) {
                aVar.g(2, this.bJT);
            }
            if (this.rQE != null) {
                aVar.g(3, this.rQE);
            }
            if (this.sus != null) {
                aVar.g(4, this.sus);
            }
            if (this.hFk != null) {
                aVar.g(5, this.hFk);
            }
            if (this.rQn == null) {
                return 0;
            }
            aVar.g(6, this.rQn);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            if (this.bJT != null) {
                h += f.a.a.b.b.a.h(2, this.bJT);
            }
            if (this.rQE != null) {
                h += f.a.a.b.b.a.h(3, this.rQE);
            }
            if (this.sus != null) {
                h += f.a.a.b.b.a.h(4, this.sus);
            }
            if (this.hFk != null) {
                h += f.a.a.b.b.a.h(5, this.hFk);
            }
            if (this.rQn != null) {
                h += f.a.a.b.b.a.h(6, this.rQn);
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
            byk byk = (byk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byk.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    byk.bJT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    byk.rQE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    byk.sus = aVar3.vHC.readString();
                    return 0;
                case 5:
                    byk.hFk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    byk.rQn = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
