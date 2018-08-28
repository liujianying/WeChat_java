package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class asn extends a {
    public LinkedList<b> rUN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).d(1, 6, this.rUN);
            return 0;
        } else if (i == 1) {
            return f.a.a.a.c(1, 6, this.rUN) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rUN.clear();
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
                asn asn = (asn) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        asn.rUN.add(aVar2.cJR());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
