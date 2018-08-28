package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class m extends a {
    public int qXM;
    public int qXN;
    public LinkedList<n> qXO = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qXM);
            aVar.fT(2, this.qXN);
            aVar.d(3, 8, this.qXO);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.fQ(1, this.qXM) + 0) + f.a.a.a.fQ(2, this.qXN)) + f.a.a.a.c(3, 8, this.qXO);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.qXO.clear();
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
                m mVar = (m) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        mVar.qXM = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        mVar.qXN = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            n nVar = new n();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                            }
                            mVar.qXO.add(nVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
