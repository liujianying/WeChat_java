package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bju extends a {
    public int eJH;
    public String eJI;
    public String eJJ;
    public String eJK;
    public int eJL;
    public String eJM;
    public String eJQ;
    public bhz rQz;
    public int rTe;
    public String rTf;
    public String rTg;
    public String rTh;
    public int rTi;
    public qt rTl;
    public String rqZ;
    public String rra;
    public bhz rvi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.rvi != null) {
                    aVar.fV(1, this.rvi.boi());
                    this.rvi.a(aVar);
                }
                if (this.rQz != null) {
                    aVar.fV(2, this.rQz.boi());
                    this.rQz.a(aVar);
                }
                aVar.fT(3, this.eJH);
                if (this.eJI != null) {
                    aVar.g(4, this.eJI);
                }
                if (this.eJJ != null) {
                    aVar.g(5, this.eJJ);
                }
                if (this.eJK != null) {
                    aVar.g(6, this.eJK);
                }
                aVar.fT(7, this.eJL);
                aVar.fT(8, this.rTe);
                if (this.rTf != null) {
                    aVar.g(9, this.rTf);
                }
                if (this.rTg != null) {
                    aVar.g(10, this.rTg);
                }
                if (this.eJM != null) {
                    aVar.g(11, this.eJM);
                }
                if (this.rTh != null) {
                    aVar.g(12, this.rTh);
                }
                aVar.fT(13, this.rTi);
                if (this.eJQ != null) {
                    aVar.g(14, this.eJQ);
                }
                if (this.rTl != null) {
                    aVar.fV(15, this.rTl.boi());
                    this.rTl.a(aVar);
                }
                if (this.rqZ != null) {
                    aVar.g(16, this.rqZ);
                }
                if (this.rra == null) {
                    return 0;
                }
                aVar.g(17, this.rra);
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
            fS += f.a.a.a.fQ(3, this.eJH);
            if (this.eJI != null) {
                fS += f.a.a.b.b.a.h(4, this.eJI);
            }
            if (this.eJJ != null) {
                fS += f.a.a.b.b.a.h(5, this.eJJ);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(6, this.eJK);
            }
            fS = (fS + f.a.a.a.fQ(7, this.eJL)) + f.a.a.a.fQ(8, this.rTe);
            if (this.rTf != null) {
                fS += f.a.a.b.b.a.h(9, this.rTf);
            }
            if (this.rTg != null) {
                fS += f.a.a.b.b.a.h(10, this.rTg);
            }
            if (this.eJM != null) {
                fS += f.a.a.b.b.a.h(11, this.eJM);
            }
            if (this.rTh != null) {
                fS += f.a.a.b.b.a.h(12, this.rTh);
            }
            fS += f.a.a.a.fQ(13, this.rTi);
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(14, this.eJQ);
            }
            if (this.rTl != null) {
                fS += f.a.a.a.fS(15, this.rTl.boi());
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(16, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(17, this.rra);
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
            } else if (this.rQz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bju bju = (bju) objArr[1];
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
                        bju.rvi = bhz;
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
                        bju.rQz = bhz;
                    }
                    return 0;
                case 3:
                    bju.eJH = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bju.eJI = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bju.eJJ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bju.eJK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bju.eJL = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bju.rTe = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bju.rTf = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bju.rTg = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bju.eJM = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bju.rTh = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bju.rTi = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bju.eJQ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        bju.rTl = qtVar;
                    }
                    return 0;
                case 16:
                    bju.rqZ = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bju.rra = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
