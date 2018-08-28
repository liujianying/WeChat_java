package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class hj extends bhp {
    public int hcd;
    public int raE;
    public int raH;
    public bhy rcn;
    public bhy reB;
    public bhy rev;
    public bic rhO;
    public String rhV;
    public bhz rhY;
    public bhy rhZ;
    public int rib;
    public String ric;
    public String rid;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rhV != null) {
                    aVar.g(2, this.rhV);
                }
                if (this.rcn != null) {
                    aVar.fV(3, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                aVar.fT(4, this.raH);
                aVar.fT(5, this.rib);
                if (this.ric != null) {
                    aVar.g(6, this.ric);
                }
                aVar.fT(7, this.hcd);
                if (this.rid != null) {
                    aVar.g(8, this.rid);
                }
                if (this.rhY != null) {
                    aVar.fV(9, this.rhY.boi());
                    this.rhY.a(aVar);
                }
                if (this.reB != null) {
                    aVar.fV(10, this.reB.boi());
                    this.reB.a(aVar);
                }
                if (this.rhZ != null) {
                    aVar.fV(11, this.rhZ.boi());
                    this.rhZ.a(aVar);
                }
                if (this.rhO != null) {
                    aVar.fV(12, this.rhO.boi());
                    this.rhO.a(aVar);
                }
                aVar.fT(13, this.raE);
                if (this.rev == null) {
                    return 0;
                }
                aVar.fV(14, this.rev.boi());
                this.rev.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhV != null) {
                fS += f.a.a.b.b.a.h(2, this.rhV);
            }
            if (this.rcn != null) {
                fS += f.a.a.a.fS(3, this.rcn.boi());
            }
            fS = (fS + f.a.a.a.fQ(4, this.raH)) + f.a.a.a.fQ(5, this.rib);
            if (this.ric != null) {
                fS += f.a.a.b.b.a.h(6, this.ric);
            }
            fS += f.a.a.a.fQ(7, this.hcd);
            if (this.rid != null) {
                fS += f.a.a.b.b.a.h(8, this.rid);
            }
            if (this.rhY != null) {
                fS += f.a.a.a.fS(9, this.rhY.boi());
            }
            if (this.reB != null) {
                fS += f.a.a.a.fS(10, this.reB.boi());
            }
            if (this.rhZ != null) {
                fS += f.a.a.a.fS(11, this.rhZ.boi());
            }
            if (this.rhO != null) {
                fS += f.a.a.a.fS(12, this.rhO.boi());
            }
            fS += f.a.a.a.fQ(13, this.raE);
            if (this.rev != null) {
                fS += f.a.a.a.fS(14, this.rev.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            hj hjVar = (hj) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        hjVar.six = flVar;
                    }
                    return 0;
                case 2:
                    hjVar.rhV = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        hjVar.rcn = bhy;
                    }
                    return 0;
                case 4:
                    hjVar.raH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    hjVar.rib = aVar3.vHC.rY();
                    return 0;
                case 6:
                    hjVar.ric = aVar3.vHC.readString();
                    return 0;
                case 7:
                    hjVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 8:
                    hjVar.rid = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        hjVar.rhY = bhz;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        hjVar.reB = bhy;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        hjVar.rhZ = bhy;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bic bic = new bic();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bic.a(aVar4, bic, bhp.a(aVar4))) {
                        }
                        hjVar.rhO = bic;
                    }
                    return 0;
                case 13:
                    hjVar.raE = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        hjVar.rev = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
