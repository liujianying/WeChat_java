package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class ah extends a {
    public String jOS;
    public String jOU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            }
            if (this.jOS != null) {
                aVar.g(1, this.jOS);
            }
            if (this.jOU == null) {
                return 0;
            }
            aVar.g(2, this.jOU);
            return 0;
        } else if (i == 1) {
            if (this.jOS != null) {
                h = f.a.a.b.b.a.h(1, this.jOS) + 0;
            } else {
                h = 0;
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(2, this.jOU);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jOS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Desc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ah ahVar = (ah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ahVar.jOU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
