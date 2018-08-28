package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ako extends bhp {
    public String bSc;
    public int gTo;
    public String rNg;
    public String rNi;
    public int rNj;
    public LinkedList<avr> rNk = new LinkedList();
    public int rNl;
    public String rNm;
    public String rNn;
    public int rNo;
    public String rNp;
    public String rNq;
    public String rNr;
    public int rNs;
    public int rNt;
    public avr rNu;
    public cgh rrI;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.rrI != null) {
                aVar.fV(2, this.rrI.boi());
                this.rrI.a(aVar);
            }
            if (this.rNi != null) {
                aVar.g(3, this.rNi);
            }
            aVar.fT(4, this.rNj);
            aVar.fT(5, this.gTo);
            if (this.rNg != null) {
                aVar.g(6, this.rNg);
            }
            aVar.d(7, 8, this.rNk);
            aVar.fT(8, this.rNl);
            if (this.rNm != null) {
                aVar.g(9, this.rNm);
            }
            if (this.rNn != null) {
                aVar.g(10, this.rNn);
            }
            aVar.fT(11, this.rNo);
            if (this.bSc != null) {
                aVar.g(12, this.bSc);
            }
            if (this.rNp != null) {
                aVar.g(13, this.rNp);
            }
            if (this.rNq != null) {
                aVar.g(14, this.rNq);
            }
            if (this.rNr != null) {
                aVar.g(15, this.rNr);
            }
            aVar.fT(16, this.rNs);
            aVar.fT(17, this.rNt);
            if (this.rNu == null) {
                return 0;
            }
            aVar.fV(18, this.rNu.boi());
            this.rNu.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rrI != null) {
                fS += f.a.a.a.fS(2, this.rrI.boi());
            }
            if (this.rNi != null) {
                fS += f.a.a.b.b.a.h(3, this.rNi);
            }
            fS = (fS + f.a.a.a.fQ(4, this.rNj)) + f.a.a.a.fQ(5, this.gTo);
            if (this.rNg != null) {
                fS += f.a.a.b.b.a.h(6, this.rNg);
            }
            fS = (fS + f.a.a.a.c(7, 8, this.rNk)) + f.a.a.a.fQ(8, this.rNl);
            if (this.rNm != null) {
                fS += f.a.a.b.b.a.h(9, this.rNm);
            }
            if (this.rNn != null) {
                fS += f.a.a.b.b.a.h(10, this.rNn);
            }
            fS += f.a.a.a.fQ(11, this.rNo);
            if (this.bSc != null) {
                fS += f.a.a.b.b.a.h(12, this.bSc);
            }
            if (this.rNp != null) {
                fS += f.a.a.b.b.a.h(13, this.rNp);
            }
            if (this.rNq != null) {
                fS += f.a.a.b.b.a.h(14, this.rNq);
            }
            if (this.rNr != null) {
                fS += f.a.a.b.b.a.h(15, this.rNr);
            }
            fS = (fS + f.a.a.a.fQ(16, this.rNs)) + f.a.a.a.fQ(17, this.rNt);
            if (this.rNu != null) {
                fS += f.a.a.a.fS(18, this.rNu.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rNk.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ako ako = (ako) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            avr avr;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ako.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cgh cgh = new cgh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgh.a(aVar4, cgh, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ako.rrI = cgh;
                    }
                    return 0;
                case 3:
                    ako.rNi = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ako.rNj = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ako.gTo = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ako.rNg = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        avr = new avr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avr.a(aVar4, avr, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ako.rNk.add(avr);
                    }
                    return 0;
                case 8:
                    ako.rNl = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ako.rNm = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ako.rNn = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ako.rNo = aVar3.vHC.rY();
                    return 0;
                case 12:
                    ako.bSc = aVar3.vHC.readString();
                    return 0;
                case 13:
                    ako.rNp = aVar3.vHC.readString();
                    return 0;
                case 14:
                    ako.rNq = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ako.rNr = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ako.rNs = aVar3.vHC.rY();
                    return 0;
                case 17:
                    ako.rNt = aVar3.vHC.rY();
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        avr = new avr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avr.a(aVar4, avr, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ako.rNu = avr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
