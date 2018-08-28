package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bxd extends a {
    public String eJM;
    public String hbL;
    public String hcS;
    public String rej;
    public String rul;
    public String stJ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.stJ == null) {
                throw new b("Not all required fields were included: MatchWord");
            } else {
                if (this.hbL != null) {
                    aVar.g(1, this.hbL);
                }
                if (this.stJ != null) {
                    aVar.g(2, this.stJ);
                }
                if (this.hcS != null) {
                    aVar.g(3, this.hcS);
                }
                if (this.rul != null) {
                    aVar.g(4, this.rul);
                }
                if (this.eJM != null) {
                    aVar.g(5, this.eJM);
                }
                if (this.rej == null) {
                    return 0;
                }
                aVar.g(6, this.rej);
                return 0;
            }
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.stJ != null) {
                h += f.a.a.b.b.a.h(2, this.stJ);
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(3, this.hcS);
            }
            if (this.rul != null) {
                h += f.a.a.b.b.a.h(4, this.rul);
            }
            if (this.eJM != null) {
                h += f.a.a.b.b.a.h(5, this.eJM);
            }
            if (this.rej != null) {
                h += f.a.a.b.b.a.h(6, this.rej);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.stJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MatchWord");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bxd bxd = (bxd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxd.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bxd.stJ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bxd.hcS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bxd.rul = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bxd.eJM = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bxd.rej = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
