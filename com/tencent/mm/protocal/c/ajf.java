package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ajf extends bhp {
    public String bhd;
    public int iEk;
    public boolean ixG;
    public String ixv;
    public String ixx;
    public String rLQ;
    public cig rLR;
    public LinkedList<cii> rLS = new LinkedList();
    public LinkedList<cih> rLT = new LinkedList();
    public LinkedList<String> rLU = new LinkedList();
    public String rLV;
    public String rLW;
    public LinkedList<kc> rLX = new LinkedList();
    public boolean rLY;
    public LinkedList<bre> rcK = new LinkedList();
    public LinkedList<xj> rch = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rLQ == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.ixx == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.rLR == null) {
                throw new b("Not all required fields were included: rankdesc");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rLQ != null) {
                    aVar.g(2, this.rLQ);
                }
                if (this.ixx != null) {
                    aVar.g(3, this.ixx);
                }
                if (this.rLR != null) {
                    aVar.fV(4, this.rLR.boi());
                    this.rLR.a(aVar);
                }
                aVar.d(5, 8, this.rLS);
                aVar.d(6, 8, this.rLT);
                if (this.bhd != null) {
                    aVar.g(7, this.bhd);
                }
                aVar.d(8, 1, this.rLU);
                if (this.rLV != null) {
                    aVar.g(9, this.rLV);
                }
                if (this.rLW != null) {
                    aVar.g(10, this.rLW);
                }
                aVar.d(14, 8, this.rcK);
                aVar.d(15, 8, this.rch);
                aVar.av(16, this.ixG);
                aVar.d(17, 8, this.rLX);
                aVar.av(18, this.rLY);
                aVar.fT(19, this.iEk);
                if (this.ixv == null) {
                    return 0;
                }
                aVar.g(20, this.ixv);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rLQ != null) {
                fS += f.a.a.b.b.a.h(2, this.rLQ);
            }
            if (this.ixx != null) {
                fS += f.a.a.b.b.a.h(3, this.ixx);
            }
            if (this.rLR != null) {
                fS += f.a.a.a.fS(4, this.rLR.boi());
            }
            fS = (fS + f.a.a.a.c(5, 8, this.rLS)) + f.a.a.a.c(6, 8, this.rLT);
            if (this.bhd != null) {
                fS += f.a.a.b.b.a.h(7, this.bhd);
            }
            fS += f.a.a.a.c(8, 1, this.rLU);
            if (this.rLV != null) {
                fS += f.a.a.b.b.a.h(9, this.rLV);
            }
            if (this.rLW != null) {
                fS += f.a.a.b.b.a.h(10, this.rLW);
            }
            fS = (((((fS + f.a.a.a.c(14, 8, this.rcK)) + f.a.a.a.c(15, 8, this.rch)) + (f.a.a.b.b.a.ec(16) + 1)) + f.a.a.a.c(17, 8, this.rLX)) + (f.a.a.b.b.a.ec(18) + 1)) + f.a.a.a.fQ(19, this.iEk);
            if (this.ixv != null) {
                fS += f.a.a.b.b.a.h(20, this.ixv);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rLS.clear();
            this.rLT.clear();
            this.rLU.clear();
            this.rcK.clear();
            this.rch.clear();
            this.rLX.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rLQ == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.ixx == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.rLR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankdesc");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ajf ajf = (ajf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            com.tencent.mm.bk.a flVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.six = flVar;
                    }
                    return 0;
                case 2:
                    ajf.rLQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ajf.ixx = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cig cig = new cig();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cig.a(aVar4, cig, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rLR = cig;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cii cii = new cii();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cii.a(aVar4, cii, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rLS.add(cii);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cih cih = new cih();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cih.a(aVar4, cih, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rLT.add(cih);
                    }
                    return 0;
                case 7:
                    ajf.bhd = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ajf.rLU.add(aVar3.vHC.readString());
                    return 0;
                case 9:
                    ajf.rLV = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ajf.rLW = aVar3.vHC.readString();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bre();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rcK.add(flVar);
                    }
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xj xjVar = new xj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xjVar.a(aVar4, xjVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rch.add(xjVar);
                    }
                    return 0;
                case 16:
                    ajf.ixG = aVar3.cJQ();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kc kcVar = new kc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kcVar.a(aVar4, kcVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ajf.rLX.add(kcVar);
                    }
                    return 0;
                case 18:
                    ajf.rLY = aVar3.cJQ();
                    return 0;
                case 19:
                    ajf.iEk = aVar3.vHC.rY();
                    return 0;
                case 20:
                    ajf.ixv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
