package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class va extends a {
    public String jPe;
    public long mFa;
    public int ryv;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.mFa);
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            aVar.fT(3, this.ryv);
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.mFa) + 0;
            if (this.jPe != null) {
                S += f.a.a.b.b.a.h(2, this.jPe);
            }
            return S + f.a.a.a.fQ(3, this.ryv);
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
            va vaVar = (va) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vaVar.mFa = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    vaVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vaVar.ryv = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
