package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.f$k;
import f.a.a.b;
import java.util.LinkedList;

public final class bmk extends a {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public String eJQ;
    public String eJR;
    public String hbL;
    public String hcS;
    public String rEJ;
    public String rKZ;
    public String rTd;
    public int rTe;
    public String rTf;
    public String rTg;
    public String rTh;
    public int rTi;
    public int rTj;
    public bqd rTk;
    public qt rTl;
    public int rcm;
    public String rqZ;
    public String rra;
    public int skC;
    public bhy skD;
    public int skE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.skD == null) {
                throw new b("Not all required fields were included: ImgBuffer");
            }
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.eJI != null) {
                aVar.g(3, this.eJI);
            }
            if (this.eJJ != null) {
                aVar.g(4, this.eJJ);
            }
            if (this.eJK != null) {
                aVar.g(5, this.eJK);
            }
            if (this.rTd != null) {
                aVar.g(6, this.rTd);
            }
            aVar.fT(7, this.eJH);
            aVar.fT(8, this.rcm);
            aVar.fT(9, this.skC);
            if (this.skD != null) {
                aVar.fV(10, this.skD.boi());
                this.skD.a(aVar);
            }
            aVar.fT(11, this.skE);
            if (this.rTg != null) {
                aVar.g(12, this.rTg);
            }
            if (this.rTh != null) {
                aVar.g(13, this.rTh);
            }
            aVar.fT(14, this.rTi);
            aVar.fT(15, this.rTe);
            if (this.rTf != null) {
                aVar.g(16, this.rTf);
            }
            if (this.rKZ != null) {
                aVar.g(17, this.rKZ);
            }
            aVar.fT(21, this.rTj);
            if (this.rTk != null) {
                aVar.fV(22, this.rTk.boi());
                this.rTk.a(aVar);
            }
            if (this.eJQ != null) {
                aVar.g(23, this.eJQ);
            }
            if (this.rqZ != null) {
                aVar.g(24, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(25, this.rra);
            }
            if (this.eJR != null) {
                aVar.g(26, this.eJR);
            }
            if (this.rTl != null) {
                aVar.fV(27, this.rTl.boi());
                this.rTl.a(aVar);
            }
            if (this.rEJ == null) {
                return 0;
            }
            aVar.g(28, this.rEJ);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.eJI != null) {
                h += f.a.a.b.b.a.h(3, this.eJI);
            }
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(4, this.eJJ);
            }
            if (this.eJK != null) {
                h += f.a.a.b.b.a.h(5, this.eJK);
            }
            if (this.rTd != null) {
                h += f.a.a.b.b.a.h(6, this.rTd);
            }
            h = ((h + f.a.a.a.fQ(7, this.eJH)) + f.a.a.a.fQ(8, this.rcm)) + f.a.a.a.fQ(9, this.skC);
            if (this.skD != null) {
                h += f.a.a.a.fS(10, this.skD.boi());
            }
            h += f.a.a.a.fQ(11, this.skE);
            if (this.rTg != null) {
                h += f.a.a.b.b.a.h(12, this.rTg);
            }
            if (this.rTh != null) {
                h += f.a.a.b.b.a.h(13, this.rTh);
            }
            h = (h + f.a.a.a.fQ(14, this.rTi)) + f.a.a.a.fQ(15, this.rTe);
            if (this.rTf != null) {
                h += f.a.a.b.b.a.h(16, this.rTf);
            }
            if (this.rKZ != null) {
                h += f.a.a.b.b.a.h(17, this.rKZ);
            }
            h += f.a.a.a.fQ(21, this.rTj);
            if (this.rTk != null) {
                h += f.a.a.a.fS(22, this.rTk.boi());
            }
            if (this.eJQ != null) {
                h += f.a.a.b.b.a.h(23, this.eJQ);
            }
            if (this.rqZ != null) {
                h += f.a.a.b.b.a.h(24, this.rqZ);
            }
            if (this.rra != null) {
                h += f.a.a.b.b.a.h(25, this.rra);
            }
            if (this.eJR != null) {
                h += f.a.a.b.b.a.h(26, this.eJR);
            }
            if (this.rTl != null) {
                h += f.a.a.a.fS(27, this.rTl.boi());
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(28, this.rEJ);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.skD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bmk bmk = (bmk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bmk.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bmk.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bmk.eJI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bmk.eJJ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bmk.eJK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bmk.rTd = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bmk.eJH = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bmk.rcm = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bmk.skC = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bmk.skD = bhy;
                    }
                    return 0;
                case 11:
                    bmk.skE = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bmk.rTg = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bmk.rTh = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bmk.rTi = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bmk.rTe = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bmk.rTf = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bmk.rKZ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bmk.rTj = aVar3.vHC.rY();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        bmk.rTk = bqd;
                    }
                    return 0;
                case 23:
                    bmk.eJQ = aVar3.vHC.readString();
                    return 0;
                case 24:
                    bmk.rqZ = aVar3.vHC.readString();
                    return 0;
                case 25:
                    bmk.rra = aVar3.vHC.readString();
                    return 0;
                case 26:
                    bmk.eJR = aVar3.vHC.readString();
                    return 0;
                case 27:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        bmk.rTl = qtVar;
                    }
                    return 0;
                case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    bmk.rEJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
