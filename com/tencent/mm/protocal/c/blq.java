package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class blq extends bhd {
    public int mask;
    public int rFW;
    public ia rFY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rFY == null) {
                throw new b("Not all required fields were included: attr");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rFW);
            aVar.fT(3, this.mask);
            if (this.rFY == null) {
                return 0;
            }
            aVar.fV(4, this.rFY.boi());
            this.rFY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rFW)) + f.a.a.a.fQ(3, this.mask);
            if (this.rFY != null) {
                fS += f.a.a.a.fS(4, this.rFY.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rFY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: attr");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            blq blq = (blq) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        blq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    blq.rFW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    blq.mask = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ia iaVar = new ia();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iaVar.a(aVar4, iaVar, bhd.a(aVar4))) {
                        }
                        blq.rFY = iaVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
