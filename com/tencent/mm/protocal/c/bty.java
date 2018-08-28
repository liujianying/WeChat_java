package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bty extends a {
    public String knE;
    public String lMV;
    public String muA;
    public String muB;
    public String muC;
    public String muD;
    public String mug;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.muA != null) {
                aVar.g(1, this.muA);
            }
            if (this.muB != null) {
                aVar.g(2, this.muB);
            }
            if (this.mug != null) {
                aVar.g(3, this.mug);
            }
            if (this.knE != null) {
                aVar.g(4, this.knE);
            }
            if (this.lMV != null) {
                aVar.g(5, this.lMV);
            }
            if (this.muC != null) {
                aVar.g(6, this.muC);
            }
            if (this.muD == null) {
                return 0;
            }
            aVar.g(7, this.muD);
            return 0;
        } else if (i == 1) {
            if (this.muA != null) {
                h = f.a.a.b.b.a.h(1, this.muA) + 0;
            } else {
                h = 0;
            }
            if (this.muB != null) {
                h += f.a.a.b.b.a.h(2, this.muB);
            }
            if (this.mug != null) {
                h += f.a.a.b.b.a.h(3, this.mug);
            }
            if (this.knE != null) {
                h += f.a.a.b.b.a.h(4, this.knE);
            }
            if (this.lMV != null) {
                h += f.a.a.b.b.a.h(5, this.lMV);
            }
            if (this.muC != null) {
                h += f.a.a.b.b.a.h(6, this.muC);
            }
            if (this.muD != null) {
                h += f.a.a.b.b.a.h(7, this.muD);
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
            bty bty = (bty) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bty.muA = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bty.muB = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bty.mug = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bty.knE = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bty.lMV = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bty.muC = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bty.muD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
