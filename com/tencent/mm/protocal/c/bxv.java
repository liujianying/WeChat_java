package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bxv extends bhd {
    public int qZc;
    public bhz rMn;
    public bhy rgk;
    public String rhU;
    public bhz rhY;
    public bhy rhZ;
    public int skH;
    public String stV;
    public bhz stW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.qZc);
            if (this.stV != null) {
                aVar.g(3, this.stV);
            }
            if (this.rhU != null) {
                aVar.g(4, this.rhU);
            }
            if (this.rMn != null) {
                aVar.fV(5, this.rMn.boi());
                this.rMn.a(aVar);
            }
            if (this.stW != null) {
                aVar.fV(6, this.stW.boi());
                this.stW.a(aVar);
            }
            if (this.rhY != null) {
                aVar.fV(7, this.rhY.boi());
                this.rhY.a(aVar);
            }
            if (this.rhZ != null) {
                aVar.fV(8, this.rhZ.boi());
                this.rhZ.a(aVar);
            }
            aVar.fT(9, this.skH);
            if (this.rgk == null) {
                return 0;
            }
            aVar.fV(10, this.rgk.boi());
            this.rgk.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.qZc);
            if (this.stV != null) {
                fS += f.a.a.b.b.a.h(3, this.stV);
            }
            if (this.rhU != null) {
                fS += f.a.a.b.b.a.h(4, this.rhU);
            }
            if (this.rMn != null) {
                fS += f.a.a.a.fS(5, this.rMn.boi());
            }
            if (this.stW != null) {
                fS += f.a.a.a.fS(6, this.stW.boi());
            }
            if (this.rhY != null) {
                fS += f.a.a.a.fS(7, this.rhY.boi());
            }
            if (this.rhZ != null) {
                fS += f.a.a.a.fS(8, this.rhZ.boi());
            }
            fS += f.a.a.a.fQ(9, this.skH);
            if (this.rgk != null) {
                fS += f.a.a.a.fS(10, this.rgk.boi());
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
            bxv bxv = (bxv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
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
                        bxv.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bxv.qZc = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bxv.stV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bxv.rhU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bxv.rMn = bhz;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bxv.stW = bhz;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bxv.rhY = bhz;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bxv.rhZ = bhy;
                    }
                    return 0;
                case 9:
                    bxv.skH = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bxv.rgk = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
