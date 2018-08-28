package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class wb extends a {
    public LinkedList<auj> iXe = new LinkedList();
    public LinkedList<aum> rBr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.iXe);
            aVar.d(2, 8, this.rBr);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 8, this.iXe) + 0) + f.a.a.a.c(2, 8, this.rBr);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.iXe.clear();
                this.rBr.clear();
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
                wb wbVar = (wb) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                f.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            auj auj = new auj();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = auj.a(aVar4, auj, a.a(aVar4))) {
                            }
                            wbVar.iXe.add(auj);
                        }
                        return 0;
                    case 2:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            aum aum = new aum();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = aum.a(aVar4, aum, a.a(aVar4))) {
                            }
                            wbVar.rBr.add(aum);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
