package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class arp extends a {
    public String devicename;
    public String devicetype;
    public String fMk;
    public int rTQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.fMk != null) {
                aVar.g(1, this.fMk);
            }
            if (this.devicename != null) {
                aVar.g(2, this.devicename);
            }
            if (this.devicetype != null) {
                aVar.g(3, this.devicetype);
            }
            aVar.fT(4, this.rTQ);
            return 0;
        } else if (i == 1) {
            if (this.fMk != null) {
                h = f.a.a.b.b.a.h(1, this.fMk) + 0;
            } else {
                h = 0;
            }
            if (this.devicename != null) {
                h += f.a.a.b.b.a.h(2, this.devicename);
            }
            if (this.devicetype != null) {
                h += f.a.a.b.b.a.h(3, this.devicetype);
            }
            return h + f.a.a.a.fQ(4, this.rTQ);
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
            arp arp = (arp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arp.fMk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    arp.devicename = aVar3.vHC.readString();
                    return 0;
                case 3:
                    arp.devicetype = aVar3.vHC.readString();
                    return 0;
                case 4:
                    arp.rTQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
