package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cfy extends a {
    public String bKg;
    public int rka;
    public int sAw;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sAw);
            aVar.fT(2, this.rka);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.bKg != null) {
                aVar.g(4, this.bKg);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.sAw) + 0) + f.a.a.a.fQ(2, this.rka);
            if (this.url != null) {
                fQ += f.a.a.b.b.a.h(3, this.url);
            }
            if (this.bKg != null) {
                return fQ + f.a.a.b.b.a.h(4, this.bKg);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfy cfy = (cfy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfy.sAw = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cfy.rka = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfy.url = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cfy.bKg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
