package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class xy extends a {
    public String jPc;
    public int rDF;
    public String rDG;
    public String rDO;
    public String rej;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.rDO == null) {
                throw new b("Not all required fields were included: RecommendKey");
            } else {
                if (this.jPc != null) {
                    aVar.g(1, this.jPc);
                }
                if (this.rDO != null) {
                    aVar.g(2, this.rDO);
                }
                if (this.rej != null) {
                    aVar.g(3, this.rej);
                }
                aVar.fT(4, this.rDF);
                if (this.rDG == null) {
                    return 0;
                }
                aVar.g(5, this.rDG);
                return 0;
            }
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.rDO != null) {
                h += f.a.a.b.b.a.h(2, this.rDO);
            }
            if (this.rej != null) {
                h += f.a.a.b.b.a.h(3, this.rej);
            }
            h += f.a.a.a.fQ(4, this.rDF);
            if (this.rDG != null) {
                h += f.a.a.b.b.a.h(5, this.rDG);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPc == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.rDO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RecommendKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xy xyVar = (xy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xyVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xyVar.rDO = aVar3.vHC.readString();
                    return 0;
                case 3:
                    xyVar.rej = aVar3.vHC.readString();
                    return 0;
                case 4:
                    xyVar.rDF = aVar3.vHC.rY();
                    return 0;
                case 5:
                    xyVar.rDG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
