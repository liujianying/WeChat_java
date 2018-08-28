package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class j extends a {
    public int bWA;
    public String gmb;
    public g lRQ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.bWA);
            if (this.lRQ != null) {
                aVar.fV(2, this.lRQ.boi());
                this.lRQ.a(aVar);
            }
            if (this.gmb != null) {
                aVar.g(3, this.gmb);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.bWA) + 0;
            if (this.lRQ != null) {
                fQ += f.a.a.a.fS(2, this.lRQ.boi());
            }
            if (this.gmb != null) {
                return fQ + f.a.a.b.b.a.h(3, this.gmb);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.bWA = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        g gVar = new g();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        jVar.lRQ = gVar;
                    }
                    return 0;
                case 3:
                    jVar.gmb = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
