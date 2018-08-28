package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aea extends a {
    public String gmb;
    public String lMY;
    public String path;
    public String title;
    public int type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lMY != null) {
                aVar.g(1, this.lMY);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.fT(3, this.type);
            if (this.gmb != null) {
                aVar.g(4, this.gmb);
            }
            if (this.username != null) {
                aVar.g(5, this.username);
            }
            if (this.path == null) {
                return 0;
            }
            aVar.g(6, this.path);
            return 0;
        } else if (i == 1) {
            if (this.lMY != null) {
                h = f.a.a.b.b.a.h(1, this.lMY) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(2, this.title);
            }
            h += f.a.a.a.fQ(3, this.type);
            if (this.gmb != null) {
                h += f.a.a.b.b.a.h(4, this.gmb);
            }
            if (this.username != null) {
                h += f.a.a.b.b.a.h(5, this.username);
            }
            if (this.path != null) {
                h += f.a.a.b.b.a.h(6, this.path);
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
            aea aea = (aea) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aea.lMY = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aea.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aea.type = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aea.gmb = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aea.username = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aea.path = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
