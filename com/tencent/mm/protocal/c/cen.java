package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cen extends a {
    public String bHD;
    public String jSA;
    public int jTt;
    public b szc;
    public String szk;
    public int szw;
    public boolean szx;
    public boolean szy;
    public boolean szz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            } else if (this.bHD == null) {
                throw new f.a.a.b("Not all required fields were included: Title");
            } else if (this.jSA == null) {
                throw new f.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fT(1, this.jTt);
                if (this.szk != null) {
                    aVar.g(2, this.szk);
                }
                if (this.bHD != null) {
                    aVar.g(3, this.bHD);
                }
                if (this.jSA != null) {
                    aVar.g(4, this.jSA);
                }
                aVar.fT(5, this.szw);
                if (this.szc != null) {
                    aVar.b(6, this.szc);
                }
                aVar.av(7, this.szx);
                aVar.av(8, this.szy);
                aVar.av(9, this.szz);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jTt) + 0;
            if (this.szk != null) {
                fQ += f.a.a.b.b.a.h(2, this.szk);
            }
            if (this.bHD != null) {
                fQ += f.a.a.b.b.a.h(3, this.bHD);
            }
            if (this.jSA != null) {
                fQ += f.a.a.b.b.a.h(4, this.jSA);
            }
            fQ += f.a.a.a.fQ(5, this.szw);
            if (this.szc != null) {
                fQ += f.a.a.a.a(6, this.szc);
            }
            return ((fQ + (f.a.a.b.b.a.ec(7) + 1)) + (f.a.a.b.b.a.ec(8) + 1)) + (f.a.a.b.b.a.ec(9) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            } else if (this.bHD == null) {
                throw new f.a.a.b("Not all required fields were included: Title");
            } else if (this.jSA != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cen cen = (cen) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cen.jTt = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cen.szk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cen.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cen.jSA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cen.szw = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cen.szc = aVar3.cJR();
                    return 0;
                case 7:
                    cen.szx = aVar3.cJQ();
                    return 0;
                case 8:
                    cen.szy = aVar3.cJQ();
                    return 0;
                case 9:
                    cen.szz = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
