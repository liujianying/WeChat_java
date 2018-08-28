package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class vu extends a {
    public long rza;
    public long rzb;
    public LinkedList<bsv> rzc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.rza);
            aVar.T(2, this.rzb);
            aVar.d(3, 8, this.rzc);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.S(1, this.rza) + 0) + f.a.a.a.S(2, this.rzb)) + f.a.a.a.c(3, 8, this.rzc);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rzc.clear();
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
                vu vuVar = (vu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        vuVar.rza = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        vuVar.rzb = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bsv bsv = new bsv();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bsv.a(aVar4, bsv, a.a(aVar4))) {
                            }
                            vuVar.rzc.add(bsv);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
