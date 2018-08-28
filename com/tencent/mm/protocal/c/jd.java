package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class jd extends bhd {
    public int amount;
    public int bVU;
    public int mwQ;
    public String mwR;
    public String mwS;
    public String myi;
    public String myl;
    public String rcH;
    public String rky;
    public int rkz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.amount);
            aVar.fT(3, this.bVU);
            aVar.fT(4, this.mwQ);
            if (this.rky != null) {
                aVar.g(5, this.rky);
            }
            if (this.myi != null) {
                aVar.g(6, this.myi);
            }
            if (this.mwR != null) {
                aVar.g(7, this.mwR);
            }
            if (this.myl != null) {
                aVar.g(8, this.myl);
            }
            if (this.rcH != null) {
                aVar.g(9, this.rcH);
            }
            if (this.mwS != null) {
                aVar.g(10, this.mwS);
            }
            aVar.fT(11, this.rkz);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.amount)) + f.a.a.a.fQ(3, this.bVU)) + f.a.a.a.fQ(4, this.mwQ);
            if (this.rky != null) {
                fS += f.a.a.b.b.a.h(5, this.rky);
            }
            if (this.myi != null) {
                fS += f.a.a.b.b.a.h(6, this.myi);
            }
            if (this.mwR != null) {
                fS += f.a.a.b.b.a.h(7, this.mwR);
            }
            if (this.myl != null) {
                fS += f.a.a.b.b.a.h(8, this.myl);
            }
            if (this.rcH != null) {
                fS += f.a.a.b.b.a.h(9, this.rcH);
            }
            if (this.mwS != null) {
                fS += f.a.a.b.b.a.h(10, this.mwS);
            }
            return fS + f.a.a.a.fQ(11, this.rkz);
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
            jd jdVar = (jd) objArr[1];
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
                        jdVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    jdVar.amount = aVar3.vHC.rY();
                    return 0;
                case 3:
                    jdVar.bVU = aVar3.vHC.rY();
                    return 0;
                case 4:
                    jdVar.mwQ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    jdVar.rky = aVar3.vHC.readString();
                    return 0;
                case 6:
                    jdVar.myi = aVar3.vHC.readString();
                    return 0;
                case 7:
                    jdVar.mwR = aVar3.vHC.readString();
                    return 0;
                case 8:
                    jdVar.myl = aVar3.vHC.readString();
                    return 0;
                case 9:
                    jdVar.rcH = aVar3.vHC.readString();
                    return 0;
                case 10:
                    jdVar.mwS = aVar3.vHC.readString();
                    return 0;
                case 11:
                    jdVar.rkz = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
