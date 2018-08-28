package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ccf extends a {
    public String jPM;
    public String jTv;
    public String sdK;
    public String syi;
    public String syj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sdK != null) {
                aVar.g(1, this.sdK);
            }
            if (this.syi != null) {
                aVar.g(2, this.syi);
            }
            if (this.jTv != null) {
                aVar.g(3, this.jTv);
            }
            if (this.jPM != null) {
                aVar.g(4, this.jPM);
            }
            if (this.syj == null) {
                return 0;
            }
            aVar.g(5, this.syj);
            return 0;
        } else if (i == 1) {
            if (this.sdK != null) {
                h = f.a.a.b.b.a.h(1, this.sdK) + 0;
            } else {
                h = 0;
            }
            if (this.syi != null) {
                h += f.a.a.b.b.a.h(2, this.syi);
            }
            if (this.jTv != null) {
                h += f.a.a.b.b.a.h(3, this.jTv);
            }
            if (this.jPM != null) {
                h += f.a.a.b.b.a.h(4, this.jPM);
            }
            if (this.syj != null) {
                h += f.a.a.b.b.a.h(5, this.syj);
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
            ccf ccf = (ccf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccf.sdK = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ccf.syi = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ccf.jTv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ccf.jPM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ccf.syj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
