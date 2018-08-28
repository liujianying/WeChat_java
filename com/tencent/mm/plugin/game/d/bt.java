package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class bt extends a {
    public String desc;
    public String dvS;
    public String jSq;
    public String jSr;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.dvS != null) {
                aVar.g(2, this.dvS);
            }
            if (this.jSq != null) {
                aVar.g(3, this.jSq);
            }
            if (this.desc != null) {
                aVar.g(4, this.desc);
            }
            if (this.jSr == null) {
                return 0;
            }
            aVar.g(5, this.jSr);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.dvS != null) {
                h += f.a.a.b.b.a.h(2, this.dvS);
            }
            if (this.jSq != null) {
                h += f.a.a.b.b.a.h(3, this.jSq);
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(4, this.desc);
            }
            if (this.jSr != null) {
                h += f.a.a.b.b.a.h(5, this.jSr);
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
            bt btVar = (bt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    btVar.dvS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    btVar.jSq = aVar3.vHC.readString();
                    return 0;
                case 4:
                    btVar.desc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    btVar.jSr = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
