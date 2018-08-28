package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cgv extends a {
    public boolean sAJ;
    public String sAZ;
    public bnh sBa;
    public String slo;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sAZ != null) {
                aVar.g(1, this.sAZ);
            }
            if (this.slo != null) {
                aVar.g(2, this.slo);
            }
            if (this.sBa != null) {
                aVar.fV(3, this.sBa.boi());
                this.sBa.a(aVar);
            }
            aVar.av(4, this.sAJ);
            return 0;
        } else if (i == 1) {
            if (this.sAZ != null) {
                h = f.a.a.b.b.a.h(1, this.sAZ) + 0;
            } else {
                h = 0;
            }
            if (this.slo != null) {
                h += f.a.a.b.b.a.h(2, this.slo);
            }
            if (this.sBa != null) {
                h += f.a.a.a.fS(3, this.sBa.boi());
            }
            return h + (f.a.a.b.b.a.ec(4) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cgv cgv = (cgv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgv.sAZ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cgv.slo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bnh bnh = new bnh();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnh.a(aVar4, bnh, a.a(aVar4))) {
                        }
                        cgv.sBa = bnh;
                    }
                    return 0;
                case 4:
                    cgv.sAJ = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
