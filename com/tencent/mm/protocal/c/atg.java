package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class atg extends a {
    public float rWu;
    public float rWv;
    public float rWw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.l(1, this.rWu);
            aVar.l(2, this.rWv);
            aVar.l(3, this.rWw);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.b.b.a.ec(1) + 4) + 0) + (f.a.a.b.b.a.ec(2) + 4)) + (f.a.a.b.b.a.ec(3) + 4);
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
                atg atg = (atg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        atg.rWu = aVar3.vHC.readFloat();
                        return 0;
                    case 2:
                        atg.rWv = aVar3.vHC.readFloat();
                        return 0;
                    case 3:
                        atg.rWw = aVar3.vHC.readFloat();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
