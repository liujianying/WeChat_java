package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ath extends a {
    public int afv;
    public String bKg;
    public int bMQ;
    public String bPS;
    public int dHg;
    public String jOS;
    public int rVG;
    public String rVZ;
    public int rWA;
    public String rWB;
    public String rWC;
    public String rWD;
    public aso rWE;
    public int rWF;
    public int rWa;
    public int rWb;
    public int rWj;
    public String rWk;
    public atb rWx;
    public int rWy;
    public LinkedList<atb> rWz = new LinkedList();
    public String token;
    public String videoPath;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rWa);
            aVar.fT(2, this.rWb);
            aVar.fT(3, this.rVG);
            if (this.rWx != null) {
                aVar.fV(4, this.rWx.boi());
                this.rWx.a(aVar);
            }
            aVar.fT(5, this.rWy);
            aVar.d(6, 8, this.rWz);
            aVar.fT(7, this.dHg);
            aVar.fT(8, this.rWA);
            if (this.jOS != null) {
                aVar.g(9, this.jOS);
            }
            if (this.rWB != null) {
                aVar.g(10, this.rWB);
            }
            if (this.token != null) {
                aVar.g(11, this.token);
            }
            if (this.rWk != null) {
                aVar.g(12, this.rWk);
            }
            aVar.fT(13, this.rWj);
            if (this.videoPath != null) {
                aVar.g(14, this.videoPath);
            }
            if (this.rWC != null) {
                aVar.g(15, this.rWC);
            }
            if (this.rWD != null) {
                aVar.g(16, this.rWD);
            }
            if (this.bKg != null) {
                aVar.g(17, this.bKg);
            }
            if (this.bPS != null) {
                aVar.g(18, this.bPS);
            }
            aVar.fT(19, this.afv);
            aVar.fT(20, this.bMQ);
            if (this.rVZ != null) {
                aVar.g(21, this.rVZ);
            }
            if (this.rWE != null) {
                aVar.fV(22, this.rWE.boi());
                this.rWE.a(aVar);
            }
            aVar.fT(23, this.rWF);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rWa) + 0) + f.a.a.a.fQ(2, this.rWb)) + f.a.a.a.fQ(3, this.rVG);
            if (this.rWx != null) {
                fQ += f.a.a.a.fS(4, this.rWx.boi());
            }
            fQ = (((fQ + f.a.a.a.fQ(5, this.rWy)) + f.a.a.a.c(6, 8, this.rWz)) + f.a.a.a.fQ(7, this.dHg)) + f.a.a.a.fQ(8, this.rWA);
            if (this.jOS != null) {
                fQ += f.a.a.b.b.a.h(9, this.jOS);
            }
            if (this.rWB != null) {
                fQ += f.a.a.b.b.a.h(10, this.rWB);
            }
            if (this.token != null) {
                fQ += f.a.a.b.b.a.h(11, this.token);
            }
            if (this.rWk != null) {
                fQ += f.a.a.b.b.a.h(12, this.rWk);
            }
            fQ += f.a.a.a.fQ(13, this.rWj);
            if (this.videoPath != null) {
                fQ += f.a.a.b.b.a.h(14, this.videoPath);
            }
            if (this.rWC != null) {
                fQ += f.a.a.b.b.a.h(15, this.rWC);
            }
            if (this.rWD != null) {
                fQ += f.a.a.b.b.a.h(16, this.rWD);
            }
            if (this.bKg != null) {
                fQ += f.a.a.b.b.a.h(17, this.bKg);
            }
            if (this.bPS != null) {
                fQ += f.a.a.b.b.a.h(18, this.bPS);
            }
            fQ = (fQ + f.a.a.a.fQ(19, this.afv)) + f.a.a.a.fQ(20, this.bMQ);
            if (this.rVZ != null) {
                fQ += f.a.a.b.b.a.h(21, this.rVZ);
            }
            if (this.rWE != null) {
                fQ += f.a.a.a.fS(22, this.rWE.boi());
            }
            return fQ + f.a.a.a.fQ(23, this.rWF);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rWz.clear();
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
            ath ath = (ath) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            atb atb;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ath.rWa = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ath.rWb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ath.rVG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atb = new atb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atb.a(aVar4, atb, a.a(aVar4))) {
                        }
                        ath.rWx = atb;
                    }
                    return 0;
                case 5:
                    ath.rWy = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atb = new atb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atb.a(aVar4, atb, a.a(aVar4))) {
                        }
                        ath.rWz.add(atb);
                    }
                    return 0;
                case 7:
                    ath.dHg = aVar3.vHC.rY();
                    return 0;
                case 8:
                    ath.rWA = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ath.jOS = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ath.rWB = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ath.token = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ath.rWk = aVar3.vHC.readString();
                    return 0;
                case 13:
                    ath.rWj = aVar3.vHC.rY();
                    return 0;
                case 14:
                    ath.videoPath = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ath.rWC = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ath.rWD = aVar3.vHC.readString();
                    return 0;
                case 17:
                    ath.bKg = aVar3.vHC.readString();
                    return 0;
                case 18:
                    ath.bPS = aVar3.vHC.readString();
                    return 0;
                case 19:
                    ath.afv = aVar3.vHC.rY();
                    return 0;
                case 20:
                    ath.bMQ = aVar3.vHC.rY();
                    return 0;
                case 21:
                    ath.rVZ = aVar3.vHC.readString();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aso aso = new aso();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aso.a(aVar4, aso, a.a(aVar4))) {
                        }
                        ath.rWE = aso;
                    }
                    return 0;
                case 23:
                    ath.rWF = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
