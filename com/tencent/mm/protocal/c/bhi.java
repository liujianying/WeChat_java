package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bhi extends a {
    public int qCh;
    public int rIr;
    public int rPB;
    public int rlY;
    public int sdX;
    public bhl sih;
    public bhk sii;
    public int sij;
    public String sik;
    public int sil;
    public int sim;
    public int sin;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sik == null) {
                throw new b("Not all required fields were included: SampleId");
            }
            aVar.fT(1, this.sdX);
            if (this.sih != null) {
                aVar.fV(2, this.sih.boi());
                this.sih.a(aVar);
            }
            if (this.sii != null) {
                aVar.fV(3, this.sii.boi());
                this.sii.a(aVar);
            }
            aVar.fT(4, this.rIr);
            aVar.fT(5, this.sij);
            if (this.sik != null) {
                aVar.g(6, this.sik);
            }
            aVar.fT(7, this.rlY);
            aVar.fT(8, this.sil);
            aVar.fT(9, this.qCh);
            aVar.fT(10, this.sim);
            aVar.fT(11, this.sin);
            aVar.fT(12, this.rPB);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.sdX) + 0;
            if (this.sih != null) {
                fQ += f.a.a.a.fS(2, this.sih.boi());
            }
            if (this.sii != null) {
                fQ += f.a.a.a.fS(3, this.sii.boi());
            }
            fQ = (fQ + f.a.a.a.fQ(4, this.rIr)) + f.a.a.a.fQ(5, this.sij);
            if (this.sik != null) {
                fQ += f.a.a.b.b.a.h(6, this.sik);
            }
            return (((((fQ + f.a.a.a.fQ(7, this.rlY)) + f.a.a.a.fQ(8, this.sil)) + f.a.a.a.fQ(9, this.qCh)) + f.a.a.a.fQ(10, this.sim)) + f.a.a.a.fQ(11, this.sin)) + f.a.a.a.fQ(12, this.rPB);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.sik != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SampleId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhi bhi = (bhi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bhi.sdX = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhl bhl = new bhl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhl.a(aVar4, bhl, a.a(aVar4))) {
                        }
                        bhi.sih = bhl;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhk bhk = new bhk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhk.a(aVar4, bhk, a.a(aVar4))) {
                        }
                        bhi.sii = bhk;
                    }
                    return 0;
                case 4:
                    bhi.rIr = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bhi.sij = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bhi.sik = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bhi.rlY = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bhi.sil = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bhi.qCh = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bhi.sim = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bhi.sin = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bhi.rPB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
