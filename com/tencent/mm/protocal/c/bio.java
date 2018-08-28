package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bio extends a {
    public String fJU;
    public String jOS;
    public String rQD;
    public String rjR;
    public int sjd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rjR != null) {
                aVar.g(1, this.rjR);
            }
            if (this.jOS != null) {
                aVar.g(2, this.jOS);
            }
            aVar.fT(3, this.sjd);
            if (this.fJU != null) {
                aVar.g(4, this.fJU);
            }
            if (this.rQD == null) {
                return 0;
            }
            aVar.g(5, this.rQD);
            return 0;
        } else if (i == 1) {
            if (this.rjR != null) {
                h = f.a.a.b.b.a.h(1, this.rjR) + 0;
            } else {
                h = 0;
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(2, this.jOS);
            }
            h += f.a.a.a.fQ(3, this.sjd);
            if (this.fJU != null) {
                h += f.a.a.b.b.a.h(4, this.fJU);
            }
            if (this.rQD != null) {
                h += f.a.a.b.b.a.h(5, this.rQD);
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
            bio bio = (bio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bio.rjR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bio.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bio.sjd = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bio.fJU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bio.rQD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
