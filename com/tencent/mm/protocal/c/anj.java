package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class anj extends a {
    public String desc;
    public String rPX;
    public String rPY;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.rPX != null) {
                aVar.g(3, this.rPX);
            }
            if (this.rPY == null) {
                return 0;
            }
            aVar.g(4, this.rPY);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            if (this.rPX != null) {
                h += f.a.a.b.b.a.h(3, this.rPX);
            }
            if (this.rPY != null) {
                h += f.a.a.b.b.a.h(4, this.rPY);
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
            anj anj = (anj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anj.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    anj.desc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    anj.rPX = aVar3.vHC.readString();
                    return 0;
                case 4:
                    anj.rPY = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
