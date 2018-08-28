package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<h> pek = new LinkedList();
    public b pel;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.pek);
            if (this.pel != null) {
                aVar.b(2, this.pel);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.pek) + 0;
            if (this.pel != null) {
                return c + f.a.a.a.a(2, this.pel);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pek.clear();
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a hVar = new h();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        gVar.pek.add(hVar);
                    }
                    return 0;
                case 2:
                    gVar.pel = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
