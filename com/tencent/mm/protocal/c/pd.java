package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class pd extends a {
    public String bPS;
    public int mQH;
    public String path;
    public long rty;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rty);
            aVar.fT(2, this.mQH);
            if (this.bPS != null) {
                aVar.g(3, this.bPS);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rty) + 0) + f.a.a.a.fQ(2, this.mQH);
            if (this.bPS != null) {
                S += f.a.a.b.b.a.h(3, this.bPS);
            }
            if (this.path != null) {
                return S + f.a.a.b.b.a.h(4, this.path);
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
            pd pdVar = (pd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pdVar.rty = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    pdVar.mQH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    pdVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    pdVar.path = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
