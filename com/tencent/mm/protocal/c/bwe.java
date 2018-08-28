package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwe extends bhd {
    public int jSO;
    public int rdV;
    public int rdW;
    public int rdX;
    public bhy rtW;
    public int ssA;
    public bhz ssv;
    public bhz ssw;
    public int ssx;
    public int ssy;
    public int ssz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ssv == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.ssw == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ssv != null) {
                    aVar.fV(2, this.ssv.boi());
                    this.ssv.a(aVar);
                }
                if (this.ssw != null) {
                    aVar.fV(3, this.ssw.boi());
                    this.ssw.a(aVar);
                }
                aVar.fT(4, this.rdV);
                aVar.fT(5, this.rdW);
                aVar.fT(6, this.rdX);
                if (this.rtW != null) {
                    aVar.fV(7, this.rtW.boi());
                    this.rtW.a(aVar);
                }
                aVar.fT(8, this.jSO);
                aVar.fT(9, this.ssx);
                aVar.fT(10, this.ssy);
                aVar.fT(11, this.ssz);
                aVar.fT(12, this.ssA);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ssv != null) {
                fS += f.a.a.a.fS(2, this.ssv.boi());
            }
            if (this.ssw != null) {
                fS += f.a.a.a.fS(3, this.ssw.boi());
            }
            fS = ((fS + f.a.a.a.fQ(4, this.rdV)) + f.a.a.a.fQ(5, this.rdW)) + f.a.a.a.fQ(6, this.rdX);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(7, this.rtW.boi());
            }
            return ((((fS + f.a.a.a.fQ(8, this.jSO)) + f.a.a.a.fQ(9, this.ssx)) + f.a.a.a.fQ(10, this.ssy)) + f.a.a.a.fQ(11, this.ssz)) + f.a.a.a.fQ(12, this.ssA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ssv == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.ssw == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.rtW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bwe bwe = (bwe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
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
                        bwe.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bwe.ssv = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bwe.ssw = bhz;
                    }
                    return 0;
                case 4:
                    bwe.rdV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bwe.rdW = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bwe.rdX = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwe.rtW = bhy;
                    }
                    return 0;
                case 8:
                    bwe.jSO = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bwe.ssx = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bwe.ssy = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bwe.ssz = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bwe.ssA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
