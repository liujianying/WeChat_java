package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class afa extends bhp {
    public String eJJ;
    public bhy rIW;
    public int rJb;
    public LinkedList<bhz> rJc = new LinkedList();
    public int rJd;
    public LinkedList<aqq> rJe = new LinkedList();
    public String rJf;
    public int rJg;
    public int rJh;
    public aqr rJi;
    public String rJj;
    public int rlm;
    public String rlo;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rIW == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rIW != null) {
                    aVar.fV(2, this.rIW.boi());
                    this.rIW.a(aVar);
                }
                aVar.fT(3, this.rJb);
                aVar.d(4, 8, this.rJc);
                aVar.fT(5, this.rJd);
                aVar.d(6, 8, this.rJe);
                aVar.fT(7, this.rlm);
                if (this.rJf != null) {
                    aVar.g(8, this.rJf);
                }
                if (this.rlo != null) {
                    aVar.g(9, this.rlo);
                }
                aVar.fT(10, this.rJg);
                if (this.eJJ != null) {
                    aVar.g(11, this.eJJ);
                }
                aVar.fT(12, this.rJh);
                if (this.rJi != null) {
                    aVar.fV(13, this.rJi.boi());
                    this.rJi.a(aVar);
                }
                if (this.rJj == null) {
                    return 0;
                }
                aVar.g(14, this.rJj);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rIW != null) {
                fS += f.a.a.a.fS(2, this.rIW.boi());
            }
            fS = ((((fS + f.a.a.a.fQ(3, this.rJb)) + f.a.a.a.c(4, 8, this.rJc)) + f.a.a.a.fQ(5, this.rJd)) + f.a.a.a.c(6, 8, this.rJe)) + f.a.a.a.fQ(7, this.rlm);
            if (this.rJf != null) {
                fS += f.a.a.b.b.a.h(8, this.rJf);
            }
            if (this.rlo != null) {
                fS += f.a.a.b.b.a.h(9, this.rlo);
            }
            fS += f.a.a.a.fQ(10, this.rJg);
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(11, this.eJJ);
            }
            fS += f.a.a.a.fQ(12, this.rJh);
            if (this.rJi != null) {
                fS += f.a.a.a.fS(13, this.rJi.boi());
            }
            if (this.rJj != null) {
                fS += f.a.a.b.b.a.h(14, this.rJj);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rJc.clear();
            this.rJe.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rIW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            afa afa = (afa) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        afa.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        afa.rIW = bhy;
                    }
                    return 0;
                case 3:
                    afa.rJb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        afa.rJc.add(bhz);
                    }
                    return 0;
                case 5:
                    afa.rJd = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqq aqq = new aqq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqq.a(aVar4, aqq, bhp.a(aVar4))) {
                        }
                        afa.rJe.add(aqq);
                    }
                    return 0;
                case 7:
                    afa.rlm = aVar3.vHC.rY();
                    return 0;
                case 8:
                    afa.rJf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    afa.rlo = aVar3.vHC.readString();
                    return 0;
                case 10:
                    afa.rJg = aVar3.vHC.rY();
                    return 0;
                case 11:
                    afa.eJJ = aVar3.vHC.readString();
                    return 0;
                case 12:
                    afa.rJh = aVar3.vHC.rY();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqr aqr = new aqr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqr.a(aVar4, aqr, bhp.a(aVar4))) {
                        }
                        afa.rJi = aqr;
                    }
                    return 0;
                case 14:
                    afa.rJj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
