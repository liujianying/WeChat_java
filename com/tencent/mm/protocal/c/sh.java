package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class sh extends a {
    public int rvE;
    public si rvF;
    public int rvG;
    public si rvH;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvF == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.rvH == null) {
                throw new b("Not all required fields were included: AllDayTime");
            } else {
                aVar.fT(1, this.rvE);
                if (this.rvF != null) {
                    aVar.fV(2, this.rvF.boi());
                    this.rvF.a(aVar);
                }
                aVar.fT(3, this.rvG);
                if (this.rvH != null) {
                    aVar.fV(4, this.rvH.boi());
                    this.rvH.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rvE) + 0;
            if (this.rvF != null) {
                fQ += f.a.a.a.fS(2, this.rvF.boi());
            }
            fQ += f.a.a.a.fQ(3, this.rvG);
            if (this.rvH != null) {
                return fQ + f.a.a.a.fS(4, this.rvH.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rvF == null) {
                throw new b("Not all required fields were included: NightTime");
            } else if (this.rvH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AllDayTime");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sh shVar = (sh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            si siVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    shVar.rvE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        siVar = new si();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = siVar.a(aVar4, siVar, a.a(aVar4))) {
                        }
                        shVar.rvF = siVar;
                    }
                    return 0;
                case 3:
                    shVar.rvG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        siVar = new si();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = siVar.a(aVar4, siVar, a.a(aVar4))) {
                        }
                        shVar.rvH = siVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
