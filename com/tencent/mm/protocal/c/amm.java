package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class amm extends bhp {
    public int hwV;
    public String hwW;
    public LinkedList<amn> rPg = new LinkedList();
    public baq rPh;
    public bhw rPi;
    public boolean rPj;

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
            aVar.d(4, 8, this.rPg);
            if (this.rPh != null) {
                aVar.fV(5, this.rPh.boi());
                this.rPh.a(aVar);
            }
            if (this.rPi != null) {
                aVar.fV(6, this.rPi.boi());
                this.rPi.a(aVar);
            }
            aVar.av(7, this.rPj);
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
            fS += f.a.a.a.c(4, 8, this.rPg);
            if (this.rPh != null) {
                fS += f.a.a.a.fS(5, this.rPh.boi());
            }
            if (this.rPi != null) {
                fS += f.a.a.a.fS(6, this.rPi.boi());
            }
            return fS + (f.a.a.b.b.a.ec(7) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rPg.clear();
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
            amm amm = (amm) objArr[1];
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
                        amm.six = flVar;
                    }
                    return 0;
                case 2:
                    amm.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    amm.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amn amn = new amn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amn.a(aVar4, amn, bhp.a(aVar4))) {
                        }
                        amm.rPg.add(amn);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        baq baq = new baq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baq.a(aVar4, baq, bhp.a(aVar4))) {
                        }
                        amm.rPh = baq;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhw bhw = new bhw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhw.a(aVar4, bhw, bhp.a(aVar4))) {
                        }
                        amm.rPi = bhw;
                    }
                    return 0;
                case 7:
                    amm.rPj = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
