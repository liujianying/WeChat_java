package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bv extends a {
    public String bHD;
    public String jOX;
    public String jQf;
    public String jSp;
    public String jSt;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.jSp != null) {
                aVar.g(1, this.jSp);
            }
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            if (this.jQf != null) {
                aVar.g(3, this.jQf);
            }
            if (this.jOX != null) {
                aVar.g(4, this.jOX);
            }
            if (this.jSt == null) {
                return 0;
            }
            aVar.g(5, this.jSt);
            return 0;
        } else if (i == 1) {
            if (this.jSp != null) {
                h = f.a.a.b.b.a.h(1, this.jSp) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.jQf != null) {
                h += f.a.a.b.b.a.h(3, this.jQf);
            }
            if (this.jOX != null) {
                h += f.a.a.b.b.a.h(4, this.jOX);
            }
            if (this.jSt != null) {
                h += f.a.a.b.b.a.h(5, this.jSt);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bv bvVar = (bv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvVar.jSp = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bvVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvVar.jQf = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bvVar.jOX = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bvVar.jSt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
