package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cgm extends bhd {
    public String bPS;
    public LinkedList<String> sAI = new LinkedList();
    public boolean sAJ;
    public String sAK;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.bPS != null) {
                aVar.g(2, this.bPS);
            }
            aVar.d(3, 1, this.sAI);
            aVar.av(4, this.sAJ);
            if (this.sAK == null) {
                return 0;
            }
            aVar.g(5, this.sAK);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(2, this.bPS);
            }
            fS = (fS + f.a.a.a.c(3, 1, this.sAI)) + (f.a.a.b.b.a.ec(4) + 1);
            if (this.sAK != null) {
                fS += f.a.a.b.b.a.h(5, this.sAK);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sAI.clear();
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
            cgm cgm = (cgm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        cgm.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cgm.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cgm.sAI.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    cgm.sAJ = aVar3.cJQ();
                    return 0;
                case 5:
                    cgm.sAK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
