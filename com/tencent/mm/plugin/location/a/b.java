package com.tencent.mm.plugin.location.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> kCt = new LinkedList();
    public String kCu;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.kCt);
            if (this.kCu != null) {
                aVar.g(2, this.kCu);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.kCt) + 0;
            if (this.kCu != null) {
                return c + f.a.a.b.b.a.h(2, this.kCu);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kCt.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar4 = new a();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.kCt.add(aVar4);
                    }
                    return 0;
                case 2:
                    bVar.kCu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
