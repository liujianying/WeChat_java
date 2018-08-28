package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cec extends a {
    public String cCZ;
    public String hbQ;
    public int rdn;
    public String ruf;
    public String szd;
    public String sze;
    public String szf;
    public String szg;
    public String szh;
    public String szi;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szd == null) {
                throw new b("Not all required fields were included: LocalNodeId");
            }
            if (this.szd != null) {
                aVar.g(1, this.szd);
            }
            if (this.hbQ != null) {
                aVar.g(2, this.hbQ);
            }
            if (this.sze != null) {
                aVar.g(3, this.sze);
            }
            if (this.cCZ != null) {
                aVar.g(4, this.cCZ);
            }
            if (this.szf != null) {
                aVar.g(5, this.szf);
            }
            if (this.ruf != null) {
                aVar.g(6, this.ruf);
            }
            if (this.szg != null) {
                aVar.g(7, this.szg);
            }
            if (this.szh != null) {
                aVar.g(8, this.szh);
            }
            if (this.szi != null) {
                aVar.g(9, this.szi);
            }
            aVar.fT(10, this.rdn);
            return 0;
        } else if (i == 1) {
            if (this.szd != null) {
                h = f.a.a.b.b.a.h(1, this.szd) + 0;
            } else {
                h = 0;
            }
            if (this.hbQ != null) {
                h += f.a.a.b.b.a.h(2, this.hbQ);
            }
            if (this.sze != null) {
                h += f.a.a.b.b.a.h(3, this.sze);
            }
            if (this.cCZ != null) {
                h += f.a.a.b.b.a.h(4, this.cCZ);
            }
            if (this.szf != null) {
                h += f.a.a.b.b.a.h(5, this.szf);
            }
            if (this.ruf != null) {
                h += f.a.a.b.b.a.h(6, this.ruf);
            }
            if (this.szg != null) {
                h += f.a.a.b.b.a.h(7, this.szg);
            }
            if (this.szh != null) {
                h += f.a.a.b.b.a.h(8, this.szh);
            }
            if (this.szi != null) {
                h += f.a.a.b.b.a.h(9, this.szi);
            }
            return h + f.a.a.a.fQ(10, this.rdn);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.szd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LocalNodeId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cec cec = (cec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cec.szd = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cec.hbQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cec.sze = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cec.cCZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cec.szf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cec.ruf = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cec.szg = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cec.szh = aVar3.vHC.readString();
                    return 0;
                case 9:
                    cec.szi = aVar3.vHC.readString();
                    return 0;
                case 10:
                    cec.rdn = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
