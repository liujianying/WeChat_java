package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ams extends a {
    public String rPA;
    public int rPB;
    public String rPz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rPz != null) {
                aVar.g(1, this.rPz);
            }
            if (this.rPA != null) {
                aVar.g(2, this.rPA);
            }
            aVar.fT(3, this.rPB);
            return 0;
        } else if (i == 1) {
            if (this.rPz != null) {
                h = f.a.a.b.b.a.h(1, this.rPz) + 0;
            } else {
                h = 0;
            }
            if (this.rPA != null) {
                h += f.a.a.b.b.a.h(2, this.rPA);
            }
            return h + f.a.a.a.fQ(3, this.rPB);
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
            ams ams = (ams) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ams.rPz = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ams.rPA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ams.rPB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
