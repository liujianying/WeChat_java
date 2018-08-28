package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cai extends bhd {
    public int rxG;
    public long rxH;
    public int seq;
    public int swG;
    public int swH;
    public LinkedList<cal> swI = new LinkedList();
    public int swJ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.seq);
            aVar.fT(5, this.swG);
            aVar.fT(6, this.swH);
            aVar.d(7, 8, this.swI);
            aVar.fT(8, this.swJ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.seq)) + f.a.a.a.fQ(5, this.swG)) + f.a.a.a.fQ(6, this.swH)) + f.a.a.a.c(7, 8, this.swI)) + f.a.a.a.fQ(8, this.swJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.swI.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            cai cai = (cai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
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
                        cai.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cai.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cai.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    cai.seq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cai.swG = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cai.swH = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cal cal = new cal();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cal.a(aVar4, cal, bhd.a(aVar4))) {
                        }
                        cai.swI.add(cal);
                    }
                    return 0;
                case 8:
                    cai.swJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
