package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class baa extends bhd {
    public int qZe;
    public int rmJ;
    public aw rmQ;
    public String scJ;
    public String scK;
    public b scL;
    public int scM;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.scJ != null) {
                aVar.g(2, this.scJ);
            }
            if (this.scK != null) {
                aVar.g(3, this.scK);
            }
            if (this.scL != null) {
                aVar.b(4, this.scL);
            }
            aVar.fT(5, this.rmJ);
            aVar.fT(6, this.qZe);
            aVar.fT(7, this.scM);
            if (this.rmQ == null) {
                return 0;
            }
            aVar.fV(8, this.rmQ.boi());
            this.rmQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.scJ != null) {
                fS += f.a.a.b.b.a.h(2, this.scJ);
            }
            if (this.scK != null) {
                fS += f.a.a.b.b.a.h(3, this.scK);
            }
            if (this.scL != null) {
                fS += f.a.a.a.a(4, this.scL);
            }
            fS = ((fS + f.a.a.a.fQ(5, this.rmJ)) + f.a.a.a.fQ(6, this.qZe)) + f.a.a.a.fQ(7, this.scM);
            if (this.rmQ != null) {
                fS += f.a.a.a.fS(8, this.rmQ.boi());
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
            baa baa = (baa) objArr[1];
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
                        baa.shX = fkVar;
                    }
                    return 0;
                case 2:
                    baa.scJ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    baa.scK = aVar3.vHC.readString();
                    return 0;
                case 4:
                    baa.scL = aVar3.cJR();
                    return 0;
                case 5:
                    baa.rmJ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    baa.qZe = aVar3.vHC.rY();
                    return 0;
                case 7:
                    baa.scM = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        baa.rmQ = awVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
