package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cf extends a {
    public String jPe;
    public String jSH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jSH == null) {
                throw new b("Not all required fields were included: Color");
            } else {
                if (this.jPe != null) {
                    aVar.g(1, this.jPe);
                }
                if (this.jSH == null) {
                    return 0;
                }
                aVar.g(2, this.jSH);
                return 0;
            }
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.jSH != null) {
                h += f.a.a.b.b.a.h(2, this.jSH);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jSH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Color");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cfVar.jSH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
