package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class xg extends a {
    public int hcy;
    public String rDd;
    public long rDe;
    public String rDf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rDd == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.rDf == null) {
                throw new b("Not all required fields were included: MimeType");
            } else {
                if (this.rDd != null) {
                    aVar.g(1, this.rDd);
                }
                aVar.T(2, this.rDe);
                aVar.fT(3, this.hcy);
                if (this.rDf == null) {
                    return 0;
                }
                aVar.g(4, this.rDf);
                return 0;
            }
        } else if (i == 1) {
            if (this.rDd != null) {
                h = f.a.a.b.b.a.h(1, this.rDd) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.S(2, this.rDe)) + f.a.a.a.fQ(3, this.hcy);
            if (this.rDf != null) {
                h += f.a.a.b.b.a.h(4, this.rDf);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rDd == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.rDf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MimeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xg xgVar = (xg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xgVar.rDd = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xgVar.rDe = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    xgVar.hcy = aVar3.vHC.rY();
                    return 0;
                case 4:
                    xgVar.rDf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
