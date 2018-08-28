package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class tx extends bhp {
    public LinkedList<bsm> rbQ = new LinkedList();
    public int rfh;
    public LinkedList<bsl> rfi = new LinkedList();
    public int rxG;
    public long rxH;
    public int rxI;
    public int rxJ;
    public int rxK;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.rxI);
            aVar.fT(5, this.rxJ);
            aVar.d(6, 8, this.rbQ);
            aVar.fT(7, this.rxK);
            aVar.fT(8, this.rfh);
            aVar.d(9, 8, this.rfi);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.rxI)) + f.a.a.a.fQ(5, this.rxJ)) + f.a.a.a.c(6, 8, this.rbQ)) + f.a.a.a.fQ(7, this.rxK)) + f.a.a.a.fQ(8, this.rfh)) + f.a.a.a.c(9, 8, this.rfi);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rbQ.clear();
            this.rfi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            tx txVar = (tx) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        txVar.six = flVar;
                    }
                    return 0;
                case 2:
                    txVar.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    txVar.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    txVar.rxI = aVar3.vHC.rY();
                    return 0;
                case 5:
                    txVar.rxJ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsm bsm = new bsm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsm.a(aVar4, bsm, bhp.a(aVar4))) {
                        }
                        txVar.rbQ.add(bsm);
                    }
                    return 0;
                case 7:
                    txVar.rxK = aVar3.vHC.rY();
                    return 0;
                case 8:
                    txVar.rfh = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsl bsl = new bsl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsl.a(aVar4, bsl, bhp.a(aVar4))) {
                        }
                        txVar.rfi.add(bsl);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
