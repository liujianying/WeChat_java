package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cew extends a {
    public int otY;
    public String rlw;
    public String rwt;
    public String szk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szk == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.rwt == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.rlw == null) {
                throw new b("Not all required fields were included: ProductId");
            } else {
                if (this.szk != null) {
                    aVar.g(1, this.szk);
                }
                if (this.rwt != null) {
                    aVar.g(2, this.rwt);
                }
                if (this.rlw != null) {
                    aVar.g(3, this.rlw);
                }
                aVar.fT(4, this.otY);
                return 0;
            }
        } else if (i == 1) {
            if (this.szk != null) {
                h = f.a.a.b.b.a.h(1, this.szk) + 0;
            } else {
                h = 0;
            }
            if (this.rwt != null) {
                h += f.a.a.b.b.a.h(2, this.rwt);
            }
            if (this.rlw != null) {
                h += f.a.a.b.b.a.h(3, this.rlw);
            }
            return h + f.a.a.a.fQ(4, this.otY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.szk == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.rwt == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.rlw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ProductId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cew cew = (cew) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cew.szk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cew.rwt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cew.rlw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cew.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
