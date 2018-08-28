package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class aqq extends a {
    public String bHD;
    public int hcE;
    public String lCG;
    public float lCH;
    public int lCI;
    public LinkedList<Integer> lCJ = new LinkedList();
    public int lCK;
    public LinkedList<bhz> lCL = new LinkedList();
    public float lCM;
    public String lCN;
    public bhy lCO;
    public String rTm;
    public bhy rTn;
    public int rTo;
    public int rTp;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lCG != null) {
                aVar.g(1, this.lCG);
            }
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            aVar.l(3, this.lCH);
            aVar.fT(4, this.lCI);
            aVar.c(5, this.lCJ);
            aVar.fT(6, this.lCK);
            aVar.d(7, 8, this.lCL);
            aVar.l(8, this.lCM);
            if (this.lCN != null) {
                aVar.g(9, this.lCN);
            }
            aVar.fT(10, this.hcE);
            if (this.lCO != null) {
                aVar.fV(11, this.lCO.boi());
                this.lCO.a(aVar);
            }
            if (this.rTm != null) {
                aVar.g(12, this.rTm);
            }
            if (this.rTn != null) {
                aVar.fV(13, this.rTn.boi());
                this.rTn.a(aVar);
            }
            aVar.fT(14, this.rTo);
            aVar.fT(15, this.rTp);
            return 0;
        } else if (i == 1) {
            if (this.lCG != null) {
                h = f.a.a.b.b.a.h(1, this.lCG) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            h = (((((h + (f.a.a.b.b.a.ec(3) + 4)) + f.a.a.a.fQ(4, this.lCI)) + f.a.a.a.b(5, this.lCJ)) + f.a.a.a.fQ(6, this.lCK)) + f.a.a.a.c(7, 8, this.lCL)) + (f.a.a.b.b.a.ec(8) + 4);
            if (this.lCN != null) {
                h += f.a.a.b.b.a.h(9, this.lCN);
            }
            h += f.a.a.a.fQ(10, this.hcE);
            if (this.lCO != null) {
                h += f.a.a.a.fS(11, this.lCO.boi());
            }
            if (this.rTm != null) {
                h += f.a.a.b.b.a.h(12, this.rTm);
            }
            if (this.rTn != null) {
                h += f.a.a.a.fS(13, this.rTn.boi());
            }
            return (h + f.a.a.a.fQ(14, this.rTo)) + f.a.a.a.fQ(15, this.rTp);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.lCJ.clear();
            this.lCL.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aqq aqq = (aqq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            switch (intValue) {
                case 1:
                    aqq.lCG = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aqq.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aqq.lCH = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    aqq.lCI = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aqq.lCJ = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 6:
                    aqq.lCK = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aqq.lCL.add(bhz);
                    }
                    return 0;
                case 8:
                    aqq.lCM = aVar3.vHC.readFloat();
                    return 0;
                case 9:
                    aqq.lCN = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aqq.hcE = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        aqq.lCO = bhy;
                    }
                    return 0;
                case 12:
                    aqq.rTm = aVar3.vHC.readString();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        aqq.rTn = bhy;
                    }
                    return 0;
                case 14:
                    aqq.rTo = aVar3.vHC.rY();
                    return 0;
                case 15:
                    aqq.rTp = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
