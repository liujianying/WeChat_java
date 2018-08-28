package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class eq extends a {
    public LinkedList<String> rfd = new LinkedList();
    public int rfe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.rfd);
            aVar.fT(2, this.rfe);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 1, this.rfd) + 0) + f.a.a.a.fQ(2, this.rfe);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rfd.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                eq eqVar = (eq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        eqVar.rfd.add(aVar3.vHC.readString());
                        return 0;
                    case 2:
                        eqVar.rfe = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
