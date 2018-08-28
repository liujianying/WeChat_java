package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class sm extends bhd {
    public String hbL;
    public int hcE;
    public String jQb;
    public long rcq;
    public int rdV;
    public int rdW;
    public int rdX;
    public int rdn;
    public String rvP;
    public String rvQ;
    public int rvR;
    public int rvS;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            aVar.fT(3, this.rdn);
            if (this.rvP != null) {
                aVar.g(4, this.rvP);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            aVar.fT(6, this.rdV);
            aVar.fT(7, this.rdW);
            aVar.fT(8, this.rdX);
            if (this.rvQ != null) {
                aVar.g(9, this.rvQ);
            }
            aVar.fT(10, this.rvR);
            aVar.fT(11, this.hcE);
            aVar.fT(12, this.rvS);
            aVar.T(13, this.rcq);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            fS += f.a.a.a.fQ(3, this.rdn);
            if (this.rvP != null) {
                fS += f.a.a.b.b.a.h(4, this.rvP);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(5, this.hbL);
            }
            fS = ((fS + f.a.a.a.fQ(6, this.rdV)) + f.a.a.a.fQ(7, this.rdW)) + f.a.a.a.fQ(8, this.rdX);
            if (this.rvQ != null) {
                fS += f.a.a.b.b.a.h(9, this.rvQ);
            }
            return (((fS + f.a.a.a.fQ(10, this.rvR)) + f.a.a.a.fQ(11, this.hcE)) + f.a.a.a.fQ(12, this.rvS)) + f.a.a.a.S(13, this.rcq);
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
            sm smVar = (sm) objArr[1];
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
                        smVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    smVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    smVar.rdn = aVar3.vHC.rY();
                    return 0;
                case 4:
                    smVar.rvP = aVar3.vHC.readString();
                    return 0;
                case 5:
                    smVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    smVar.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    smVar.rdW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    smVar.rdX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    smVar.rvQ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    smVar.rvR = aVar3.vHC.rY();
                    return 0;
                case 11:
                    smVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 12:
                    smVar.rvS = aVar3.vHC.rY();
                    return 0;
                case 13:
                    smVar.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
