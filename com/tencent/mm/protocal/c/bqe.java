package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bqe extends bhd {
    public String rdS;
    public int rdq;
    public String smu;
    public long smv;
    public long snR;
    public int snS;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.smu != null) {
                aVar.g(2, this.smu);
            }
            if (this.rdS != null) {
                aVar.g(3, this.rdS);
            }
            aVar.T(4, this.smv);
            aVar.fT(5, this.rdq);
            aVar.T(6, this.snR);
            aVar.fT(7, this.snS);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.smu != null) {
                fS += f.a.a.b.b.a.h(2, this.smu);
            }
            if (this.rdS != null) {
                fS += f.a.a.b.b.a.h(3, this.rdS);
            }
            return (((fS + f.a.a.a.S(4, this.smv)) + f.a.a.a.fQ(5, this.rdq)) + f.a.a.a.S(6, this.snR)) + f.a.a.a.fQ(7, this.snS);
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
            bqe bqe = (bqe) objArr[1];
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
                        bqe.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bqe.smu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bqe.rdS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bqe.smv = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bqe.rdq = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bqe.snR = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    bqe.snS = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
