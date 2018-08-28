package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class atr extends a {
    public String desc;
    public String huW;
    public String path;
    public String title;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.huW != null) {
                aVar.g(1, this.huW);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            if (this.username != null) {
                aVar.g(4, this.username);
            }
            if (this.path == null) {
                return 0;
            }
            aVar.g(5, this.path);
            return 0;
        } else if (i == 1) {
            if (this.huW != null) {
                h = f.a.a.b.b.a.h(1, this.huW) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(2, this.title);
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(3, this.desc);
            }
            if (this.username != null) {
                h += f.a.a.b.b.a.h(4, this.username);
            }
            if (this.path != null) {
                h += f.a.a.b.b.a.h(5, this.path);
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
            atr atr = (atr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atr.huW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    atr.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    atr.desc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    atr.username = aVar3.vHC.readString();
                    return 0;
                case 5:
                    atr.path = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
