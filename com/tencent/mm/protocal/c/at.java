package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class at extends a {
    public String jQb;
    public String raM;
    public String raN;
    public String raO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb != null) {
                aVar.g(1, this.jQb);
            }
            if (this.raM != null) {
                aVar.g(2, this.raM);
            }
            if (this.raN != null) {
                aVar.g(3, this.raN);
            }
            if (this.raO == null) {
                return 0;
            }
            aVar.g(4, this.raO);
            return 0;
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            if (this.raM != null) {
                h += f.a.a.b.b.a.h(2, this.raM);
            }
            if (this.raN != null) {
                h += f.a.a.b.b.a.h(3, this.raN);
            }
            if (this.raO != null) {
                h += f.a.a.b.b.a.h(4, this.raO);
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
            at atVar = (at) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    atVar.raM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    atVar.raN = aVar3.vHC.readString();
                    return 0;
                case 4:
                    atVar.raO = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
