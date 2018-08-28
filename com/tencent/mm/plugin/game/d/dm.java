package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class dm extends a {
    public String jPS;
    public String jTA;
    public String jTB;
    public String jTC;
    public int jTD;
    public String jTE;
    public String jTF;
    public String jTz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPS != null) {
                aVar.g(1, this.jPS);
            }
            if (this.jTz != null) {
                aVar.g(2, this.jTz);
            }
            if (this.jTA != null) {
                aVar.g(3, this.jTA);
            }
            if (this.jTB != null) {
                aVar.g(4, this.jTB);
            }
            if (this.jTC != null) {
                aVar.g(5, this.jTC);
            }
            aVar.fT(6, this.jTD);
            if (this.jTE != null) {
                aVar.g(7, this.jTE);
            }
            if (this.jTF == null) {
                return 0;
            }
            aVar.g(8, this.jTF);
            return 0;
        } else if (i == 1) {
            if (this.jPS != null) {
                h = f.a.a.b.b.a.h(1, this.jPS) + 0;
            } else {
                h = 0;
            }
            if (this.jTz != null) {
                h += f.a.a.b.b.a.h(2, this.jTz);
            }
            if (this.jTA != null) {
                h += f.a.a.b.b.a.h(3, this.jTA);
            }
            if (this.jTB != null) {
                h += f.a.a.b.b.a.h(4, this.jTB);
            }
            if (this.jTC != null) {
                h += f.a.a.b.b.a.h(5, this.jTC);
            }
            h += f.a.a.a.fQ(6, this.jTD);
            if (this.jTE != null) {
                h += f.a.a.b.b.a.h(7, this.jTE);
            }
            if (this.jTF != null) {
                h += f.a.a.b.b.a.h(8, this.jTF);
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
            dm dmVar = (dm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dmVar.jPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dmVar.jTz = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dmVar.jTA = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dmVar.jTB = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dmVar.jTC = aVar3.vHC.readString();
                    return 0;
                case 6:
                    dmVar.jTD = aVar3.vHC.rY();
                    return 0;
                case 7:
                    dmVar.jTE = aVar3.vHC.readString();
                    return 0;
                case 8:
                    dmVar.jTF = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
