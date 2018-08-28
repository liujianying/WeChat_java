package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bmr extends bhd {
    public int rdn;
    public int rgC;
    public float rms;
    public bhy rtW;
    public int rth;
    public int skI;
    public float skJ;
    public float skK;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rtW != null) {
                aVar.fV(2, this.rtW.boi());
                this.rtW.a(aVar);
            }
            aVar.fT(3, this.skI);
            aVar.fT(4, this.rgC);
            aVar.l(5, this.skJ);
            aVar.fT(6, this.rth);
            aVar.fT(7, this.rdn);
            aVar.l(8, this.skK);
            aVar.l(9, this.rms);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rtW != null) {
                fS += f.a.a.a.fS(2, this.rtW.boi());
            }
            return ((((((fS + f.a.a.a.fQ(3, this.skI)) + f.a.a.a.fQ(4, this.rgC)) + (f.a.a.b.b.a.ec(5) + 4)) + f.a.a.a.fQ(6, this.rth)) + f.a.a.a.fQ(7, this.rdn)) + (f.a.a.b.b.a.ec(8) + 4)) + (f.a.a.b.b.a.ec(9) + 4);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bmr bmr = (bmr) objArr[1];
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
                        bmr.shX = fkVar;
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
                        bmr.rtW = bhy;
                    }
                    return 0;
                case 3:
                    bmr.skI = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bmr.rgC = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bmr.skJ = aVar3.vHC.readFloat();
                    return 0;
                case 6:
                    bmr.rth = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bmr.rdn = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bmr.skK = aVar3.vHC.readFloat();
                    return 0;
                case 9:
                    bmr.rms = aVar3.vHC.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
