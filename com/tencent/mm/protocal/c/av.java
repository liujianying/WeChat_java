package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class av extends a {
    public int hcE;
    public String jPK;
    public int otY;
    public String raP;
    public String raQ;
    public String raR;
    public at raS;
    public String raT;
    public ct raU;
    public de raV;
    public dd raW;
    public dd raX;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            if (this.jPK != null) {
                aVar.g(2, this.jPK);
            }
            aVar.fT(3, this.otY);
            if (this.raP != null) {
                aVar.g(4, this.raP);
            }
            if (this.raQ != null) {
                aVar.g(5, this.raQ);
            }
            if (this.raR != null) {
                aVar.g(6, this.raR);
            }
            if (this.raS != null) {
                aVar.fV(7, this.raS.boi());
                this.raS.a(aVar);
            }
            if (this.raT != null) {
                aVar.g(8, this.raT);
            }
            if (this.raU != null) {
                aVar.fV(9, this.raU.boi());
                this.raU.a(aVar);
            }
            if (this.raV != null) {
                aVar.fV(10, this.raV.boi());
                this.raV.a(aVar);
            }
            if (this.raW != null) {
                aVar.fV(11, this.raW.boi());
                this.raW.a(aVar);
            }
            if (this.raX != null) {
                aVar.fV(12, this.raX.boi());
                this.raX.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.jPK != null) {
                fQ += f.a.a.b.b.a.h(2, this.jPK);
            }
            fQ += f.a.a.a.fQ(3, this.otY);
            if (this.raP != null) {
                fQ += f.a.a.b.b.a.h(4, this.raP);
            }
            if (this.raQ != null) {
                fQ += f.a.a.b.b.a.h(5, this.raQ);
            }
            if (this.raR != null) {
                fQ += f.a.a.b.b.a.h(6, this.raR);
            }
            if (this.raS != null) {
                fQ += f.a.a.a.fS(7, this.raS.boi());
            }
            if (this.raT != null) {
                fQ += f.a.a.b.b.a.h(8, this.raT);
            }
            if (this.raU != null) {
                fQ += f.a.a.a.fS(9, this.raU.boi());
            }
            if (this.raV != null) {
                fQ += f.a.a.a.fS(10, this.raV.boi());
            }
            if (this.raW != null) {
                fQ += f.a.a.a.fS(11, this.raW.boi());
            }
            if (this.raX != null) {
                return fQ + f.a.a.a.fS(12, this.raX.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            dd ddVar;
            switch (intValue) {
                case 1:
                    avVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    avVar.jPK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    avVar.otY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    avVar.raP = aVar3.vHC.readString();
                    return 0;
                case 5:
                    avVar.raQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    avVar.raR = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        at atVar = new at();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.a(aVar4, atVar, a.a(aVar4))) {
                        }
                        avVar.raS = atVar;
                    }
                    return 0;
                case 8:
                    avVar.raT = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ct ctVar = new ct();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ctVar.a(aVar4, ctVar, a.a(aVar4))) {
                        }
                        avVar.raU = ctVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        de deVar = new de();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = deVar.a(aVar4, deVar, a.a(aVar4))) {
                        }
                        avVar.raV = deVar;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ddVar = new dd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        avVar.raW = ddVar;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ddVar = new dd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        avVar.raX = ddVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
