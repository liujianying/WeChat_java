package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class cej extends a {
    public int jQd;
    public String jSA;
    public String rTW;
    public String szk;
    public long szl;
    public long szq;
    public boolean szr;
    public b szs;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rTW == null) {
                throw new f.a.a.b("Not all required fields were included: Nickname");
            } else if (this.jSA == null) {
                throw new f.a.a.b("Not all required fields were included: Content");
            } else if (this.szk == null) {
                throw new f.a.a.b("Not all required fields were included: Talker");
            } else {
                aVar.T(1, this.szl);
                if (this.rTW != null) {
                    aVar.g(2, this.rTW);
                }
                if (this.jSA != null) {
                    aVar.g(3, this.jSA);
                }
                aVar.fT(4, this.jQd);
                if (this.szk != null) {
                    aVar.g(5, this.szk);
                }
                aVar.T(6, this.szq);
                aVar.av(7, this.szr);
                if (this.szs != null) {
                    aVar.b(8, this.szs);
                }
                return 0;
            }
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.szl) + 0;
            if (this.rTW != null) {
                S += f.a.a.b.b.a.h(2, this.rTW);
            }
            if (this.jSA != null) {
                S += f.a.a.b.b.a.h(3, this.jSA);
            }
            S += f.a.a.a.fQ(4, this.jQd);
            if (this.szk != null) {
                S += f.a.a.b.b.a.h(5, this.szk);
            }
            S = (S + f.a.a.a.S(6, this.szq)) + (f.a.a.b.b.a.ec(7) + 1);
            if (this.szs != null) {
                return S + f.a.a.a.a(8, this.szs);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rTW == null) {
                throw new f.a.a.b("Not all required fields were included: Nickname");
            } else if (this.jSA == null) {
                throw new f.a.a.b("Not all required fields were included: Content");
            } else if (this.szk != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: Talker");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cej cej = (cej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cej.szl = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    cej.rTW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cej.jSA = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cej.jQd = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cej.szk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cej.szq = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    cej.szr = aVar3.cJQ();
                    return 0;
                case 8:
                    cej.szs = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
