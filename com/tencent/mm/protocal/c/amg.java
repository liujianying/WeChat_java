package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class amg extends a {
    public fj rOP;
    public kk rOQ;
    public atk rOR;
    public brf rOS;
    public bip rOT;
    public po rOU;
    public xd rOV;
    public xu rOW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rOP != null) {
                aVar.fV(1, this.rOP.boi());
                this.rOP.a(aVar);
            }
            if (this.rOQ != null) {
                aVar.fV(2, this.rOQ.boi());
                this.rOQ.a(aVar);
            }
            if (this.rOR != null) {
                aVar.fV(3, this.rOR.boi());
                this.rOR.a(aVar);
            }
            if (this.rOS != null) {
                aVar.fV(4, this.rOS.boi());
                this.rOS.a(aVar);
            }
            if (this.rOT != null) {
                aVar.fV(6, this.rOT.boi());
                this.rOT.a(aVar);
            }
            if (this.rOU != null) {
                aVar.fV(7, this.rOU.boi());
                this.rOU.a(aVar);
            }
            if (this.rOV != null) {
                aVar.fV(8, this.rOV.boi());
                this.rOV.a(aVar);
            }
            if (this.rOW == null) {
                return 0;
            }
            aVar.fV(9, this.rOW.boi());
            this.rOW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rOP != null) {
                fS = f.a.a.a.fS(1, this.rOP.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rOQ != null) {
                fS += f.a.a.a.fS(2, this.rOQ.boi());
            }
            if (this.rOR != null) {
                fS += f.a.a.a.fS(3, this.rOR.boi());
            }
            if (this.rOS != null) {
                fS += f.a.a.a.fS(4, this.rOS.boi());
            }
            if (this.rOT != null) {
                fS += f.a.a.a.fS(6, this.rOT.boi());
            }
            if (this.rOU != null) {
                fS += f.a.a.a.fS(7, this.rOU.boi());
            }
            if (this.rOV != null) {
                fS += f.a.a.a.fS(8, this.rOV.boi());
            }
            if (this.rOW != null) {
                fS += f.a.a.a.fS(9, this.rOW.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            amg amg = (amg) objArr[1];
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
                        fj fjVar = new fj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fjVar.a(aVar4, fjVar, a.a(aVar4))) {
                        }
                        amg.rOP = fjVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kk kkVar = new kk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kkVar.a(aVar4, kkVar, a.a(aVar4))) {
                        }
                        amg.rOQ = kkVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atk atk = new atk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atk.a(aVar4, atk, a.a(aVar4))) {
                        }
                        amg.rOR = atk;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brf brf = new brf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.a(aVar4, brf, a.a(aVar4))) {
                        }
                        amg.rOS = brf;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bip bip = new bip();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bip.a(aVar4, bip, a.a(aVar4))) {
                        }
                        amg.rOT = bip;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        po poVar = new po();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = poVar.a(aVar4, poVar, a.a(aVar4))) {
                        }
                        amg.rOU = poVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xd xdVar = new xd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xdVar.a(aVar4, xdVar, a.a(aVar4))) {
                        }
                        amg.rOV = xdVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xu xuVar = new xu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xuVar.a(aVar4, xuVar, a.a(aVar4))) {
                        }
                        amg.rOW = xuVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
