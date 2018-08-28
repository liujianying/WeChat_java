package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bdi extends bhp {
    public int hwV;
    public String hwW;
    public LinkedList<aze> qYU = new LinkedList();
    public btd rHg;
    public ke rIx;
    public bhw rPi;
    public long rrX;
    public long rrY;
    public amo ruX;

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
            if (this.ruX != null) {
                aVar.fV(4, this.ruX.boi());
                this.ruX.a(aVar);
            }
            aVar.d(5, 8, this.qYU);
            aVar.T(6, this.rrX);
            aVar.T(7, this.rrY);
            if (this.rPi != null) {
                aVar.fV(8, this.rPi.boi());
                this.rPi.a(aVar);
            }
            if (this.rIx != null) {
                aVar.fV(9, this.rIx.boi());
                this.rIx.a(aVar);
            }
            if (this.rHg == null) {
                return 0;
            }
            aVar.fV(10, this.rHg.boi());
            this.rHg.a(aVar);
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
            if (this.ruX != null) {
                fS += f.a.a.a.fS(4, this.ruX.boi());
            }
            fS = ((fS + f.a.a.a.c(5, 8, this.qYU)) + f.a.a.a.S(6, this.rrX)) + f.a.a.a.S(7, this.rrY);
            if (this.rPi != null) {
                fS += f.a.a.a.fS(8, this.rPi.boi());
            }
            if (this.rIx != null) {
                fS += f.a.a.a.fS(9, this.rIx.boi());
            }
            if (this.rHg != null) {
                fS += f.a.a.a.fS(10, this.rHg.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qYU.clear();
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
            bdi bdi = (bdi) objArr[1];
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
                        bdi.six = flVar;
                    }
                    return 0;
                case 2:
                    bdi.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdi.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amo amo = new amo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amo.a(aVar4, amo, bhp.a(aVar4))) {
                        }
                        bdi.ruX = amo;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aze aze = new aze();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aze.a(aVar4, aze, bhp.a(aVar4))) {
                        }
                        bdi.qYU.add(aze);
                    }
                    return 0;
                case 6:
                    bdi.rrX = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    bdi.rrY = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhw bhw = new bhw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhw.a(aVar4, bhw, bhp.a(aVar4))) {
                        }
                        bdi.rPi = bhw;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ke keVar = new ke();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = keVar.a(aVar4, keVar, bhp.a(aVar4))) {
                        }
                        bdi.rIx = keVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btd btd = new btd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btd.a(aVar4, btd, bhp.a(aVar4))) {
                        }
                        bdi.rHg = btd;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
