package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ars extends a {
    public String eJG;
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
    public String rEJ;
    public String rTW;
    public va rTX;
    public bqd rTk;
    public qt rTl;
    public String rdS;
    public String rqZ;
    public String rra;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdS != null) {
                aVar.g(1, this.rdS);
            }
            if (this.rTW != null) {
                aVar.g(2, this.rTW);
            }
            if (this.eJG != null) {
                aVar.g(3, this.eJG);
            }
            aVar.fT(4, this.eJH);
            if (this.eJI != null) {
                aVar.g(5, this.eJI);
            }
            if (this.eJJ != null) {
                aVar.g(6, this.eJJ);
            }
            if (this.eJK != null) {
                aVar.g(7, this.eJK);
            }
            aVar.fT(8, this.eJL);
            if (this.eJM != null) {
                aVar.g(9, this.eJM);
            }
            if (this.rTX != null) {
                aVar.fV(10, this.rTX.boi());
                this.rTX.a(aVar);
            }
            aVar.fT(11, this.eJN);
            aVar.fT(12, this.eJO);
            if (this.eJP != null) {
                aVar.g(13, this.eJP);
            }
            if (this.rTk != null) {
                aVar.fV(14, this.rTk.boi());
                this.rTk.a(aVar);
            }
            if (this.eJQ != null) {
                aVar.g(15, this.eJQ);
            }
            if (this.eJR != null) {
                aVar.g(16, this.eJR);
            }
            if (this.rTl != null) {
                aVar.fV(17, this.rTl.boi());
                this.rTl.a(aVar);
            }
            if (this.rqZ != null) {
                aVar.g(20, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(21, this.rra);
            }
            if (this.rEJ == null) {
                return 0;
            }
            aVar.g(22, this.rEJ);
            return 0;
        } else if (i == 1) {
            if (this.rdS != null) {
                h = f.a.a.b.b.a.h(1, this.rdS) + 0;
            } else {
                h = 0;
            }
            if (this.rTW != null) {
                h += f.a.a.b.b.a.h(2, this.rTW);
            }
            if (this.eJG != null) {
                h += f.a.a.b.b.a.h(3, this.eJG);
            }
            h += f.a.a.a.fQ(4, this.eJH);
            if (this.eJI != null) {
                h += f.a.a.b.b.a.h(5, this.eJI);
            }
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(6, this.eJJ);
            }
            if (this.eJK != null) {
                h += f.a.a.b.b.a.h(7, this.eJK);
            }
            h += f.a.a.a.fQ(8, this.eJL);
            if (this.eJM != null) {
                h += f.a.a.b.b.a.h(9, this.eJM);
            }
            if (this.rTX != null) {
                h += f.a.a.a.fS(10, this.rTX.boi());
            }
            h = (h + f.a.a.a.fQ(11, this.eJN)) + f.a.a.a.fQ(12, this.eJO);
            if (this.eJP != null) {
                h += f.a.a.b.b.a.h(13, this.eJP);
            }
            if (this.rTk != null) {
                h += f.a.a.a.fS(14, this.rTk.boi());
            }
            if (this.eJQ != null) {
                h += f.a.a.b.b.a.h(15, this.eJQ);
            }
            if (this.eJR != null) {
                h += f.a.a.b.b.a.h(16, this.eJR);
            }
            if (this.rTl != null) {
                h += f.a.a.a.fS(17, this.rTl.boi());
            }
            if (this.rqZ != null) {
                h += f.a.a.b.b.a.h(20, this.rqZ);
            }
            if (this.rra != null) {
                h += f.a.a.b.b.a.h(21, this.rra);
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(22, this.rEJ);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ars ars = (ars) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ars.rdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ars.rTW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ars.eJG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ars.eJH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ars.eJI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ars.eJJ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ars.eJK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ars.eJL = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ars.eJM = aVar3.vHC.readString();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        va vaVar = new va();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vaVar.a(aVar4, vaVar, a.a(aVar4))) {
                        }
                        ars.rTX = vaVar;
                    }
                    return 0;
                case 11:
                    ars.eJN = aVar3.vHC.rY();
                    return 0;
                case 12:
                    ars.eJO = aVar3.vHC.rY();
                    return 0;
                case 13:
                    ars.eJP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        ars.rTk = bqd;
                    }
                    return 0;
                case 15:
                    ars.eJQ = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ars.eJR = aVar3.vHC.readString();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        ars.rTl = qtVar;
                    }
                    return 0;
                case 20:
                    ars.rqZ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    ars.rra = aVar3.vHC.readString();
                    return 0;
                case 22:
                    ars.rEJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
