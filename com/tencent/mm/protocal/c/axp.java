package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class axp extends bhp {
    public int hwV;
    public String hwW;
    public String rhd;
    public bbc rhe;
    public ayi rhf;
    public String saE;
    public String saK;

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
            if (this.saE != null) {
                aVar.g(4, this.saE);
            }
            if (this.rhd != null) {
                aVar.g(5, this.rhd);
            }
            if (this.saK != null) {
                aVar.g(6, this.saK);
            }
            if (this.rhe != null) {
                aVar.fV(7, this.rhe.boi());
                this.rhe.a(aVar);
            }
            if (this.rhf == null) {
                return 0;
            }
            aVar.fV(8, this.rhf.boi());
            this.rhf.a(aVar);
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
            if (this.saE != null) {
                fS += f.a.a.b.b.a.h(4, this.saE);
            }
            if (this.rhd != null) {
                fS += f.a.a.b.b.a.h(5, this.rhd);
            }
            if (this.saK != null) {
                fS += f.a.a.b.b.a.h(6, this.saK);
            }
            if (this.rhe != null) {
                fS += f.a.a.a.fS(7, this.rhe.boi());
            }
            if (this.rhf != null) {
                fS += f.a.a.a.fS(8, this.rhf.boi());
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
            axp axp = (axp) objArr[1];
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
                        axp.six = flVar;
                    }
                    return 0;
                case 2:
                    axp.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    axp.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    axp.saE = aVar3.vHC.readString();
                    return 0;
                case 5:
                    axp.rhd = aVar3.vHC.readString();
                    return 0;
                case 6:
                    axp.saK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbc bbc = new bbc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.a(aVar4, bbc, bhp.a(aVar4))) {
                        }
                        axp.rhe = bbc;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayi ayi = new ayi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.a(aVar4, ayi, bhp.a(aVar4))) {
                        }
                        axp.rhf = ayi;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
