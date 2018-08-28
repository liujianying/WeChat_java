package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bmt extends bhd {
    public int cae;
    public LinkedList<bmv> dzs = new LinkedList();
    public bqs qZR;
    public String rGk;
    public int skX;
    public String skY;
    public bnk skZ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.skX);
            aVar.d(3, 8, this.dzs);
            if (this.skY != null) {
                aVar.g(4, this.skY);
            }
            if (this.rGk != null) {
                aVar.g(5, this.rGk);
            }
            if (this.skZ != null) {
                aVar.fV(6, this.skZ.boi());
                this.skZ.a(aVar);
            }
            aVar.fT(7, this.cae);
            if (this.qZR == null) {
                return 0;
            }
            aVar.fV(8, this.qZR.boi());
            this.qZR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.skX)) + f.a.a.a.c(3, 8, this.dzs);
            if (this.skY != null) {
                fS += f.a.a.b.b.a.h(4, this.skY);
            }
            if (this.rGk != null) {
                fS += f.a.a.b.b.a.h(5, this.rGk);
            }
            if (this.skZ != null) {
                fS += f.a.a.a.fS(6, this.skZ.boi());
            }
            fS += f.a.a.a.fQ(7, this.cae);
            if (this.qZR != null) {
                fS += f.a.a.a.fS(8, this.qZR.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.dzs.clear();
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
            bmt bmt = (bmt) objArr[1];
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
                        bmt.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bmt.skX = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bmv bmv = new bmv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmv.a(aVar4, bmv, bhd.a(aVar4))) {
                        }
                        bmt.dzs.add(bmv);
                    }
                    return 0;
                case 4:
                    bmt.skY = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bmt.rGk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnk bnk = new bnk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnk.a(aVar4, bnk, bhd.a(aVar4))) {
                        }
                        bmt.skZ = bnk;
                    }
                    return 0;
                case 7:
                    bmt.cae = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqs bqs = new bqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqs.a(aVar4, bqs, bhd.a(aVar4))) {
                        }
                        bmt.qZR = bqs;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
