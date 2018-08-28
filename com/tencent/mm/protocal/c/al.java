package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class al extends bhd {
    public int cae;
    public String qZN;
    public String qZO;
    public int qZP;
    public LinkedList<ky> qZS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.d(2, 8, this.qZS);
            aVar.fT(3, this.cae);
            if (this.qZN != null) {
                aVar.g(4, this.qZN);
            }
            if (this.qZO != null) {
                aVar.g(5, this.qZO);
            }
            aVar.fT(6, this.qZP);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.c(2, 8, this.qZS)) + f.a.a.a.fQ(3, this.cae);
            if (this.qZN != null) {
                fS += f.a.a.b.b.a.h(4, this.qZN);
            }
            if (this.qZO != null) {
                fS += f.a.a.b.b.a.h(5, this.qZO);
            }
            return fS + f.a.a.a.fQ(6, this.qZP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qZS.clear();
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
            al alVar = (al) objArr[1];
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
                        alVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ky kyVar = new ky();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kyVar.a(aVar4, kyVar, bhd.a(aVar4))) {
                        }
                        alVar.qZS.add(kyVar);
                    }
                    return 0;
                case 3:
                    alVar.cae = aVar3.vHC.rY();
                    return 0;
                case 4:
                    alVar.qZN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    alVar.qZO = aVar3.vHC.readString();
                    return 0;
                case 6:
                    alVar.qZP = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
