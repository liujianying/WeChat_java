package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cdw extends a {
    public String bHD;
    public String jSA;
    public int jTt;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jSA == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.fT(1, this.jTt);
                if (this.bHD != null) {
                    aVar.g(2, this.bHD);
                }
                if (this.jSA != null) {
                    aVar.g(3, this.jSA);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jTt) + 0;
            if (this.bHD != null) {
                fQ += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.jSA != null) {
                return fQ + f.a.a.b.b.a.h(3, this.jSA);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jSA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cdw cdw = (cdw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdw.jTt = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cdw.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cdw.jSA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
