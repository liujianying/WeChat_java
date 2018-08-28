package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cez extends a {
    public int otY;
    public b rdU;
    public long szF;
    public String szk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            } else if (this.rdU == null) {
                throw new f.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.szk != null) {
                    aVar.g(1, this.szk);
                }
                aVar.T(2, this.szF);
                if (this.rdU != null) {
                    aVar.b(3, this.rdU);
                }
                aVar.fT(4, this.otY);
                return 0;
            }
        } else if (i == 1) {
            if (this.szk != null) {
                h = f.a.a.b.b.a.h(1, this.szk) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.S(2, this.szF);
            if (this.rdU != null) {
                h += f.a.a.a.a(3, this.rdU);
            }
            return h + f.a.a.a.fQ(4, this.otY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            } else if (this.rdU != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cez cez = (cez) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cez.szk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cez.szF = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    cez.rdU = aVar3.cJR();
                    return 0;
                case 4:
                    cez.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
