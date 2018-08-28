package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class jh extends bhd {
    public int bVU;
    public int mwQ;
    public String mxM;
    public String myf;
    public String myg;
    public String myi;
    public int myk;
    public String myl;
    public String mym;
    public String nickname;
    public String onE;
    public String onF;
    public xb rcG;
    public String rcH;
    public int rcI;
    public String rkC;
    public String rkD;
    public String rkE;
    public int rkF;
    public boolean rkG;
    public boolean rkH;
    public String rkI;
    public int rkJ;
    public String rkw;
    public int scene;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rkC == null) {
                throw new b("Not all required fields were included: qrcode_id");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.myl != null) {
                aVar.g(2, this.myl);
            }
            if (this.rkC != null) {
                aVar.g(3, this.rkC);
            }
            aVar.fT(4, this.scene);
            if (this.rkD != null) {
                aVar.g(5, this.rkD);
            }
            if (this.myf != null) {
                aVar.g(6, this.myf);
            }
            aVar.fT(7, this.rcI);
            aVar.fT(8, this.bVU);
            if (this.mym != null) {
                aVar.g(9, this.mym);
            }
            if (this.myg != null) {
                aVar.g(10, this.myg);
            }
            if (this.rkE != null) {
                aVar.g(11, this.rkE);
            }
            aVar.fT(12, this.rkF);
            aVar.fT(13, this.myk);
            if (this.rcH != null) {
                aVar.g(14, this.rcH);
            }
            if (this.rcG != null) {
                aVar.fV(15, this.rcG.boi());
                this.rcG.a(aVar);
            }
            if (this.rkw != null) {
                aVar.g(16, this.rkw);
            }
            aVar.fT(17, this.mwQ);
            aVar.av(18, this.rkG);
            aVar.av(19, this.rkH);
            if (this.onE != null) {
                aVar.g(20, this.onE);
            }
            if (this.onF != null) {
                aVar.g(21, this.onF);
            }
            if (this.rkI != null) {
                aVar.g(22, this.rkI);
            }
            if (this.myi != null) {
                aVar.g(23, this.myi);
            }
            if (this.nickname != null) {
                aVar.g(24, this.nickname);
            }
            if (this.mxM != null) {
                aVar.g(25, this.mxM);
            }
            aVar.fT(26, this.rkJ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.myl != null) {
                fS += f.a.a.b.b.a.h(2, this.myl);
            }
            if (this.rkC != null) {
                fS += f.a.a.b.b.a.h(3, this.rkC);
            }
            fS += f.a.a.a.fQ(4, this.scene);
            if (this.rkD != null) {
                fS += f.a.a.b.b.a.h(5, this.rkD);
            }
            if (this.myf != null) {
                fS += f.a.a.b.b.a.h(6, this.myf);
            }
            fS = (fS + f.a.a.a.fQ(7, this.rcI)) + f.a.a.a.fQ(8, this.bVU);
            if (this.mym != null) {
                fS += f.a.a.b.b.a.h(9, this.mym);
            }
            if (this.myg != null) {
                fS += f.a.a.b.b.a.h(10, this.myg);
            }
            if (this.rkE != null) {
                fS += f.a.a.b.b.a.h(11, this.rkE);
            }
            fS = (fS + f.a.a.a.fQ(12, this.rkF)) + f.a.a.a.fQ(13, this.myk);
            if (this.rcH != null) {
                fS += f.a.a.b.b.a.h(14, this.rcH);
            }
            if (this.rcG != null) {
                fS += f.a.a.a.fS(15, this.rcG.boi());
            }
            if (this.rkw != null) {
                fS += f.a.a.b.b.a.h(16, this.rkw);
            }
            fS = ((fS + f.a.a.a.fQ(17, this.mwQ)) + (f.a.a.b.b.a.ec(18) + 1)) + (f.a.a.b.b.a.ec(19) + 1);
            if (this.onE != null) {
                fS += f.a.a.b.b.a.h(20, this.onE);
            }
            if (this.onF != null) {
                fS += f.a.a.b.b.a.h(21, this.onF);
            }
            if (this.rkI != null) {
                fS += f.a.a.b.b.a.h(22, this.rkI);
            }
            if (this.myi != null) {
                fS += f.a.a.b.b.a.h(23, this.myi);
            }
            if (this.nickname != null) {
                fS += f.a.a.b.b.a.h(24, this.nickname);
            }
            if (this.mxM != null) {
                fS += f.a.a.b.b.a.h(25, this.mxM);
            }
            return fS + f.a.a.a.fQ(26, this.rkJ);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rkC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: qrcode_id");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jh jhVar = (jh) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        jhVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    jhVar.myl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jhVar.rkC = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jhVar.scene = aVar3.vHC.rY();
                    return 0;
                case 5:
                    jhVar.rkD = aVar3.vHC.readString();
                    return 0;
                case 6:
                    jhVar.myf = aVar3.vHC.readString();
                    return 0;
                case 7:
                    jhVar.rcI = aVar3.vHC.rY();
                    return 0;
                case 8:
                    jhVar.bVU = aVar3.vHC.rY();
                    return 0;
                case 9:
                    jhVar.mym = aVar3.vHC.readString();
                    return 0;
                case 10:
                    jhVar.myg = aVar3.vHC.readString();
                    return 0;
                case 11:
                    jhVar.rkE = aVar3.vHC.readString();
                    return 0;
                case 12:
                    jhVar.rkF = aVar3.vHC.rY();
                    return 0;
                case 13:
                    jhVar.myk = aVar3.vHC.rY();
                    return 0;
                case 14:
                    jhVar.rcH = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xb xbVar = new xb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xbVar.a(aVar4, xbVar, bhd.a(aVar4))) {
                        }
                        jhVar.rcG = xbVar;
                    }
                    return 0;
                case 16:
                    jhVar.rkw = aVar3.vHC.readString();
                    return 0;
                case 17:
                    jhVar.mwQ = aVar3.vHC.rY();
                    return 0;
                case 18:
                    jhVar.rkG = aVar3.cJQ();
                    return 0;
                case 19:
                    jhVar.rkH = aVar3.cJQ();
                    return 0;
                case 20:
                    jhVar.onE = aVar3.vHC.readString();
                    return 0;
                case 21:
                    jhVar.onF = aVar3.vHC.readString();
                    return 0;
                case 22:
                    jhVar.rkI = aVar3.vHC.readString();
                    return 0;
                case 23:
                    jhVar.myi = aVar3.vHC.readString();
                    return 0;
                case 24:
                    jhVar.nickname = aVar3.vHC.readString();
                    return 0;
                case 25:
                    jhVar.mxM = aVar3.vHC.readString();
                    return 0;
                case 26:
                    jhVar.rkJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
