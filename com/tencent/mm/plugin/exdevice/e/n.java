package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public c ixh;
    public int ixl;
    public int ixm;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ixh == null) {
                throw new b("Not all required fields were included: BasePush");
            }
            if (this.ixh != null) {
                aVar.fV(1, this.ixh.boi());
                this.ixh.a(aVar);
            }
            aVar.fT(2, this.ixl);
            aVar.fT(3, this.ixm);
            return 0;
        } else if (i == 1) {
            if (this.ixh != null) {
                fS = f.a.a.a.fS(1, this.ixh.boi()) + 0;
            } else {
                fS = 0;
            }
            return (fS + f.a.a.a.fQ(2, this.ixl)) + f.a.a.a.fQ(3, this.ixm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ixh != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BasePush");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        c cVar = new c();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        nVar.ixh = cVar;
                    }
                    return 0;
                case 2:
                    nVar.ixl = aVar3.vHC.rY();
                    return 0;
                case 3:
                    nVar.ixm = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
