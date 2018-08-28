package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class f extends a {
    public int ceS;
    public int ceT;
    public long cfh;
    public int hUg;
    public String kLZ;
    public String kLf;
    public int kNg;
    public String kNh;
    public String kNi;
    public String kNj;
    public int kPI;
    public String kPJ;
    public String kPK;
    public String kPL;
    public String kPM;
    public String kPN;
    public String kPO;
    public long kPP;
    public long kPQ;
    public long kPR;
    public String kPS;
    public int kPT;
    public int kPU;
    public int kPV;
    public String kPW;
    public int kPX;
    public a kPY;
    public LinkedList<ai> kPZ = new LinkedList();
    public ai kQa;
    public String kQb;
    public String kQc;
    public int kQd;
    public LinkedList<n> kQe = new LinkedList();
    public String kQf;
    public String kQg;
    public int kQh;
    public String kQi;
    public int resourceId;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.kPI);
            aVar.fT(2, this.ceS);
            if (this.kPJ != null) {
                aVar.g(3, this.kPJ);
            }
            if (this.kPK != null) {
                aVar.g(4, this.kPK);
            }
            if (this.kLf != null) {
                aVar.g(5, this.kLf);
            }
            if (this.kPL != null) {
                aVar.g(6, this.kPL);
            }
            if (this.kPM != null) {
                aVar.g(7, this.kPM);
            }
            if (this.kLZ != null) {
                aVar.g(8, this.kLZ);
            }
            if (this.kPN != null) {
                aVar.g(9, this.kPN);
            }
            if (this.kPO != null) {
                aVar.g(10, this.kPO);
            }
            aVar.T(11, this.cfh);
            aVar.T(12, this.kPP);
            aVar.T(13, this.kPQ);
            aVar.fT(14, this.hUg);
            aVar.T(15, this.kPR);
            if (this.kPS != null) {
                aVar.g(16, this.kPS);
            }
            aVar.fT(17, this.kPT);
            aVar.fT(18, this.kPU);
            aVar.fT(19, this.kPV);
            if (this.kPW != null) {
                aVar.g(20, this.kPW);
            }
            aVar.fT(21, this.ceT);
            aVar.fT(22, this.kPX);
            if (this.kPY != null) {
                aVar.fV(23, this.kPY.boi());
                this.kPY.a(aVar);
            }
            aVar.fT(24, this.kNg);
            if (this.kNi != null) {
                aVar.g(25, this.kNi);
            }
            aVar.d(26, 8, this.kPZ);
            if (this.kQa != null) {
                aVar.fV(27, this.kQa.boi());
                this.kQa.a(aVar);
            }
            if (this.kQb != null) {
                aVar.g(28, this.kQb);
            }
            if (this.kQc != null) {
                aVar.g(29, this.kQc);
            }
            aVar.fT(30, this.kQd);
            aVar.fT(31, this.resourceId);
            if (this.kNj != null) {
                aVar.g(32, this.kNj);
            }
            aVar.d(33, 8, this.kQe);
            if (this.kNh != null) {
                aVar.g(34, this.kNh);
            }
            if (this.kQf != null) {
                aVar.g(35, this.kQf);
            }
            if (this.kQg != null) {
                aVar.g(36, this.kQg);
            }
            aVar.fT(37, this.kQh);
            if (this.kQi != null) {
                aVar.g(38, this.kQi);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.kPI) + 0) + f.a.a.a.fQ(2, this.ceS);
            if (this.kPJ != null) {
                fQ += f.a.a.b.b.a.h(3, this.kPJ);
            }
            if (this.kPK != null) {
                fQ += f.a.a.b.b.a.h(4, this.kPK);
            }
            if (this.kLf != null) {
                fQ += f.a.a.b.b.a.h(5, this.kLf);
            }
            if (this.kPL != null) {
                fQ += f.a.a.b.b.a.h(6, this.kPL);
            }
            if (this.kPM != null) {
                fQ += f.a.a.b.b.a.h(7, this.kPM);
            }
            if (this.kLZ != null) {
                fQ += f.a.a.b.b.a.h(8, this.kLZ);
            }
            if (this.kPN != null) {
                fQ += f.a.a.b.b.a.h(9, this.kPN);
            }
            if (this.kPO != null) {
                fQ += f.a.a.b.b.a.h(10, this.kPO);
            }
            fQ = ((((fQ + f.a.a.a.S(11, this.cfh)) + f.a.a.a.S(12, this.kPP)) + f.a.a.a.S(13, this.kPQ)) + f.a.a.a.fQ(14, this.hUg)) + f.a.a.a.S(15, this.kPR);
            if (this.kPS != null) {
                fQ += f.a.a.b.b.a.h(16, this.kPS);
            }
            fQ = ((fQ + f.a.a.a.fQ(17, this.kPT)) + f.a.a.a.fQ(18, this.kPU)) + f.a.a.a.fQ(19, this.kPV);
            if (this.kPW != null) {
                fQ += f.a.a.b.b.a.h(20, this.kPW);
            }
            fQ = (fQ + f.a.a.a.fQ(21, this.ceT)) + f.a.a.a.fQ(22, this.kPX);
            if (this.kPY != null) {
                fQ += f.a.a.a.fS(23, this.kPY.boi());
            }
            fQ += f.a.a.a.fQ(24, this.kNg);
            if (this.kNi != null) {
                fQ += f.a.a.b.b.a.h(25, this.kNi);
            }
            fQ += f.a.a.a.c(26, 8, this.kPZ);
            if (this.kQa != null) {
                fQ += f.a.a.a.fS(27, this.kQa.boi());
            }
            if (this.kQb != null) {
                fQ += f.a.a.b.b.a.h(28, this.kQb);
            }
            if (this.kQc != null) {
                fQ += f.a.a.b.b.a.h(29, this.kQc);
            }
            fQ = (fQ + f.a.a.a.fQ(30, this.kQd)) + f.a.a.a.fQ(31, this.resourceId);
            if (this.kNj != null) {
                fQ += f.a.a.b.b.a.h(32, this.kNj);
            }
            fQ += f.a.a.a.c(33, 8, this.kQe);
            if (this.kNh != null) {
                fQ += f.a.a.b.b.a.h(34, this.kNh);
            }
            if (this.kQf != null) {
                fQ += f.a.a.b.b.a.h(35, this.kQf);
            }
            if (this.kQg != null) {
                fQ += f.a.a.b.b.a.h(36, this.kQg);
            }
            fQ += f.a.a.a.fQ(37, this.kQh);
            if (this.kQi != null) {
                return fQ + f.a.a.b.b.a.h(38, this.kQi);
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kPZ.clear();
            this.kQe.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            ai aiVar;
            switch (intValue) {
                case 1:
                    fVar.kPI = aVar3.vHC.rY();
                    return 0;
                case 2:
                    fVar.ceS = aVar3.vHC.rY();
                    return 0;
                case 3:
                    fVar.kPJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    fVar.kPK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    fVar.kLf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    fVar.kPL = aVar3.vHC.readString();
                    return 0;
                case 7:
                    fVar.kPM = aVar3.vHC.readString();
                    return 0;
                case 8:
                    fVar.kLZ = aVar3.vHC.readString();
                    return 0;
                case 9:
                    fVar.kPN = aVar3.vHC.readString();
                    return 0;
                case 10:
                    fVar.kPO = aVar3.vHC.readString();
                    return 0;
                case 11:
                    fVar.cfh = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    fVar.kPP = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    fVar.kPQ = aVar3.vHC.rZ();
                    return 0;
                case 14:
                    fVar.hUg = aVar3.vHC.rY();
                    return 0;
                case 15:
                    fVar.kPR = aVar3.vHC.rZ();
                    return 0;
                case 16:
                    fVar.kPS = aVar3.vHC.readString();
                    return 0;
                case 17:
                    fVar.kPT = aVar3.vHC.rY();
                    return 0;
                case 18:
                    fVar.kPU = aVar3.vHC.rY();
                    return 0;
                case 19:
                    fVar.kPV = aVar3.vHC.rY();
                    return 0;
                case 20:
                    fVar.kPW = aVar3.vHC.readString();
                    return 0;
                case 21:
                    fVar.ceT = aVar3.vHC.rY();
                    return 0;
                case 22:
                    fVar.kPX = aVar3.vHC.rY();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        fVar.kPY = aVar5;
                    }
                    return 0;
                case 24:
                    fVar.kNg = aVar3.vHC.rY();
                    return 0;
                case 25:
                    fVar.kNi = aVar3.vHC.readString();
                    return 0;
                case 26:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aiVar = new ai();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aiVar.a(aVar4, aiVar, a.a(aVar4))) {
                        }
                        fVar.kPZ.add(aiVar);
                    }
                    return 0;
                case 27:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aiVar = new ai();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aiVar.a(aVar4, aiVar, a.a(aVar4))) {
                        }
                        fVar.kQa = aiVar;
                    }
                    return 0;
                case 28:
                    fVar.kQb = aVar3.vHC.readString();
                    return 0;
                case 29:
                    fVar.kQc = aVar3.vHC.readString();
                    return 0;
                case 30:
                    fVar.kQd = aVar3.vHC.rY();
                    return 0;
                case 31:
                    fVar.resourceId = aVar3.vHC.rY();
                    return 0;
                case 32:
                    fVar.kNj = aVar3.vHC.readString();
                    return 0;
                case 33:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        n nVar = new n();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                        }
                        fVar.kQe.add(nVar);
                    }
                    return 0;
                case 34:
                    fVar.kNh = aVar3.vHC.readString();
                    return 0;
                case 35:
                    fVar.kQf = aVar3.vHC.readString();
                    return 0;
                case 36:
                    fVar.kQg = aVar3.vHC.readString();
                    return 0;
                case 37:
                    fVar.kQh = aVar3.vHC.rY();
                    return 0;
                case 38:
                    fVar.kQi = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
