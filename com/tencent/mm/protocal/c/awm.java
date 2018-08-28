package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class awm extends bhp {
    public String dxK;
    public LinkedList<awp> rZJ = new LinkedList();
    public String rZK;
    public boolean rZL;
    public boolean rZM;
    public boolean rZN;
    public String rqU;

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
            aVar.d(3, 8, this.rZJ);
            if (this.dxK != null) {
                aVar.g(4, this.dxK);
            }
            if (this.rZK != null) {
                aVar.g(5, this.rZK);
            }
            if (this.rqU != null) {
                aVar.g(6, this.rqU);
            }
            aVar.av(8, this.rZL);
            aVar.av(9, this.rZM);
            aVar.av(10, this.rZN);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(3, 8, this.rZJ);
            if (this.dxK != null) {
                fS += f.a.a.b.b.a.h(4, this.dxK);
            }
            if (this.rZK != null) {
                fS += f.a.a.b.b.a.h(5, this.rZK);
            }
            if (this.rqU != null) {
                fS += f.a.a.b.b.a.h(6, this.rqU);
            }
            return ((fS + (f.a.a.b.b.a.ec(8) + 1)) + (f.a.a.b.b.a.ec(9) + 1)) + (f.a.a.b.b.a.ec(10) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rZJ.clear();
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
            awm awm = (awm) objArr[1];
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
                        awm.six = flVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        awp awp = new awp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awp.a(aVar4, awp, bhp.a(aVar4))) {
                        }
                        awm.rZJ.add(awp);
                    }
                    return 0;
                case 4:
                    awm.dxK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    awm.rZK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    awm.rqU = aVar3.vHC.readString();
                    return 0;
                case 8:
                    awm.rZL = aVar3.cJQ();
                    return 0;
                case 9:
                    awm.rZM = aVar3.cJQ();
                    return 0;
                case 10:
                    awm.rZN = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
