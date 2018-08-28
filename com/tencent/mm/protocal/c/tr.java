package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class tr extends a {
    public int rbZ;
    public String rxq;
    public String rxr;
    public String rxs;
    public String rxt;
    public String rxu;
    public int rxv;
    public int rxw;
    public String rxx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rxq == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.rxr == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.rxs == null) {
                throw new b("Not all required fields were included: ThanksPicUrl");
            } else {
                if (this.rxq != null) {
                    aVar.g(1, this.rxq);
                }
                if (this.rxr != null) {
                    aVar.g(2, this.rxr);
                }
                if (this.rxs != null) {
                    aVar.g(3, this.rxs);
                }
                if (this.rxt != null) {
                    aVar.g(4, this.rxt);
                }
                if (this.rxu != null) {
                    aVar.g(5, this.rxu);
                }
                aVar.fT(6, this.rxv);
                aVar.fT(7, this.rxw);
                if (this.rxx != null) {
                    aVar.g(8, this.rxx);
                }
                aVar.fT(9, this.rbZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.rxq != null) {
                h = f.a.a.b.b.a.h(1, this.rxq) + 0;
            } else {
                h = 0;
            }
            if (this.rxr != null) {
                h += f.a.a.b.b.a.h(2, this.rxr);
            }
            if (this.rxs != null) {
                h += f.a.a.b.b.a.h(3, this.rxs);
            }
            if (this.rxt != null) {
                h += f.a.a.b.b.a.h(4, this.rxt);
            }
            if (this.rxu != null) {
                h += f.a.a.b.b.a.h(5, this.rxu);
            }
            h = (h + f.a.a.a.fQ(6, this.rxv)) + f.a.a.a.fQ(7, this.rxw);
            if (this.rxx != null) {
                h += f.a.a.b.b.a.h(8, this.rxx);
            }
            return h + f.a.a.a.fQ(9, this.rbZ);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rxq == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.rxr == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.rxs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThanksPicUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            tr trVar = (tr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    trVar.rxq = aVar3.vHC.readString();
                    return 0;
                case 2:
                    trVar.rxr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    trVar.rxs = aVar3.vHC.readString();
                    return 0;
                case 4:
                    trVar.rxt = aVar3.vHC.readString();
                    return 0;
                case 5:
                    trVar.rxu = aVar3.vHC.readString();
                    return 0;
                case 6:
                    trVar.rxv = aVar3.vHC.rY();
                    return 0;
                case 7:
                    trVar.rxw = aVar3.vHC.rY();
                    return 0;
                case 8:
                    trVar.rxx = aVar3.vHC.readString();
                    return 0;
                case 9:
                    trVar.rbZ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
