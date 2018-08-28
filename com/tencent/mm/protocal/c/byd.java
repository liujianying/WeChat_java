package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class byd extends bhd {
    public String rKZ;
    public bhy rTr;
    public int rfe;
    public int suj;
    public LinkedList<byb> suk = new LinkedList();
    public int sul;
    public LinkedList<Integer> sum = new LinkedList();
    public int sun;
    public LinkedList<byc> suo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rfe);
            aVar.fT(3, this.suj);
            aVar.d(4, 8, this.suk);
            if (this.rKZ != null) {
                aVar.g(5, this.rKZ);
            }
            aVar.fT(6, this.sul);
            aVar.c(7, this.sum);
            aVar.fT(8, this.sun);
            aVar.d(9, 8, this.suo);
            if (this.rTr == null) {
                return 0;
            }
            aVar.fV(10, this.rTr.boi());
            this.rTr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.rfe)) + f.a.a.a.fQ(3, this.suj)) + f.a.a.a.c(4, 8, this.suk);
            if (this.rKZ != null) {
                fS += f.a.a.b.b.a.h(5, this.rKZ);
            }
            fS = (((fS + f.a.a.a.fQ(6, this.sul)) + f.a.a.a.b(7, this.sum)) + f.a.a.a.fQ(8, this.sun)) + f.a.a.a.c(9, 8, this.suo);
            if (this.rTr != null) {
                fS += f.a.a.a.fS(10, this.rTr.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.suk.clear();
            this.sum.clear();
            this.suo.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            byd byd = (byd) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        byd.shX = fkVar;
                    }
                    return 0;
                case 2:
                    byd.rfe = aVar3.vHC.rY();
                    return 0;
                case 3:
                    byd.suj = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byb byb = new byb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byb.a(aVar4, byb, bhd.a(aVar4))) {
                        }
                        byd.suk.add(byb);
                    }
                    return 0;
                case 5:
                    byd.rKZ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    byd.sul = aVar3.vHC.rY();
                    return 0;
                case 7:
                    byd.sum = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 8:
                    byd.sun = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byc byc = new byc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byc.a(aVar4, byc, bhd.a(aVar4))) {
                        }
                        byd.suo.add(byc);
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        byd.rTr = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
