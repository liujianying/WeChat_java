package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class u extends a {
    public String hbL;
    public String jQf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.jQf == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.hbL != null) {
                    aVar.g(1, this.hbL);
                }
                if (this.jQf == null) {
                    return 0;
                }
                aVar.g(2, this.jQf);
                return 0;
            }
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.jQf != null) {
                h += f.a.a.b.b.a.h(2, this.jQf);
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
            } else if (this.jQf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    uVar.jQf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
