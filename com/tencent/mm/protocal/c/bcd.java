package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bcd extends a {
    public int kpJ;
    public int rxG;
    public long rxH;
    public LinkedList<bcm> sew = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rxG);
            aVar.T(2, this.rxH);
            aVar.d(3, 8, this.sew);
            aVar.fT(4, this.kpJ);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.rxG) + 0) + f.a.a.a.S(2, this.rxH)) + f.a.a.a.c(3, 8, this.sew)) + f.a.a.a.fQ(4, this.kpJ);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.sew.clear();
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
                bcd bcd = (bcd) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bcd.rxG = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bcd.rxH = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bcm bcm = new bcm();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bcm.a(aVar4, bcm, a.a(aVar4))) {
                            }
                            bcd.sew.add(bcm);
                        }
                        return 0;
                    case 4:
                        bcd.kpJ = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
