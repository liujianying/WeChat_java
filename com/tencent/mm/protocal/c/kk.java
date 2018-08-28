package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class kk extends a {
    public String rgp;
    public String rmD;
    public int rmE;
    public String rmF;
    public String rmG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rmD != null) {
                aVar.g(1, this.rmD);
            }
            aVar.fT(2, this.rmE);
            if (this.rmF != null) {
                aVar.g(3, this.rmF);
            }
            if (this.rgp != null) {
                aVar.g(4, this.rgp);
            }
            if (this.rmG == null) {
                return 0;
            }
            aVar.g(5, this.rmG);
            return 0;
        } else if (i == 1) {
            if (this.rmD != null) {
                h = f.a.a.b.b.a.h(1, this.rmD) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rmE);
            if (this.rmF != null) {
                h += f.a.a.b.b.a.h(3, this.rmF);
            }
            if (this.rgp != null) {
                h += f.a.a.b.b.a.h(4, this.rgp);
            }
            if (this.rmG != null) {
                h += f.a.a.b.b.a.h(5, this.rmG);
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
            kk kkVar = (kk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kkVar.rmD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    kkVar.rmE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    kkVar.rmF = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kkVar.rgp = aVar3.vHC.readString();
                    return 0;
                case 5:
                    kkVar.rmG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
