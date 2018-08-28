package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bzj extends a {
    public long rxH;
    public int svC;
    public int svD;
    public int svE;
    public int svF;
    public b svG;
    public long svs;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.svs);
            aVar.T(2, this.rxH);
            aVar.fT(3, this.svC);
            aVar.fT(4, this.svD);
            aVar.fT(5, this.svE);
            aVar.fT(6, this.svF);
            if (this.svG != null) {
                aVar.b(7, this.svG);
            }
            return 0;
        } else if (i == 1) {
            S = (((((f.a.a.a.S(1, this.svs) + 0) + f.a.a.a.S(2, this.rxH)) + f.a.a.a.fQ(3, this.svC)) + f.a.a.a.fQ(4, this.svD)) + f.a.a.a.fQ(5, this.svE)) + f.a.a.a.fQ(6, this.svF);
            if (this.svG != null) {
                return S + f.a.a.a.a(7, this.svG);
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
            bzj bzj = (bzj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzj.svs = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    bzj.rxH = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzj.svC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bzj.svD = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzj.svE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bzj.svF = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bzj.svG = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
