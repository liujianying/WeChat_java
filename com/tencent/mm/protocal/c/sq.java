package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class sq extends bhd {
    public int rci;
    public long rcq;
    public String rdo;
    public int rjC;
    public int rvV;
    public long rvW;
    public String rvj;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.fT(1, this.rci);
            aVar.fT(2, this.rjC);
            aVar.fT(3, this.rvV);
            if (this.rdo != null) {
                aVar.g(4, this.rdo);
            }
            if (this.shX != null) {
                aVar.fV(5, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.T(6, this.rcq);
            if (this.rvj != null) {
                aVar.g(7, this.rvj);
            }
            aVar.T(8, this.rvW);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rci) + 0) + f.a.a.a.fQ(2, this.rjC)) + f.a.a.a.fQ(3, this.rvV);
            if (this.rdo != null) {
                fQ += f.a.a.b.b.a.h(4, this.rdo);
            }
            if (this.shX != null) {
                fQ += f.a.a.a.fS(5, this.shX.boi());
            }
            fQ += f.a.a.a.S(6, this.rcq);
            if (this.rvj != null) {
                fQ += f.a.a.b.b.a.h(7, this.rvj);
            }
            return fQ + f.a.a.a.S(8, this.rvW);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = bhd.a(aVar2); fQ > 0; fQ = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sq sqVar = (sq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    sqVar.rci = aVar3.vHC.rY();
                    return 0;
                case 2:
                    sqVar.rjC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    sqVar.rvV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    sqVar.rdo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        sqVar.shX = fkVar;
                    }
                    return 0;
                case 6:
                    sqVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    sqVar.rvj = aVar3.vHC.readString();
                    return 0;
                case 8:
                    sqVar.rvW = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
