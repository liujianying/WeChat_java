package com.tencent.mm.protocal.c;

import android.support.design.a$i;
import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class atf extends a {
    public String bJK;
    public String bZM;
    public int ceS;
    public int dHg;
    public int rVG;
    public int rWa;
    public int rWb;
    public LinkedList<ari> rWc = new LinkedList();
    public LinkedList<bqg> rWd = new LinkedList();
    public int rWe;
    public long rWf;
    public int rWg;
    public LinkedList<Long> rWh = new LinkedList();
    public int rWi;
    public int rWj;
    public String rWk;
    public int rWl;
    public LinkedList<bhz> rWm = new LinkedList();
    public bpi rWn;
    public LinkedList<bpo> rWo = new LinkedList();
    public String rWp;
    public long rWq;
    public String rWr;
    public boolean rWs;
    public boj rWt;
    public String rcc;
    public String rwj;
    public String token;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rWa);
            aVar.fT(2, this.rWb);
            aVar.fT(3, this.rVG);
            if (this.rcc != null) {
                aVar.g(4, this.rcc);
            }
            aVar.d(5, 8, this.rWc);
            aVar.d(6, 8, this.rWd);
            aVar.fT(7, this.rWe);
            aVar.fT(8, this.dHg);
            aVar.T(9, this.rWf);
            aVar.fT(10, this.rWg);
            aVar.d(11, 3, this.rWh);
            aVar.fT(12, this.rWi);
            aVar.fT(13, this.rWj);
            if (this.token != null) {
                aVar.g(14, this.token);
            }
            if (this.rWk != null) {
                aVar.g(15, this.rWk);
            }
            aVar.fT(16, this.rWl);
            aVar.d(17, 8, this.rWm);
            if (this.rWn != null) {
                aVar.fV(18, this.rWn.boi());
                this.rWn.a(aVar);
            }
            if (this.bZM != null) {
                aVar.g(19, this.bZM);
            }
            aVar.d(20, 8, this.rWo);
            if (this.bJK != null) {
                aVar.g(21, this.bJK);
            }
            if (this.rWp != null) {
                aVar.g(22, this.rWp);
            }
            if (this.rwj != null) {
                aVar.g(23, this.rwj);
            }
            aVar.fT(24, this.ceS);
            aVar.T(25, this.rWq);
            if (this.rWr != null) {
                aVar.g(26, this.rWr);
            }
            aVar.av(27, this.rWs);
            if (this.rWt != null) {
                aVar.fV(28, this.rWt.boi());
                this.rWt.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rWa) + 0) + f.a.a.a.fQ(2, this.rWb)) + f.a.a.a.fQ(3, this.rVG);
            if (this.rcc != null) {
                fQ += f.a.a.b.b.a.h(4, this.rcc);
            }
            fQ = ((((((((fQ + f.a.a.a.c(5, 8, this.rWc)) + f.a.a.a.c(6, 8, this.rWd)) + f.a.a.a.fQ(7, this.rWe)) + f.a.a.a.fQ(8, this.dHg)) + f.a.a.a.S(9, this.rWf)) + f.a.a.a.fQ(10, this.rWg)) + f.a.a.a.c(11, 3, this.rWh)) + f.a.a.a.fQ(12, this.rWi)) + f.a.a.a.fQ(13, this.rWj);
            if (this.token != null) {
                fQ += f.a.a.b.b.a.h(14, this.token);
            }
            if (this.rWk != null) {
                fQ += f.a.a.b.b.a.h(15, this.rWk);
            }
            fQ = (fQ + f.a.a.a.fQ(16, this.rWl)) + f.a.a.a.c(17, 8, this.rWm);
            if (this.rWn != null) {
                fQ += f.a.a.a.fS(18, this.rWn.boi());
            }
            if (this.bZM != null) {
                fQ += f.a.a.b.b.a.h(19, this.bZM);
            }
            fQ += f.a.a.a.c(20, 8, this.rWo);
            if (this.bJK != null) {
                fQ += f.a.a.b.b.a.h(21, this.bJK);
            }
            if (this.rWp != null) {
                fQ += f.a.a.b.b.a.h(22, this.rWp);
            }
            if (this.rwj != null) {
                fQ += f.a.a.b.b.a.h(23, this.rwj);
            }
            fQ = (fQ + f.a.a.a.fQ(24, this.ceS)) + f.a.a.a.S(25, this.rWq);
            if (this.rWr != null) {
                fQ += f.a.a.b.b.a.h(26, this.rWr);
            }
            fQ += f.a.a.b.b.a.ec(27) + 1;
            if (this.rWt != null) {
                return fQ + f.a.a.a.fS(28, this.rWt.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rWc.clear();
            this.rWd.clear();
            this.rWh.clear();
            this.rWm.clear();
            this.rWo.clear();
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
            atf atf = (atf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    atf.rWa = aVar3.vHC.rY();
                    return 0;
                case 2:
                    atf.rWb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    atf.rVG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    atf.rcc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ari ari = new ari();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ari.a(aVar4, ari, a.a(aVar4))) {
                        }
                        atf.rWc.add(ari);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqg bqg = new bqg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqg.a(aVar4, bqg, a.a(aVar4))) {
                        }
                        atf.rWd.add(bqg);
                    }
                    return 0;
                case 7:
                    atf.rWe = aVar3.vHC.rY();
                    return 0;
                case 8:
                    atf.dHg = aVar3.vHC.rY();
                    return 0;
                case 9:
                    atf.rWf = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    atf.rWg = aVar3.vHC.rY();
                    return 0;
                case 11:
                    atf.rWh.add(Long.valueOf(aVar3.vHC.rZ()));
                    return 0;
                case 12:
                    atf.rWi = aVar3.vHC.rY();
                    return 0;
                case 13:
                    atf.rWj = aVar3.vHC.rY();
                    return 0;
                case 14:
                    atf.token = aVar3.vHC.readString();
                    return 0;
                case 15:
                    atf.rWk = aVar3.vHC.readString();
                    return 0;
                case 16:
                    atf.rWl = aVar3.vHC.rY();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atf.rWm.add(bhz);
                    }
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpi bpi = new bpi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpi.a(aVar4, bpi, a.a(aVar4))) {
                        }
                        atf.rWn = bpi;
                    }
                    return 0;
                case 19:
                    atf.bZM = aVar3.vHC.readString();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpo bpo = new bpo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpo.a(aVar4, bpo, a.a(aVar4))) {
                        }
                        atf.rWo.add(bpo);
                    }
                    return 0;
                case 21:
                    atf.bJK = aVar3.vHC.readString();
                    return 0;
                case 22:
                    atf.rWp = aVar3.vHC.readString();
                    return 0;
                case 23:
                    atf.rwj = aVar3.vHC.readString();
                    return 0;
                case 24:
                    atf.ceS = aVar3.vHC.rY();
                    return 0;
                case 25:
                    atf.rWq = aVar3.vHC.rZ();
                    return 0;
                case 26:
                    atf.rWr = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    atf.rWs = aVar3.cJQ();
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boj boj = new boj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boj.a(aVar4, boj, a.a(aVar4))) {
                        }
                        atf.rWt = boj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
