package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;

public final class cy extends a {
    public String jOX;
    public String jPd;
    public String jTm;
    public String jTn;
    public String jTo;
    public boolean jTp;
    public boolean jTq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPd != null) {
                aVar.g(1, this.jPd);
            }
            if (this.jTm != null) {
                aVar.g(2, this.jTm);
            }
            if (this.jTn != null) {
                aVar.g(3, this.jTn);
            }
            if (this.jTo != null) {
                aVar.g(4, this.jTo);
            }
            if (this.jOX != null) {
                aVar.g(5, this.jOX);
            }
            aVar.av(6, this.jTp);
            aVar.av(7, this.jTq);
            return 0;
        } else if (i == 1) {
            if (this.jPd != null) {
                h = f.a.a.b.b.a.h(1, this.jPd) + 0;
            } else {
                h = 0;
            }
            if (this.jTm != null) {
                h += f.a.a.b.b.a.h(2, this.jTm);
            }
            if (this.jTn != null) {
                h += f.a.a.b.b.a.h(3, this.jTn);
            }
            if (this.jTo != null) {
                h += f.a.a.b.b.a.h(4, this.jTo);
            }
            if (this.jOX != null) {
                h += f.a.a.b.b.a.h(5, this.jOX);
            }
            return (h + (f.a.a.b.b.a.ec(6) + 1)) + (f.a.a.b.b.a.ec(7) + 1);
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
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.jPd = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cyVar.jTm = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cyVar.jTn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cyVar.jTo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cyVar.jOX = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cyVar.jTp = aVar3.cJQ();
                    return 0;
                case 7:
                    cyVar.jTq = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
