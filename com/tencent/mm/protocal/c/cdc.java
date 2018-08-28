package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cdc extends bhd {
    public int hcE;
    public String rHk;
    public int rjC;
    public String rlo;
    public int sdX;
    public int syH;
    public int syI = 2;
    public double syJ;
    public double syK;
    public String syL;
    public String syM;
    public String syN;
    public String syO;
    public int syP;
    public String syQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rHk != null) {
                aVar.g(2, this.rHk);
            }
            aVar.fT(3, this.rjC);
            aVar.fT(4, this.syH);
            if (this.rlo != null) {
                aVar.g(5, this.rlo);
            }
            aVar.fT(6, this.syI);
            aVar.c(7, this.syJ);
            aVar.c(8, this.syK);
            aVar.fT(9, this.hcE);
            aVar.fT(10, this.sdX);
            if (this.syL != null) {
                aVar.g(99, this.syL);
            }
            if (this.syM != null) {
                aVar.g(100, this.syM);
            }
            if (this.syN != null) {
                aVar.g(101, this.syN);
            }
            if (this.syO != null) {
                aVar.g(102, this.syO);
            }
            aVar.fT(103, this.syP);
            if (this.syQ == null) {
                return 0;
            }
            aVar.g(104, this.syQ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rHk != null) {
                fS += f.a.a.b.b.a.h(2, this.rHk);
            }
            fS = (fS + f.a.a.a.fQ(3, this.rjC)) + f.a.a.a.fQ(4, this.syH);
            if (this.rlo != null) {
                fS += f.a.a.b.b.a.h(5, this.rlo);
            }
            fS = ((((fS + f.a.a.a.fQ(6, this.syI)) + (f.a.a.b.b.a.ec(7) + 8)) + (f.a.a.b.b.a.ec(8) + 8)) + f.a.a.a.fQ(9, this.hcE)) + f.a.a.a.fQ(10, this.sdX);
            if (this.syL != null) {
                fS += f.a.a.b.b.a.h(99, this.syL);
            }
            if (this.syM != null) {
                fS += f.a.a.b.b.a.h(100, this.syM);
            }
            if (this.syN != null) {
                fS += f.a.a.b.b.a.h(101, this.syN);
            }
            if (this.syO != null) {
                fS += f.a.a.b.b.a.h(102, this.syO);
            }
            fS += f.a.a.a.fQ(103, this.syP);
            if (this.syQ != null) {
                fS += f.a.a.b.b.a.h(104, this.syQ);
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
            cdc cdc = (cdc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        cdc.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cdc.rHk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cdc.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cdc.syH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cdc.rlo = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cdc.syI = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cdc.syJ = aVar3.vHC.readDouble();
                    return 0;
                case 8:
                    cdc.syK = aVar3.vHC.readDouble();
                    return 0;
                case 9:
                    cdc.hcE = aVar3.vHC.rY();
                    return 0;
                case 10:
                    cdc.sdX = aVar3.vHC.rY();
                    return 0;
                case 99:
                    cdc.syL = aVar3.vHC.readString();
                    return 0;
                case 100:
                    cdc.syM = aVar3.vHC.readString();
                    return 0;
                case 101:
                    cdc.syN = aVar3.vHC.readString();
                    return 0;
                case 102:
                    cdc.syO = aVar3.vHC.readString();
                    return 0;
                case 103:
                    cdc.syP = aVar3.vHC.rY();
                    return 0;
                case 104:
                    cdc.syQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
