package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class nr extends bhp {
    public cgh rrI;
    public boolean rrJ;
    public String rrK;
    public String rrL;
    public boolean rrM;
    public String rrN;
    public String rrO;
    public String rrP;

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
            if (this.rrI != null) {
                aVar.fV(2, this.rrI.boi());
                this.rrI.a(aVar);
            }
            aVar.av(3, this.rrJ);
            if (this.rrK != null) {
                aVar.g(4, this.rrK);
            }
            if (this.rrL != null) {
                aVar.g(5, this.rrL);
            }
            aVar.av(6, this.rrM);
            if (this.rrN != null) {
                aVar.g(7, this.rrN);
            }
            if (this.rrO != null) {
                aVar.g(8, this.rrO);
            }
            if (this.rrP == null) {
                return 0;
            }
            aVar.g(9, this.rrP);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rrI != null) {
                fS += f.a.a.a.fS(2, this.rrI.boi());
            }
            fS += f.a.a.b.b.a.ec(3) + 1;
            if (this.rrK != null) {
                fS += f.a.a.b.b.a.h(4, this.rrK);
            }
            if (this.rrL != null) {
                fS += f.a.a.b.b.a.h(5, this.rrL);
            }
            fS += f.a.a.b.b.a.ec(6) + 1;
            if (this.rrN != null) {
                fS += f.a.a.b.b.a.h(7, this.rrN);
            }
            if (this.rrO != null) {
                fS += f.a.a.b.b.a.h(8, this.rrO);
            }
            if (this.rrP != null) {
                fS += f.a.a.b.b.a.h(9, this.rrP);
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
            nr nrVar = (nr) objArr[1];
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
                        nrVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cgh cgh = new cgh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgh.a(aVar4, cgh, bhp.a(aVar4))) {
                        }
                        nrVar.rrI = cgh;
                    }
                    return 0;
                case 3:
                    nrVar.rrJ = aVar3.cJQ();
                    return 0;
                case 4:
                    nrVar.rrK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nrVar.rrL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nrVar.rrM = aVar3.cJQ();
                    return 0;
                case 7:
                    nrVar.rrN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    nrVar.rrO = aVar3.vHC.readString();
                    return 0;
                case 9:
                    nrVar.rrP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
