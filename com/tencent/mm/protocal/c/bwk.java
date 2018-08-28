package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bwk extends a {
    public int qZc;
    public LinkedList<String> ssL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qZc);
            aVar.d(2, 1, this.ssL);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.qZc) + 0) + f.a.a.a.c(2, 1, this.ssL);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.ssL.clear();
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
                bwk bwk = (bwk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bwk.qZc = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bwk.ssL.add(aVar3.vHC.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
