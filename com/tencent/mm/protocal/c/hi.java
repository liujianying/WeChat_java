package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class hi extends bhd {
    public bhy rgk;
    public String rhA;
    public String rhI;
    public int rhT;
    public String rhU;
    public String rhV;
    public String rhW;
    public int rhX;
    public bhz rhY;
    public bhy rhZ;
    public String rhz;
    public int ria;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rhT);
            if (this.rhI != null) {
                aVar.g(3, this.rhI);
            }
            if (this.rhU != null) {
                aVar.g(4, this.rhU);
            }
            if (this.rhV != null) {
                aVar.g(5, this.rhV);
            }
            if (this.rhW != null) {
                aVar.g(6, this.rhW);
            }
            aVar.fT(7, this.rhX);
            if (this.rhY != null) {
                aVar.fV(8, this.rhY.boi());
                this.rhY.a(aVar);
            }
            if (this.rhZ != null) {
                aVar.fV(9, this.rhZ.boi());
                this.rhZ.a(aVar);
            }
            aVar.fT(10, this.ria);
            if (this.rhz != null) {
                aVar.g(11, this.rhz);
            }
            if (this.rhA != null) {
                aVar.g(12, this.rhA);
            }
            if (this.rgk == null) {
                return 0;
            }
            aVar.fV(13, this.rgk.boi());
            this.rgk.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rhT);
            if (this.rhI != null) {
                fS += f.a.a.b.b.a.h(3, this.rhI);
            }
            if (this.rhU != null) {
                fS += f.a.a.b.b.a.h(4, this.rhU);
            }
            if (this.rhV != null) {
                fS += f.a.a.b.b.a.h(5, this.rhV);
            }
            if (this.rhW != null) {
                fS += f.a.a.b.b.a.h(6, this.rhW);
            }
            fS += f.a.a.a.fQ(7, this.rhX);
            if (this.rhY != null) {
                fS += f.a.a.a.fS(8, this.rhY.boi());
            }
            if (this.rhZ != null) {
                fS += f.a.a.a.fS(9, this.rhZ.boi());
            }
            fS += f.a.a.a.fQ(10, this.ria);
            if (this.rhz != null) {
                fS += f.a.a.b.b.a.h(11, this.rhz);
            }
            if (this.rhA != null) {
                fS += f.a.a.b.b.a.h(12, this.rhA);
            }
            if (this.rgk != null) {
                fS += f.a.a.a.fS(13, this.rgk.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            hi hiVar = (hi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
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
                        hiVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    hiVar.rhT = aVar3.vHC.rY();
                    return 0;
                case 3:
                    hiVar.rhI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hiVar.rhU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    hiVar.rhV = aVar3.vHC.readString();
                    return 0;
                case 6:
                    hiVar.rhW = aVar3.vHC.readString();
                    return 0;
                case 7:
                    hiVar.rhX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        hiVar.rhY = bhz;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        hiVar.rhZ = bhy;
                    }
                    return 0;
                case 10:
                    hiVar.ria = aVar3.vHC.rY();
                    return 0;
                case 11:
                    hiVar.rhz = aVar3.vHC.readString();
                    return 0;
                case 12:
                    hiVar.rhA = aVar3.vHC.readString();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        hiVar.rgk = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
