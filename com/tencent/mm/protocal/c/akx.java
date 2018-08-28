package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class akx extends a {
    public String rNM;
    public String rNN;
    public String rwL;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwL != null) {
                aVar.g(1, this.rwL);
            }
            if (this.rNM != null) {
                aVar.g(2, this.rNM);
            }
            if (this.rNN == null) {
                return 0;
            }
            aVar.g(3, this.rNN);
            return 0;
        } else if (i == 1) {
            if (this.rwL != null) {
                h = f.a.a.b.b.a.h(1, this.rwL) + 0;
            } else {
                h = 0;
            }
            if (this.rNM != null) {
                h += f.a.a.b.b.a.h(2, this.rNM);
            }
            if (this.rNN != null) {
                h += f.a.a.b.b.a.h(3, this.rNN);
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
            akx akx = (akx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akx.rwL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    akx.rNM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    akx.rNN = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
