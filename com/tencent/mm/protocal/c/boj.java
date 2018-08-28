package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class boj extends a {
    public String hbL;
    public int rTo;
    public String smq;
    public int smr;
    public String sms;
    public int smt;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.smq != null) {
                aVar.g(1, this.smq);
            }
            aVar.fT(2, this.smr);
            if (this.hbL != null) {
                aVar.g(3, this.hbL);
            }
            if (this.sms != null) {
                aVar.g(4, this.sms);
            }
            aVar.fT(5, this.rTo);
            aVar.fT(6, this.smt);
            return 0;
        } else if (i == 1) {
            if (this.smq != null) {
                h = f.a.a.b.b.a.h(1, this.smq) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.smr);
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(3, this.hbL);
            }
            if (this.sms != null) {
                h += f.a.a.b.b.a.h(4, this.sms);
            }
            return (h + f.a.a.a.fQ(5, this.rTo)) + f.a.a.a.fQ(6, this.smt);
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
            boj boj = (boj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    boj.smq = aVar3.vHC.readString();
                    return 0;
                case 2:
                    boj.smr = aVar3.vHC.rY();
                    return 0;
                case 3:
                    boj.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    boj.sms = aVar3.vHC.readString();
                    return 0;
                case 5:
                    boj.rTo = aVar3.vHC.rY();
                    return 0;
                case 6:
                    boj.smt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
