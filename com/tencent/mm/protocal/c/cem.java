package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cem extends a {
    public LinkedList<Integer> szu = new LinkedList();
    public boolean szv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 2, this.szu);
            aVar.av(2, this.szv);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 2, this.szu) + 0) + (f.a.a.b.b.a.ec(2) + 1);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.szu.clear();
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
                cem cem = (cem) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cem.szu.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 2:
                        cem.szv = aVar3.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
