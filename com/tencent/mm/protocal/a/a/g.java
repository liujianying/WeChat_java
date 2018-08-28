package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<b> qXA = new LinkedList();
    public b qXB;
    public int qXj;
    public int qXz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qXj);
            aVar.fT(2, this.qXz);
            aVar.d(3, 8, this.qXA);
            if (this.qXB != null) {
                aVar.b(4, this.qXB);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.qXj) + 0) + f.a.a.a.fQ(2, this.qXz)) + f.a.a.a.c(3, 8, this.qXA);
            if (this.qXB != null) {
                return fQ + f.a.a.a.a(4, this.qXB);
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qXA.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.qXj = aVar3.vHC.rY();
                    return 0;
                case 2:
                    gVar.qXz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        b bVar = new b();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        gVar.qXA.add(bVar);
                    }
                    return 0;
                case 4:
                    gVar.qXB = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
