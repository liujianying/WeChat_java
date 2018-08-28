package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ph extends a {
    public int rtD;
    public bhy rtE;
    public int rtF;
    public bhy rtG;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rtE == null) {
                throw new b("Not all required fields were included: OperationInfo");
            }
            aVar.fT(1, this.rtD);
            if (this.rtE != null) {
                aVar.fV(2, this.rtE.boi());
                this.rtE.a(aVar);
            }
            aVar.fT(3, this.rtF);
            if (this.rtG != null) {
                aVar.fV(4, this.rtG.boi());
                this.rtG.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rtD) + 0;
            if (this.rtE != null) {
                fQ += f.a.a.a.fS(2, this.rtE.boi());
            }
            fQ += f.a.a.a.fQ(3, this.rtF);
            if (this.rtG != null) {
                return fQ + f.a.a.a.fS(4, this.rtG.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rtE != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OperationInfo");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ph phVar = (ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhy bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    phVar.rtD = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        phVar.rtE = bhy;
                    }
                    return 0;
                case 3:
                    phVar.rtF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        phVar.rtG = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
