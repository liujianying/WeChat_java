package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.wxpay.a$k;
import f.a.a.b;
import java.util.LinkedList;

public final class boy extends a {
    public int lOH;
    public String rTW;
    public LinkedList<bhz> rWm = new LinkedList();
    public int rXs;
    public int rXx;
    public int rYP;
    public LinkedList<bot> rcM = new LinkedList();
    public String rdS;
    public long rlK;
    public bhy smH;
    public int smI;
    public int smJ;
    public int smK;
    public LinkedList<bon> smL = new LinkedList();
    public int smM;
    public int smN;
    public LinkedList<bon> smO = new LinkedList();
    public int smP;
    public int smQ;
    public LinkedList<bon> smR = new LinkedList();
    public int smS;
    public String smT;
    public long smU;
    public int smV;
    public LinkedList<bhz> smW = new LinkedList();
    public int smX;
    public bhy smY;
    public bpn smZ;
    public int smi;
    public bbj sna;
    public boj snb;

    protected final int a(int i, Object... objArr) {
        int S;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.smH == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.T(1, this.rlK);
            if (this.rdS != null) {
                aVar.g(2, this.rdS);
            }
            if (this.rTW != null) {
                aVar.g(3, this.rTW);
            }
            aVar.fT(4, this.lOH);
            if (this.smH != null) {
                aVar.fV(5, this.smH.boi());
                this.smH.a(aVar);
            }
            aVar.fT(6, this.smI);
            aVar.fT(7, this.smJ);
            aVar.fT(8, this.smK);
            aVar.d(9, 8, this.smL);
            aVar.fT(10, this.smM);
            aVar.fT(11, this.smN);
            aVar.d(12, 8, this.smO);
            aVar.fT(13, this.smP);
            aVar.fT(14, this.smQ);
            aVar.d(15, 8, this.smR);
            aVar.fT(16, this.rXx);
            aVar.fT(17, this.smS);
            aVar.fT(18, this.rYP);
            aVar.d(19, 8, this.rcM);
            aVar.fT(20, this.smi);
            if (this.smT != null) {
                aVar.g(21, this.smT);
            }
            aVar.T(22, this.smU);
            aVar.fT(23, this.smV);
            aVar.d(24, 8, this.smW);
            aVar.fT(25, this.rXs);
            aVar.fT(26, this.smX);
            aVar.d(27, 8, this.rWm);
            if (this.smY != null) {
                aVar.fV(28, this.smY.boi());
                this.smY.a(aVar);
            }
            if (this.smZ != null) {
                aVar.fV(29, this.smZ.boi());
                this.smZ.a(aVar);
            }
            if (this.sna != null) {
                aVar.fV(30, this.sna.boi());
                this.sna.a(aVar);
            }
            if (this.snb != null) {
                aVar.fV(31, this.snb.boi());
                this.snb.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.rlK) + 0;
            if (this.rdS != null) {
                S += f.a.a.b.b.a.h(2, this.rdS);
            }
            if (this.rTW != null) {
                S += f.a.a.b.b.a.h(3, this.rTW);
            }
            S += f.a.a.a.fQ(4, this.lOH);
            if (this.smH != null) {
                S += f.a.a.a.fS(5, this.smH.boi());
            }
            S = ((((((((((((((S + f.a.a.a.fQ(6, this.smI)) + f.a.a.a.fQ(7, this.smJ)) + f.a.a.a.fQ(8, this.smK)) + f.a.a.a.c(9, 8, this.smL)) + f.a.a.a.fQ(10, this.smM)) + f.a.a.a.fQ(11, this.smN)) + f.a.a.a.c(12, 8, this.smO)) + f.a.a.a.fQ(13, this.smP)) + f.a.a.a.fQ(14, this.smQ)) + f.a.a.a.c(15, 8, this.smR)) + f.a.a.a.fQ(16, this.rXx)) + f.a.a.a.fQ(17, this.smS)) + f.a.a.a.fQ(18, this.rYP)) + f.a.a.a.c(19, 8, this.rcM)) + f.a.a.a.fQ(20, this.smi);
            if (this.smT != null) {
                S += f.a.a.b.b.a.h(21, this.smT);
            }
            S = (((((S + f.a.a.a.S(22, this.smU)) + f.a.a.a.fQ(23, this.smV)) + f.a.a.a.c(24, 8, this.smW)) + f.a.a.a.fQ(25, this.rXs)) + f.a.a.a.fQ(26, this.smX)) + f.a.a.a.c(27, 8, this.rWm);
            if (this.smY != null) {
                S += f.a.a.a.fS(28, this.smY.boi());
            }
            if (this.smZ != null) {
                S += f.a.a.a.fS(29, this.smZ.boi());
            }
            if (this.sna != null) {
                S += f.a.a.a.fS(30, this.sna.boi());
            }
            if (this.snb != null) {
                return S + f.a.a.a.fS(31, this.snb.boi());
            }
            return S;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.smL.clear();
            this.smO.clear();
            this.smR.clear();
            this.rcM.clear();
            this.smW.clear();
            this.rWm.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
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
            boy boy = (boy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            bhy bhy;
            f.a.a.a.a aVar4;
            boolean z;
            bon bon;
            bhz bhz;
            switch (intValue) {
                case 1:
                    boy.rlK = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    boy.rdS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    boy.rTW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    boy.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        boy.smH = bhy;
                    }
                    return 0;
                case 6:
                    boy.smI = aVar3.vHC.rY();
                    return 0;
                case 7:
                    boy.smJ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    boy.smK = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bon = new bon();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bon.a(aVar4, bon, a.a(aVar4))) {
                        }
                        boy.smL.add(bon);
                    }
                    return 0;
                case 10:
                    boy.smM = aVar3.vHC.rY();
                    return 0;
                case 11:
                    boy.smN = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bon = new bon();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bon.a(aVar4, bon, a.a(aVar4))) {
                        }
                        boy.smO.add(bon);
                    }
                    return 0;
                case 13:
                    boy.smP = aVar3.vHC.rY();
                    return 0;
                case 14:
                    boy.smQ = aVar3.vHC.rY();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bon = new bon();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bon.a(aVar4, bon, a.a(aVar4))) {
                        }
                        boy.smR.add(bon);
                    }
                    return 0;
                case 16:
                    boy.rXx = aVar3.vHC.rY();
                    return 0;
                case 17:
                    boy.smS = aVar3.vHC.rY();
                    return 0;
                case 18:
                    boy.rYP = aVar3.vHC.rY();
                    return 0;
                case 19:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bot bot = new bot();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bot.a(aVar4, bot, a.a(aVar4))) {
                        }
                        boy.rcM.add(bot);
                    }
                    return 0;
                case 20:
                    boy.smi = aVar3.vHC.rY();
                    return 0;
                case 21:
                    boy.smT = aVar3.vHC.readString();
                    return 0;
                case 22:
                    boy.smU = aVar3.vHC.rZ();
                    return 0;
                case 23:
                    boy.smV = aVar3.vHC.rY();
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        boy.smW.add(bhz);
                    }
                    return 0;
                case 25:
                    boy.rXs = aVar3.vHC.rY();
                    return 0;
                case 26:
                    boy.smX = aVar3.vHC.rY();
                    return 0;
                case 27:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        boy.rWm.add(bhz);
                    }
                    return 0;
                case 28:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        boy.smY = bhy;
                    }
                    return 0;
                case 29:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpn bpn = new bpn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpn.a(aVar4, bpn, a.a(aVar4))) {
                        }
                        boy.smZ = bpn;
                    }
                    return 0;
                case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbj bbj = new bbj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbj.a(aVar4, bbj, a.a(aVar4))) {
                        }
                        boy.sna = bbj;
                    }
                    return 0;
                case 31:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boj boj = new boj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boj.a(aVar4, boj, a.a(aVar4))) {
                        }
                        boy.snb = boj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
