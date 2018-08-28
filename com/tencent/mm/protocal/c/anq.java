package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class anq extends a {
    public int key;
    public int length;
    public long rQr;
    public int rQs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.key);
            aVar.T(2, this.rQr);
            aVar.fT(3, this.length);
            aVar.fT(4, this.rQs);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.key) + 0) + f.a.a.a.S(2, this.rQr)) + f.a.a.a.fQ(3, this.length)) + f.a.a.a.fQ(4, this.rQs);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                anq anq = (anq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        anq.key = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        anq.rQr = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        anq.length = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        anq.rQs = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
