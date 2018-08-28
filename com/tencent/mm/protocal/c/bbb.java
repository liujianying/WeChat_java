package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bbb extends a {
    public String eJJ;
    public String eJQ;
    public String rPL;
    public float rmr;
    public float rms;
    public String sdn;
    public String sdo;
    public long sdp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sdn != null) {
                aVar.g(1, this.sdn);
            }
            if (this.eJQ != null) {
                aVar.g(2, this.eJQ);
            }
            if (this.eJJ != null) {
                aVar.g(3, this.eJJ);
            }
            if (this.rPL != null) {
                aVar.g(4, this.rPL);
            }
            aVar.l(5, this.rms);
            aVar.l(6, this.rmr);
            if (this.sdo != null) {
                aVar.g(7, this.sdo);
            }
            aVar.T(8, this.sdp);
            return 0;
        } else if (i == 1) {
            if (this.sdn != null) {
                h = f.a.a.b.b.a.h(1, this.sdn) + 0;
            } else {
                h = 0;
            }
            if (this.eJQ != null) {
                h += f.a.a.b.b.a.h(2, this.eJQ);
            }
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(3, this.eJJ);
            }
            if (this.rPL != null) {
                h += f.a.a.b.b.a.h(4, this.rPL);
            }
            h = (h + (f.a.a.b.b.a.ec(5) + 4)) + (f.a.a.b.b.a.ec(6) + 4);
            if (this.sdo != null) {
                h += f.a.a.b.b.a.h(7, this.sdo);
            }
            return h + f.a.a.a.S(8, this.sdp);
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
            bbb bbb = (bbb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbb.sdn = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bbb.eJQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbb.eJJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbb.rPL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbb.rms = aVar3.vHC.readFloat();
                    return 0;
                case 6:
                    bbb.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 7:
                    bbb.sdo = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbb.sdp = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
