package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.sns.i$l;
import f.a.a.b;
import java.util.LinkedList;

public final class biy extends a {
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
                if (this.eJI != null) {
                    aVar.g(7, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(8, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(9, this.eJK);
                }
                aVar.fT(10, this.eJL);
                aVar.fT(11, this.rTe);
                if (this.rTf != null) {
                    aVar.g(12, this.rTf);
                }
                if (this.rTg != null) {
                    aVar.g(13, this.rTg);
                }
                if (this.eJM != null) {
                    aVar.g(14, this.eJM);
                }
                if (this.rTh != null) {
                    aVar.g(15, this.rTh);
                }
                aVar.fT(16, this.rTi);
                aVar.fT(17, this.eJO);
                aVar.fT(18, this.eJN);
                if (this.eJP != null) {
                    aVar.g(19, this.eJP);
                }
                if (this.rTk != null) {
                    aVar.fV(20, this.rTk.boi());
                    this.rTk.a(aVar);
                }
                if (this.eJQ != null) {
                    aVar.g(21, this.eJQ);
                }
                if (this.eJR != null) {
                    aVar.g(22, this.eJR);
                }
                if (this.rTl != null) {
                    aVar.fV(23, this.rTl.boi());
                    this.rTl.a(aVar);
                }
                if (this.rqZ != null) {
                    aVar.g(24, this.rqZ);
                }
                if (this.rra != null) {
                    aVar.g(25, this.rra);
                }
                if (this.rEJ != null) {
                    aVar.g(26, this.rEJ);
                }
                aVar.fT(27, this.sjj);
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
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(7, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(8, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(9, this.eJK);
            }
            fS = (fS + f.a.a.a.fQ(10, this.eJL)) + f.a.a.a.fQ(11, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(12, this.rTf);
            }
            if (this.rTg != null) {
                fS += f.a.a.b.b.a.h(13, this.rTg);
            }
            if (this.eJM != null) {
                fS += f.a.a.b.b.a.h(14, this.eJM);
            }
            if (this.rTh != null) {
                fS += f.a.a.b.b.a.h(15, this.rTh);
            }
            fS = ((fS + f.a.a.a.fQ(16, this.rTi)) + f.a.a.a.fQ(17, this.eJO)) + f.a.a.a.fQ(18, this.eJN);
            if (this.eJP != null) {
                fS += f.a.a.b.b.a.h(19, this.eJP);
            }
            if (this.rTk != null) {
                fS += f.a.a.a.fS(20, this.rTk.boi());
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(21, this.eJQ);
            }
            if (this.eJR != null) {
                fS += f.a.a.b.b.a.h(22, this.eJR);
            }
            if (this.rTl != null) {
                fS += f.a.a.a.fS(23, this.rTl.boi());
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(24, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(25, this.rra);
            }
            if (this.rEJ != null) {
                fS += f.a.a.b.b.a.h(26, this.rEJ);
            }
            return fS + f.a.a.a.fQ(27, this.sjj);
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
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            biy biy = (biy) objArr[1];
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
                        biy.rvi = bhz;
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
                        biy.rQz = bhz;
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
                        biy.ruT = bhz;
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
                        biy.ruU = bhz;
                    }
                    return 0;
                case 5:
                    biy.eJH = aVar3.vHC.rY();
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
                        biy.rcn = bhy;
                    }
                    return 0;
                case 7:
                    biy.eJI = aVar3.vHC.readString();
                    return 0;
                case 8:
                    biy.eJJ = aVar3.vHC.readString();
                    return 0;
                case 9:
                    biy.eJK = aVar3.vHC.readString();
                    return 0;
                case 10:
                    biy.eJL = aVar3.vHC.rY();
                    return 0;
                case 11:
                    biy.rTe = aVar3.vHC.rY();
                    return 0;
                case 12:
                    biy.rTf = aVar3.vHC.readString();
                    return 0;
                case 13:
                    biy.rTg = aVar3.vHC.readString();
                    return 0;
                case 14:
                    biy.eJM = aVar3.vHC.readString();
                    return 0;
                case 15:
                    biy.rTh = aVar3.vHC.readString();
                    return 0;
                case 16:
                    biy.rTi = aVar3.vHC.rY();
                    return 0;
                case 17:
                    biy.eJO = aVar3.vHC.rY();
                    return 0;
                case 18:
                    biy.eJN = aVar3.vHC.rY();
                    return 0;
                case 19:
                    biy.eJP = aVar3.vHC.readString();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        biy.rTk = bqd;
                    }
                    return 0;
                case 21:
                    biy.eJQ = aVar3.vHC.readString();
                    return 0;
                case 22:
                    biy.eJR = aVar3.vHC.readString();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        biy.rTl = qtVar;
                    }
                    return 0;
                case 24:
                    biy.rqZ = aVar3.vHC.readString();
                    return 0;
                case 25:
                    biy.rra = aVar3.vHC.readString();
                    return 0;
                case 26:
                    biy.rEJ = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeStyle /*27*/:
                    biy.sjj = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
