package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class sk extends bhd {
    public int hcE;
    public int rjC;
    public ayv rvL;
    public int rvM;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rvL == null) {
                throw new b("Not all required fields were included: Package");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rvL != null) {
                aVar.fV(2, this.rvL.boi());
                this.rvL.a(aVar);
            }
            aVar.fT(3, this.rjC);
            aVar.fT(4, this.rvM);
            aVar.fT(5, this.hcE);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rvL != null) {
                fS += f.a.a.a.fS(2, this.rvL.boi());
            }
            return ((fS + f.a.a.a.fQ(3, this.rjC)) + f.a.a.a.fQ(4, this.rvM)) + f.a.a.a.fQ(5, this.hcE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rvL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Package");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sk skVar = (sk) objArr[1];
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
                        skVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayv ayv = new ayv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayv.a(aVar4, ayv, bhd.a(aVar4))) {
                        }
                        skVar.rvL = ayv;
                    }
                    return 0;
                case 3:
                    skVar.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    skVar.rvM = aVar3.vHC.rY();
                    return 0;
                case 5:
                    skVar.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
