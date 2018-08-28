package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bsd extends a {
    public String rbW;
    public String spJ;
    public chn spM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.spJ == null) {
                throw new b("Not all required fields were included: WxaUserName");
            }
            if (this.spJ != null) {
                aVar.g(1, this.spJ);
            }
            if (this.spM != null) {
                aVar.fV(2, this.spM.boi());
                this.spM.a(aVar);
            }
            if (this.rbW == null) {
                return 0;
            }
            aVar.g(3, this.rbW);
            return 0;
        } else if (i == 1) {
            if (this.spJ != null) {
                h = f.a.a.b.b.a.h(1, this.spJ) + 0;
            } else {
                h = 0;
            }
            if (this.spM != null) {
                h += f.a.a.a.fS(2, this.spM.boi());
            }
            if (this.rbW != null) {
                h += f.a.a.b.b.a.h(3, this.rbW);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.spJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: WxaUserName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bsd bsd = (bsd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bsd.spJ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        chn chn = new chn();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chn.a(aVar4, chn, a.a(aVar4))) {
                        }
                        bsd.spM = chn;
                    }
                    return 0;
                case 3:
                    bsd.rbW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
