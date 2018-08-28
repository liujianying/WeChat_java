package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bcv extends a {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public int eJL;
    public String eJM;
    public int eJN;
    public int eJO;
    public String eJP;
    public String eJQ;
    public String eJR;
    public String hbL;
    public String hcS;
    public String rEJ;
    public bqd rTk;
    public qt rTl;
    public String rqZ;
    public String rra;
    public int seY;
    public String seZ;
    public int sfa;
    public String sfb;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.seY);
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(3, this.hcS);
            }
            if (this.seZ != null) {
                aVar.g(4, this.seZ);
            }
            aVar.fT(5, this.sfa);
            if (this.sfb != null) {
                aVar.g(6, this.sfb);
            }
            aVar.fT(7, this.eJH);
            if (this.eJI != null) {
                aVar.g(8, this.eJI);
            }
            if (this.eJJ != null) {
                aVar.g(9, this.eJJ);
            }
            if (this.eJK != null) {
                aVar.g(10, this.eJK);
            }
            aVar.fT(11, this.eJL);
            if (this.eJM != null) {
                aVar.g(12, this.eJM);
            }
            aVar.fT(13, this.eJN);
            aVar.fT(14, this.eJO);
            if (this.eJP != null) {
                aVar.g(15, this.eJP);
            }
            if (this.rTk != null) {
                aVar.fV(16, this.rTk.boi());
                this.rTk.a(aVar);
            }
            if (this.eJQ != null) {
                aVar.g(17, this.eJQ);
            }
            if (this.eJR != null) {
                aVar.g(18, this.eJR);
            }
            if (this.rTl != null) {
                aVar.fV(19, this.rTl.boi());
                this.rTl.a(aVar);
            }
            if (this.rqZ != null) {
                aVar.g(20, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(21, this.rra);
            }
            if (this.rEJ != null) {
                aVar.g(22, this.rEJ);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.seY) + 0;
            if (this.hbL != null) {
                fQ += f.a.a.b.b.a.h(2, this.hbL);
            }
            if (this.hcS != null) {
                fQ += f.a.a.b.b.a.h(3, this.hcS);
            }
            if (this.seZ != null) {
                fQ += f.a.a.b.b.a.h(4, this.seZ);
            }
            fQ += f.a.a.a.fQ(5, this.sfa);
            if (this.sfb != null) {
                fQ += f.a.a.b.b.a.h(6, this.sfb);
            }
            fQ += f.a.a.a.fQ(7, this.eJH);
            if (this.eJI != null) {
                fQ += f.a.a.b.b.a.h(8, this.eJI);
            }
            if (this.eJJ != null) {
                fQ += f.a.a.b.b.a.h(9, this.eJJ);
            }
            if (this.eJK != null) {
                fQ += f.a.a.b.b.a.h(10, this.eJK);
            }
            fQ += f.a.a.a.fQ(11, this.eJL);
            if (this.eJM != null) {
                fQ += f.a.a.b.b.a.h(12, this.eJM);
            }
            fQ = (fQ + f.a.a.a.fQ(13, this.eJN)) + f.a.a.a.fQ(14, this.eJO);
            if (this.eJP != null) {
                fQ += f.a.a.b.b.a.h(15, this.eJP);
            }
            if (this.rTk != null) {
                fQ += f.a.a.a.fS(16, this.rTk.boi());
            }
            if (this.eJQ != null) {
                fQ += f.a.a.b.b.a.h(17, this.eJQ);
            }
            if (this.eJR != null) {
                fQ += f.a.a.b.b.a.h(18, this.eJR);
            }
            if (this.rTl != null) {
                fQ += f.a.a.a.fS(19, this.rTl.boi());
            }
            if (this.rqZ != null) {
                fQ += f.a.a.b.b.a.h(20, this.rqZ);
            }
            if (this.rra != null) {
                fQ += f.a.a.b.b.a.h(21, this.rra);
            }
            if (this.rEJ != null) {
                return fQ + f.a.a.b.b.a.h(22, this.rEJ);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bcv bcv = (bcv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bcv.seY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bcv.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bcv.hcS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bcv.seZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bcv.sfa = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bcv.sfb = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bcv.eJH = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bcv.eJI = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bcv.eJJ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bcv.eJK = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bcv.eJL = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bcv.eJM = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bcv.eJN = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bcv.eJO = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bcv.eJP = aVar3.vHC.readString();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        bcv.rTk = bqd;
                    }
                    return 0;
                case 17:
                    bcv.eJQ = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bcv.eJR = aVar3.vHC.readString();
                    return 0;
                case 19:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        bcv.rTl = qtVar;
                    }
                    return 0;
                case 20:
                    bcv.rqZ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bcv.rra = aVar3.vHC.readString();
                    return 0;
                case 22:
                    bcv.rEJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
