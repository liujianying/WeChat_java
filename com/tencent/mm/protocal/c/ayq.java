package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ayq extends a {
    public int rfn;
    public ayr sbu;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sbu == null) {
                throw new b("Not all required fields were included: OplogRet");
            }
            aVar.fT(1, this.rfn);
            if (this.sbu != null) {
                aVar.fV(2, this.sbu.boi());
                this.sbu.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.sbu != null) {
                return fQ + f.a.a.a.fS(2, this.sbu.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.sbu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OplogRet");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ayq ayq = (ayq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayq.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ayr ayr = new ayr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ayr.a(aVar4, ayr, a.a(aVar4))) {
                        }
                        ayq.sbu = ayr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
