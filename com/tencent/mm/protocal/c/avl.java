package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class avl extends a {
    public LinkedList<avk> hbG = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).d(1, 8, this.hbG);
            return 0;
        } else if (i == 1) {
            return f.a.a.a.c(1, 8, this.hbG) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hbG.clear();
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
                avl avl = (avl) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList IC = aVar2.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            avk avk = new avk();
                            f.a.a.a.a aVar3 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = avk.a(aVar3, avk, a.a(aVar3))) {
                            }
                            avl.hbG.add(avk);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
