package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bao extends a {
    public String lMV;
    public String scW;
    public String scX;
    public String scY;
    public String scZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.scW != null) {
                aVar.g(1, this.scW);
            }
            if (this.scX != null) {
                aVar.g(2, this.scX);
            }
            if (this.lMV != null) {
                aVar.g(3, this.lMV);
            }
            if (this.scY != null) {
                aVar.g(4, this.scY);
            }
            if (this.scZ == null) {
                return 0;
            }
            aVar.g(5, this.scZ);
            return 0;
        } else if (i == 1) {
            if (this.scW != null) {
                h = f.a.a.b.b.a.h(1, this.scW) + 0;
            } else {
                h = 0;
            }
            if (this.scX != null) {
                h += f.a.a.b.b.a.h(2, this.scX);
            }
            if (this.lMV != null) {
                h += f.a.a.b.b.a.h(3, this.lMV);
            }
            if (this.scY != null) {
                h += f.a.a.b.b.a.h(4, this.scY);
            }
            if (this.scZ != null) {
                h += f.a.a.b.b.a.h(5, this.scZ);
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
            bao bao = (bao) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bao.scW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bao.scX = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bao.lMV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bao.scY = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bao.scZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
