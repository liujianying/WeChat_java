package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cdv extends a {
    public LinkedList<String> rfd = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).d(1, 1, this.rfd);
            return 0;
        } else if (i == 1) {
            return f.a.a.a.c(1, 1, this.rfd) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rfd.clear();
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
                cdv cdv = (cdv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cdv.rfd.add(aVar2.vHC.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
