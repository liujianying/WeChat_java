package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ah extends a {
    public int qZC;
    public int qZD;
    public int qZJ;
    public LinkedList<af> qZK = new LinkedList();
    public int qZL;
    public LinkedList<af> qZM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qZC);
            aVar.fT(2, this.qZJ);
            aVar.d(3, 8, this.qZK);
            aVar.fT(4, this.qZD);
            aVar.fT(5, this.qZL);
            aVar.d(6, 8, this.qZM);
            return 0;
        } else if (i == 1) {
            return (((((f.a.a.a.fQ(1, this.qZC) + 0) + f.a.a.a.fQ(2, this.qZJ)) + f.a.a.a.c(3, 8, this.qZK)) + f.a.a.a.fQ(4, this.qZD)) + f.a.a.a.fQ(5, this.qZL)) + f.a.a.a.c(6, 8, this.qZM);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.qZK.clear();
                this.qZM.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                ah ahVar = (ah) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                a afVar;
                f.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        ahVar.qZC = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        ahVar.qZJ = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            afVar = new af();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = afVar.a(aVar4, afVar, a.a(aVar4))) {
                            }
                            ahVar.qZK.add(afVar);
                        }
                        return 0;
                    case 4:
                        ahVar.qZD = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        ahVar.qZL = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            afVar = new af();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = afVar.a(aVar4, afVar, a.a(aVar4))) {
                            }
                            ahVar.qZM.add(afVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
