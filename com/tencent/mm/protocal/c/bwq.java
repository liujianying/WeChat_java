package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.appbrand.s$l;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwq extends bhd {
    public String jTu;
    public String jTv;
    public String rPP;
    public String rPR;
    public int rVp;
    public int rVq;
    public bhy rVr;
    public int rVs;
    public String rco;
    public String rdo;
    public int rdq;
    public int rmA;
    public int rmB;
    public String rmy;
    public int rmz;
    public int rvT;
    public int rwB;
    public int sjV;
    public int slf;
    public int ssI;
    public int ssJ;
    public int ssK;
    public int ssQ;
    public int ssR;
    public bhy ssS;
    public int ssT;
    public String ssU;
    public int ssV;
    public String ssW;
    public String ssX;
    public int ssY;
    public String ssZ;
    public String sta;
    public String stb;
    public String stc;
    public String std;
    public String ste;
    public String stf;
    public String stg;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rVr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.ssS == null) {
                throw new b("Not all required fields were included: VideoData");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rdo != null) {
                    aVar.g(2, this.rdo);
                }
                if (this.jTv != null) {
                    aVar.g(3, this.jTv);
                }
                if (this.jTu != null) {
                    aVar.g(4, this.jTu);
                }
                aVar.fT(5, this.rVp);
                aVar.fT(6, this.rVq);
                if (this.rVr != null) {
                    aVar.fV(7, this.rVr.boi());
                    this.rVr.a(aVar);
                }
                aVar.fT(8, this.ssQ);
                aVar.fT(9, this.ssR);
                if (this.ssS != null) {
                    aVar.fV(10, this.ssS.boi());
                    this.ssS.a(aVar);
                }
                aVar.fT(11, this.slf);
                aVar.fT(12, this.rvT);
                aVar.fT(13, this.rVs);
                aVar.fT(14, this.ssT);
                if (this.rco != null) {
                    aVar.g(15, this.rco);
                }
                if (this.ssU != null) {
                    aVar.g(16, this.ssU);
                }
                if (this.rmy != null) {
                    aVar.g(17, this.rmy);
                }
                aVar.fT(18, this.rmz);
                if (this.rPP != null) {
                    aVar.g(19, this.rPP);
                }
                aVar.fT(20, this.ssI);
                aVar.fT(21, this.ssJ);
                aVar.fT(22, this.ssK);
                if (this.rPR != null) {
                    aVar.g(23, this.rPR);
                }
                aVar.fT(24, this.ssV);
                aVar.fT(25, this.rwB);
                if (this.ssW != null) {
                    aVar.g(26, this.ssW);
                }
                if (this.ssX != null) {
                    aVar.g(27, this.ssX);
                }
                aVar.fT(28, this.ssY);
                if (this.ssZ != null) {
                    aVar.g(29, this.ssZ);
                }
                if (this.sta != null) {
                    aVar.g(30, this.sta);
                }
                if (this.stb != null) {
                    aVar.g(31, this.stb);
                }
                if (this.stc != null) {
                    aVar.g(32, this.stc);
                }
                if (this.std != null) {
                    aVar.g(33, this.std);
                }
                if (this.ste != null) {
                    aVar.g(34, this.ste);
                }
                if (this.stf != null) {
                    aVar.g(35, this.stf);
                }
                aVar.fT(36, this.sjV);
                if (this.stg != null) {
                    aVar.g(37, this.stg);
                }
                aVar.fT(38, this.rmA);
                aVar.fT(39, this.rmB);
                aVar.fT(40, this.rdq);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rdo != null) {
                fS += f.a.a.b.b.a.h(2, this.rdo);
            }
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(3, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(4, this.jTu);
            }
            fS = (fS + f.a.a.a.fQ(5, this.rVp)) + f.a.a.a.fQ(6, this.rVq);
            if (this.rVr != null) {
                fS += f.a.a.a.fS(7, this.rVr.boi());
            }
            fS = (fS + f.a.a.a.fQ(8, this.ssQ)) + f.a.a.a.fQ(9, this.ssR);
            if (this.ssS != null) {
                fS += f.a.a.a.fS(10, this.ssS.boi());
            }
            fS = (((fS + f.a.a.a.fQ(11, this.slf)) + f.a.a.a.fQ(12, this.rvT)) + f.a.a.a.fQ(13, this.rVs)) + f.a.a.a.fQ(14, this.ssT);
            if (this.rco != null) {
                fS += f.a.a.b.b.a.h(15, this.rco);
            }
            if (this.ssU != null) {
                fS += f.a.a.b.b.a.h(16, this.ssU);
            }
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(17, this.rmy);
            }
            fS += f.a.a.a.fQ(18, this.rmz);
            if (this.rPP != null) {
                fS += f.a.a.b.b.a.h(19, this.rPP);
            }
            fS = ((fS + f.a.a.a.fQ(20, this.ssI)) + f.a.a.a.fQ(21, this.ssJ)) + f.a.a.a.fQ(22, this.ssK);
            if (this.rPR != null) {
                fS += f.a.a.b.b.a.h(23, this.rPR);
            }
            fS = (fS + f.a.a.a.fQ(24, this.ssV)) + f.a.a.a.fQ(25, this.rwB);
            if (this.ssW != null) {
                fS += f.a.a.b.b.a.h(26, this.ssW);
            }
            if (this.ssX != null) {
                fS += f.a.a.b.b.a.h(27, this.ssX);
            }
            fS += f.a.a.a.fQ(28, this.ssY);
            if (this.ssZ != null) {
                fS += f.a.a.b.b.a.h(29, this.ssZ);
            }
            if (this.sta != null) {
                fS += f.a.a.b.b.a.h(30, this.sta);
            }
            if (this.stb != null) {
                fS += f.a.a.b.b.a.h(31, this.stb);
            }
            if (this.stc != null) {
                fS += f.a.a.b.b.a.h(32, this.stc);
            }
            if (this.std != null) {
                fS += f.a.a.b.b.a.h(33, this.std);
            }
            if (this.ste != null) {
                fS += f.a.a.b.b.a.h(34, this.ste);
            }
            if (this.stf != null) {
                fS += f.a.a.b.b.a.h(35, this.stf);
            }
            fS += f.a.a.a.fQ(36, this.sjV);
            if (this.stg != null) {
                fS += f.a.a.b.b.a.h(37, this.stg);
            }
            return ((fS + f.a.a.a.fQ(38, this.rmA)) + f.a.a.a.fQ(39, this.rmB)) + f.a.a.a.fQ(40, this.rdq);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rVr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.ssS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: VideoData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bwq bwq = (bwq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
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
                        bwq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bwq.rdo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwq.jTv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bwq.jTu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bwq.rVp = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bwq.rVq = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwq.rVr = bhy;
                    }
                    return 0;
                case 8:
                    bwq.ssQ = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bwq.ssR = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwq.ssS = bhy;
                    }
                    return 0;
                case 11:
                    bwq.slf = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bwq.rvT = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bwq.rVs = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bwq.ssT = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bwq.rco = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bwq.ssU = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bwq.rmy = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bwq.rmz = aVar3.vHC.rY();
                    return 0;
                case 19:
                    bwq.rPP = aVar3.vHC.readString();
                    return 0;
                case 20:
                    bwq.ssI = aVar3.vHC.rY();
                    return 0;
                case 21:
                    bwq.ssJ = aVar3.vHC.rY();
                    return 0;
                case 22:
                    bwq.ssK = aVar3.vHC.rY();
                    return 0;
                case 23:
                    bwq.rPR = aVar3.vHC.readString();
                    return 0;
                case 24:
                    bwq.ssV = aVar3.vHC.rY();
                    return 0;
                case 25:
                    bwq.rwB = aVar3.vHC.rY();
                    return 0;
                case 26:
                    bwq.ssW = aVar3.vHC.readString();
                    return 0;
                case 27:
                    bwq.ssX = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    bwq.ssY = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeBackground /*29*/:
                    bwq.ssZ = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                    bwq.sta = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    bwq.stb = aVar3.vHC.readString();
                    return 0;
                case 32:
                    bwq.stc = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    bwq.std = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                    bwq.ste = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    bwq.stf = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                    bwq.sjV = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                    bwq.stg = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    bwq.rmA = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    bwq.rmB = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    bwq.rdq = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
