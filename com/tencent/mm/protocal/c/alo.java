package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class alo extends a {
    public String kLc;
    public String nickname;
    public long rNZ;
    public long rOa;
    public int rOb;
    public String rOc;
    public String username;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rNZ);
            aVar.T(2, this.rOa);
            if (this.nickname != null) {
                aVar.g(3, this.nickname);
            }
            if (this.kLc != null) {
                aVar.g(4, this.kLc);
            }
            aVar.fT(5, this.rOb);
            if (this.username != null) {
                aVar.g(6, this.username);
            }
            if (this.rOc != null) {
                aVar.g(7, this.rOc);
            }
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rNZ) + 0) + f.a.a.a.S(2, this.rOa);
            if (this.nickname != null) {
                S += f.a.a.b.b.a.h(3, this.nickname);
            }
            if (this.kLc != null) {
                S += f.a.a.b.b.a.h(4, this.kLc);
            }
            S += f.a.a.a.fQ(5, this.rOb);
            if (this.username != null) {
                S += f.a.a.b.b.a.h(6, this.username);
            }
            if (this.rOc != null) {
                return S + f.a.a.b.b.a.h(7, this.rOc);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            alo alo = (alo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alo.rNZ = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    alo.rOa = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    alo.nickname = aVar3.vHC.readString();
                    return 0;
                case 4:
                    alo.kLc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    alo.rOb = aVar3.vHC.rY();
                    return 0;
                case 6:
                    alo.username = aVar3.vHC.readString();
                    return 0;
                case 7:
                    alo.rOc = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
