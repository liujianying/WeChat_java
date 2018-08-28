package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class dz extends a {
    public String qZs;
    public String rem;
    public tq ren;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rem == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.ren == null) {
                throw new b("Not all required fields were included: Price");
            } else {
                if (this.rem != null) {
                    aVar.g(1, this.rem);
                }
                if (this.ren != null) {
                    aVar.fV(2, this.ren.boi());
                    this.ren.a(aVar);
                }
                if (this.qZs == null) {
                    return 0;
                }
                aVar.g(3, this.qZs);
                return 0;
            }
        } else if (i == 1) {
            if (this.rem != null) {
                h = f.a.a.b.b.a.h(1, this.rem) + 0;
            } else {
                h = 0;
            }
            if (this.ren != null) {
                h += f.a.a.a.fS(2, this.ren.boi());
            }
            if (this.qZs != null) {
                h += f.a.a.b.b.a.h(3, this.qZs);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rem == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.ren != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Price");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dz dzVar = (dz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzVar.rem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        tq tqVar = new tq();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tqVar.a(aVar4, tqVar, a.a(aVar4))) {
                        }
                        dzVar.ren = tqVar;
                    }
                    return 0;
                case 3:
                    dzVar.qZs = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
