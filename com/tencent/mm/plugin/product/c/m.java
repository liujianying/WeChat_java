package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class m extends a {
    public String lRU;
    public String lRV;
    public LinkedList<h> lRW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lRU != null) {
                aVar.g(1, this.lRU);
            }
            if (this.lRV != null) {
                aVar.g(2, this.lRV);
            }
            aVar.d(3, 8, this.lRW);
            return 0;
        } else if (i == 1) {
            if (this.lRU != null) {
                h = f.a.a.b.b.a.h(1, this.lRU) + 0;
            } else {
                h = 0;
            }
            if (this.lRV != null) {
                h += f.a.a.b.b.a.h(2, this.lRV);
            }
            return h + f.a.a.a.c(3, 8, this.lRW);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.lRW.clear();
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
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.lRU = aVar3.vHC.readString();
                    return 0;
                case 2:
                    mVar.lRV = aVar3.vHC.readString();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        h hVar = new h();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        mVar.lRW.add(hVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
