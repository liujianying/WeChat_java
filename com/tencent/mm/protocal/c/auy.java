package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.sns.i$l;
import java.util.LinkedList;

public final class auy extends a {
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
    public int hcd;
    public bhz rQz;
    public int rTe;
    public String rTf;
    public String rTg;
    public String rTh;
    public int rTi;
    public int rXL;
    public int rXQ;
    public b rXR;
    public int rXT;
    public bhz rXU;
    public bhz rXV;
    public int rXW;
    public int rXX;
    public int rXY;
    public int rXZ;
    public int rXf;
    public sh rXz;
    public int rYa;
    public alb rYb;
    public int rYc;
    public String rYd;
    public int raB;
    public int ray;
    public bhz rvi;
    public long ryG;
    public String ryH;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvi == null) {
                throw new f.a.a.b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new f.a.a.b("Not all required fields were included: NickName");
            } else if (this.rXU == null) {
                throw new f.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.rXV == null) {
                throw new f.a.a.b("Not all required fields were included: BindMobile");
            } else {
                aVar.fT(1, this.rXT);
                if (this.rvi != null) {
                    aVar.fV(2, this.rvi.boi());
                    this.rvi.a(aVar);
                }
                if (this.rQz != null) {
                    aVar.fV(3, this.rQz.boi());
                    this.rQz.a(aVar);
                }
                aVar.fT(4, this.ray);
                if (this.rXU != null) {
                    aVar.fV(5, this.rXU.boi());
                    this.rXU.a(aVar);
                }
                if (this.rXV != null) {
                    aVar.fV(6, this.rXV.boi());
                    this.rXV.a(aVar);
                }
                aVar.fT(7, this.hcd);
                aVar.fT(8, this.rXQ);
                if (this.rXR != null) {
                    aVar.b(9, this.rXR);
                }
                aVar.fT(10, this.eJH);
                if (this.eJI != null) {
                    aVar.g(11, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(12, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(13, this.eJK);
                }
                aVar.fT(14, this.eJL);
                if (this.rXz != null) {
                    aVar.fV(15, this.rXz.boi());
                    this.rXz.a(aVar);
                }
                aVar.fT(16, this.raB);
                aVar.fT(17, this.rTe);
                if (this.rTf != null) {
                    aVar.g(18, this.rTf);
                }
                aVar.fT(19, this.rXW);
                aVar.fT(20, this.rXX);
                aVar.fT(21, this.rXf);
                aVar.fT(22, this.rXY);
                aVar.fT(23, this.rXZ);
                if (this.rTg != null) {
                    aVar.g(24, this.rTg);
                }
                aVar.fT(25, this.rYa);
                if (this.rYb != null) {
                    aVar.fV(26, this.rYb.boi());
                    this.rYb.a(aVar);
                }
                if (this.eJM != null) {
                    aVar.g(27, this.eJM);
                }
                if (this.rTh != null) {
                    aVar.g(28, this.rTh);
                }
                aVar.fT(29, this.rTi);
                aVar.fT(30, this.rYc);
                aVar.T(31, this.ryG);
                if (this.ryH != null) {
                    aVar.g(32, this.ryH);
                }
                aVar.fT(33, this.eJO);
                aVar.fT(34, this.eJN);
                if (this.eJP != null) {
                    aVar.g(35, this.eJP);
                }
                aVar.fT(36, this.rXL);
                if (this.rYd != null) {
                    aVar.g(37, this.rYd);
                }
                if (this.eJQ != null) {
                    aVar.g(38, this.eJQ);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rXT) + 0;
            if (this.rvi != null) {
                fQ += f.a.a.a.fS(2, this.rvi.boi());
            }
            if (this.rQz != null) {
                fQ += f.a.a.a.fS(3, this.rQz.boi());
            }
            fQ += f.a.a.a.fQ(4, this.ray);
            if (this.rXU != null) {
                fQ += f.a.a.a.fS(5, this.rXU.boi());
            }
            if (this.rXV != null) {
                fQ += f.a.a.a.fS(6, this.rXV.boi());
            }
            fQ = (fQ + f.a.a.a.fQ(7, this.hcd)) + f.a.a.a.fQ(8, this.rXQ);
            if (this.rXR != null) {
                fQ += f.a.a.a.a(9, this.rXR);
            }
            fQ += f.a.a.a.fQ(10, this.eJH);
            if (this.eJI != null) {
                fQ += f.a.a.b.b.a.h(11, this.eJI);
            }
            if (this.eJJ != null) {
                fQ += f.a.a.b.b.a.h(12, this.eJJ);
            }
            if (this.eJK != null) {
                fQ += f.a.a.b.b.a.h(13, this.eJK);
            }
            fQ += f.a.a.a.fQ(14, this.eJL);
            if (this.rXz != null) {
                fQ += f.a.a.a.fS(15, this.rXz.boi());
            }
            fQ = (fQ + f.a.a.a.fQ(16, this.raB)) + f.a.a.a.fQ(17, this.rTe);
            if (this.rTf != null) {
                fQ += f.a.a.b.b.a.h(18, this.rTf);
            }
            fQ = ((((fQ + f.a.a.a.fQ(19, this.rXW)) + f.a.a.a.fQ(20, this.rXX)) + f.a.a.a.fQ(21, this.rXf)) + f.a.a.a.fQ(22, this.rXY)) + f.a.a.a.fQ(23, this.rXZ);
            if (this.rTg != null) {
                fQ += f.a.a.b.b.a.h(24, this.rTg);
            }
            fQ += f.a.a.a.fQ(25, this.rYa);
            if (this.rYb != null) {
                fQ += f.a.a.a.fS(26, this.rYb.boi());
            }
            if (this.eJM != null) {
                fQ += f.a.a.b.b.a.h(27, this.eJM);
            }
            if (this.rTh != null) {
                fQ += f.a.a.b.b.a.h(28, this.rTh);
            }
            fQ = ((fQ + f.a.a.a.fQ(29, this.rTi)) + f.a.a.a.fQ(30, this.rYc)) + f.a.a.a.S(31, this.ryG);
            if (this.ryH != null) {
                fQ += f.a.a.b.b.a.h(32, this.ryH);
            }
            fQ = (fQ + f.a.a.a.fQ(33, this.eJO)) + f.a.a.a.fQ(34, this.eJN);
            if (this.eJP != null) {
                fQ += f.a.a.b.b.a.h(35, this.eJP);
            }
            fQ += f.a.a.a.fQ(36, this.rXL);
            if (this.rYd != null) {
                fQ += f.a.a.b.b.a.h(37, this.rYd);
            }
            if (this.eJQ != null) {
                return fQ + f.a.a.b.b.a.h(38, this.eJQ);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rvi == null) {
                throw new f.a.a.b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new f.a.a.b("Not all required fields were included: NickName");
            } else if (this.rXU == null) {
                throw new f.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.rXV != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: BindMobile");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            auy auy = (auy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhz bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    auy.rXT = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        auy.rvi = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        auy.rQz = bhz;
                    }
                    return 0;
                case 4:
                    auy.ray = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        auy.rXU = bhz;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        auy.rXV = bhz;
                    }
                    return 0;
                case 7:
                    auy.hcd = aVar3.vHC.rY();
                    return 0;
                case 8:
                    auy.rXQ = aVar3.vHC.rY();
                    return 0;
                case 9:
                    auy.rXR = aVar3.cJR();
                    return 0;
                case 10:
                    auy.eJH = aVar3.vHC.rY();
                    return 0;
                case 11:
                    auy.eJI = aVar3.vHC.readString();
                    return 0;
                case 12:
                    auy.eJJ = aVar3.vHC.readString();
                    return 0;
                case 13:
                    auy.eJK = aVar3.vHC.readString();
                    return 0;
                case 14:
                    auy.eJL = aVar3.vHC.rY();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sh shVar = new sh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = shVar.a(aVar4, shVar, a.a(aVar4))) {
                        }
                        auy.rXz = shVar;
                    }
                    return 0;
                case 16:
                    auy.raB = aVar3.vHC.rY();
                    return 0;
                case 17:
                    auy.rTe = aVar3.vHC.rY();
                    return 0;
                case 18:
                    auy.rTf = aVar3.vHC.readString();
                    return 0;
                case 19:
                    auy.rXW = aVar3.vHC.rY();
                    return 0;
                case 20:
                    auy.rXX = aVar3.vHC.rY();
                    return 0;
                case 21:
                    auy.rXf = aVar3.vHC.rY();
                    return 0;
                case 22:
                    auy.rXY = aVar3.vHC.rY();
                    return 0;
                case 23:
                    auy.rXZ = aVar3.vHC.rY();
                    return 0;
                case 24:
                    auy.rTg = aVar3.vHC.readString();
                    return 0;
                case 25:
                    auy.rYa = aVar3.vHC.rY();
                    return 0;
                case 26:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alb alb = new alb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        auy.rYb = alb;
                    }
                    return 0;
                case i$l.AppCompatTheme_actionModeStyle /*27*/:
                    auy.eJM = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    auy.rTh = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeBackground /*29*/:
                    auy.rTi = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                    auy.rYc = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    auy.ryG = aVar3.vHC.rZ();
                    return 0;
                case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                    auy.ryH = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    auy.eJO = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                    auy.eJN = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    auy.eJP = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                    auy.rXL = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                    auy.rYd = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    auy.eJQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
