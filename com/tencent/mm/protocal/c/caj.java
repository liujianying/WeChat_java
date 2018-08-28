package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class caj extends bhp {
    public int rxG;
    public long rxH;
    public int seq;
    public LinkedList<byx> svB = new LinkedList();
    public int swK;
    public LinkedList<byx> swL = new LinkedList();
    public int swM;
    public LinkedList<byx> swN = new LinkedList();
    public int swO;
    public int swP;
    public int swQ;

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
            aVar.fT(3, this.swK);
            aVar.d(4, 8, this.swL);
            aVar.fT(5, this.swM);
            aVar.d(6, 8, this.swN);
            aVar.T(7, this.rxH);
            aVar.fT(8, this.seq);
            aVar.fT(9, this.swO);
            aVar.d(10, 8, this.svB);
            aVar.fT(11, this.swP);
            aVar.fT(12, this.swQ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.fQ(3, this.swK)) + f.a.a.a.c(4, 8, this.swL)) + f.a.a.a.fQ(5, this.swM)) + f.a.a.a.c(6, 8, this.swN)) + f.a.a.a.S(7, this.rxH)) + f.a.a.a.fQ(8, this.seq)) + f.a.a.a.fQ(9, this.swO)) + f.a.a.a.c(10, 8, this.svB)) + f.a.a.a.fQ(11, this.swP)) + f.a.a.a.fQ(12, this.swQ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.swL.clear();
            this.swN.clear();
            this.svB.clear();
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
            caj caj = (caj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            byx byx;
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
                        caj.six = flVar;
                    }
                    return 0;
                case 2:
                    caj.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    caj.swK = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx = new byx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.a(aVar4, byx, bhp.a(aVar4))) {
                        }
                        caj.swL.add(byx);
                    }
                    return 0;
                case 5:
                    caj.swM = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx = new byx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.a(aVar4, byx, bhp.a(aVar4))) {
                        }
                        caj.swN.add(byx);
                    }
                    return 0;
                case 7:
                    caj.rxH = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    caj.seq = aVar3.vHC.rY();
                    return 0;
                case 9:
                    caj.swO = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx = new byx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.a(aVar4, byx, bhp.a(aVar4))) {
                        }
                        caj.svB.add(byx);
                    }
                    return 0;
                case 11:
                    caj.swP = aVar3.vHC.rY();
                    return 0;
                case 12:
                    caj.swQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
