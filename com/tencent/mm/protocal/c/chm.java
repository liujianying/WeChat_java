package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class chm extends a {
    public chl sBu;
    public LinkedList<Integer> sBv = new LinkedList();
    public int sBw;
    public int sBx;
    public LinkedList<Integer> sum = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sBu != null) {
                aVar.fV(1, this.sBu.boi());
                this.sBu.a(aVar);
            }
            aVar.d(2, 2, this.sBv);
            aVar.d(3, 2, this.sum);
            aVar.fT(4, this.sBw);
            aVar.fT(5, this.sBx);
            return 0;
        } else if (i == 1) {
            if (this.sBu != null) {
                fS = f.a.a.a.fS(1, this.sBu.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.c(2, 2, this.sBv)) + f.a.a.a.c(3, 2, this.sum)) + f.a.a.a.fQ(4, this.sBw)) + f.a.a.a.fQ(5, this.sBx);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sBv.clear();
            this.sum.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            chm chm = (chm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chl chl = new chl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chl.a(aVar4, chl, a.a(aVar4))) {
                        }
                        chm.sBu = chl;
                    }
                    return 0;
                case 2:
                    chm.sBv.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 3:
                    chm.sum.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 4:
                    chm.sBw = aVar3.vHC.rY();
                    return 0;
                case 5:
                    chm.sBx = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
