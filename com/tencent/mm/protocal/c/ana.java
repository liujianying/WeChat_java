package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ana extends a {
    public String bHD;
    public String jPK;
    public String jSv;
    public String rPM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPK != null) {
                aVar.g(1, this.jPK);
            }
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            if (this.rPM != null) {
                aVar.g(3, this.rPM);
            }
            if (this.jSv == null) {
                return 0;
            }
            aVar.g(4, this.jSv);
            return 0;
        } else if (i == 1) {
            if (this.jPK != null) {
                h = f.a.a.b.b.a.h(1, this.jPK) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.rPM != null) {
                h += f.a.a.b.b.a.h(3, this.rPM);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(4, this.jSv);
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
            ana ana = (ana) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ana.jPK = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ana.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ana.rPM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ana.jSv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
