package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class aue extends a {
    public String csY;
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
    public String jTB;
    public mx rGM;
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
    public bhz rXd;
    public int rXe;
    public int rXf;
    public String rXg;
    public String rXh;
    public String rXi;
    public String rXj;
    public String rXk;
    public String rXl;
    public String rXm;
    public String rXn;
    public ce rXo;
    public int rXp;
    public int rXq;
    public int rXr;
    public int rXs;
    public String rXt;
    public bas rXu;
    public int rXv;
    public int rXw;
    public int rXx;
    public bhy rcn;
    public int rdq;
    public String rej;
    public String rqZ;
    public String rra;
    public bhz ruT;
    public bhz ruU;
    public int ruj;
    public int ruk;
    public int rup;
    public int ruq;
    public LinkedList<bhx> rur = new LinkedList();
    public int rut;
    public int ruu;
    public bhz rvi;
    public int rvk;
    public String rvl;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
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
                aVar.fT(7, this.ruj);
                aVar.fT(8, this.ruk);
                aVar.fT(9, this.rWZ);
                if (this.rWH != null) {
                    aVar.fV(10, this.rWH.boi());
                    this.rWH.a(aVar);
                }
                if (this.rWI != null) {
                    aVar.fV(11, this.rWI.boi());
                    this.rWI.a(aVar);
                }
                if (this.rWJ != null) {
                    aVar.fV(12, this.rWJ.boi());
                    this.rWJ.a(aVar);
                }
                aVar.fT(13, this.rup);
                aVar.fT(14, this.ruq);
                aVar.d(15, 8, this.rur);
                if (this.rXd != null) {
                    aVar.fV(16, this.rXd.boi());
                    this.rXd.a(aVar);
                }
                aVar.fT(17, this.rut);
                aVar.fT(18, this.ruu);
                if (this.eJI != null) {
                    aVar.g(19, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(20, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(21, this.eJK);
                }
                aVar.fT(22, this.eJL);
                aVar.fT(23, this.rXe);
                aVar.fT(24, this.rTe);
                if (this.rTf != null) {
                    aVar.g(25, this.rTf);
                }
                aVar.fT(26, this.rXf);
                aVar.fT(27, this.rdq);
                if (this.rTg != null) {
                    aVar.g(28, this.rTg);
                }
                if (this.rKZ != null) {
                    aVar.g(29, this.rKZ);
                }
                if (this.eJM != null) {
                    aVar.g(30, this.eJM);
                }
                if (this.rXg != null) {
                    aVar.g(31, this.rXg);
                }
                if (this.rTh != null) {
                    aVar.g(32, this.rTh);
                }
                aVar.fT(33, this.rTi);
                aVar.fT(34, this.eJO);
                aVar.fT(35, this.eJN);
                if (this.eJP != null) {
                    aVar.g(36, this.eJP);
                }
                if (this.rTk != null) {
                    aVar.fV(37, this.rTk.boi());
                    this.rTk.a(aVar);
                }
                if (this.eJQ != null) {
                    aVar.g(38, this.eJQ);
                }
                if (this.rqZ != null) {
                    aVar.g(39, this.rqZ);
                }
                if (this.rra != null) {
                    aVar.g(40, this.rra);
                }
                if (this.eJR != null) {
                    aVar.g(41, this.eJR);
                }
                if (this.rTl != null) {
                    aVar.fV(42, this.rTl.boi());
                    this.rTl.a(aVar);
                }
                if (this.rXh != null) {
                    aVar.g(43, this.rXh);
                }
                if (this.rXi != null) {
                    aVar.g(44, this.rXi);
                }
                if (this.rXj != null) {
                    aVar.g(45, this.rXj);
                }
                if (this.rXk != null) {
                    aVar.g(46, this.rXk);
                }
                if (this.rXl != null) {
                    aVar.g(47, this.rXl);
                }
                if (this.rXm != null) {
                    aVar.g(48, this.rXm);
                }
                if (this.rXn != null) {
                    aVar.g(49, this.rXn);
                }
                if (this.rXo != null) {
                    aVar.fV(50, this.rXo.boi());
                    this.rXo.a(aVar);
                }
                aVar.fT(53, this.rXp);
                if (this.jTB != null) {
                    aVar.g(54, this.jTB);
                }
                aVar.fT(55, this.rXq);
                aVar.fT(56, this.rXr);
                if (this.rGM != null) {
                    aVar.fV(57, this.rGM.boi());
                    this.rGM.a(aVar);
                }
                aVar.fT(58, this.rXs);
                if (this.rej != null) {
                    aVar.g(59, this.rej);
                }
                if (this.rXt != null) {
                    aVar.g(60, this.rXt);
                }
                if (this.rvl != null) {
                    aVar.g(61, this.rvl);
                }
                if (this.rXu != null) {
                    aVar.fV(62, this.rXu.boi());
                    this.rXu.a(aVar);
                }
                if (this.csY != null) {
                    aVar.g(63, this.csY);
                }
                aVar.fT(64, this.rXv);
                aVar.fT(65, this.rvk);
                aVar.fT(66, this.rXw);
                aVar.fT(67, this.rXx);
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
            fS = ((fS + f.a.a.a.fQ(7, this.ruj)) + f.a.a.a.fQ(8, this.ruk)) + f.a.a.a.fQ(9, this.rWZ);
            if (this.rWH != null) {
                fS += f.a.a.a.fS(10, this.rWH.boi());
            }
            if (this.rWI != null) {
                fS += f.a.a.a.fS(11, this.rWI.boi());
            }
            if (this.rWJ != null) {
                fS += f.a.a.a.fS(12, this.rWJ.boi());
            }
            fS = ((fS + f.a.a.a.fQ(13, this.rup)) + f.a.a.a.fQ(14, this.ruq)) + f.a.a.a.c(15, 8, this.rur);
            if (this.rXd != null) {
                fS += f.a.a.a.fS(16, this.rXd.boi());
            }
            fS = (fS + f.a.a.a.fQ(17, this.rut)) + f.a.a.a.fQ(18, this.ruu);
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(19, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(20, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(21, this.eJK);
            }
            fS = ((fS + f.a.a.a.fQ(22, this.eJL)) + f.a.a.a.fQ(23, this.rXe)) + f.a.a.a.fQ(24, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(25, this.rTf);
            }
            fS = (fS + f.a.a.a.fQ(26, this.rXf)) + f.a.a.a.fQ(27, this.rdq);
            if (this.rTg != null) {
                fS += f.a.a.b.b.a.h(28, this.rTg);
            }
            if (this.rKZ != null) {
                fS += f.a.a.b.b.a.h(29, this.rKZ);
            }
            if (this.eJM != null) {
                fS += f.a.a.b.b.a.h(30, this.eJM);
            }
            if (this.rXg != null) {
                fS += f.a.a.b.b.a.h(31, this.rXg);
            }
            if (this.rTh != null) {
                fS += f.a.a.b.b.a.h(32, this.rTh);
            }
            fS = ((fS + f.a.a.a.fQ(33, this.rTi)) + f.a.a.a.fQ(34, this.eJO)) + f.a.a.a.fQ(35, this.eJN);
            if (this.eJP != null) {
                fS += f.a.a.b.b.a.h(36, this.eJP);
            }
            if (this.rTk != null) {
                fS += f.a.a.a.fS(37, this.rTk.boi());
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(38, this.eJQ);
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(39, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(40, this.rra);
            }
            if (this.eJR != null) {
                fS += f.a.a.b.b.a.h(41, this.eJR);
            }
            if (this.rTl != null) {
                fS += f.a.a.a.fS(42, this.rTl.boi());
            }
            if (this.rXh != null) {
                fS += f.a.a.b.b.a.h(43, this.rXh);
            }
            if (this.rXi != null) {
                fS += f.a.a.b.b.a.h(44, this.rXi);
            }
            if (this.rXj != null) {
                fS += f.a.a.b.b.a.h(45, this.rXj);
            }
            if (this.rXk != null) {
                fS += f.a.a.b.b.a.h(46, this.rXk);
            }
            if (this.rXl != null) {
                fS += f.a.a.b.b.a.h(47, this.rXl);
            }
            if (this.rXm != null) {
                fS += f.a.a.b.b.a.h(48, this.rXm);
            }
            if (this.rXn != null) {
                fS += f.a.a.b.b.a.h(49, this.rXn);
            }
            if (this.rXo != null) {
                fS += f.a.a.a.fS(50, this.rXo.boi());
            }
            fS += f.a.a.a.fQ(53, this.rXp);
            if (this.jTB != null) {
                fS += f.a.a.b.b.a.h(54, this.jTB);
            }
            fS = (fS + f.a.a.a.fQ(55, this.rXq)) + f.a.a.a.fQ(56, this.rXr);
            if (this.rGM != null) {
                fS += f.a.a.a.fS(57, this.rGM.boi());
            }
            fS += f.a.a.a.fQ(58, this.rXs);
            if (this.rej != null) {
                fS += f.a.a.b.b.a.h(59, this.rej);
            }
            if (this.rXt != null) {
                fS += f.a.a.b.b.a.h(60, this.rXt);
            }
            if (this.rvl != null) {
                fS += f.a.a.b.b.a.h(61, this.rvl);
            }
            if (this.rXu != null) {
                fS += f.a.a.a.fS(62, this.rXu.boi());
            }
            if (this.csY != null) {
                fS += f.a.a.b.b.a.h(63, this.csY);
            }
            return (((fS + f.a.a.a.fQ(64, this.rXv)) + f.a.a.a.fQ(65, this.rvk)) + f.a.a.a.fQ(66, this.rXw)) + f.a.a.a.fQ(67, this.rXx);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rur.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            aue aue = (aue) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            a bhz;
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
                        aue.rvi = bhz;
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
                        aue.rQz = bhz;
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
                        aue.ruT = bhz;
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
                        aue.ruU = bhz;
                    }
                    return 0;
                case 5:
                    aue.eJH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rcn = bhz;
                    }
                    return 0;
                case 7:
                    aue.ruj = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aue.ruk = aVar3.vHC.rY();
                    return 0;
                case 9:
                    aue.rWZ = aVar3.vHC.rY();
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
                        aue.rWH = bhz;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rWI = bhz;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rWJ = bhz;
                    }
                    return 0;
                case 13:
                    aue.rup = aVar3.vHC.rY();
                    return 0;
                case 14:
                    aue.ruq = aVar3.vHC.rY();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rur.add(bhz);
                    }
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rXd = bhz;
                    }
                    return 0;
                case 17:
                    aue.rut = aVar3.vHC.rY();
                    return 0;
                case 18:
                    aue.ruu = aVar3.vHC.rY();
                    return 0;
                case 19:
                    aue.eJI = aVar3.vHC.readString();
                    return 0;
                case 20:
                    aue.eJJ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    aue.eJK = aVar3.vHC.readString();
                    return 0;
                case 22:
                    aue.eJL = aVar3.vHC.rY();
                    return 0;
                case 23:
                    aue.rXe = aVar3.vHC.rY();
                    return 0;
                case 24:
                    aue.rTe = aVar3.vHC.rY();
                    return 0;
                case 25:
                    aue.rTf = aVar3.vHC.readString();
                    return 0;
                case 26:
                    aue.rXf = aVar3.vHC.rY();
                    return 0;
                case 27:
                    aue.rdq = aVar3.vHC.rY();
                    return 0;
                case 28:
                    aue.rTg = aVar3.vHC.readString();
                    return 0;
                case 29:
                    aue.rKZ = aVar3.vHC.readString();
                    return 0;
                case 30:
                    aue.eJM = aVar3.vHC.readString();
                    return 0;
                case 31:
                    aue.rXg = aVar3.vHC.readString();
                    return 0;
                case 32:
                    aue.rTh = aVar3.vHC.readString();
                    return 0;
                case 33:
                    aue.rTi = aVar3.vHC.rY();
                    return 0;
                case 34:
                    aue.eJO = aVar3.vHC.rY();
                    return 0;
                case 35:
                    aue.eJN = aVar3.vHC.rY();
                    return 0;
                case 36:
                    aue.eJP = aVar3.vHC.readString();
                    return 0;
                case 37:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rTk = bhz;
                    }
                    return 0;
                case 38:
                    aue.eJQ = aVar3.vHC.readString();
                    return 0;
                case 39:
                    aue.rqZ = aVar3.vHC.readString();
                    return 0;
                case 40:
                    aue.rra = aVar3.vHC.readString();
                    return 0;
                case 41:
                    aue.eJR = aVar3.vHC.readString();
                    return 0;
                case 42:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rTl = bhz;
                    }
                    return 0;
                case 43:
                    aue.rXh = aVar3.vHC.readString();
                    return 0;
                case 44:
                    aue.rXi = aVar3.vHC.readString();
                    return 0;
                case 45:
                    aue.rXj = aVar3.vHC.readString();
                    return 0;
                case 46:
                    aue.rXk = aVar3.vHC.readString();
                    return 0;
                case 47:
                    aue.rXl = aVar3.vHC.readString();
                    return 0;
                case 48:
                    aue.rXm = aVar3.vHC.readString();
                    return 0;
                case 49:
                    aue.rXn = aVar3.vHC.readString();
                    return 0;
                case 50:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new ce();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rXo = bhz;
                    }
                    return 0;
                case 53:
                    aue.rXp = aVar3.vHC.rY();
                    return 0;
                case 54:
                    aue.jTB = aVar3.vHC.readString();
                    return 0;
                case 55:
                    aue.rXq = aVar3.vHC.rY();
                    return 0;
                case 56:
                    aue.rXr = aVar3.vHC.rY();
                    return 0;
                case 57:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new mx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rGM = bhz;
                    }
                    return 0;
                case 58:
                    aue.rXs = aVar3.vHC.rY();
                    return 0;
                case 59:
                    aue.rej = aVar3.vHC.readString();
                    return 0;
                case 60:
                    aue.rXt = aVar3.vHC.readString();
                    return 0;
                case 61:
                    aue.rvl = aVar3.vHC.readString();
                    return 0;
                case 62:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        aue.rXu = bhz;
                    }
                    return 0;
                case 63:
                    aue.csY = aVar3.vHC.readString();
                    return 0;
                case 64:
                    aue.rXv = aVar3.vHC.rY();
                    return 0;
                case 65:
                    aue.rvk = aVar3.vHC.rY();
                    return 0;
                case 66:
                    aue.rXw = aVar3.vHC.rY();
                    return 0;
                case 67:
                    aue.rXx = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
