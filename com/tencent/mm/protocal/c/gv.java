package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class gv extends a {
    public String lMY;
    public String nickname;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.lMY != null) {
                aVar.g(2, this.lMY);
            }
            if (this.nickname == null) {
                return 0;
            }
            aVar.g(3, this.nickname);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.lMY != null) {
                h += f.a.a.b.b.a.h(2, this.lMY);
            }
            if (this.nickname != null) {
                h += f.a.a.b.b.a.h(3, this.nickname);
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
            gv gvVar = (gv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gvVar.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    gvVar.lMY = aVar3.vHC.readString();
                    return 0;
                case 3:
                    gvVar.nickname = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
