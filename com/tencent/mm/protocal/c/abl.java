package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class abl extends bhd {
    public int cae;
    public String qZN;
    public String qZO;
    public int qZP;
    public LinkedList<ky> qZS = new LinkedList();
    public String rGk;
    public String rGl;
    public String rcN;
    public String sign;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.d(2, 8, this.qZS);
            aVar.fT(3, this.cae);
            if (this.rGl != null) {
                aVar.g(4, this.rGl);
            }
            if (this.rcN != null) {
                aVar.g(5, this.rcN);
            }
            if (this.sign != null) {
                aVar.g(6, this.sign);
            }
            if (this.qZN != null) {
                aVar.g(7, this.qZN);
            }
            if (this.qZO != null) {
                aVar.g(8, this.qZO);
            }
            if (this.rGk != null) {
                aVar.g(9, this.rGk);
            }
            aVar.fT(10, this.qZP);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.c(2, 8, this.qZS)) + f.a.a.a.fQ(3, this.cae);
            if (this.rGl != null) {
                fS += f.a.a.b.b.a.h(4, this.rGl);
            }
            if (this.rcN != null) {
                fS += f.a.a.b.b.a.h(5, this.rcN);
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(6, this.sign);
            }
            if (this.qZN != null) {
                fS += f.a.a.b.b.a.h(7, this.qZN);
            }
            if (this.qZO != null) {
                fS += f.a.a.b.b.a.h(8, this.qZO);
            }
            if (this.rGk != null) {
                fS += f.a.a.b.b.a.h(9, this.rGk);
            }
            return fS + f.a.a.a.fQ(10, this.qZP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qZS.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            abl abl = (abl) objArr[1];
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
                        com.tencent.mm.bk.a fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        abl.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ky kyVar = new ky();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kyVar.a(aVar4, kyVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        abl.qZS.add(kyVar);
                    }
                    return 0;
                case 3:
                    abl.cae = aVar3.vHC.rY();
                    return 0;
                case 4:
                    abl.rGl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    abl.rcN = aVar3.vHC.readString();
                    return 0;
                case 6:
                    abl.sign = aVar3.vHC.readString();
                    return 0;
                case 7:
                    abl.qZN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    abl.qZO = aVar3.vHC.readString();
                    return 0;
                case 9:
                    abl.rGk = aVar3.vHC.readString();
                    return 0;
                case 10:
                    abl.qZP = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
