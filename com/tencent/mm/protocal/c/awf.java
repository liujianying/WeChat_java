package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class awf extends a {
    public long lastUpdateTime;
    public LinkedList<kw> ruL = new LinkedList();
    public int ruM;
    public int ruN;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.ruL);
            aVar.fT(2, this.version);
            aVar.fT(3, this.ruM);
            aVar.fT(4, this.ruN);
            aVar.T(5, this.lastUpdateTime);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.c(1, 8, this.ruL) + 0) + f.a.a.a.fQ(2, this.version)) + f.a.a.a.fQ(3, this.ruM)) + f.a.a.a.fQ(4, this.ruN)) + f.a.a.a.S(5, this.lastUpdateTime);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ruL.clear();
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
                awf awf = (awf) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            kw kwVar = new kw();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kwVar.a(aVar4, kwVar, a.a(aVar4))) {
                            }
                            awf.ruL.add(kwVar);
                        }
                        return 0;
                    case 2:
                        awf.version = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        awf.ruM = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        awf.ruN = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        awf.lastUpdateTime = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
