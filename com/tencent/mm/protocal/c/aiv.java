package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aiv extends bhp {
    public int rLA;
    public LinkedList<bhz> rLB = new LinkedList();
    public String rLC;
    public int rLD;
    public String rLE;
    public int rLF;
    public bhy rLG;
    public int rLw;
    public String rLx;
    public int rLy;
    public String rLz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rLw);
            if (this.rLx != null) {
                aVar.g(3, this.rLx);
            }
            aVar.fT(4, this.rLy);
            if (this.rLz != null) {
                aVar.g(5, this.rLz);
            }
            aVar.fT(6, this.rLA);
            aVar.d(7, 8, this.rLB);
            if (this.rLC != null) {
                aVar.g(8, this.rLC);
            }
            aVar.fT(9, this.rLD);
            if (this.rLE != null) {
                aVar.g(10, this.rLE);
            }
            aVar.fT(11, this.rLF);
            if (this.rLG == null) {
                return 0;
            }
            aVar.fV(12, this.rLG.boi());
            this.rLG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rLw);
            if (this.rLx != null) {
                fS += f.a.a.b.b.a.h(3, this.rLx);
            }
            fS += f.a.a.a.fQ(4, this.rLy);
            if (this.rLz != null) {
                fS += f.a.a.b.b.a.h(5, this.rLz);
            }
            fS = (fS + f.a.a.a.fQ(6, this.rLA)) + f.a.a.a.c(7, 8, this.rLB);
            if (this.rLC != null) {
                fS += f.a.a.b.b.a.h(8, this.rLC);
            }
            fS += f.a.a.a.fQ(9, this.rLD);
            if (this.rLE != null) {
                fS += f.a.a.b.b.a.h(10, this.rLE);
            }
            fS += f.a.a.a.fQ(11, this.rLF);
            if (this.rLG != null) {
                fS += f.a.a.a.fS(12, this.rLG.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rLB.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aiv aiv = (aiv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        aiv.six = flVar;
                    }
                    return 0;
                case 2:
                    aiv.rLw = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aiv.rLx = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aiv.rLy = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aiv.rLz = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aiv.rLA = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        aiv.rLB.add(bhz);
                    }
                    return 0;
                case 8:
                    aiv.rLC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aiv.rLD = aVar3.vHC.rY();
                    return 0;
                case 10:
                    aiv.rLE = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aiv.rLF = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        aiv.rLG = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
