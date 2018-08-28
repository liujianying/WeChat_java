package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class avu extends a {
    public int jQd;
    public String jTu;
    public String jTv;
    public int rci;
    public long rcq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jTv != null) {
                aVar.g(1, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(2, this.jTu);
            }
            aVar.fT(3, this.rci);
            aVar.fT(4, this.jQd);
            aVar.T(5, this.rcq);
            return 0;
        } else if (i == 1) {
            if (this.jTv != null) {
                h = f.a.a.b.b.a.h(1, this.jTv) + 0;
            } else {
                h = 0;
            }
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(2, this.jTu);
            }
            return ((h + f.a.a.a.fQ(3, this.rci)) + f.a.a.a.fQ(4, this.jQd)) + f.a.a.a.S(5, this.rcq);
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
            avu avu = (avu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avu.jTv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    avu.jTu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    avu.rci = aVar3.vHC.rY();
                    return 0;
                case 4:
                    avu.jQd = aVar3.vHC.rY();
                    return 0;
                case 5:
                    avu.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
