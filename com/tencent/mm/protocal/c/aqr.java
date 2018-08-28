package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aqr extends a {
    public float rmr;
    public float rms;
    public int ryV;
    public String ryW;
    public String ryX;
    public int ryY;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.l(1, this.rmr);
            aVar.l(2, this.rms);
            aVar.fT(3, this.ryV);
            if (this.ryW != null) {
                aVar.g(4, this.ryW);
            }
            if (this.ryX != null) {
                aVar.g(5, this.ryX);
            }
            aVar.fT(6, this.ryY);
            return 0;
        } else if (i == 1) {
            ec = (((f.a.a.b.b.a.ec(1) + 4) + 0) + (f.a.a.b.b.a.ec(2) + 4)) + f.a.a.a.fQ(3, this.ryV);
            if (this.ryW != null) {
                ec += f.a.a.b.b.a.h(4, this.ryW);
            }
            if (this.ryX != null) {
                ec += f.a.a.b.b.a.h(5, this.ryX);
            }
            return ec + f.a.a.a.fQ(6, this.ryY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aqr aqr = (aqr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqr.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 2:
                    aqr.rms = aVar3.vHC.readFloat();
                    return 0;
                case 3:
                    aqr.ryV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aqr.ryW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aqr.ryX = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aqr.ryY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
