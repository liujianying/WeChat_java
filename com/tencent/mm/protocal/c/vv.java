package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class vv extends a {
    public String appId;
    public String bGH;
    public int bPh;
    public String iconUrl;
    public String rzd;
    public int type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.appId != null) {
                aVar.g(2, this.appId);
            }
            aVar.fT(3, this.bPh);
            if (this.iconUrl != null) {
                aVar.g(4, this.iconUrl);
            }
            aVar.fT(5, this.type);
            if (this.bGH != null) {
                aVar.g(6, this.bGH);
            }
            if (this.rzd == null) {
                return 0;
            }
            aVar.g(7, this.rzd);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.appId != null) {
                h += f.a.a.b.b.a.h(2, this.appId);
            }
            h += f.a.a.a.fQ(3, this.bPh);
            if (this.iconUrl != null) {
                h += f.a.a.b.b.a.h(4, this.iconUrl);
            }
            h += f.a.a.a.fQ(5, this.type);
            if (this.bGH != null) {
                h += f.a.a.b.b.a.h(6, this.bGH);
            }
            if (this.rzd != null) {
                h += f.a.a.b.b.a.h(7, this.rzd);
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
            vv vvVar = (vv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vvVar.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    vvVar.appId = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vvVar.bPh = aVar3.vHC.rY();
                    return 0;
                case 4:
                    vvVar.iconUrl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vvVar.type = aVar3.vHC.rY();
                    return 0;
                case 6:
                    vvVar.bGH = aVar3.vHC.readString();
                    return 0;
                case 7:
                    vvVar.rzd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
