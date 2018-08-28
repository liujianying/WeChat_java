package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<k> hbM = new LinkedList();
    public int hbN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hbM);
            aVar.fT(2, this.hbN);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 8, this.hbM) + 0) + f.a.a.a.fQ(2, this.hbN);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hbM.clear();
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
                l lVar = (l) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            k kVar = new k();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                            }
                            lVar.hbM.add(kVar);
                        }
                        return 0;
                    case 2:
                        lVar.hbN = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
