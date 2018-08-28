package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bfw extends a {
    public String iwF;
    public String rgL;
    public int sfQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.iwF != null) {
                aVar.g(1, this.iwF);
            }
            if (this.rgL != null) {
                aVar.g(2, this.rgL);
            }
            aVar.fT(3, this.sfQ);
            return 0;
        } else if (i == 1) {
            if (this.iwF != null) {
                h = f.a.a.b.b.a.h(1, this.iwF) + 0;
            } else {
                h = 0;
            }
            if (this.rgL != null) {
                h += f.a.a.b.b.a.h(2, this.rgL);
            }
            return h + f.a.a.a.fQ(3, this.sfQ);
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
            bfw bfw = (bfw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfw.iwF = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bfw.rgL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bfw.sfQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
