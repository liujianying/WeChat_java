package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class l extends a {
    public String jPH;
    public String jPI;
    public String jPJ;
    public String jPK;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPH == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.jPI == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.jPJ == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.jPK == null) {
                throw new b("Not all required fields were included: Url");
            } else {
                if (this.jPH != null) {
                    aVar.g(1, this.jPH);
                }
                if (this.jPI != null) {
                    aVar.g(2, this.jPI);
                }
                if (this.jPJ != null) {
                    aVar.g(3, this.jPJ);
                }
                if (this.jPK == null) {
                    return 0;
                }
                aVar.g(4, this.jPK);
                return 0;
            }
        } else if (i == 1) {
            if (this.jPH != null) {
                h = f.a.a.b.b.a.h(1, this.jPH) + 0;
            } else {
                h = 0;
            }
            if (this.jPI != null) {
                h += f.a.a.b.b.a.h(2, this.jPI);
            }
            if (this.jPJ != null) {
                h += f.a.a.b.b.a.h(3, this.jPJ);
            }
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(4, this.jPK);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPH == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.jPI == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.jPJ == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.jPK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.jPH = aVar3.vHC.readString();
                    return 0;
                case 2:
                    lVar.jPI = aVar3.vHC.readString();
                    return 0;
                case 3:
                    lVar.jPJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    lVar.jPK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
