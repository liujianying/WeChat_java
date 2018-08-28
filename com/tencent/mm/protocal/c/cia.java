package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public class cia extends a {
    public String hbL;
    public String jPG;
    public String jQb;
    public String jQp;
    public String jSv;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.jSv == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else {
                if (this.jQb != null) {
                    aVar.g(1, this.jQb);
                }
                if (this.jSv != null) {
                    aVar.g(2, this.jSv);
                }
                if (this.hbL != null) {
                    aVar.g(3, this.hbL);
                }
                if (this.jPG != null) {
                    aVar.g(4, this.jPG);
                }
                if (this.jQp == null) {
                    return 0;
                }
                aVar.g(5, this.jQp);
                return 0;
            }
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(2, this.jSv);
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(3, this.hbL);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(4, this.jPG);
            }
            if (this.jQp != null) {
                h += f.a.a.b.b.a.h(5, this.jQp);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.jSv == null) {
                throw new b("Not all required fields were included: AppName");
            } else if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.jPG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cia cia = (cia) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cia.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cia.jSv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cia.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cia.jPG = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cia.jQp = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
