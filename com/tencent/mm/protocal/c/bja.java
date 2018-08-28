package com.tencent.mm.protocal.c;

import android.support.design.a$i;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bja extends bhp {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public int eJL;
    public String eJM;
    public int eJN;
    public int eJO;
    public String eJP;
    public String eJQ;
    public String eJR;
    public String rEJ;
    public int rHb;
    public LinkedList<biy> rHc = new LinkedList();
    public bhz rQz;
    public int rTe;
    public String rTf;
    public String rTg;
    public String rTh;
    public int rTi;
    public bqd rTk;
    public qt rTl;
    public bhy rcn;
    public String rqZ;
    public String rra;
    public bhz ruT;
    public bhz ruU;
    public bhz rvi;
    public int sjj;
    public bhy sjl;
    public String sjm;
    public String sjn;
    public int sjo;
    public LinkedList<bjp> sjp = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rvi != null) {
                    aVar.fV(2, this.rvi.boi());
                    this.rvi.a(aVar);
                }
                if (this.rQz != null) {
                    aVar.fV(3, this.rQz.boi());
                    this.rQz.a(aVar);
                }
                if (this.ruT != null) {
                    aVar.fV(4, this.ruT.boi());
                    this.ruT.a(aVar);
                }
                if (this.ruU != null) {
                    aVar.fV(5, this.ruU.boi());
                    this.ruU.a(aVar);
                }
                aVar.fT(6, this.eJH);
                if (this.rcn != null) {
                    aVar.fV(7, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                if (this.eJI != null) {
                    aVar.g(8, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(9, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(10, this.eJK);
                }
                aVar.fT(11, this.eJL);
                aVar.fT(12, this.rTe);
                if (this.rTf != null) {
                    aVar.g(13, this.rTf);
                }
                if (this.rTg != null) {
                    aVar.g(14, this.rTg);
                }
                if (this.eJM != null) {
                    aVar.g(15, this.eJM);
                }
                if (this.rTh != null) {
                    aVar.g(16, this.rTh);
                }
                aVar.fT(17, this.rTi);
                aVar.fT(18, this.eJO);
                aVar.fT(19, this.eJN);
                if (this.eJP != null) {
                    aVar.g(20, this.eJP);
                }
                if (this.rTk != null) {
                    aVar.fV(21, this.rTk.boi());
                    this.rTk.a(aVar);
                }
                if (this.eJQ != null) {
                    aVar.g(22, this.eJQ);
                }
                if (this.eJR != null) {
                    aVar.g(23, this.eJR);
                }
                if (this.rTl != null) {
                    aVar.fV(24, this.rTl.boi());
                    this.rTl.a(aVar);
                }
                aVar.fT(25, this.rHb);
                aVar.d(26, 8, this.rHc);
                if (this.rqZ != null) {
                    aVar.g(27, this.rqZ);
                }
                if (this.rra != null) {
                    aVar.g(28, this.rra);
                }
                if (this.sjl != null) {
                    aVar.fV(29, this.sjl.boi());
                    this.sjl.a(aVar);
                }
                if (this.rEJ != null) {
                    aVar.g(30, this.rEJ);
                }
                if (this.sjm != null) {
                    aVar.g(31, this.sjm);
                }
                aVar.fT(32, this.sjj);
                if (this.sjn != null) {
                    aVar.g(33, this.sjn);
                }
                aVar.fT(34, this.sjo);
                aVar.d(35, 8, this.sjp);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rvi != null) {
                fS += f.a.a.a.fS(2, this.rvi.boi());
            }
            if (this.rQz != null) {
                fS += f.a.a.a.fS(3, this.rQz.boi());
            }
            if (this.ruT != null) {
                fS += f.a.a.a.fS(4, this.ruT.boi());
            }
            if (this.ruU != null) {
                fS += f.a.a.a.fS(5, this.ruU.boi());
            }
            fS += f.a.a.a.fQ(6, this.eJH);
            if (this.rcn != null) {
                fS += f.a.a.a.fS(7, this.rcn.boi());
            }
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(8, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(9, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(10, this.eJK);
            }
            fS = (fS + f.a.a.a.fQ(11, this.eJL)) + f.a.a.a.fQ(12, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(13, this.rTf);
            }
            if (this.rTg != null) {
                fS += f.a.a.b.b.a.h(14, this.rTg);
            }
            if (this.eJM != null) {
                fS += f.a.a.b.b.a.h(15, this.eJM);
            }
            if (this.rTh != null) {
                fS += f.a.a.b.b.a.h(16, this.rTh);
            }
            fS = ((fS + f.a.a.a.fQ(17, this.rTi)) + f.a.a.a.fQ(18, this.eJO)) + f.a.a.a.fQ(19, this.eJN);
            if (this.eJP != null) {
                fS += f.a.a.b.b.a.h(20, this.eJP);
            }
            if (this.rTk != null) {
                fS += f.a.a.a.fS(21, this.rTk.boi());
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(22, this.eJQ);
            }
            if (this.eJR != null) {
                fS += f.a.a.b.b.a.h(23, this.eJR);
            }
            if (this.rTl != null) {
                fS += f.a.a.a.fS(24, this.rTl.boi());
            }
            fS = (fS + f.a.a.a.fQ(25, this.rHb)) + f.a.a.a.c(26, 8, this.rHc);
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(27, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(28, this.rra);
            }
            if (this.sjl != null) {
                fS += f.a.a.a.fS(29, this.sjl.boi());
            }
            if (this.rEJ != null) {
                fS += f.a.a.b.b.a.h(30, this.rEJ);
            }
            if (this.sjm != null) {
                fS += f.a.a.b.b.a.h(31, this.sjm);
            }
            fS += f.a.a.a.fQ(32, this.sjj);
            if (this.sjn != null) {
                fS += f.a.a.b.b.a.h(33, this.sjn);
            }
            return (fS + f.a.a.a.fQ(34, this.sjo)) + f.a.a.a.c(35, 8, this.sjp);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHc.clear();
            this.sjp.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bja bja = (bja) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
            bhy bhy;
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
                        bja.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bja.rvi = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bja.rQz = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bja.ruT = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bja.ruU = bhz;
                    }
                    return 0;
                case 6:
                    bja.eJH = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bja.rcn = bhy;
                    }
                    return 0;
                case 8:
                    bja.eJI = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bja.eJJ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bja.eJK = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bja.eJL = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bja.rTe = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bja.rTf = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bja.rTg = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bja.eJM = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bja.rTh = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bja.rTi = aVar3.vHC.rY();
                    return 0;
                case 18:
                    bja.eJO = aVar3.vHC.rY();
                    return 0;
                case 19:
                    bja.eJN = aVar3.vHC.rY();
                    return 0;
                case 20:
                    bja.eJP = aVar3.vHC.readString();
                    return 0;
                case 21:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, bhp.a(aVar4))) {
                        }
                        bja.rTk = bqd;
                    }
                    return 0;
                case 22:
                    bja.eJQ = aVar3.vHC.readString();
                    return 0;
                case 23:
                    bja.eJR = aVar3.vHC.readString();
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, bhp.a(aVar4))) {
                        }
                        bja.rTl = qtVar;
                    }
                    return 0;
                case 25:
                    bja.rHb = aVar3.vHC.rY();
                    return 0;
                case 26:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        biy biy = new biy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = biy.a(aVar4, biy, bhp.a(aVar4))) {
                        }
                        bja.rHc.add(biy);
                    }
                    return 0;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    bja.rqZ = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    bja.rra = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeBackground /*29*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bja.sjl = bhy;
                    }
                    return 0;
                case 30:
                    bja.rEJ = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    bja.sjm = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                    bja.sjj = aVar3.vHC.rY();
                    return 0;
                case a$i.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    bja.sjn = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                    bja.sjo = aVar3.vHC.rY();
                    return 0;
                case a$i.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bjp bjp = new bjp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjp.a(aVar4, bjp, bhp.a(aVar4))) {
                        }
                        bja.sjp.add(bjp);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
