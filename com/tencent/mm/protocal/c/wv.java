package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class wv extends a {
    public int bkq;
    public String qdu;
    public String rBS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.qdu == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.rBS == null) {
                throw new b("Not all required fields were included: tagPinYin");
            } else {
                if (this.qdu != null) {
                    aVar.g(1, this.qdu);
                }
                if (this.rBS != null) {
                    aVar.g(2, this.rBS);
                }
                aVar.fT(3, this.bkq);
                return 0;
            }
        } else if (i == 1) {
            if (this.qdu != null) {
                h = f.a.a.b.b.a.h(1, this.qdu) + 0;
            } else {
                h = 0;
            }
            if (this.rBS != null) {
                h += f.a.a.b.b.a.h(2, this.rBS);
            }
            return h + f.a.a.a.fQ(3, this.bkq);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.qdu == null) {
                throw new b("Not all required fields were included: tagName");
            } else if (this.rBS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: tagPinYin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            wv wvVar = (wv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wvVar.qdu = aVar3.vHC.readString();
                    return 0;
                case 2:
                    wvVar.rBS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    wvVar.bkq = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
