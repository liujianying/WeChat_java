package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cer extends a {
    public int spd;
    public String syk;
    public b szA;
    public b szB;
    public String szC;
    public String szD;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syk == null) {
                throw new f.a.a.b("Not all required fields were included: Msg");
            }
            aVar.fT(1, this.spd);
            if (this.syk != null) {
                aVar.g(2, this.syk);
            }
            if (this.szA != null) {
                aVar.b(3, this.szA);
            }
            if (this.szB != null) {
                aVar.b(4, this.szB);
            }
            if (this.szC != null) {
                aVar.g(5, this.szC);
            }
            if (this.szD != null) {
                aVar.g(6, this.szD);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.spd) + 0;
            if (this.syk != null) {
                fQ += f.a.a.b.b.a.h(2, this.syk);
            }
            if (this.szA != null) {
                fQ += f.a.a.a.a(3, this.szA);
            }
            if (this.szB != null) {
                fQ += f.a.a.a.a(4, this.szB);
            }
            if (this.szC != null) {
                fQ += f.a.a.b.b.a.h(5, this.szC);
            }
            if (this.szD != null) {
                return fQ + f.a.a.b.b.a.h(6, this.szD);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.syk != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cer cer = (cer) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cer.spd = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cer.syk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cer.szA = aVar3.cJR();
                    return 0;
                case 4:
                    cer.szB = aVar3.cJR();
                    return 0;
                case 5:
                    cer.szC = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cer.szD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
