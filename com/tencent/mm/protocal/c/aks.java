package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aks extends bhp {
    public String rNA;
    public int rNB;
    public String rNC;
    public String rND;
    public String rNE;
    public String rNF;
    public int rNs;
    public LinkedList<chg> rNy = new LinkedList();
    public chg rNz;
    public cgh rrI;

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
            if (this.rrI != null) {
                aVar.fV(2, this.rrI.boi());
                this.rrI.a(aVar);
            }
            aVar.d(3, 8, this.rNy);
            if (this.rNz != null) {
                aVar.fV(4, this.rNz.boi());
                this.rNz.a(aVar);
            }
            if (this.rNA != null) {
                aVar.g(5, this.rNA);
            }
            aVar.fT(6, this.rNB);
            if (this.rNC != null) {
                aVar.g(7, this.rNC);
            }
            if (this.rND != null) {
                aVar.g(8, this.rND);
            }
            if (this.rNE != null) {
                aVar.g(9, this.rNE);
            }
            if (this.rNF != null) {
                aVar.g(10, this.rNF);
            }
            aVar.fT(11, this.rNs);
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
            fS += f.a.a.a.c(3, 8, this.rNy);
            if (this.rNz != null) {
                fS += f.a.a.a.fS(4, this.rNz.boi());
            }
            if (this.rNA != null) {
                fS += f.a.a.b.b.a.h(5, this.rNA);
            }
            fS += f.a.a.a.fQ(6, this.rNB);
            if (this.rNC != null) {
                fS += f.a.a.b.b.a.h(7, this.rNC);
            }
            if (this.rND != null) {
                fS += f.a.a.b.b.a.h(8, this.rND);
            }
            if (this.rNE != null) {
                fS += f.a.a.b.b.a.h(9, this.rNE);
            }
            if (this.rNF != null) {
                fS += f.a.a.b.b.a.h(10, this.rNF);
            }
            return fS + f.a.a.a.fQ(11, this.rNs);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rNy.clear();
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
            aks aks = (aks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            chg chg;
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
                        aks.six = flVar;
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
                        aks.rrI = cgh;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chg = new chg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chg.a(aVar4, chg, bhp.a(aVar4))) {
                        }
                        aks.rNy.add(chg);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chg = new chg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chg.a(aVar4, chg, bhp.a(aVar4))) {
                        }
                        aks.rNz = chg;
                    }
                    return 0;
                case 5:
                    aks.rNA = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aks.rNB = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aks.rNC = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aks.rND = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aks.rNE = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aks.rNF = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aks.rNs = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
