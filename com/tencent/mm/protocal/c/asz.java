package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class asz extends bhd {
    public int jQd;
    public String jRi;
    public String lPl;
    public int rJr;
    public String rVi;
    public String rVj;
    public String rVk;
    public int rVl;
    public bhy rVm;
    public int rVn;
    public int rVo;
    public int rVp;
    public int rVq;
    public bhy rVr;
    public int rVs;
    public int rVt;
    public int rVu;
    public int rVv;
    public int rVw;
    public String rVx;
    public String rVy;
    public int rmo;
    public int rmp;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rVm == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.rVr == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rVi != null) {
                    aVar.g(2, this.rVi);
                }
                if (this.rVj != null) {
                    aVar.g(3, this.rVj);
                }
                if (this.rVk != null) {
                    aVar.g(4, this.rVk);
                }
                aVar.fT(5, this.jQd);
                aVar.fT(6, this.rVl);
                if (this.rVm != null) {
                    aVar.fV(7, this.rVm.boi());
                    this.rVm.a(aVar);
                }
                aVar.fT(8, this.rVn);
                aVar.fT(9, this.rVo);
                aVar.fT(10, this.rVp);
                aVar.fT(11, this.rVq);
                if (this.rVr != null) {
                    aVar.fV(12, this.rVr.boi());
                    this.rVr.a(aVar);
                }
                aVar.fT(13, this.rVs);
                aVar.fT(14, this.rVt);
                aVar.fT(15, this.rVu);
                aVar.fT(16, this.rVv);
                aVar.fT(17, this.rJr);
                aVar.fT(18, this.rVw);
                if (this.jRi != null) {
                    aVar.g(19, this.jRi);
                }
                if (this.lPl != null) {
                    aVar.g(20, this.lPl);
                }
                aVar.fT(21, this.rmp);
                aVar.fT(22, this.rmo);
                if (this.rVx != null) {
                    aVar.g(23, this.rVx);
                }
                if (this.rVy == null) {
                    return 0;
                }
                aVar.g(24, this.rVy);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rVi != null) {
                fS += f.a.a.b.b.a.h(2, this.rVi);
            }
            if (this.rVj != null) {
                fS += f.a.a.b.b.a.h(3, this.rVj);
            }
            if (this.rVk != null) {
                fS += f.a.a.b.b.a.h(4, this.rVk);
            }
            fS = (fS + f.a.a.a.fQ(5, this.jQd)) + f.a.a.a.fQ(6, this.rVl);
            if (this.rVm != null) {
                fS += f.a.a.a.fS(7, this.rVm.boi());
            }
            fS = (((fS + f.a.a.a.fQ(8, this.rVn)) + f.a.a.a.fQ(9, this.rVo)) + f.a.a.a.fQ(10, this.rVp)) + f.a.a.a.fQ(11, this.rVq);
            if (this.rVr != null) {
                fS += f.a.a.a.fS(12, this.rVr.boi());
            }
            fS = (((((fS + f.a.a.a.fQ(13, this.rVs)) + f.a.a.a.fQ(14, this.rVt)) + f.a.a.a.fQ(15, this.rVu)) + f.a.a.a.fQ(16, this.rVv)) + f.a.a.a.fQ(17, this.rJr)) + f.a.a.a.fQ(18, this.rVw);
            if (this.jRi != null) {
                fS += f.a.a.b.b.a.h(19, this.jRi);
            }
            if (this.lPl != null) {
                fS += f.a.a.b.b.a.h(20, this.lPl);
            }
            fS = (fS + f.a.a.a.fQ(21, this.rmp)) + f.a.a.a.fQ(22, this.rmo);
            if (this.rVx != null) {
                fS += f.a.a.b.b.a.h(23, this.rVx);
            }
            if (this.rVy != null) {
                fS += f.a.a.b.b.a.h(24, this.rVy);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rVm == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.rVr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            asz asz = (asz) objArr[1];
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
                        asz.shX = fkVar;
                    }
                    return 0;
                case 2:
                    asz.rVi = aVar3.vHC.readString();
                    return 0;
                case 3:
                    asz.rVj = aVar3.vHC.readString();
                    return 0;
                case 4:
                    asz.rVk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    asz.jQd = aVar3.vHC.rY();
                    return 0;
                case 6:
                    asz.rVl = aVar3.vHC.rY();
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
                        asz.rVm = bhy;
                    }
                    return 0;
                case 8:
                    asz.rVn = aVar3.vHC.rY();
                    return 0;
                case 9:
                    asz.rVo = aVar3.vHC.rY();
                    return 0;
                case 10:
                    asz.rVp = aVar3.vHC.rY();
                    return 0;
                case 11:
                    asz.rVq = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        asz.rVr = bhy;
                    }
                    return 0;
                case 13:
                    asz.rVs = aVar3.vHC.rY();
                    return 0;
                case 14:
                    asz.rVt = aVar3.vHC.rY();
                    return 0;
                case 15:
                    asz.rVu = aVar3.vHC.rY();
                    return 0;
                case 16:
                    asz.rVv = aVar3.vHC.rY();
                    return 0;
                case 17:
                    asz.rJr = aVar3.vHC.rY();
                    return 0;
                case 18:
                    asz.rVw = aVar3.vHC.rY();
                    return 0;
                case 19:
                    asz.jRi = aVar3.vHC.readString();
                    return 0;
                case 20:
                    asz.lPl = aVar3.vHC.readString();
                    return 0;
                case 21:
                    asz.rmp = aVar3.vHC.rY();
                    return 0;
                case 22:
                    asz.rmo = aVar3.vHC.rY();
                    return 0;
                case 23:
                    asz.rVx = aVar3.vHC.readString();
                    return 0;
                case 24:
                    asz.rVy = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
