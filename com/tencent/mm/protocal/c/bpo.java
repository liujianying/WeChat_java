package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bpo extends a {
    public float biF;
    public int nOD;
    public float snF;
    public float snG;
    public float snH;
    public float snI;
    public int snJ;
    public long snK;
    public long snL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.l(1, this.snF);
            aVar.l(2, this.snG);
            aVar.l(3, this.snH);
            aVar.l(4, this.snI);
            aVar.fT(5, this.snJ);
            aVar.T(6, this.snK);
            aVar.T(7, this.snL);
            aVar.l(8, this.biF);
            aVar.fT(9, this.nOD);
            return 0;
        } else if (i == 1) {
            return (((((((((f.a.a.b.b.a.ec(1) + 4) + 0) + (f.a.a.b.b.a.ec(2) + 4)) + (f.a.a.b.b.a.ec(3) + 4)) + (f.a.a.b.b.a.ec(4) + 4)) + f.a.a.a.fQ(5, this.snJ)) + f.a.a.a.S(6, this.snK)) + f.a.a.a.S(7, this.snL)) + (f.a.a.b.b.a.ec(8) + 4)) + f.a.a.a.fQ(9, this.nOD);
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
                bpo bpo = (bpo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bpo.snF = aVar3.vHC.readFloat();
                        return 0;
                    case 2:
                        bpo.snG = aVar3.vHC.readFloat();
                        return 0;
                    case 3:
                        bpo.snH = aVar3.vHC.readFloat();
                        return 0;
                    case 4:
                        bpo.snI = aVar3.vHC.readFloat();
                        return 0;
                    case 5:
                        bpo.snJ = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        bpo.snK = aVar3.vHC.rZ();
                        return 0;
                    case 7:
                        bpo.snL = aVar3.vHC.rZ();
                        return 0;
                    case 8:
                        bpo.biF = aVar3.vHC.readFloat();
                        return 0;
                    case 9:
                        bpo.nOD = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
