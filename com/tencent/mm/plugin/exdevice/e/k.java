package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class k extends i {
    public b hbs;
    public int hcE;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.hbs == null) {
                throw new f.a.a.b("Not all required fields were included: Data");
            }
            if (this.ixi != null) {
                aVar.fV(1, this.ixi.boi());
                this.ixi.a(aVar);
            }
            if (this.hbs != null) {
                aVar.b(2, this.hbs);
            }
            aVar.fT(3, this.hcE);
            return 0;
        } else if (i == 1) {
            if (this.ixi != null) {
                fS = f.a.a.a.fS(1, this.ixi.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hbs != null) {
                fS += f.a.a.a.a(2, this.hbs);
            }
            return fS + f.a.a.a.fQ(3, this.hcE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = i.a(aVar2); fS > 0; fS = i.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.hbs != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        d dVar = new d();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, i.a(aVar4))) {
                        }
                        kVar.ixi = dVar;
                    }
                    return 0;
                case 2:
                    kVar.hbs = aVar3.cJR();
                    return 0;
                case 3:
                    kVar.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
