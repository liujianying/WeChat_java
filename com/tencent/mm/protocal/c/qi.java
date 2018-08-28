package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class qi extends bhp {
    public String pjK;
    public LinkedList<kw> ruL = new LinkedList();
    public int ruM;
    public int ruN;
    public int version;

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
            aVar.d(2, 8, this.ruL);
            aVar.fT(3, this.version);
            aVar.fT(4, this.ruM);
            aVar.fT(5, this.ruN);
            if (this.pjK == null) {
                return 0;
            }
            aVar.g(6, this.pjK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + f.a.a.a.c(2, 8, this.ruL)) + f.a.a.a.fQ(3, this.version)) + f.a.a.a.fQ(4, this.ruM)) + f.a.a.a.fQ(5, this.ruN);
            if (this.pjK != null) {
                fS += f.a.a.b.b.a.h(6, this.pjK);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ruL.clear();
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
            qi qiVar = (qi) objArr[1];
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
                        qiVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kw kwVar = new kw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kwVar.a(aVar4, kwVar, bhp.a(aVar4))) {
                        }
                        qiVar.ruL.add(kwVar);
                    }
                    return 0;
                case 3:
                    qiVar.version = aVar3.vHC.rY();
                    return 0;
                case 4:
                    qiVar.ruM = aVar3.vHC.rY();
                    return 0;
                case 5:
                    qiVar.ruN = aVar3.vHC.rY();
                    return 0;
                case 6:
                    qiVar.pjK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
