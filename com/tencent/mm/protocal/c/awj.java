package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class awj extends bhd {
    public String rZG;
    public int rZH;
    public LinkedList<String> rZI = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rZG != null) {
                aVar.g(2, this.rZG);
            }
            aVar.fT(3, this.rZH);
            aVar.d(4, 1, this.rZI);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rZG != null) {
                fS += f.a.a.b.b.a.h(2, this.rZG);
            }
            return (fS + f.a.a.a.fQ(3, this.rZH)) + f.a.a.a.c(4, 1, this.rZI);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rZI.clear();
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
            awj awj = (awj) objArr[1];
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
                        awj.shX = fkVar;
                    }
                    return 0;
                case 2:
                    awj.rZG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    awj.rZH = aVar3.vHC.rY();
                    return 0;
                case 4:
                    awj.rZI.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
