package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bpj extends bhd {
    public bhy rTr;
    public int rWb;
    public LinkedList<bot> rWh = new LinkedList();
    public LinkedList<bhz> rWm = new LinkedList();
    public bpi rWn;
    public int rYP;
    public String rcc;
    public bue sdt;
    public bhy smH;
    public int smQ;
    public LinkedList<bhz> smR = new LinkedList();
    public long smU;
    public int smV;
    public LinkedList<bhz> smW = new LinkedList();
    public int smX;
    public bpn smZ;
    public int snp;
    public int snq;
    public int snr;
    public bph sns;
    public bhy snt;
    public String snu;
    public ku snv;
    public int snw;
    public LinkedList<atc> snx = new LinkedList();
    public boj sny;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.smH == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.smH != null) {
                aVar.fV(2, this.smH.boi());
                this.smH.a(aVar);
            }
            aVar.fT(3, this.smQ);
            aVar.d(4, 8, this.smR);
            aVar.fT(5, this.snp);
            aVar.fT(6, this.rWb);
            if (this.rcc != null) {
                aVar.g(7, this.rcc);
            }
            aVar.fT(8, this.snq);
            aVar.fT(9, this.rYP);
            aVar.d(10, 8, this.rWh);
            aVar.fT(11, this.snr);
            aVar.T(12, this.smU);
            aVar.fT(13, this.smV);
            aVar.d(14, 8, this.smW);
            if (this.sdt != null) {
                aVar.fV(15, this.sdt.boi());
                this.sdt.a(aVar);
            }
            aVar.fT(16, this.smX);
            aVar.d(17, 8, this.rWm);
            if (this.sns != null) {
                aVar.fV(18, this.sns.boi());
                this.sns.a(aVar);
            }
            if (this.rWn != null) {
                aVar.fV(19, this.rWn.boi());
                this.rWn.a(aVar);
            }
            if (this.smZ != null) {
                aVar.fV(20, this.smZ.boi());
                this.smZ.a(aVar);
            }
            if (this.snt != null) {
                aVar.fV(21, this.snt.boi());
                this.snt.a(aVar);
            }
            if (this.snu != null) {
                aVar.g(22, this.snu);
            }
            if (this.snv != null) {
                aVar.fV(23, this.snv.boi());
                this.snv.a(aVar);
            }
            aVar.fT(24, this.snw);
            aVar.d(25, 8, this.snx);
            if (this.sny != null) {
                aVar.fV(26, this.sny.boi());
                this.sny.a(aVar);
            }
            if (this.rTr == null) {
                return 0;
            }
            aVar.fV(27, this.rTr.boi());
            this.rTr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.smH != null) {
                fS += f.a.a.a.fS(2, this.smH.boi());
            }
            fS = (((fS + f.a.a.a.fQ(3, this.smQ)) + f.a.a.a.c(4, 8, this.smR)) + f.a.a.a.fQ(5, this.snp)) + f.a.a.a.fQ(6, this.rWb);
            if (this.rcc != null) {
                fS += f.a.a.b.b.a.h(7, this.rcc);
            }
            fS = ((((((fS + f.a.a.a.fQ(8, this.snq)) + f.a.a.a.fQ(9, this.rYP)) + f.a.a.a.c(10, 8, this.rWh)) + f.a.a.a.fQ(11, this.snr)) + f.a.a.a.S(12, this.smU)) + f.a.a.a.fQ(13, this.smV)) + f.a.a.a.c(14, 8, this.smW);
            if (this.sdt != null) {
                fS += f.a.a.a.fS(15, this.sdt.boi());
            }
            fS = (fS + f.a.a.a.fQ(16, this.smX)) + f.a.a.a.c(17, 8, this.rWm);
            if (this.sns != null) {
                fS += f.a.a.a.fS(18, this.sns.boi());
            }
            if (this.rWn != null) {
                fS += f.a.a.a.fS(19, this.rWn.boi());
            }
            if (this.smZ != null) {
                fS += f.a.a.a.fS(20, this.smZ.boi());
            }
            if (this.snt != null) {
                fS += f.a.a.a.fS(21, this.snt.boi());
            }
            if (this.snu != null) {
                fS += f.a.a.b.b.a.h(22, this.snu);
            }
            if (this.snv != null) {
                fS += f.a.a.a.fS(23, this.snv.boi());
            }
            fS = (fS + f.a.a.a.fQ(24, this.snw)) + f.a.a.a.c(25, 8, this.snx);
            if (this.sny != null) {
                fS += f.a.a.a.fS(26, this.sny.boi());
            }
            if (this.rTr != null) {
                fS += f.a.a.a.fS(27, this.rTr.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.smR.clear();
            this.rWh.clear();
            this.smW.clear();
            this.rWm.clear();
            this.snx.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.smH != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bpj bpj = (bpj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            bhz bhz;
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
                        bpj.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bpj.smH = bhy;
                    }
                    return 0;
                case 3:
                    bpj.smQ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bpj.smR.add(bhz);
                    }
                    return 0;
                case 5:
                    bpj.snp = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bpj.rWb = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bpj.rcc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bpj.snq = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bpj.rYP = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bot bot = new bot();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bot.a(aVar4, bot, bhd.a(aVar4))) {
                        }
                        bpj.rWh.add(bot);
                    }
                    return 0;
                case 11:
                    bpj.snr = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bpj.smU = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    bpj.smV = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bpj.smW.add(bhz);
                    }
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bue bue = new bue();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bue.a(aVar4, bue, bhd.a(aVar4))) {
                        }
                        bpj.sdt = bue;
                    }
                    return 0;
                case 16:
                    bpj.smX = aVar3.vHC.rY();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bpj.rWm.add(bhz);
                    }
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bph bph = new bph();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bph.a(aVar4, bph, bhd.a(aVar4))) {
                        }
                        bpj.sns = bph;
                    }
                    return 0;
                case 19:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpi bpi = new bpi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpi.a(aVar4, bpi, bhd.a(aVar4))) {
                        }
                        bpj.rWn = bpi;
                    }
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpn bpn = new bpn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpn.a(aVar4, bpn, bhd.a(aVar4))) {
                        }
                        bpj.smZ = bpn;
                    }
                    return 0;
                case 21:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bpj.snt = bhy;
                    }
                    return 0;
                case 22:
                    bpj.snu = aVar3.vHC.readString();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ku kuVar = new ku();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kuVar.a(aVar4, kuVar, bhd.a(aVar4))) {
                        }
                        bpj.snv = kuVar;
                    }
                    return 0;
                case 24:
                    bpj.snw = aVar3.vHC.rY();
                    return 0;
                case 25:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atc atc = new atc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atc.a(aVar4, atc, bhd.a(aVar4))) {
                        }
                        bpj.snx.add(atc);
                    }
                    return 0;
                case 26:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boj boj = new boj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boj.a(aVar4, boj, bhd.a(aVar4))) {
                        }
                        bpj.sny = boj;
                    }
                    return 0;
                case 27:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bpj.rTr = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
