package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.appbrand.s$l;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwi extends bhd {
    public String jQb;
    public int jQd;
    public int rJr;
    public String rPR;
    public String raM;
    public String raN;
    public String raO;
    public bhz rcj;
    public bhz rck;
    public String rco;
    public int rdV;
    public int rdW;
    public int rdX;
    public int rmA;
    public int rmB;
    public String rmy;
    public int rmz;
    public bhy rtW;
    public int rth;
    public String rvP;
    public int rwB;
    public String rwk;
    public int sjV;
    public int soa;
    public bhz ssC;
    public String ssD;
    public String ssE;
    public int ssF;
    public int ssG;
    public String ssH;
    public int ssI;
    public int ssJ;
    public int ssK;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ssC == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ssC != null) {
                    aVar.fV(2, this.ssC.boi());
                    this.ssC.a(aVar);
                }
                if (this.rcj != null) {
                    aVar.fV(3, this.rcj.boi());
                    this.rcj.a(aVar);
                }
                if (this.rck != null) {
                    aVar.fV(4, this.rck.boi());
                    this.rck.a(aVar);
                }
                aVar.fT(5, this.rdV);
                aVar.fT(6, this.rdW);
                aVar.fT(7, this.rdX);
                if (this.rtW != null) {
                    aVar.fV(8, this.rtW.boi());
                    this.rtW.a(aVar);
                }
                aVar.fT(9, this.jQd);
                if (this.rco != null) {
                    aVar.g(10, this.rco);
                }
                aVar.fT(11, this.rJr);
                aVar.fT(12, this.rth);
                aVar.fT(13, this.soa);
                if (this.rvP != null) {
                    aVar.g(14, this.rvP);
                }
                if (this.ssD != null) {
                    aVar.g(15, this.ssD);
                }
                if (this.ssE != null) {
                    aVar.g(16, this.ssE);
                }
                if (this.rmy != null) {
                    aVar.g(17, this.rmy);
                }
                aVar.fT(18, this.rmz);
                aVar.fT(19, this.ssF);
                aVar.fT(20, this.ssG);
                if (this.ssH != null) {
                    aVar.g(21, this.ssH);
                }
                aVar.fT(22, this.ssI);
                aVar.fT(23, this.ssJ);
                aVar.fT(24, this.ssK);
                if (this.rPR != null) {
                    aVar.g(25, this.rPR);
                }
                aVar.fT(26, this.rwB);
                if (this.rwk != null) {
                    aVar.g(27, this.rwk);
                }
                aVar.fT(28, this.rmA);
                aVar.fT(29, this.rmB);
                aVar.fT(30, this.sjV);
                if (this.jQb != null) {
                    aVar.g(31, this.jQb);
                }
                if (this.raO != null) {
                    aVar.g(32, this.raO);
                }
                if (this.raN != null) {
                    aVar.g(33, this.raN);
                }
                if (this.raM == null) {
                    return 0;
                }
                aVar.g(34, this.raM);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ssC != null) {
                fS += f.a.a.a.fS(2, this.ssC.boi());
            }
            if (this.rcj != null) {
                fS += f.a.a.a.fS(3, this.rcj.boi());
            }
            if (this.rck != null) {
                fS += f.a.a.a.fS(4, this.rck.boi());
            }
            fS = ((fS + f.a.a.a.fQ(5, this.rdV)) + f.a.a.a.fQ(6, this.rdW)) + f.a.a.a.fQ(7, this.rdX);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(8, this.rtW.boi());
            }
            fS += f.a.a.a.fQ(9, this.jQd);
            if (this.rco != null) {
                fS += f.a.a.b.b.a.h(10, this.rco);
            }
            fS = ((fS + f.a.a.a.fQ(11, this.rJr)) + f.a.a.a.fQ(12, this.rth)) + f.a.a.a.fQ(13, this.soa);
            if (this.rvP != null) {
                fS += f.a.a.b.b.a.h(14, this.rvP);
            }
            if (this.ssD != null) {
                fS += f.a.a.b.b.a.h(15, this.ssD);
            }
            if (this.ssE != null) {
                fS += f.a.a.b.b.a.h(16, this.ssE);
            }
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(17, this.rmy);
            }
            fS = ((fS + f.a.a.a.fQ(18, this.rmz)) + f.a.a.a.fQ(19, this.ssF)) + f.a.a.a.fQ(20, this.ssG);
            if (this.ssH != null) {
                fS += f.a.a.b.b.a.h(21, this.ssH);
            }
            fS = ((fS + f.a.a.a.fQ(22, this.ssI)) + f.a.a.a.fQ(23, this.ssJ)) + f.a.a.a.fQ(24, this.ssK);
            if (this.rPR != null) {
                fS += f.a.a.b.b.a.h(25, this.rPR);
            }
            fS += f.a.a.a.fQ(26, this.rwB);
            if (this.rwk != null) {
                fS += f.a.a.b.b.a.h(27, this.rwk);
            }
            fS = ((fS + f.a.a.a.fQ(28, this.rmA)) + f.a.a.a.fQ(29, this.rmB)) + f.a.a.a.fQ(30, this.sjV);
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(31, this.jQb);
            }
            if (this.raO != null) {
                fS += f.a.a.b.b.a.h(32, this.raO);
            }
            if (this.raN != null) {
                fS += f.a.a.b.b.a.h(33, this.raN);
            }
            if (this.raM != null) {
                fS += f.a.a.b.b.a.h(34, this.raM);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ssC == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rtW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bwi bwi = (bwi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
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
                        bwi.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bwi.ssC = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        bwi.rcj = bhz;
                    }
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
                        bwi.rck = bhz;
                    }
                    return 0;
                case 5:
                    bwi.rdV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bwi.rdW = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bwi.rdX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwi.rtW = bhy;
                    }
                    return 0;
                case 9:
                    bwi.jQd = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bwi.rco = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bwi.rJr = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bwi.rth = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bwi.soa = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bwi.rvP = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bwi.ssD = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bwi.ssE = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bwi.rmy = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bwi.rmz = aVar3.vHC.rY();
                    return 0;
                case 19:
                    bwi.ssF = aVar3.vHC.rY();
                    return 0;
                case 20:
                    bwi.ssG = aVar3.vHC.rY();
                    return 0;
                case 21:
                    bwi.ssH = aVar3.vHC.readString();
                    return 0;
                case 22:
                    bwi.ssI = aVar3.vHC.rY();
                    return 0;
                case 23:
                    bwi.ssJ = aVar3.vHC.rY();
                    return 0;
                case 24:
                    bwi.ssK = aVar3.vHC.rY();
                    return 0;
                case 25:
                    bwi.rPR = aVar3.vHC.readString();
                    return 0;
                case 26:
                    bwi.rwB = aVar3.vHC.rY();
                    return 0;
                case 27:
                    bwi.rwk = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    bwi.rmA = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeBackground /*29*/:
                    bwi.rmB = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                    bwi.sjV = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    bwi.jQb = aVar3.vHC.readString();
                    return 0;
                case 32:
                    bwi.raO = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    bwi.raN = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                    bwi.raM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
