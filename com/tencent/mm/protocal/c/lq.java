package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class lq extends bhd {
    public int amount;
    public int bVU;
    public int mwQ;
    public String mye;
    public String myf;
    public String rcD;
    public String rcE;
    public String rpL;
    public String rpM;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rcD != null) {
                aVar.g(2, this.rcD);
            }
            if (this.rcE != null) {
                aVar.g(3, this.rcE);
            }
            aVar.fT(4, this.amount);
            if (this.myf != null) {
                aVar.g(5, this.myf);
            }
            if (this.mye != null) {
                aVar.g(6, this.mye);
            }
            aVar.fT(7, this.bVU);
            aVar.fT(8, this.mwQ);
            if (this.rpL != null) {
                aVar.g(9, this.rpL);
            }
            if (this.rpM == null) {
                return 0;
            }
            aVar.g(10, this.rpM);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcD != null) {
                fS += f.a.a.b.b.a.h(2, this.rcD);
            }
            if (this.rcE != null) {
                fS += f.a.a.b.b.a.h(3, this.rcE);
            }
            fS += f.a.a.a.fQ(4, this.amount);
            if (this.myf != null) {
                fS += f.a.a.b.b.a.h(5, this.myf);
            }
            if (this.mye != null) {
                fS += f.a.a.b.b.a.h(6, this.mye);
            }
            fS = (fS + f.a.a.a.fQ(7, this.bVU)) + f.a.a.a.fQ(8, this.mwQ);
            if (this.rpL != null) {
                fS += f.a.a.b.b.a.h(9, this.rpL);
            }
            if (this.rpM != null) {
                fS += f.a.a.b.b.a.h(10, this.rpM);
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
            lq lqVar = (lq) objArr[1];
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
                        lqVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    lqVar.rcD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    lqVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    lqVar.amount = aVar3.vHC.rY();
                    return 0;
                case 5:
                    lqVar.myf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    lqVar.mye = aVar3.vHC.readString();
                    return 0;
                case 7:
                    lqVar.bVU = aVar3.vHC.rY();
                    return 0;
                case 8:
                    lqVar.mwQ = aVar3.vHC.rY();
                    return 0;
                case 9:
                    lqVar.rpL = aVar3.vHC.readString();
                    return 0;
                case 10:
                    lqVar.rpM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
