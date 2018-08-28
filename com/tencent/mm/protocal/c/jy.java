package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class jy extends a {
    public String lPm;
    public String rlA;
    public String rlw;
    public String rlx;
    public String rly;
    public int rlz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rlw == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.lPm == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.rlx == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.rly == null) {
                throw new b("Not all required fields were included: SellerUserName");
            } else {
                if (this.rlw != null) {
                    aVar.g(1, this.rlw);
                }
                if (this.lPm != null) {
                    aVar.g(2, this.lPm);
                }
                if (this.rlx != null) {
                    aVar.g(3, this.rlx);
                }
                if (this.rly != null) {
                    aVar.g(4, this.rly);
                }
                aVar.fT(5, this.rlz);
                if (this.rlA == null) {
                    return 0;
                }
                aVar.g(6, this.rlA);
                return 0;
            }
        } else if (i == 1) {
            if (this.rlw != null) {
                h = f.a.a.b.b.a.h(1, this.rlw) + 0;
            } else {
                h = 0;
            }
            if (this.lPm != null) {
                h += f.a.a.b.b.a.h(2, this.lPm);
            }
            if (this.rlx != null) {
                h += f.a.a.b.b.a.h(3, this.rlx);
            }
            if (this.rly != null) {
                h += f.a.a.b.b.a.h(4, this.rly);
            }
            h += f.a.a.a.fQ(5, this.rlz);
            if (this.rlA != null) {
                h += f.a.a.b.b.a.h(6, this.rlA);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rlw == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.lPm == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.rlx == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.rly != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SellerUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jy jyVar = (jy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jyVar.rlw = aVar3.vHC.readString();
                    return 0;
                case 2:
                    jyVar.lPm = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jyVar.rlx = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jyVar.rly = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jyVar.rlz = aVar3.vHC.rY();
                    return 0;
                case 6:
                    jyVar.rlA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
