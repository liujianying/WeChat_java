package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class adg extends bhd {
    public int otY;
    public int rHA;
    public bhy rcT;
    public int rgA;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rcT == null) {
                throw new b("Not all required fields were included: ReqBuf");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rcT != null) {
                aVar.fV(2, this.rcT.boi());
                this.rcT.a(aVar);
            }
            aVar.fT(3, this.rgA);
            aVar.fT(4, this.otY);
            aVar.fT(5, this.rHA);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcT != null) {
                fS += f.a.a.a.fS(2, this.rcT.boi());
            }
            return ((fS + f.a.a.a.fQ(3, this.rgA)) + f.a.a.a.fQ(4, this.otY)) + f.a.a.a.fQ(5, this.rHA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rcT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqBuf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            adg adg = (adg) objArr[1];
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
                        adg.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        adg.rcT = bhy;
                    }
                    return 0;
                case 3:
                    adg.rgA = aVar3.vHC.rY();
                    return 0;
                case 4:
                    adg.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    adg.rHA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
