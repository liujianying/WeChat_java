package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class atj extends a {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public int eJL;
    public String eJQ;
    public bhz rQz;
    public int rTe;
    public String rTf;
    public int rWG;
    public bhz rWH;
    public bhz rWI;
    public bhz rWJ;
    public bhz ruT;
    public bhz ruU;
    public int rup;
    public bhz rvo;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvo == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rWH == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.rWI == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.rWJ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.rvo != null) {
                    aVar.fV(1, this.rvo.boi());
                    this.rvo.a(aVar);
                }
                aVar.fT(2, this.rWG);
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
                if (this.rWH != null) {
                    aVar.fV(9, this.rWH.boi());
                    this.rWH.a(aVar);
                }
                if (this.rWI != null) {
                    aVar.fV(10, this.rWI.boi());
                    this.rWI.a(aVar);
                }
                if (this.rWJ != null) {
                    aVar.fV(11, this.rWJ.boi());
                    this.rWJ.a(aVar);
                }
                aVar.fT(12, this.rup);
                if (this.eJI != null) {
                    aVar.g(13, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(14, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(15, this.eJK);
                }
                aVar.fT(16, this.eJL);
                aVar.fT(17, this.rTe);
                if (this.rTf != null) {
                    aVar.g(18, this.rTf);
                }
                if (this.eJQ == null) {
                    return 0;
                }
                aVar.g(19, this.eJQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.rvo != null) {
                fS = f.a.a.a.fS(1, this.rvo.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rWG);
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
            if (this.rWH != null) {
                fS += f.a.a.a.fS(9, this.rWH.boi());
            }
            if (this.rWI != null) {
                fS += f.a.a.a.fS(10, this.rWI.boi());
            }
            if (this.rWJ != null) {
                fS += f.a.a.a.fS(11, this.rWJ.boi());
            }
            fS += f.a.a.a.fQ(12, this.rup);
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(13, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(14, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(15, this.eJK);
            }
            fS = (fS + f.a.a.a.fQ(16, this.eJL)) + f.a.a.a.fQ(17, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(18, this.rTf);
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(19, this.eJQ);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rvo == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
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
            atj atj = (atj) objArr[1];
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
                        atj.rvo = bhz;
                    }
                    return 0;
                case 2:
                    atj.rWG = aVar3.vHC.rY();
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
                        atj.rQz = bhz;
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
                        atj.ruT = bhz;
                    }
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
                        atj.ruU = bhz;
                    }
                    return 0;
                case 6:
                    atj.eJH = aVar3.vHC.rY();
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
                        atj.rWH = bhz;
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
                        atj.rWI = bhz;
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
                        atj.rWJ = bhz;
                    }
                    return 0;
                case 12:
                    atj.rup = aVar3.vHC.rY();
                    return 0;
                case 13:
                    atj.eJI = aVar3.vHC.readString();
                    return 0;
                case 14:
                    atj.eJJ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    atj.eJK = aVar3.vHC.readString();
                    return 0;
                case 16:
                    atj.eJL = aVar3.vHC.rY();
                    return 0;
                case 17:
                    atj.rTe = aVar3.vHC.rY();
                    return 0;
                case 18:
                    atj.rTf = aVar3.vHC.readString();
                    return 0;
                case 19:
                    atj.eJQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
