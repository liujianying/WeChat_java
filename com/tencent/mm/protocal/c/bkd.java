package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bkd extends a {
    public b rwb;
    public int sjL;
    public int sjM;
    public int sjN;
    public int sjO;
    public int sjP;
    public int sjQ;
    public int sjR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwb == null) {
                throw new f.a.a.b("Not all required fields were included: data");
            }
            aVar.fT(1, this.sjL);
            aVar.fT(2, this.sjM);
            aVar.fT(3, this.sjN);
            aVar.fT(4, this.sjO);
            aVar.fT(5, this.sjP);
            aVar.fT(6, this.sjQ);
            aVar.fT(7, this.sjR);
            if (this.rwb != null) {
                aVar.b(8, this.rwb);
            }
            return 0;
        } else if (i == 1) {
            int fQ = ((((((f.a.a.a.fQ(1, this.sjL) + 0) + f.a.a.a.fQ(2, this.sjM)) + f.a.a.a.fQ(3, this.sjN)) + f.a.a.a.fQ(4, this.sjO)) + f.a.a.a.fQ(5, this.sjP)) + f.a.a.a.fQ(6, this.sjQ)) + f.a.a.a.fQ(7, this.sjR);
            if (this.rwb != null) {
                return fQ + f.a.a.a.a(8, this.rwb);
            }
            return fQ;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (bArr != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bkd bkd = (bkd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkd.sjL = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bkd.sjM = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bkd.sjN = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bkd.sjO = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bkd.sjP = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bkd.sjQ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bkd.sjR = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bkd.rwb = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
