package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cdz extends a {
    public String hbL;
    public String hcS;
    public String jSA;
    public int jTt;
    public b szc;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL == null) {
                throw new f.a.a.b("Not all required fields were included: UserName");
            } else if (this.hcS == null) {
                throw new f.a.a.b("Not all required fields were included: NickName");
            } else if (this.jSA == null) {
                throw new f.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fT(1, this.jTt);
                if (this.hbL != null) {
                    aVar.g(2, this.hbL);
                }
                if (this.hcS != null) {
                    aVar.g(3, this.hcS);
                }
                if (this.jSA != null) {
                    aVar.g(4, this.jSA);
                }
                if (this.szc != null) {
                    aVar.b(5, this.szc);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jTt) + 0;
            if (this.hbL != null) {
                fQ += f.a.a.b.b.a.h(2, this.hbL);
            }
            if (this.hcS != null) {
                fQ += f.a.a.b.b.a.h(3, this.hcS);
            }
            if (this.jSA != null) {
                fQ += f.a.a.b.b.a.h(4, this.jSA);
            }
            if (this.szc != null) {
                return fQ + f.a.a.a.a(5, this.szc);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.hbL == null) {
                throw new f.a.a.b("Not all required fields were included: UserName");
            } else if (this.hcS == null) {
                throw new f.a.a.b("Not all required fields were included: NickName");
            } else if (this.jSA != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cdz cdz = (cdz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdz.jTt = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cdz.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cdz.hcS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cdz.jSA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cdz.szc = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
