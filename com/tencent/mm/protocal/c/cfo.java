package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class cfo extends a {
    public String iwP;
    public int otY;
    public bsg pKY;
    public String rDH;
    public aqs rUI;
    public int rjC;
    public long rll;
    public String rlo;
    public LinkedList<String> sAa = new LinkedList();
    public LinkedList<awg> sAb = new LinkedList();
    public b sAc;
    public b sAd;
    public boq sAe;
    public qv sAf;
    public bbb sAg;
    public int shN;
    public LinkedList<bxd> sjr = new LinkedList();
    public int syH;
    public int syI = 2;
    public String syL;
    public int szP;
    public LinkedList<ps> szQ = new LinkedList();
    public String szX;
    public String szY;
    public int szZ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rDH == null) {
                throw new f.a.a.b("Not all required fields were included: Keyword");
            }
            aVar.fT(1, this.shN);
            if (this.rDH != null) {
                aVar.g(2, this.rDH);
            }
            aVar.fT(3, this.rjC);
            aVar.T(4, this.rll);
            aVar.fT(5, this.syH);
            if (this.rUI != null) {
                aVar.fV(6, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.d(7, 8, this.sjr);
            aVar.fT(8, this.otY);
            if (this.rlo != null) {
                aVar.g(9, this.rlo);
            }
            aVar.fT(10, this.szP);
            if (this.szX != null) {
                aVar.g(11, this.szX);
            }
            if (this.szY != null) {
                aVar.g(12, this.szY);
            }
            aVar.fT(13, this.szZ);
            aVar.d(14, 1, this.sAa);
            aVar.fT(15, this.syI);
            if (this.pKY != null) {
                aVar.fV(16, this.pKY.boi());
                this.pKY.a(aVar);
            }
            aVar.d(17, 8, this.szQ);
            aVar.d(18, 8, this.sAb);
            if (this.iwP != null) {
                aVar.g(19, this.iwP);
            }
            if (this.sAc != null) {
                aVar.b(20, this.sAc);
            }
            if (this.syL != null) {
                aVar.g(21, this.syL);
            }
            if (this.sAd != null) {
                aVar.b(22, this.sAd);
            }
            if (this.sAe != null) {
                aVar.fV(23, this.sAe.boi());
                this.sAe.a(aVar);
            }
            if (this.sAf != null) {
                aVar.fV(24, this.sAf.boi());
                this.sAf.a(aVar);
            }
            if (this.sAg != null) {
                aVar.fV(25, this.sAg.boi());
                this.sAg.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.shN) + 0;
            if (this.rDH != null) {
                fQ += f.a.a.b.b.a.h(2, this.rDH);
            }
            fQ = ((fQ + f.a.a.a.fQ(3, this.rjC)) + f.a.a.a.S(4, this.rll)) + f.a.a.a.fQ(5, this.syH);
            if (this.rUI != null) {
                fQ += f.a.a.a.fS(6, this.rUI.boi());
            }
            fQ = (fQ + f.a.a.a.c(7, 8, this.sjr)) + f.a.a.a.fQ(8, this.otY);
            if (this.rlo != null) {
                fQ += f.a.a.b.b.a.h(9, this.rlo);
            }
            fQ += f.a.a.a.fQ(10, this.szP);
            if (this.szX != null) {
                fQ += f.a.a.b.b.a.h(11, this.szX);
            }
            if (this.szY != null) {
                fQ += f.a.a.b.b.a.h(12, this.szY);
            }
            fQ = ((fQ + f.a.a.a.fQ(13, this.szZ)) + f.a.a.a.c(14, 1, this.sAa)) + f.a.a.a.fQ(15, this.syI);
            if (this.pKY != null) {
                fQ += f.a.a.a.fS(16, this.pKY.boi());
            }
            fQ = (fQ + f.a.a.a.c(17, 8, this.szQ)) + f.a.a.a.c(18, 8, this.sAb);
            if (this.iwP != null) {
                fQ += f.a.a.b.b.a.h(19, this.iwP);
            }
            if (this.sAc != null) {
                fQ += f.a.a.a.a(20, this.sAc);
            }
            if (this.syL != null) {
                fQ += f.a.a.b.b.a.h(21, this.syL);
            }
            if (this.sAd != null) {
                fQ += f.a.a.a.a(22, this.sAd);
            }
            if (this.sAe != null) {
                fQ += f.a.a.a.fS(23, this.sAe.boi());
            }
            if (this.sAf != null) {
                fQ += f.a.a.a.fS(24, this.sAf.boi());
            }
            if (this.sAg != null) {
                return fQ + f.a.a.a.fS(25, this.sAg.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sjr.clear();
            this.sAa.clear();
            this.szQ.clear();
            this.sAb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rDH != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: Keyword");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfo cfo = (cfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cfo.shN = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cfo.rDH = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cfo.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cfo.rll = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    cfo.syH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        cfo.rUI = aqs;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bxd bxd = new bxd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxd.a(aVar4, bxd, a.a(aVar4))) {
                        }
                        cfo.sjr.add(bxd);
                    }
                    return 0;
                case 8:
                    cfo.otY = aVar3.vHC.rY();
                    return 0;
                case 9:
                    cfo.rlo = aVar3.vHC.readString();
                    return 0;
                case 10:
                    cfo.szP = aVar3.vHC.rY();
                    return 0;
                case 11:
                    cfo.szX = aVar3.vHC.readString();
                    return 0;
                case 12:
                    cfo.szY = aVar3.vHC.readString();
                    return 0;
                case 13:
                    cfo.szZ = aVar3.vHC.rY();
                    return 0;
                case 14:
                    cfo.sAa.add(aVar3.vHC.readString());
                    return 0;
                case 15:
                    cfo.syI = aVar3.vHC.rY();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsg bsg = new bsg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsg.a(aVar4, bsg, a.a(aVar4))) {
                        }
                        cfo.pKY = bsg;
                    }
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ps psVar = new ps();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = psVar.a(aVar4, psVar, a.a(aVar4))) {
                        }
                        cfo.szQ.add(psVar);
                    }
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        awg awg = new awg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awg.a(aVar4, awg, a.a(aVar4))) {
                        }
                        cfo.sAb.add(awg);
                    }
                    return 0;
                case 19:
                    cfo.iwP = aVar3.vHC.readString();
                    return 0;
                case 20:
                    cfo.sAc = aVar3.cJR();
                    return 0;
                case 21:
                    cfo.syL = aVar3.vHC.readString();
                    return 0;
                case 22:
                    cfo.sAd = aVar3.cJR();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boq boq = new boq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boq.a(aVar4, boq, a.a(aVar4))) {
                        }
                        cfo.sAe = boq;
                    }
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qv qvVar = new qv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qvVar.a(aVar4, qvVar, a.a(aVar4))) {
                        }
                        cfo.sAf = qvVar;
                    }
                    return 0;
                case 25:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbb bbb = new bbb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbb.a(aVar4, bbb, a.a(aVar4))) {
                        }
                        cfo.sAg = bbb;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
