package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bdg extends bhp {
    public String bWP;
    public int huV;
    public int hwV;
    public String hwW;
    public String hwg;
    public String qYy;
    public btd rHg;
    public bhw rPi;
    public long rPl;
    public long ruW;

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
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            if (this.qYy != null) {
                aVar.g(4, this.qYy);
            }
            aVar.T(5, this.rPl);
            aVar.T(6, this.ruW);
            if (this.rPi != null) {
                aVar.fV(7, this.rPi.boi());
                this.rPi.a(aVar);
            }
            if (this.rHg != null) {
                aVar.fV(8, this.rHg.boi());
                this.rHg.a(aVar);
            }
            if (this.hwg != null) {
                aVar.g(9, this.hwg);
            }
            aVar.fT(10, this.huV);
            if (this.bWP == null) {
                return 0;
            }
            aVar.g(11, this.bWP);
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
            if (this.qYy != null) {
                fS += f.a.a.b.b.a.h(4, this.qYy);
            }
            fS = (fS + f.a.a.a.S(5, this.rPl)) + f.a.a.a.S(6, this.ruW);
            if (this.rPi != null) {
                fS += f.a.a.a.fS(7, this.rPi.boi());
            }
            if (this.rHg != null) {
                fS += f.a.a.a.fS(8, this.rHg.boi());
            }
            if (this.hwg != null) {
                fS += f.a.a.b.b.a.h(9, this.hwg);
            }
            fS += f.a.a.a.fQ(10, this.huV);
            if (this.bWP != null) {
                fS += f.a.a.b.b.a.h(11, this.bWP);
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
            bdg bdg = (bdg) objArr[1];
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
                        bdg.six = flVar;
                    }
                    return 0;
                case 2:
                    bdg.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdg.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bdg.qYy = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bdg.rPl = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bdg.ruW = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhw bhw = new bhw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhw.a(aVar4, bhw, bhp.a(aVar4))) {
                        }
                        bdg.rPi = bhw;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btd btd = new btd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btd.a(aVar4, btd, bhp.a(aVar4))) {
                        }
                        bdg.rHg = btd;
                    }
                    return 0;
                case 9:
                    bdg.hwg = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bdg.huV = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bdg.bWP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
