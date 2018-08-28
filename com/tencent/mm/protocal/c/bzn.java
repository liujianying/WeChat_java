package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bzn extends bhd {
    public long rxH;
    public LinkedList<bzm> svI = new LinkedList();
    public long svs;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.T(2, this.svs);
            aVar.T(3, this.rxH);
            aVar.d(4, 8, this.svI);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((fS + f.a.a.a.S(2, this.svs)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.c(4, 8, this.svI);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.svI.clear();
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
            bzn bzn = (bzn) objArr[1];
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
                        bzn.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bzn.svs = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzn.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzm bzm = new bzm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzm.a(aVar4, bzm, bhd.a(aVar4))) {
                        }
                        bzn.svI.add(bzm);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
