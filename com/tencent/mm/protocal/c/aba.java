package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aba extends bhp {
    public int hbF;
    public int hcD;
    public LinkedList<aun> rGg = new LinkedList();
    public int rlm;

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
            aVar.fT(2, this.hbF);
            aVar.d(5, 8, this.rGg);
            aVar.fT(6, this.hcD);
            aVar.fT(7, this.rlm);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.fQ(2, this.hbF)) + f.a.a.a.c(5, 8, this.rGg)) + f.a.a.a.fQ(6, this.hcD)) + f.a.a.a.fQ(7, this.rlm);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rGg.clear();
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
            aba aba = (aba) objArr[1];
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
                        aba.six = flVar;
                    }
                    return 0;
                case 2:
                    aba.hbF = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aun aun = new aun();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aun.a(aVar4, aun, bhp.a(aVar4))) {
                        }
                        aba.rGg.add(aun);
                    }
                    return 0;
                case 6:
                    aba.hcD = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aba.rlm = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
