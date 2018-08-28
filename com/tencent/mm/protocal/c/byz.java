package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class byz extends bhd {
    public int rth;
    public int rxG;
    public long rxH;
    public String seC;
    public cak suK;
    public cak suL;
    public long suO;
    public int suY;
    public int suZ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.seC != null) {
                aVar.g(2, this.seC);
            }
            aVar.fT(3, this.rxG);
            aVar.fT(4, this.suY);
            if (this.suK != null) {
                aVar.fV(5, this.suK.boi());
                this.suK.a(aVar);
            }
            if (this.suL != null) {
                aVar.fV(6, this.suL.boi());
                this.suL.a(aVar);
            }
            aVar.T(7, this.rxH);
            aVar.fT(8, this.rth);
            aVar.T(9, this.suO);
            aVar.fT(10, this.suZ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.seC != null) {
                fS += f.a.a.b.b.a.h(2, this.seC);
            }
            fS = (fS + f.a.a.a.fQ(3, this.rxG)) + f.a.a.a.fQ(4, this.suY);
            if (this.suK != null) {
                fS += f.a.a.a.fS(5, this.suK.boi());
            }
            if (this.suL != null) {
                fS += f.a.a.a.fS(6, this.suL.boi());
            }
            return (((fS + f.a.a.a.S(7, this.rxH)) + f.a.a.a.fQ(8, this.rth)) + f.a.a.a.S(9, this.suO)) + f.a.a.a.fQ(10, this.suZ);
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
            byz byz = (byz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            cak cak;
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
                        byz.shX = fkVar;
                    }
                    return 0;
                case 2:
                    byz.seC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    byz.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    byz.suY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, bhd.a(aVar4))) {
                        }
                        byz.suK = cak;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, bhd.a(aVar4))) {
                        }
                        byz.suL = cak;
                    }
                    return 0;
                case 7:
                    byz.rxH = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    byz.rth = aVar3.vHC.rY();
                    return 0;
                case 9:
                    byz.suO = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    byz.suZ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
