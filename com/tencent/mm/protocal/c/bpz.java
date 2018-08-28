package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bpz extends bhd {
    public bhy slZ;
    public String smu;
    public long smv;
    public long snR;
    public int snS;
    public long snT;
    public int snU;

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
            aVar.T(3, this.smv);
            aVar.T(4, this.snR);
            aVar.fT(5, this.snS);
            aVar.T(6, this.snT);
            if (this.slZ != null) {
                aVar.fV(7, this.slZ.boi());
                this.slZ.a(aVar);
            }
            aVar.fT(8, this.snU);
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
            fS = (((fS + f.a.a.a.S(3, this.smv)) + f.a.a.a.S(4, this.snR)) + f.a.a.a.fQ(5, this.snS)) + f.a.a.a.S(6, this.snT);
            if (this.slZ != null) {
                fS += f.a.a.a.fS(7, this.slZ.boi());
            }
            return fS + f.a.a.a.fQ(8, this.snU);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bpz bpz = (bpz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            com.tencent.mm.bk.a fkVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bpz.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bpz.smu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bpz.smv = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bpz.snR = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bpz.snS = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bpz.snT = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bpz.slZ = fkVar;
                    }
                    return 0;
                case 8:
                    bpz.snU = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
