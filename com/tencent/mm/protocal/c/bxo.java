package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bxo extends bhd {
    public String rFO;
    public long rFP;
    public bhy rhB;
    public String sha;
    public String shb;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rFO != null) {
                aVar.g(2, this.rFO);
            }
            aVar.T(3, this.rFP);
            if (this.rhB != null) {
                aVar.fV(4, this.rhB.boi());
                this.rhB.a(aVar);
            }
            if (this.sha != null) {
                aVar.g(5, this.sha);
            }
            if (this.shb == null) {
                return 0;
            }
            aVar.g(6, this.shb);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rFO != null) {
                fS += f.a.a.b.b.a.h(2, this.rFO);
            }
            fS += f.a.a.a.S(3, this.rFP);
            if (this.rhB != null) {
                fS += f.a.a.a.fS(4, this.rhB.boi());
            }
            if (this.sha != null) {
                fS += f.a.a.b.b.a.h(5, this.sha);
            }
            if (this.shb != null) {
                fS += f.a.a.b.b.a.h(6, this.shb);
            }
            return fS;
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
            bxo bxo = (bxo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bxo.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bxo.rFO = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bxo.rFP = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bxo.rhB = bhy;
                    }
                    return 0;
                case 5:
                    bxo.sha = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bxo.shb = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
