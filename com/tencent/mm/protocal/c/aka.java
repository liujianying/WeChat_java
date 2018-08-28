package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aka extends bhp {
    public int rHG;
    public LinkedList<ccd> rHH = new LinkedList();
    public String rMA;
    public int rMB;
    public String rMC;
    public String rMD;
    public String rME;
    public String rMy;

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
            aVar.fT(2, this.rHG);
            aVar.d(3, 8, this.rHH);
            if (this.rMA != null) {
                aVar.g(4, this.rMA);
            }
            if (this.rMy != null) {
                aVar.g(5, this.rMy);
            }
            aVar.fT(6, this.rMB);
            if (this.rMC != null) {
                aVar.g(7, this.rMC);
            }
            if (this.rMD != null) {
                aVar.g(8, this.rMD);
            }
            if (this.rME == null) {
                return 0;
            }
            aVar.g(9, this.rME);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rHG)) + f.a.a.a.c(3, 8, this.rHH);
            if (this.rMA != null) {
                fS += f.a.a.b.b.a.h(4, this.rMA);
            }
            if (this.rMy != null) {
                fS += f.a.a.b.b.a.h(5, this.rMy);
            }
            fS += f.a.a.a.fQ(6, this.rMB);
            if (this.rMC != null) {
                fS += f.a.a.b.b.a.h(7, this.rMC);
            }
            if (this.rMD != null) {
                fS += f.a.a.b.b.a.h(8, this.rMD);
            }
            if (this.rME != null) {
                fS += f.a.a.b.b.a.h(9, this.rME);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHH.clear();
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
            aka aka = (aka) objArr[1];
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
                        aka.six = flVar;
                    }
                    return 0;
                case 2:
                    aka.rHG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccd ccd = new ccd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccd.a(aVar4, ccd, bhp.a(aVar4))) {
                        }
                        aka.rHH.add(ccd);
                    }
                    return 0;
                case 4:
                    aka.rMA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aka.rMy = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aka.rMB = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aka.rMC = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aka.rMD = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aka.rME = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
