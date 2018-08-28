package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class c extends a {
    public LinkedList<Long> nuR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).d(1, 3, this.nuR);
            return 0;
        } else if (i == 1) {
            return f.a.a.a.c(1, 3, this.nuR) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.nuR.clear();
                f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar2 = (f.a.a.a.a) objArr[0];
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.nuR.add(Long.valueOf(aVar2.vHC.rZ()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
