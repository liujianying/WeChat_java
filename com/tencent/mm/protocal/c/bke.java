package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bke extends bhd {
    public String eJK;
    public int rdY;
    public int rmA;
    public int rwB;
    public String rwk;
    public df sjS;
    public String sjT;
    public String sjU;
    public int sjV;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.sjS == null) {
                throw new b("Not all required fields were included: Msg");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.sjS != null) {
                aVar.fV(2, this.sjS.boi());
                this.sjS.a(aVar);
            }
            if (this.sjT != null) {
                aVar.g(3, this.sjT);
            }
            aVar.fT(4, this.rwB);
            if (this.rwk != null) {
                aVar.g(5, this.rwk);
            }
            aVar.fT(6, this.rdY);
            if (this.eJK != null) {
                aVar.g(7, this.eJK);
            }
            if (this.sjU != null) {
                aVar.g(8, this.sjU);
            }
            aVar.fT(9, this.sjV);
            aVar.fT(10, this.rmA);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sjS != null) {
                fS += f.a.a.a.fS(2, this.sjS.boi());
            }
            if (this.sjT != null) {
                fS += f.a.a.b.b.a.h(3, this.sjT);
            }
            fS += f.a.a.a.fQ(4, this.rwB);
            if (this.rwk != null) {
                fS += f.a.a.b.b.a.h(5, this.rwk);
            }
            fS += f.a.a.a.fQ(6, this.rdY);
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(7, this.eJK);
            }
            if (this.sjU != null) {
                fS += f.a.a.b.b.a.h(8, this.sjU);
            }
            return (fS + f.a.a.a.fQ(9, this.sjV)) + f.a.a.a.fQ(10, this.rmA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sjS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bke bke = (bke) objArr[1];
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
                        bke.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        df dfVar = new df();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dfVar.a(aVar4, dfVar, bhd.a(aVar4))) {
                        }
                        bke.sjS = dfVar;
                    }
                    return 0;
                case 3:
                    bke.sjT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bke.rwB = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bke.rwk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bke.rdY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bke.eJK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bke.sjU = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bke.sjV = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bke.rmA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
