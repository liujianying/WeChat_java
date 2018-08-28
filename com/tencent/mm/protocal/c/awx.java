package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class awx extends bhp {
    public int balance;
    public int hwV;
    public String hwW;
    public arq rZU;
    public int rZV;
    public int rZW;
    public int rZX;
    public LinkedList<sj> rZY = new LinkedList();

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
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            aVar.fT(4, this.balance);
            aVar.fT(5, this.rZV);
            aVar.fT(6, this.rZW);
            aVar.fT(7, this.rZX);
            aVar.d(8, 8, this.rZY);
            if (this.rZU == null) {
                return 0;
            }
            aVar.fV(9, this.rZU.boi());
            this.rZU.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            fS = ((((fS + f.a.a.a.fQ(4, this.balance)) + f.a.a.a.fQ(5, this.rZV)) + f.a.a.a.fQ(6, this.rZW)) + f.a.a.a.fQ(7, this.rZX)) + f.a.a.a.c(8, 8, this.rZY);
            if (this.rZU != null) {
                fS += f.a.a.a.fS(9, this.rZU.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rZY.clear();
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
            awx awx = (awx) objArr[1];
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
                        awx.six = flVar;
                    }
                    return 0;
                case 2:
                    awx.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    awx.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    awx.balance = aVar3.vHC.rY();
                    return 0;
                case 5:
                    awx.rZV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    awx.rZW = aVar3.vHC.rY();
                    return 0;
                case 7:
                    awx.rZX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sj sjVar = new sj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.a(aVar4, sjVar, bhp.a(aVar4))) {
                        }
                        awx.rZY.add(sjVar);
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        arq arq = new arq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arq.a(aVar4, arq, bhp.a(aVar4))) {
                        }
                        awx.rZU = arq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
