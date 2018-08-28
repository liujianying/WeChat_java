package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class n extends a {
    public String jOS;
    public String jOU;
    public String jPM;
    public int jPN;
    public String jPe;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPM != null) {
                aVar.g(1, this.jPM);
            }
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            if (this.jOS != null) {
                aVar.g(3, this.jOS);
            }
            if (this.jOU != null) {
                aVar.g(4, this.jOU);
            }
            aVar.fT(5, this.jPN);
            return 0;
        } else if (i == 1) {
            if (this.jPM != null) {
                h = f.a.a.b.b.a.h(1, this.jPM) + 0;
            } else {
                h = 0;
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(3, this.jOS);
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(4, this.jOU);
            }
            return h + f.a.a.a.fQ(5, this.jPN);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.jPM = aVar3.vHC.readString();
                    return 0;
                case 2:
                    nVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nVar.jOU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nVar.jPN = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
