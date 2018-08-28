package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class il extends bhd {
    public int otY;
    public int rgC;
    public int rhX;
    public bhy rjA;
    public int rjB;
    public int rjC;
    public int rjD;
    public int rjE;
    public int rjz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rjA == null) {
                throw new b("Not all required fields were included: ImageBuffer");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rjz);
            if (this.rjA != null) {
                aVar.fV(3, this.rjA.boi());
                this.rjA.a(aVar);
            }
            aVar.fT(4, this.rjB);
            aVar.fT(5, this.rjC);
            aVar.fT(6, this.rgC);
            aVar.fT(7, this.rjD);
            aVar.fT(8, this.rhX);
            aVar.fT(9, this.rjE);
            aVar.fT(10, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rjz);
            if (this.rjA != null) {
                fS += f.a.a.a.fS(3, this.rjA.boi());
            }
            return ((((((fS + f.a.a.a.fQ(4, this.rjB)) + f.a.a.a.fQ(5, this.rjC)) + f.a.a.a.fQ(6, this.rgC)) + f.a.a.a.fQ(7, this.rjD)) + f.a.a.a.fQ(8, this.rhX)) + f.a.a.a.fQ(9, this.rjE)) + f.a.a.a.fQ(10, this.otY);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rjA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImageBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            il ilVar = (il) objArr[1];
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
                        ilVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ilVar.rjz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        ilVar.rjA = bhy;
                    }
                    return 0;
                case 4:
                    ilVar.rjB = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ilVar.rjC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ilVar.rgC = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ilVar.rjD = aVar3.vHC.rY();
                    return 0;
                case 8:
                    ilVar.rhX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ilVar.rjE = aVar3.vHC.rY();
                    return 0;
                case 10:
                    ilVar.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
