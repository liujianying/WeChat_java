package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bll extends a {
    public String nickname;
    public boolean sks;
    public String skt;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.av(2, this.sks);
            if (this.nickname != null) {
                aVar.g(3, this.nickname);
            }
            if (this.skt == null) {
                return 0;
            }
            aVar.g(4, this.skt);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.b.b.a.ec(2) + 1;
            if (this.nickname != null) {
                h += f.a.a.b.b.a.h(3, this.nickname);
            }
            if (this.skt != null) {
                h += f.a.a.b.b.a.h(4, this.skt);
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
            bll bll = (bll) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bll.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bll.sks = aVar3.cJQ();
                    return 0;
                case 3:
                    bll.nickname = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bll.skt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
