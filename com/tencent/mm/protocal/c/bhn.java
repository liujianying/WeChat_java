package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bhn extends a {
    public int hcE;
    public LinkedList<bhi> siv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            aVar.d(2, 8, this.siv);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.hcE) + 0) + f.a.a.a.c(2, 8, this.siv);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.siv.clear();
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
                bhn bhn = (bhn) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bhn.hcE = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bhi bhi = new bhi();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bhi.a(aVar4, bhi, a.a(aVar4))) {
                            }
                            bhn.siv.add(bhi);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
