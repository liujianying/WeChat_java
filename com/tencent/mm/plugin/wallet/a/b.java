package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public String lMW;
    public LinkedList<c> pdP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lMW != null) {
                aVar.g(1, this.lMW);
            }
            aVar.d(2, 8, this.pdP);
            return 0;
        } else if (i == 1) {
            if (this.lMW != null) {
                h = f.a.a.b.b.a.h(1, this.lMW) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(2, 8, this.pdP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdP.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.lMW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        c cVar = new c();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bVar.pdP.add(cVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
