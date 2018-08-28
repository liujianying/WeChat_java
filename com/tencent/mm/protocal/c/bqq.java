package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bqq extends a {
    public int soK;
    public int soL;
    public int soM;
    public int soo;
    public byx sop;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sop == null) {
                throw new b("Not all required fields were included: Addr");
            }
            if (this.sop != null) {
                aVar.fV(1, this.sop.boi());
                this.sop.a(aVar);
            }
            aVar.fT(2, this.soo);
            aVar.fT(3, this.soK);
            aVar.fT(4, this.soL);
            aVar.fT(5, this.soM);
            return 0;
        } else if (i == 1) {
            if (this.sop != null) {
                fS = f.a.a.a.fS(1, this.sop.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.fQ(2, this.soo)) + f.a.a.a.fQ(3, this.soK)) + f.a.a.a.fQ(4, this.soL)) + f.a.a.a.fQ(5, this.soM);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sop != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqq bqq = (bqq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        byx byx = new byx();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = byx.a(aVar4, byx, a.a(aVar4))) {
                        }
                        bqq.sop = byx;
                    }
                    return 0;
                case 2:
                    bqq.soo = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqq.soK = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bqq.soL = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bqq.soM = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
