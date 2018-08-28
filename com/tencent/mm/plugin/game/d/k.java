package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class k extends a {
    public String bHD;
    public String jOS;
    public String jOU;
    public String jPA;
    public int jPC;
    public String jPG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOU == null) {
                throw new b("Not all required fields were included: JumpUrl");
            } else {
                if (this.jPG != null) {
                    aVar.g(1, this.jPG);
                }
                if (this.bHD != null) {
                    aVar.g(2, this.bHD);
                }
                if (this.jOS != null) {
                    aVar.g(3, this.jOS);
                }
                if (this.jOU != null) {
                    aVar.g(4, this.jOU);
                }
                aVar.fT(5, this.jPC);
                if (this.jPA == null) {
                    return 0;
                }
                aVar.g(6, this.jPA);
                return 0;
            }
        } else if (i == 1) {
            if (this.jPG != null) {
                h = f.a.a.b.b.a.h(1, this.jPG) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(3, this.jOS);
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(4, this.jOU);
            }
            h += f.a.a.a.fQ(5, this.jPC);
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(6, this.jPA);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JumpUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 2:
                    kVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kVar.jOU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    kVar.jPC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    kVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
