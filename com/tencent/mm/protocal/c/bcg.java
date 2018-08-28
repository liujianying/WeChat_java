package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bcg extends bhd {
    public int rxG;
    public bhz seA;
    public int seB;
    public long seh;
    public bhz sey;
    public bhz sez;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.sey == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.sez == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.seA == null) {
                throw new b("Not all required fields were included: EngineReport");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.sey != null) {
                    aVar.fV(2, this.sey.boi());
                    this.sey.a(aVar);
                }
                if (this.sez != null) {
                    aVar.fV(3, this.sez.boi());
                    this.sez.a(aVar);
                }
                if (this.seA != null) {
                    aVar.fV(4, this.seA.boi());
                    this.seA.a(aVar);
                }
                aVar.fT(5, this.rxG);
                aVar.T(6, this.seh);
                aVar.fT(7, this.seB);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sey != null) {
                fS += f.a.a.a.fS(2, this.sey.boi());
            }
            if (this.sez != null) {
                fS += f.a.a.a.fS(3, this.sez.boi());
            }
            if (this.seA != null) {
                fS += f.a.a.a.fS(4, this.seA.boi());
            }
            return ((fS + f.a.a.a.fQ(5, this.rxG)) + f.a.a.a.S(6, this.seh)) + f.a.a.a.fQ(7, this.seB);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sey == null) {
                throw new b("Not all required fields were included: ClientReport");
            } else if (this.sez == null) {
                throw new b("Not all required fields were included: ChannelReport");
            } else if (this.seA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: EngineReport");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bcg bcg = (bcg) objArr[1];
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
                        bcg.shX = fkVar;
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
                        bcg.sey = bhz;
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
                        bcg.sez = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bcg.seA = bhz;
                    }
                    return 0;
                case 5:
                    bcg.rxG = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bcg.seh = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    bcg.seB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
