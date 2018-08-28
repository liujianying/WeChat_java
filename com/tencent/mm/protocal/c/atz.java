package com.tencent.mm.protocal.c;

import android.support.design.a$i;
import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class atz extends a {
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
    public String rKZ;
    public bhz rQz;
    public int rTe;
    public String rTf;
    public String rTg;
    public String rTh;
    public int rTi;
    public bqd rTk;
    public qt rTl;
    public bhz rWH;
    public bhz rWI;
    public bhz rWJ;
    public int rWZ;
    public bhy rcn;
    public String rqZ;
    public String rra;
    public bhz ruT;
    public bhz ruU;
    public int rup;
    public bhz rvi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.rWH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.rWI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.rWJ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.rvi != null) {
                    aVar.fV(1, this.rvi.boi());
                    this.rvi.a(aVar);
                }
                if (this.rQz != null) {
                    aVar.fV(2, this.rQz.boi());
                    this.rQz.a(aVar);
                }
                if (this.ruT != null) {
                    aVar.fV(3, this.ruT.boi());
                    this.ruT.a(aVar);
                }
                if (this.ruU != null) {
                    aVar.fV(4, this.ruU.boi());
                    this.ruU.a(aVar);
                }
                aVar.fT(5, this.eJH);
                if (this.rcn != null) {
                    aVar.fV(6, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                aVar.fT(7, this.rWZ);
                if (this.rWH != null) {
                    aVar.fV(8, this.rWH.boi());
                    this.rWH.a(aVar);
                }
                if (this.rWI != null) {
                    aVar.fV(9, this.rWI.boi());
                    this.rWI.a(aVar);
                }
                if (this.rWJ != null) {
                    aVar.fV(10, this.rWJ.boi());
                    this.rWJ.a(aVar);
                }
                aVar.fT(11, this.rup);
                if (this.eJI != null) {
                    aVar.g(12, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(13, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(14, this.eJK);
                }
                aVar.fT(15, this.eJL);
                aVar.fT(16, this.rTe);
                if (this.rTf != null) {
                    aVar.g(17, this.rTf);
                }
                if (this.rTg != null) {
                    aVar.g(18, this.rTg);
                }
                if (this.rKZ != null) {
                    aVar.g(19, this.rKZ);
                }
                if (this.rTh != null) {
                    aVar.g(20, this.rTh);
                }
                aVar.fT(21, this.rTi);
                aVar.fT(22, this.eJO);
                aVar.fT(23, this.eJN);
                if (this.eJP != null) {
                    aVar.g(24, this.eJP);
                }
                if (this.eJM != null) {
                    aVar.g(25, this.eJM);
                }
                if (this.rTk != null) {
                    aVar.fV(26, this.rTk.boi());
                    this.rTk.a(aVar);
                }
                if (this.eJQ != null) {
                    aVar.g(27, this.eJQ);
                }
                if (this.rqZ != null) {
                    aVar.g(28, this.rqZ);
                }
                if (this.rra != null) {
                    aVar.g(29, this.rra);
                }
                if (this.eJR != null) {
                    aVar.g(30, this.eJR);
                }
                if (this.rTl == null) {
                    return 0;
                }
                aVar.fV(31, this.rTl.boi());
                this.rTl.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rvi != null) {
                fS = f.a.a.a.fS(1, this.rvi.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rQz != null) {
                fS += f.a.a.a.fS(2, this.rQz.boi());
            }
            if (this.ruT != null) {
                fS += f.a.a.a.fS(3, this.ruT.boi());
            }
            if (this.ruU != null) {
                fS += f.a.a.a.fS(4, this.ruU.boi());
            }
            fS += f.a.a.a.fQ(5, this.eJH);
            if (this.rcn != null) {
                fS += f.a.a.a.fS(6, this.rcn.boi());
            }
            fS += f.a.a.a.fQ(7, this.rWZ);
            if (this.rWH != null) {
                fS += f.a.a.a.fS(8, this.rWH.boi());
            }
            if (this.rWI != null) {
                fS += f.a.a.a.fS(9, this.rWI.boi());
            }
            if (this.rWJ != null) {
                fS += f.a.a.a.fS(10, this.rWJ.boi());
            }
            fS += f.a.a.a.fQ(11, this.rup);
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(12, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(13, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(14, this.eJK);
            }
            fS = (fS + f.a.a.a.fQ(15, this.eJL)) + f.a.a.a.fQ(16, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(17, this.rTf);
            }
            if (this.rTg != null) {
                fS += f.a.a.b.b.a.h(18, this.rTg);
            }
            if (this.rKZ != null) {
                fS += f.a.a.b.b.a.h(19, this.rKZ);
            }
            if (this.rTh != null) {
                fS += f.a.a.b.b.a.h(20, this.rTh);
            }
            fS = ((fS + f.a.a.a.fQ(21, this.rTi)) + f.a.a.a.fQ(22, this.eJO)) + f.a.a.a.fQ(23, this.eJN);
            if (this.eJP != null) {
                fS += f.a.a.b.b.a.h(24, this.eJP);
            }
            if (this.eJM != null) {
                fS += f.a.a.b.b.a.h(25, this.eJM);
            }
            if (this.rTk != null) {
                fS += f.a.a.a.fS(26, this.rTk.boi());
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(27, this.eJQ);
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(28, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(29, this.rra);
            }
            if (this.eJR != null) {
                fS += f.a.a.b.b.a.h(30, this.eJR);
            }
            if (this.rTl != null) {
                fS += f.a.a.a.fS(31, this.rTl.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.rWH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.rWI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.rWJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            atz atz = (atz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhz bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atz.rvi = bhz;
                    }
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
                        atz.rQz = bhz;
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
                        atz.ruT = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atz.ruU = bhz;
                    }
                    return 0;
                case 5:
                    atz.eJH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        atz.rcn = bhy;
                    }
                    return 0;
                case 7:
                    atz.rWZ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atz.rWH = bhz;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atz.rWI = bhz;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        atz.rWJ = bhz;
                    }
                    return 0;
                case 11:
                    atz.rup = aVar3.vHC.rY();
                    return 0;
                case 12:
                    atz.eJI = aVar3.vHC.readString();
                    return 0;
                case 13:
                    atz.eJJ = aVar3.vHC.readString();
                    return 0;
                case 14:
                    atz.eJK = aVar3.vHC.readString();
                    return 0;
                case 15:
                    atz.eJL = aVar3.vHC.rY();
                    return 0;
                case 16:
                    atz.rTe = aVar3.vHC.rY();
                    return 0;
                case 17:
                    atz.rTf = aVar3.vHC.readString();
                    return 0;
                case 18:
                    atz.rTg = aVar3.vHC.readString();
                    return 0;
                case 19:
                    atz.rKZ = aVar3.vHC.readString();
                    return 0;
                case 20:
                    atz.rTh = aVar3.vHC.readString();
                    return 0;
                case 21:
                    atz.rTi = aVar3.vHC.rY();
                    return 0;
                case 22:
                    atz.eJO = aVar3.vHC.rY();
                    return 0;
                case 23:
                    atz.eJN = aVar3.vHC.rY();
                    return 0;
                case 24:
                    atz.eJP = aVar3.vHC.readString();
                    return 0;
                case 25:
                    atz.eJM = aVar3.vHC.readString();
                    return 0;
                case 26:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        atz.rTk = bqd;
                    }
                    return 0;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    atz.eJQ = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    atz.rqZ = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeBackground /*29*/:
                    atz.rra = aVar3.vHC.readString();
                    return 0;
                case 30:
                    atz.eJR = aVar3.vHC.readString();
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        atz.rTl = qtVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
