package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class alv extends a {
    public int rOl;
    public b rOm;
    public b rOn;
    public b rOo;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rOm == null) {
                throw new f.a.a.b("Not all required fields were included: SPSBuf");
            } else if (this.rOn == null) {
                throw new f.a.a.b("Not all required fields were included: PPSBuf");
            } else {
                aVar.fT(1, this.rOl);
                if (this.rOm != null) {
                    aVar.b(2, this.rOm);
                }
                if (this.rOn != null) {
                    aVar.b(3, this.rOn);
                }
                if (this.rOo != null) {
                    aVar.b(4, this.rOo);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rOl) + 0;
            if (this.rOm != null) {
                fQ += f.a.a.a.a(2, this.rOm);
            }
            if (this.rOn != null) {
                fQ += f.a.a.a.a(3, this.rOn);
            }
            if (this.rOo != null) {
                return fQ + f.a.a.a.a(4, this.rOo);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rOm == null) {
                throw new f.a.a.b("Not all required fields were included: SPSBuf");
            } else if (this.rOn != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: PPSBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            alv alv = (alv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alv.rOl = aVar3.vHC.rY();
                    return 0;
                case 2:
                    alv.rOm = aVar3.cJR();
                    return 0;
                case 3:
                    alv.rOn = aVar3.cJR();
                    return 0;
                case 4:
                    alv.rOo = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
