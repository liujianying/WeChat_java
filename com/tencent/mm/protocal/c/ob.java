package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class ob extends a {
    public b rsl;
    public LinkedList<b> rsm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rsl != null) {
                aVar.b(1, this.rsl);
            }
            aVar.d(2, 6, this.rsm);
            return 0;
        } else if (i == 1) {
            if (this.rsl != null) {
                a = f.a.a.a.a(1, this.rsl) + 0;
            } else {
                a = 0;
            }
            return a + f.a.a.a.c(2, 6, this.rsm);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rsm.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ob obVar = (ob) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    obVar.rsl = aVar3.cJR();
                    return 0;
                case 2:
                    obVar.rsm.add(aVar3.cJR());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
