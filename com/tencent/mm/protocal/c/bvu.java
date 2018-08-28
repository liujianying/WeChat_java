package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bvu extends bhd {
    public LinkedList<tc> rwA = new LinkedList();
    public int rwB;
    public int ssl;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.ssl);
            aVar.d(3, 8, this.rwA);
            aVar.fT(4, this.rwB);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((fS + f.a.a.a.fQ(2, this.ssl)) + f.a.a.a.c(3, 8, this.rwA)) + f.a.a.a.fQ(4, this.rwB);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rwA.clear();
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
            bvu bvu = (bvu) objArr[1];
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
                        bvu.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvu.ssl = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tc tcVar = new tc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tcVar.a(aVar4, tcVar, bhd.a(aVar4))) {
                        }
                        bvu.rwA.add(tcVar);
                    }
                    return 0;
                case 4:
                    bvu.rwB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
