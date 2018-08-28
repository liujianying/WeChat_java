package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class hh extends bhp {
    public String bLe;
    public int raE;
    public String rdS;
    public bnp reD;
    public String reE;
    public int reI;
    public int rhE;
    public String rhF;
    public String rhG;
    public int rhH;
    public String rhI;
    public amt rhJ;
    public iz rhK;
    public avs rhL;
    public String rhM;
    public int rhN;
    public bic rhO;
    public String rhP;
    public String rhQ;
    public String rhR;
    public String rhS;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.bLe != null) {
                aVar.g(2, this.bLe);
            }
            if (this.rhG != null) {
                aVar.g(3, this.rhG);
            }
            aVar.fT(4, this.rhH);
            if (this.rhI != null) {
                aVar.g(5, this.rhI);
            }
            if (this.rdS != null) {
                aVar.g(6, this.rdS);
            }
            if (this.rhJ != null) {
                aVar.fV(7, this.rhJ.boi());
                this.rhJ.a(aVar);
            }
            if (this.rhK != null) {
                aVar.fV(8, this.rhK.boi());
                this.rhK.a(aVar);
            }
            if (this.rhL != null) {
                aVar.fV(9, this.rhL.boi());
                this.rhL.a(aVar);
            }
            if (this.reE != null) {
                aVar.g(10, this.reE);
            }
            aVar.fT(11, this.raE);
            if (this.rhM != null) {
                aVar.g(12, this.rhM);
            }
            aVar.fT(13, this.rhN);
            if (this.rhO != null) {
                aVar.fV(14, this.rhO.boi());
                this.rhO.a(aVar);
            }
            if (this.rhP != null) {
                aVar.g(15, this.rhP);
            }
            if (this.rhQ != null) {
                aVar.g(16, this.rhQ);
            }
            if (this.reD != null) {
                aVar.fV(17, this.reD.boi());
                this.reD.a(aVar);
            }
            aVar.fT(18, this.reI);
            if (this.rhR != null) {
                aVar.g(19, this.rhR);
            }
            if (this.rhS != null) {
                aVar.g(20, this.rhS);
            }
            aVar.fT(21, this.rhE);
            if (this.rhF == null) {
                return 0;
            }
            aVar.g(22, this.rhF);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bLe != null) {
                fS += f.a.a.b.b.a.h(2, this.bLe);
            }
            if (this.rhG != null) {
                fS += f.a.a.b.b.a.h(3, this.rhG);
            }
            fS += f.a.a.a.fQ(4, this.rhH);
            if (this.rhI != null) {
                fS += f.a.a.b.b.a.h(5, this.rhI);
            }
            if (this.rdS != null) {
                fS += f.a.a.b.b.a.h(6, this.rdS);
            }
            if (this.rhJ != null) {
                fS += f.a.a.a.fS(7, this.rhJ.boi());
            }
            if (this.rhK != null) {
                fS += f.a.a.a.fS(8, this.rhK.boi());
            }
            if (this.rhL != null) {
                fS += f.a.a.a.fS(9, this.rhL.boi());
            }
            if (this.reE != null) {
                fS += f.a.a.b.b.a.h(10, this.reE);
            }
            fS += f.a.a.a.fQ(11, this.raE);
            if (this.rhM != null) {
                fS += f.a.a.b.b.a.h(12, this.rhM);
            }
            fS += f.a.a.a.fQ(13, this.rhN);
            if (this.rhO != null) {
                fS += f.a.a.a.fS(14, this.rhO.boi());
            }
            if (this.rhP != null) {
                fS += f.a.a.b.b.a.h(15, this.rhP);
            }
            if (this.rhQ != null) {
                fS += f.a.a.b.b.a.h(16, this.rhQ);
            }
            if (this.reD != null) {
                fS += f.a.a.a.fS(17, this.reD.boi());
            }
            fS += f.a.a.a.fQ(18, this.reI);
            if (this.rhR != null) {
                fS += f.a.a.b.b.a.h(19, this.rhR);
            }
            if (this.rhS != null) {
                fS += f.a.a.b.b.a.h(20, this.rhS);
            }
            fS += f.a.a.a.fQ(21, this.rhE);
            if (this.rhF != null) {
                fS += f.a.a.b.b.a.h(22, this.rhF);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
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
            hh hhVar = (hh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        hhVar.six = flVar;
                    }
                    return 0;
                case 2:
                    hhVar.bLe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hhVar.rhG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hhVar.rhH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    hhVar.rhI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    hhVar.rdS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amt amt = new amt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amt.a(aVar4, amt, bhp.a(aVar4))) {
                        }
                        hhVar.rhJ = amt;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        iz izVar = new iz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = izVar.a(aVar4, izVar, bhp.a(aVar4))) {
                        }
                        hhVar.rhK = izVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        avs avs = new avs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avs.a(aVar4, avs, bhp.a(aVar4))) {
                        }
                        hhVar.rhL = avs;
                    }
                    return 0;
                case 10:
                    hhVar.reE = aVar3.vHC.readString();
                    return 0;
                case 11:
                    hhVar.raE = aVar3.vHC.rY();
                    return 0;
                case 12:
                    hhVar.rhM = aVar3.vHC.readString();
                    return 0;
                case 13:
                    hhVar.rhN = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bic bic = new bic();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bic.a(aVar4, bic, bhp.a(aVar4))) {
                        }
                        hhVar.rhO = bic;
                    }
                    return 0;
                case 15:
                    hhVar.rhP = aVar3.vHC.readString();
                    return 0;
                case 16:
                    hhVar.rhQ = aVar3.vHC.readString();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnp bnp = new bnp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnp.a(aVar4, bnp, bhp.a(aVar4))) {
                        }
                        hhVar.reD = bnp;
                    }
                    return 0;
                case 18:
                    hhVar.reI = aVar3.vHC.rY();
                    return 0;
                case 19:
                    hhVar.rhR = aVar3.vHC.readString();
                    return 0;
                case 20:
                    hhVar.rhS = aVar3.vHC.readString();
                    return 0;
                case 21:
                    hhVar.rhE = aVar3.vHC.rY();
                    return 0;
                case 22:
                    hhVar.rhF = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
