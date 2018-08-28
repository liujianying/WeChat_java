package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ane extends a {
    public double ees;
    public String fMk;
    public int major;
    public int minor;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.fMk != null) {
                aVar.g(1, this.fMk);
            }
            aVar.fT(2, this.major);
            aVar.fT(3, this.minor);
            aVar.c(4, this.ees);
            return 0;
        } else if (i == 1) {
            if (this.fMk != null) {
                h = f.a.a.b.b.a.h(1, this.fMk) + 0;
            } else {
                h = 0;
            }
            return ((h + f.a.a.a.fQ(2, this.major)) + f.a.a.a.fQ(3, this.minor)) + (f.a.a.b.b.a.ec(4) + 8);
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
            ane ane = (ane) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ane.fMk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ane.major = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ane.minor = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ane.ees = aVar3.vHC.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
