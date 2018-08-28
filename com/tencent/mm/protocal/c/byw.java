package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class byw extends bhp {
    public int rxG;
    public long rxH;
    public int suJ;
    public int suP;
    public caf suQ;
    public int suR;
    public int suS;
    public int suT;
    public int suU;
    public bhy suV;

    protected final int a(int i, Object... objArr) {
        int fS;
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
            aVar.fT(4, this.suP);
            if (this.suQ != null) {
                aVar.fV(5, this.suQ.boi());
                this.suQ.a(aVar);
            }
            aVar.fT(6, this.suJ);
            aVar.fT(7, this.suR);
            aVar.fT(8, this.suS);
            aVar.fT(9, this.suT);
            aVar.fT(10, this.suU);
            if (this.suV == null) {
                return 0;
            }
            aVar.fV(11, this.suV.boi());
            this.suV.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.suP);
            if (this.suQ != null) {
                fS += f.a.a.a.fS(5, this.suQ.boi());
            }
            fS = ((((fS + f.a.a.a.fQ(6, this.suJ)) + f.a.a.a.fQ(7, this.suR)) + f.a.a.a.fQ(8, this.suS)) + f.a.a.a.fQ(9, this.suT)) + f.a.a.a.fQ(10, this.suU);
            if (this.suV != null) {
                fS += f.a.a.a.fS(11, this.suV.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            byw byw = (byw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        byw.six = flVar;
                    }
                    return 0;
                case 2:
                    byw.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    byw.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    byw.suP = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caf caf = new caf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caf.a(aVar4, caf, bhp.a(aVar4))) {
                        }
                        byw.suQ = caf;
                    }
                    return 0;
                case 6:
                    byw.suJ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    byw.suR = aVar3.vHC.rY();
                    return 0;
                case 8:
                    byw.suS = aVar3.vHC.rY();
                    return 0;
                case 9:
                    byw.suT = aVar3.vHC.rY();
                    return 0;
                case 10:
                    byw.suU = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        byw.suV = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
