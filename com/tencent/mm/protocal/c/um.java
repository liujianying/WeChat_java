package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class um extends a {
    public String jPe;
    public int jTt;
    public int rlz;
    public String rxc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            aVar.fT(2, this.rlz);
            if (this.rxc != null) {
                aVar.g(3, this.rxc);
            }
            aVar.fT(4, this.jTt);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rlz);
            if (this.rxc != null) {
                h += f.a.a.b.b.a.h(3, this.rxc);
            }
            return h + f.a.a.a.fQ(4, this.jTt);
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
            um umVar = (um) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    umVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    umVar.rlz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    umVar.rxc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    umVar.jTt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
