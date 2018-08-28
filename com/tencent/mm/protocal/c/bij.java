package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bij extends a {
    public String rTO;
    public LinkedList<cr> siZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.siZ);
            if (this.rTO != null) {
                aVar.g(2, this.rTO);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.siZ) + 0;
            if (this.rTO != null) {
                return c + f.a.a.b.b.a.h(2, this.rTO);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.siZ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bij bij = (bij) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cr crVar = new cr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        bij.siZ.add(crVar);
                    }
                    return 0;
                case 2:
                    bij.rTO = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
