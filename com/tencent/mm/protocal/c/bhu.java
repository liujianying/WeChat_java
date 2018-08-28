package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bhu extends bhd {
    public String jTu;
    public String jTv;
    public int lOH;
    public String rdo;
    public int siB;
    public int siC;
    public int siD;
    public long siE;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rdo != null) {
                aVar.g(2, this.rdo);
            }
            aVar.fT(3, this.siB);
            aVar.fT(4, this.lOH);
            aVar.fT(5, this.siC);
            if (this.jTv != null) {
                aVar.g(6, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(7, this.jTu);
            }
            aVar.fT(8, this.siD);
            aVar.T(9, this.siE);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rdo != null) {
                fS += f.a.a.b.b.a.h(2, this.rdo);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.siB)) + f.a.a.a.fQ(4, this.lOH)) + f.a.a.a.fQ(5, this.siC);
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(6, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(7, this.jTu);
            }
            return (fS + f.a.a.a.fQ(8, this.siD)) + f.a.a.a.S(9, this.siE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhu bhu = (bhu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bhu.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bhu.rdo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bhu.siB = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bhu.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bhu.siC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bhu.jTv = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bhu.jTu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bhu.siD = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bhu.siE = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
