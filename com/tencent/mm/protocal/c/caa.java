package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class caa extends bhp {
    public int hLg;
    public int lOH;
    public int rxG;
    public long rxH;
    public int svK;
    public String svS;
    public LinkedList<cav> svT = new LinkedList();

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
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.lOH);
            aVar.fT(6, this.hLg);
            aVar.d(7, 8, this.svT);
            if (this.svS != null) {
                aVar.g(8, this.svS);
            }
            aVar.fT(9, this.svK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.lOH)) + f.a.a.a.fQ(6, this.hLg)) + f.a.a.a.c(7, 8, this.svT);
            if (this.svS != null) {
                fS += f.a.a.b.b.a.h(8, this.svS);
            }
            return fS + f.a.a.a.fQ(9, this.svK);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.svT.clear();
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
            caa caa = (caa) objArr[1];
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
                        caa.six = flVar;
                    }
                    return 0;
                case 2:
                    caa.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    caa.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    caa.lOH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    caa.hLg = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cav cav = new cav();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cav.a(aVar4, cav, bhp.a(aVar4))) {
                        }
                        caa.svT.add(cav);
                    }
                    return 0;
                case 8:
                    caa.svS = aVar3.vHC.readString();
                    return 0;
                case 9:
                    caa.svK = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
