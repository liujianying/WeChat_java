package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class yq extends a {
    public int bWA;
    public int rEQ;
    public LinkedList<uj> rER = new LinkedList();
    public int rES;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rEQ);
            aVar.d(2, 8, this.rER);
            aVar.fT(3, this.rES);
            aVar.fT(4, this.bWA);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.rEQ) + 0) + f.a.a.a.c(2, 8, this.rER)) + f.a.a.a.fQ(3, this.rES)) + f.a.a.a.fQ(4, this.bWA);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rER.clear();
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
                yq yqVar = (yq) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        yqVar.rEQ = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            uj ujVar = new uj();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = ujVar.a(aVar4, ujVar, a.a(aVar4))) {
                            }
                            yqVar.rER.add(ujVar);
                        }
                        return 0;
                    case 3:
                        yqVar.rES = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        yqVar.bWA = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
